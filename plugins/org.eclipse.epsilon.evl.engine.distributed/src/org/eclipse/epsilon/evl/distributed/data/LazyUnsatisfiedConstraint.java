/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.evl.distributed.data;

import java.util.Deque;
import java.util.Map;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.execute.FixInstance;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;

/**
 * An @link {@link UnsatisfiedConstraint} which lazily resolves the constraint and model element
 * upon first request.
 *
 * @author Sina Madani
 * @since 1.6
 */
public class LazyUnsatisfiedConstraint extends UnsatisfiedConstraint {

	protected final SerializableEvlResultAtom proxy;
	protected IEvlModule module;
	
	public LazyUnsatisfiedConstraint(SerializableEvlResultAtom proxy, IEvlModule module) {
		this.proxy = proxy;
		this.message = proxy.message;
	}

	@Override
	public Constraint getConstraint() {
		if (constraint != null) return constraint;
		return constraint = module.getConstraints().stream()
			.filter(c ->
				c.getName().equals(proxy.constraintName) &&
				c.getConstraintContext().getTypeName().equals(proxy.contextName)
			)
			.findAny()
			.orElse(null);
	}

	@Override
	public Object getInstance() {
		if (instance != null) return instance;
		try {
			instance = proxy.findElement(module.getContext());
		}
		catch (EolModelNotFoundException mnf) {
			System.err.println(mnf.getMessage());
		}
		return instance;
	}

	@Override
	public Deque<FixInstance> getFixes() {
		// TODO Support
		return super.getFixes();
	}

	@Override
	public Map<String, Object> getExtras() {
		// TODO Support
		return super.getExtras();
	}
}
