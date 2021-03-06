/**
 */
package javaMM.impl;

import javaMM.AbstractTypeDeclaration;
import javaMM.ClassFile;
import javaMM.CompilationUnit;
import javaMM.JavaMMPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link javaMM.impl.ClassFileImpl#getOriginalFilePath <em>Original File Path</em>}</li>
 *   <li>{@link javaMM.impl.ClassFileImpl#getType <em>Type</em>}</li>
 *   <li>{@link javaMM.impl.ClassFileImpl#getAttachedSource <em>Attached Source</em>}</li>
 *   <li>{@link javaMM.impl.ClassFileImpl#getPackage <em>Package</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassFileImpl extends NamedElementImpl implements ClassFile {
	/**
	 * The default value of the '{@link #getOriginalFilePath() <em>Original File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalFilePath()
	 * @generated
	 * @ordered
	 */
	protected static final String ORIGINAL_FILE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOriginalFilePath() <em>Original File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalFilePath()
	 * @generated
	 * @ordered
	 */
	protected String originalFilePath = ORIGINAL_FILE_PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected AbstractTypeDeclaration type;

	/**
	 * The cached value of the '{@link #getAttachedSource() <em>Attached Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttachedSource()
	 * @generated
	 * @ordered
	 */
	protected CompilationUnit attachedSource;

	/**
	 * The cached value of the '{@link #getPackage() <em>Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected javaMM.Package package_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavaMMPackage.Literals.CLASS_FILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOriginalFilePath() {
		return originalFilePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOriginalFilePath(String newOriginalFilePath) {
		String oldOriginalFilePath = originalFilePath;
		originalFilePath = newOriginalFilePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaMMPackage.CLASS_FILE__ORIGINAL_FILE_PATH, oldOriginalFilePath, originalFilePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractTypeDeclaration getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (AbstractTypeDeclaration)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JavaMMPackage.CLASS_FILE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTypeDeclaration basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(AbstractTypeDeclaration newType) {
		AbstractTypeDeclaration oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaMMPackage.CLASS_FILE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompilationUnit getAttachedSource() {
		if (attachedSource != null && attachedSource.eIsProxy()) {
			InternalEObject oldAttachedSource = (InternalEObject)attachedSource;
			attachedSource = (CompilationUnit)eResolveProxy(oldAttachedSource);
			if (attachedSource != oldAttachedSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JavaMMPackage.CLASS_FILE__ATTACHED_SOURCE, oldAttachedSource, attachedSource));
			}
		}
		return attachedSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompilationUnit basicGetAttachedSource() {
		return attachedSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAttachedSource(CompilationUnit newAttachedSource) {
		CompilationUnit oldAttachedSource = attachedSource;
		attachedSource = newAttachedSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaMMPackage.CLASS_FILE__ATTACHED_SOURCE, oldAttachedSource, attachedSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public javaMM.Package getPackage() {
		if (package_ != null && package_.eIsProxy()) {
			InternalEObject oldPackage = (InternalEObject)package_;
			package_ = (javaMM.Package)eResolveProxy(oldPackage);
			if (package_ != oldPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JavaMMPackage.CLASS_FILE__PACKAGE, oldPackage, package_));
			}
		}
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public javaMM.Package basicGetPackage() {
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPackage(javaMM.Package newPackage) {
		javaMM.Package oldPackage = package_;
		package_ = newPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaMMPackage.CLASS_FILE__PACKAGE, oldPackage, package_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JavaMMPackage.CLASS_FILE__ORIGINAL_FILE_PATH:
				return getOriginalFilePath();
			case JavaMMPackage.CLASS_FILE__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case JavaMMPackage.CLASS_FILE__ATTACHED_SOURCE:
				if (resolve) return getAttachedSource();
				return basicGetAttachedSource();
			case JavaMMPackage.CLASS_FILE__PACKAGE:
				if (resolve) return getPackage();
				return basicGetPackage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JavaMMPackage.CLASS_FILE__ORIGINAL_FILE_PATH:
				setOriginalFilePath((String)newValue);
				return;
			case JavaMMPackage.CLASS_FILE__TYPE:
				setType((AbstractTypeDeclaration)newValue);
				return;
			case JavaMMPackage.CLASS_FILE__ATTACHED_SOURCE:
				setAttachedSource((CompilationUnit)newValue);
				return;
			case JavaMMPackage.CLASS_FILE__PACKAGE:
				setPackage((javaMM.Package)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case JavaMMPackage.CLASS_FILE__ORIGINAL_FILE_PATH:
				setOriginalFilePath(ORIGINAL_FILE_PATH_EDEFAULT);
				return;
			case JavaMMPackage.CLASS_FILE__TYPE:
				setType((AbstractTypeDeclaration)null);
				return;
			case JavaMMPackage.CLASS_FILE__ATTACHED_SOURCE:
				setAttachedSource((CompilationUnit)null);
				return;
			case JavaMMPackage.CLASS_FILE__PACKAGE:
				setPackage((javaMM.Package)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case JavaMMPackage.CLASS_FILE__ORIGINAL_FILE_PATH:
				return ORIGINAL_FILE_PATH_EDEFAULT == null ? originalFilePath != null : !ORIGINAL_FILE_PATH_EDEFAULT.equals(originalFilePath);
			case JavaMMPackage.CLASS_FILE__TYPE:
				return type != null;
			case JavaMMPackage.CLASS_FILE__ATTACHED_SOURCE:
				return attachedSource != null;
			case JavaMMPackage.CLASS_FILE__PACKAGE:
				return package_ != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (originalFilePath: ");
		result.append(originalFilePath);
		result.append(')');
		return result.toString();
	}

} //ClassFileImpl
