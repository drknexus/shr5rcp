/**
 */
package de.urszeidler.eclipse.shr5.tests;

import junit.textui.TestRunner;
import de.urszeidler.eclipse.shr5.MudanPersona;
import de.urszeidler.eclipse.shr5.Shr5Factory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Mudan Persona</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MudanPersonaTest extends KoerperPersonaTest {

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static void main(String[] args) {
        TestRunner.run(MudanPersonaTest.class);
    }

	/**
     * Constructs a new Mudan Persona test case with the given name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MudanPersonaTest(String name) {
        super(name);
    }

	/**
     * Returns the fixture for this Mudan Persona test case.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected MudanPersona getFixture() {
        return (MudanPersona)fixture;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
	@Override
	protected void setUp() throws Exception {
        setFixture(Shr5Factory.eINSTANCE.createMudanPersona());
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

} //MudanPersonaTest
