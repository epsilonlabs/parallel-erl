/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.exceptions.flowcontrol;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;


public class EolReturnException extends EolRuntimeException{
	
	protected Object returned = null;
	
	public EolReturnException(ModuleElement ast, Object returned){
		super("Return statement not allowed in the context", ast);
		this.returned = returned;
	}
	
	public void setReturned(Object returned) {
		this.returned = returned;
	}
	
	public Object getReturned(){
		return returned;
	}
	
	// Make the exception faster - we don't need a stack trace
	@Override
	public Throwable fillInStackTrace() {
		//return super.fillInStackTrace();
		return this;
	}
	
}
