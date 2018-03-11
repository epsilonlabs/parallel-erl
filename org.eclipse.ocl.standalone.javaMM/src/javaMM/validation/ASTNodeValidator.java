/**
 *
 * $Id$
 */
package javaMM.validation;

import javaMM.ClassFile;
import javaMM.Comment;
import javaMM.CompilationUnit;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link javaMM.ASTNode}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ASTNodeValidator {
	boolean validate();

	boolean validateComments(EList<Comment> value);
	boolean validateOriginalCompilationUnit(CompilationUnit value);
	boolean validateOriginalClassFile(ClassFile value);
}
