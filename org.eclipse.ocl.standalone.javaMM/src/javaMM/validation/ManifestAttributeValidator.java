/**
 *
 * $Id$
 */
package javaMM.validation;


/**
 * A sample validator interface for {@link javaMM.ManifestAttribute}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ManifestAttributeValidator {
	boolean validate();

	boolean validateKey(String value);
	boolean validateValue(String value);
}
