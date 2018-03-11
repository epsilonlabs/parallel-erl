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
package org.eclipse.epsilon.profiling;

import java.io.File;

public class FileMarker {
	
	protected File file;
	int line;
	int column;
	
	public FileMarker() {
		
	}
	
	public FileMarker(File file, int line, int column) {
		super();
		this.file = file;
		this.line = line;
		this.column = column;
	}

	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public int getLine() {
		return line;
	}
	
	public void setLine(int line) {
		this.line = line;
	}
	
	public int getColumn() {
		return column;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}
	
	
	
}
