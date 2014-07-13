/**
 */
package de.urszeidler.shr5.scripting.impl;

import de.urszeidler.eclipse.shr5.Shr5Package;

import de.urszeidler.eclipse.shr5.runtime.RuntimePackage;

import de.urszeidler.eclipse.shr5Management.Shr5managementPackage;

import de.urszeidler.shr5.scripting.Placement;
import de.urszeidler.shr5.scripting.Script;
import de.urszeidler.shr5.scripting.ScriptingFactory;
import de.urszeidler.shr5.scripting.ScriptingPackage;

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
public class ScriptingPackageImpl extends EPackageImpl implements ScriptingPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scriptEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass placementEClass = null;

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
     * @see de.urszeidler.shr5.scripting.ScriptingPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ScriptingPackageImpl() {
        super(eNS_URI, ScriptingFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link ScriptingPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ScriptingPackage init() {
        if (isInited) return (ScriptingPackage)EPackage.Registry.INSTANCE.getEPackage(ScriptingPackage.eNS_URI);

        // Obtain or create and register package
        ScriptingPackageImpl theScriptingPackage = (ScriptingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ScriptingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ScriptingPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        RuntimePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theScriptingPackage.createPackageContents();

        // Initialize created meta-data
        theScriptingPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theScriptingPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(ScriptingPackage.eNS_URI, theScriptingPackage);
        return theScriptingPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getScript() {
        return scriptEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getScript_Placements() {
        return (EReference)scriptEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getScript_AllTeams() {
        return (EReference)scriptEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getScript_Player() {
        return (EReference)scriptEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getScript_Management() {
        return (EReference)scriptEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPlacement() {
        return placementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPlacement_NextPlacements() {
        return (EReference)placementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPlacement_Teams() {
        return (EReference)placementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPlacement_Background() {
        return (EAttribute)placementEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPlacement_InTheirFace() {
        return (EAttribute)placementEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPlacement_Script() {
        return (EReference)placementEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPlacement_Debugging() {
        return (EAttribute)placementEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPlacement_Enviorment() {
        return (EReference)placementEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ScriptingFactory getScriptingFactory() {
        return (ScriptingFactory)getEFactoryInstance();
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
        scriptEClass = createEClass(SCRIPT);
        createEReference(scriptEClass, SCRIPT__PLACEMENTS);
        createEReference(scriptEClass, SCRIPT__ALL_TEAMS);
        createEReference(scriptEClass, SCRIPT__PLAYER);
        createEReference(scriptEClass, SCRIPT__MANAGEMENT);

        placementEClass = createEClass(PLACEMENT);
        createEReference(placementEClass, PLACEMENT__NEXT_PLACEMENTS);
        createEReference(placementEClass, PLACEMENT__TEAMS);
        createEAttribute(placementEClass, PLACEMENT__BACKGROUND);
        createEAttribute(placementEClass, PLACEMENT__IN_THEIR_FACE);
        createEReference(placementEClass, PLACEMENT__SCRIPT);
        createEAttribute(placementEClass, PLACEMENT__DEBUGGING);
        createEReference(placementEClass, PLACEMENT__ENVIORMENT);
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
        Shr5Package theShr5Package = (Shr5Package)EPackage.Registry.INSTANCE.getEPackage(Shr5Package.eNS_URI);
        RuntimePackage theRuntimePackage = (RuntimePackage)EPackage.Registry.INSTANCE.getEPackage(RuntimePackage.eNS_URI);
        Shr5managementPackage theShr5managementPackage = (Shr5managementPackage)EPackage.Registry.INSTANCE.getEPackage(Shr5managementPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        scriptEClass.getESuperTypes().add(theShr5Package.getBeschreibbar());
        placementEClass.getESuperTypes().add(theShr5Package.getBeschreibbar());

        // Initialize classes, features, and operations; add parameters
        initEClass(scriptEClass, Script.class, "Script", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getScript_Placements(), this.getPlacement(), this.getPlacement_Script(), "placements", null, 0, -1, Script.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getScript_AllTeams(), theRuntimePackage.getTeam(), null, "allTeams", null, 0, -1, Script.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getScript_Player(), theRuntimePackage.getTeam(), null, "player", null, 0, 1, Script.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getScript_Management(), theShr5managementPackage.getGamemasterManagement(), null, "management", null, 1, 1, Script.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(placementEClass, Placement.class, "Placement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPlacement_NextPlacements(), this.getPlacement(), null, "nextPlacements", null, 0, -1, Placement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPlacement_Teams(), theRuntimePackage.getTeam(), null, "teams", null, 0, -1, Placement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPlacement_Background(), ecorePackage.getEString(), "background", null, 0, -1, Placement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPlacement_InTheirFace(), ecorePackage.getEString(), "inTheirFace", null, 0, -1, Placement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPlacement_Script(), this.getScript(), this.getScript_Placements(), "script", null, 0, 1, Placement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPlacement_Debugging(), ecorePackage.getEString(), "debugging", null, 0, -1, Placement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPlacement_Enviorment(), theRuntimePackage.getEnviorment(), null, "enviorment", null, 1, 1, Placement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //ScriptingPackageImpl