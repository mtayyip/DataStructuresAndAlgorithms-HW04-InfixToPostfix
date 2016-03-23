/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Muhammet
 */
public class AssemblyTest {
    
    public AssemblyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of convertToAssembly method, of class Assembly.
     */
    @Test
    public void testConvertToAssembly() {
        System.out.println("convertToAssembly");
        String postfix = "";
        Assembly instance = new Assembly();
        String expResult = "";
        String result = instance.convertToAssembly(postfix);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Operatoradd method, of class Assembly.
     * @throws java.lang.Exception
     */
    @Test
    public void testOperatoradd() throws Exception {
        System.out.println("Operatoradd");
        Assembly instance = new Assembly();
        instance.Operatoradd();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Operatorsub method, of class Assembly.
     * @throws java.lang.Exception
     */
    @Test
    public void testOperatorsub() throws Exception {
        System.out.println("Operatorsub");
        Assembly instance = new Assembly();
        instance.Operatorsub();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Operatormult method, of class Assembly.
     * @throws java.lang.Exception
     */
    @Test
    public void testOperatormult() throws Exception {
        System.out.println("Operatormult");
        Assembly instance = new Assembly();
        instance.Operatormult();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Operatordiv method, of class Assembly.
     * @throws java.lang.Exception
     */
    @Test
    public void testOperatordiv() throws Exception {
        System.out.println("Operatordiv");
        Assembly instance = new Assembly();
        instance.Operatordiv();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Operatorli method, of class Assembly.
     * @throws java.lang.Exception
     */
    @Test
    public void testOperatorli() throws Exception {
        System.out.println("Operatorli");
        String c = "";
        Assembly instance = new Assembly();
        instance.Operatorli(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Operatorassign method, of class Assembly.
     */
    @Test
    public void testOperatorassign() {
        System.out.println("Operatorassign");
        Assembly instance = new Assembly();
        instance.Operatorassign();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of assign method, of class Assembly.
     */
    @Test
    public void testAssign() {
        System.out.println("assign");
        String c1 = "";
        String c2 = "";
        Assembly instance = new Assembly();
        instance.assign(c1, c2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of karakterBakma method, of class Assembly.
     * @throws java.lang.Exception
     */
    @Test
    public void testKarakterBakma() throws Exception {
        System.out.println("karakterBakma");
        String c = "";
        Assembly instance = new Assembly();
        int expResult = 0;
        int result = instance.karakterBakma(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of boskenRegisterYapma method, of class Assembly.
     * @throws java.lang.Exception
     */
    @Test
    public void testBoskenRegisterYapma() throws Exception {
        System.out.println("boskenRegisterYapma");
        String c = "";
        Assembly instance = new Assembly();
        instance.boskenRegisterYapma(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
