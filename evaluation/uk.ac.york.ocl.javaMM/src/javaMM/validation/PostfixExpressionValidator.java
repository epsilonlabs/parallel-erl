/**
 *
 * $Id$
 */
package javaMM.validation;

import javaMM.Expression;
import javaMM.PostfixExpressionKind;

/**
 * A sample validator interface for {@link javaMM.PostfixExpression}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface PostfixExpressionValidator {
	boolean validate();

	boolean validateOperator(PostfixExpressionKind value);
	boolean validateOperand(Expression value);
}
