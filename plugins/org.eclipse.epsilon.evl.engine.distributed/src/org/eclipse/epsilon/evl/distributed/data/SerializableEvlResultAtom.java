/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.evl.distributed.data;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.execute.exceptions.EvlConstraintNotFoundException;

/**
 * Serializable representation of an {@linkplain UnsatisfiedConstraint}.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class SerializableEvlResultAtom extends SerializableEvlAtom {

	private static final long serialVersionUID = 6633651795817751005L;
	
	public String constraintName, message;
	
	@Override
	protected SerializableEvlResultAtom clone() {
		SerializableEvlResultAtom clone = (SerializableEvlResultAtom) super.clone();
		clone.constraintName = ""+this.constraintName;
		clone.message = ""+this.message;
		return clone;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), constraintName, message);
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;
		
		SerializableEvlResultAtom other = (SerializableEvlResultAtom) obj;
		return
			Objects.equals(this.constraintName, other.constraintName) &&
			Objects.equals(this.message, other.message);
	}

	@Override
	public String toString() {
		return super.toString()+", constraintName=" + constraintName + ", message=" + message;
	}
	
	/**
	 * Transform the {@linkplain UnsatisfiedConstraint} into a serializable form.
	 * 
	 * @param uc The unsatisfied constraint.
	 * @param context
	 * @return The serialized form of the unsatisfied constraint.
	 */
	public static SerializableEvlResultAtom serializeResult(UnsatisfiedConstraint uc, IEvlContext context) {
		SerializableEvlResultAtom outputAtom = new SerializableEvlResultAtom();
		Object modelElement = uc.getInstance();
		IModel owningModel = context.getModelRepository().getOwningModel(modelElement);
		outputAtom.contextName = uc.getConstraint().getConstraintContext().getTypeName();
		outputAtom.modelName = owningModel.getName();
		outputAtom.modelElementID = owningModel.getElementId(modelElement);
		outputAtom.constraintName = uc.getConstraint().getName();
		outputAtom.message = uc.getMessage();
		return outputAtom;
	}
	
	public static Collection<SerializableEvlResultAtom> serializeResults(IEvlContext context) {
		return context.getUnsatisfiedConstraints()
			.parallelStream()
			.map(uc -> serializeResult(uc, context))
			.collect(Collectors.toList());
	}
	
	// TODO: support fixes and 'extras'
	/**
	 * Transforms the serialized UnsatisfiedConstraint into a native UnsatisfiedConstraint.
	 * @param sr The unsatisfied constraint information.
	 * @return The derived {@link UnsatisfiedConstraint}.
	 * @throws EolRuntimeException If the constraint or model element could not be found.
	 */
	public UnsatisfiedConstraint deserializeResult(IEvlModule module) throws EolRuntimeException {
		IEvlContext context =  module.getContext();
		UnsatisfiedConstraint uc = new UnsatisfiedConstraint();
		Object modelElement = findElement(context);
		uc.setInstance(modelElement);
		uc.setMessage(message);
		Constraint constraint = module.getConstraint(
				constraintName, module.getConstraintContext(contextName), modelElement, context, false
			)
			.orElseThrow(() -> new EvlConstraintNotFoundException(constraintName, module));
		uc.setConstraint(constraint);
		
		return uc;
	}
}
