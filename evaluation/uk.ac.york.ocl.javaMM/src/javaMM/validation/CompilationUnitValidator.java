/**
 *
 * $Id$
 */
package javaMM.validation;

import javaMM.AbstractTypeDeclaration;
import javaMM.Comment;
import javaMM.ImportDeclaration;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link javaMM.CompilationUnit}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface CompilationUnitValidator {
	boolean validate();

	boolean validateOriginalFilePath(String value);
	boolean validateCommentList(EList<Comment> value);
	boolean validateImports(EList<ImportDeclaration> value);
	boolean validatePackage(javaMM.Package value);
	boolean validateTypes(EList<AbstractTypeDeclaration> value);
}
