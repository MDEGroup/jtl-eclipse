/**
 */
package JTL.template.impl;

import JTL.JTL.JTLPackage;

import JTL.JTL.impl.JTLPackageImpl;

import JTL.emof.EmofPackage;

import JTL.emof.impl.EmofPackageImpl;

import JTL.essentialocl.EssentialoclPackage;

import JTL.essentialocl.impl.EssentialoclPackageImpl;

import JTL.imperativeocl.ImperativeoclPackage;

import JTL.imperativeocl.impl.ImperativeoclPackageImpl;

import JTL.template.CollectionTemplateExp;
import JTL.template.ObjectTemplateExp;
import JTL.template.PropertyTemplateItem;
import JTL.template.TemplateExp;
import JTL.template.TemplateFactory;
import JTL.template.TemplatePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TemplatePackageImpl extends EPackageImpl implements TemplatePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectTemplateExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionTemplateExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyTemplateItemEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see JTL.template.TemplatePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TemplatePackageImpl() {
		super(eNS_URI, TemplateFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link TemplatePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TemplatePackage init() {
		if (isInited) return (TemplatePackage)EPackage.Registry.INSTANCE.getEPackage(TemplatePackage.eNS_URI);

		// Obtain or create and register package
		TemplatePackageImpl theTemplatePackage = (TemplatePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TemplatePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TemplatePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		EmofPackageImpl theEmofPackage = (EmofPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EmofPackage.eNS_URI) instanceof EmofPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EmofPackage.eNS_URI) : EmofPackage.eINSTANCE);
		JTLPackageImpl theJTLPackage = (JTLPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(JTLPackage.eNS_URI) instanceof JTLPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(JTLPackage.eNS_URI) : JTLPackage.eINSTANCE);
		EssentialoclPackageImpl theEssentialoclPackage = (EssentialoclPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EssentialoclPackage.eNS_URI) instanceof EssentialoclPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EssentialoclPackage.eNS_URI) : EssentialoclPackage.eINSTANCE);
		ImperativeoclPackageImpl theImperativeoclPackage = (ImperativeoclPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ImperativeoclPackage.eNS_URI) instanceof ImperativeoclPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ImperativeoclPackage.eNS_URI) : ImperativeoclPackage.eINSTANCE);

		// Create package meta-data objects
		theTemplatePackage.createPackageContents();
		theEmofPackage.createPackageContents();
		theJTLPackage.createPackageContents();
		theEssentialoclPackage.createPackageContents();
		theImperativeoclPackage.createPackageContents();

		// Initialize created meta-data
		theTemplatePackage.initializePackageContents();
		theEmofPackage.initializePackageContents();
		theJTLPackage.initializePackageContents();
		theEssentialoclPackage.initializePackageContents();
		theImperativeoclPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTemplatePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TemplatePackage.eNS_URI, theTemplatePackage);
		return theTemplatePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateExp() {
		return templateExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateExp_BindsTo() {
		return (EReference)templateExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateExp_Where() {
		return (EReference)templateExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectTemplateExp() {
		return objectTemplateExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectTemplateExp_Part() {
		return (EReference)objectTemplateExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectTemplateExp_ReferredClass() {
		return (EAttribute)objectTemplateExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectTemplateExp_Inside() {
		return (EReference)objectTemplateExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionTemplateExp() {
		return collectionTemplateExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionTemplateExp_Part() {
		return (EReference)collectionTemplateExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionTemplateExp_Kind() {
		return (EAttribute)collectionTemplateExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionTemplateExp_ReferredCollectionType() {
		return (EReference)collectionTemplateExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionTemplateExp_Match() {
		return (EReference)collectionTemplateExpEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyTemplateItem() {
		return propertyTemplateItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyTemplateItem_ObjContainer() {
		return (EReference)propertyTemplateItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyTemplateItem_Value() {
		return (EReference)propertyTemplateItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyTemplateItem_ReferredProperty() {
		return (EReference)propertyTemplateItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateFactory getTemplateFactory() {
		return (TemplateFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		templateExpEClass = createEClass(TEMPLATE_EXP);
		createEReference(templateExpEClass, TEMPLATE_EXP__BINDS_TO);
		createEReference(templateExpEClass, TEMPLATE_EXP__WHERE);

		objectTemplateExpEClass = createEClass(OBJECT_TEMPLATE_EXP);
		createEReference(objectTemplateExpEClass, OBJECT_TEMPLATE_EXP__PART);
		createEAttribute(objectTemplateExpEClass, OBJECT_TEMPLATE_EXP__REFERRED_CLASS);
		createEReference(objectTemplateExpEClass, OBJECT_TEMPLATE_EXP__INSIDE);

		collectionTemplateExpEClass = createEClass(COLLECTION_TEMPLATE_EXP);
		createEReference(collectionTemplateExpEClass, COLLECTION_TEMPLATE_EXP__PART);
		createEAttribute(collectionTemplateExpEClass, COLLECTION_TEMPLATE_EXP__KIND);
		createEReference(collectionTemplateExpEClass, COLLECTION_TEMPLATE_EXP__REFERRED_COLLECTION_TYPE);
		createEReference(collectionTemplateExpEClass, COLLECTION_TEMPLATE_EXP__MATCH);

		propertyTemplateItemEClass = createEClass(PROPERTY_TEMPLATE_ITEM);
		createEReference(propertyTemplateItemEClass, PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER);
		createEReference(propertyTemplateItemEClass, PROPERTY_TEMPLATE_ITEM__VALUE);
		createEReference(propertyTemplateItemEClass, PROPERTY_TEMPLATE_ITEM__REFERRED_PROPERTY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EssentialoclPackage theEssentialoclPackage = (EssentialoclPackage)EPackage.Registry.INSTANCE.getEPackage(EssentialoclPackage.eNS_URI);
		ImperativeoclPackage theImperativeoclPackage = (ImperativeoclPackage)EPackage.Registry.INSTANCE.getEPackage(ImperativeoclPackage.eNS_URI);
		EmofPackage theEmofPackage = (EmofPackage)EPackage.Registry.INSTANCE.getEPackage(EmofPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		templateExpEClass.getESuperTypes().add(theEssentialoclPackage.getLiteralExp());
		objectTemplateExpEClass.getESuperTypes().add(this.getTemplateExp());
		collectionTemplateExpEClass.getESuperTypes().add(this.getTemplateExp());
		propertyTemplateItemEClass.getESuperTypes().add(theEmofPackage.getElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(templateExpEClass, TemplateExp.class, "TemplateExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplateExp_BindsTo(), theEssentialoclPackage.getVariable(), null, "bindsTo", null, 0, 1, TemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTemplateExp_Where(), theEssentialoclPackage.getOclExpression(), null, "where", null, 0, 1, TemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(objectTemplateExpEClass, ObjectTemplateExp.class, "ObjectTemplateExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectTemplateExp_Part(), this.getPropertyTemplateItem(), this.getPropertyTemplateItem_ObjContainer(), "part", null, 0, -1, ObjectTemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObjectTemplateExp_ReferredClass(), ecorePackage.getEString(), "referredClass", null, 0, 1, ObjectTemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObjectTemplateExp_Inside(), theImperativeoclPackage.getAssignExp(), null, "inside", null, 0, -1, ObjectTemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(collectionTemplateExpEClass, CollectionTemplateExp.class, "CollectionTemplateExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionTemplateExp_Part(), theEssentialoclPackage.getOclExpression(), null, "part", null, 0, -1, CollectionTemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionTemplateExp_Kind(), theEssentialoclPackage.getCollectionKind(), "kind", null, 0, 1, CollectionTemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCollectionTemplateExp_ReferredCollectionType(), theEssentialoclPackage.getCollectionType(), null, "referredCollectionType", null, 0, 1, CollectionTemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCollectionTemplateExp_Match(), theEssentialoclPackage.getOclExpression(), null, "match", null, 0, 1, CollectionTemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(propertyTemplateItemEClass, PropertyTemplateItem.class, "PropertyTemplateItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyTemplateItem_ObjContainer(), this.getObjectTemplateExp(), this.getObjectTemplateExp_Part(), "objContainer", null, 1, 1, PropertyTemplateItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPropertyTemplateItem_Value(), theEssentialoclPackage.getOclExpression(), null, "value", null, 1, 1, PropertyTemplateItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPropertyTemplateItem_ReferredProperty(), theEmofPackage.getProperty(), null, "referredProperty", null, 1, 1, PropertyTemplateItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //TemplatePackageImpl
