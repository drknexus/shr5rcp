/**
 * (c) Urs Zeilder
 */
package de.urszeidler.eclipse.shr5.gameplay.tests;

import junit.textui.TestRunner;
import de.urszeidler.eclipse.shr5.AbstraktPersona;
import de.urszeidler.eclipse.shr5.Fertigkeit;
import de.urszeidler.eclipse.shr5.FeuerModus;
import de.urszeidler.eclipse.shr5.Feuerwaffe;
import de.urszeidler.eclipse.shr5.PersonaFertigkeit;
import de.urszeidler.eclipse.shr5.Shr5Factory;
import de.urszeidler.eclipse.shr5.Shr5Package;
import de.urszeidler.eclipse.shr5.gameplay.GameplayFactory;
import de.urszeidler.eclipse.shr5.gameplay.RangedAttackCmd;
import de.urszeidler.eclipse.shr5.gameplay.util.GameplayTools;
import de.urszeidler.eclipse.shr5.runtime.RuntimeCharacter;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Ranged Attack Cmd</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RangedAttackCmdTest extends OpposedSkillTestCmdTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(RangedAttackCmdTest.class);
    }

    /**
     * Constructs a new Ranged Attack Cmd test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RangedAttackCmdTest(String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Ranged Attack Cmd test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected RangedAttackCmd getFixture() {
        return (RangedAttackCmd)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(GameplayFactory.eINSTANCE.createRangedAttackCmd());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#tearDown()
     * @generated
     */
    @Override
    protected void tearDown() throws Exception {
        setFixture(null);
    }

    /**
     * Tests the '{@link de.urszeidler.eclipse.shr5.gameplay.Command#isCanExecute() <em>Can Execute</em>}' feature getter.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see de.urszeidler.eclipse.shr5.gameplay.Command#isCanExecute()
     * @generated not
     */
    public void testIsCanExecute() {
        assertFalse(getFixture().isCanExecute());
        getFixture().setSubject(GameplayTools.createRuntimeCharacter());
        assertTrue(getFixture().isCanExecute());
    }

    /**
     * Tests the '{@link de.urszeidler.eclipse.shr5.gameplay.Command#redo() <em>Redo</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see de.urszeidler.eclipse.shr5.gameplay.Command#redo()
     * @generated not
     */
    public void testRedo() {
        RuntimeCharacter runtimeCharacter = GameplayTools.createRuntimeCharacter();
        RuntimeCharacter object = GameplayTools.createRuntimeCharacter();
        AbstraktPersona persona = runtimeCharacter.getCharacter().getPersona();
        persona.setGeschicklichkeitBasis(1);

        Feuerwaffe fw = Shr5Factory.eINSTANCE.createFeuerwaffe();
        fw.getModie().add(FeuerModus.EM);
        Fertigkeit fertigkeit = Shr5Factory.eINSTANCE.createFertigkeit();
        fertigkeit.setAttribut(Shr5Package.Literals.KOERPERLICHE_ATTRIBUTE__GESCHICKLICHKEIT);

        PersonaFertigkeit personaFertigkeit = Shr5Factory.eINSTANCE.createPersonaFertigkeit();
        personaFertigkeit.setFertigkeit(fertigkeit);
        personaFertigkeit.setStufe(1);
        persona.getFertigkeiten().add(personaFertigkeit);

        fw.setFertigkeit(fertigkeit);
        getFixture().setSubject(runtimeCharacter);
        getFixture().setWeapon(fw);
        getFixture().setObject(object);

        getFixture().redo();

        assertTrue(getFixture().isExecuted());
        assertEquals(2, getFixture().getProbe().size());
    }

    /**
     * Tests the '{@link de.urszeidler.eclipse.shr5.gameplay.Command#redo() <em>Redo</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see de.urszeidler.eclipse.shr5.gameplay.Command#redo()
     * @generated not
     */
    public void testRedo_Damage() {
        RuntimeCharacter runtimeCharacter = GameplayTools.createRuntimeCharacter();
        RuntimeCharacter object = GameplayTools.createRuntimeCharacter();
        AbstraktPersona persona = runtimeCharacter.getCharacter().getPersona();
        persona.setGeschicklichkeitBasis(1);

        Feuerwaffe fw = Shr5Factory.eINSTANCE.createFeuerwaffe();
        fw.setPraezision(20);
        fw.getModie().add(FeuerModus.EM);
        fw.setSchadenscode("10P");
        Fertigkeit fertigkeit = Shr5Factory.eINSTANCE.createFertigkeit();
        fertigkeit.setAttribut(Shr5Package.Literals.KOERPERLICHE_ATTRIBUTE__GESCHICKLICHKEIT);

        PersonaFertigkeit personaFertigkeit = Shr5Factory.eINSTANCE.createPersonaFertigkeit();
        personaFertigkeit.setFertigkeit(fertigkeit);
        personaFertigkeit.setStufe(100);
        persona.getFertigkeiten().add(personaFertigkeit);

        fw.setFertigkeit(fertigkeit);
        getFixture().setSubject(runtimeCharacter);
        getFixture().setWeapon(fw);
        getFixture().setObject(object);

        getFixture().redo();

        assertTrue(getFixture().isExecuted());
        assertEquals(101, getFixture().getProbe().size());
        assertEquals(20, getFixture().getSuccesses());
        assertEquals(2, getFixture().getSubCommands().size());
    }

    /**
     * Tests the '{@link de.urszeidler.eclipse.shr5.gameplay.Command#undo() <em>Undo</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see de.urszeidler.eclipse.shr5.gameplay.Command#undo()
     * @generated not
     */
    public void testUndo() {
        // fail();
    }

    
} //RangedAttackCmdTest
