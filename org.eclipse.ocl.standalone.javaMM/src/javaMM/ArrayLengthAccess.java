/**
 */
package javaMM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Length Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link javaMM.ArrayLengthAccess#getArray <em>Array</em>}</li>
 * </ul>
 *
 * @see javaMM.JavaMMPackage#getArrayLengthAccess()
 * @model
 * @generated
 */
public interface ArrayLengthAccess extends Expression {
	/**
	 * Returns the value of the '<em><b>Array</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array</em>' containment reference.
	 * @see #setArray(Expression)
	 * @see javaMM.JavaMMPackage#getArrayLengthAccess_Array()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/MoDisco/Java/0.2.incubation/java!ArrayLengthAccess!array'"
	 * @generated
	 */
	Expression getArray();

	/**
	 * Sets the value of the '{@link javaMM.ArrayLengthAccess#getArray <em>Array</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Array</em>' containment reference.
	 * @see #getArray()
	 * @generated
	 */
	void setArray(Expression value);

} // ArrayLengthAccess
