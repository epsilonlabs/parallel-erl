/**
 *
 * $Id$
 */
package javaMM.validation;

import javaMM.Annotation;
import javaMM.Modifier;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link javaMM.VariableDeclarationStatement}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface VariableDeclarationStatementValidator {
	boolean validate();

	boolean validateExtraArrayDimensions(int value);
	boolean validateModifier(Modifier value);
	boolean validateAnnotations(EList<Annotation> value);
}
