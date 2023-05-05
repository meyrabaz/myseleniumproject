package com.myfirstproject;

import org.junit.Test;

import static org.junit.Assert.*;


public class Day03_Assertions {
    /*
    What is assertion?
    Assertion is done to make sure expected status and actual status are equal
    Without assertion there will be no automation test. Assertions are mandatory in testing
    Assertion is done  to improve the quality of the application and to create bug-free applications
    expected = actual ==> PASS
    expected != actual ==> FAIL
    __________________________

    assertEquals(expected, actual); If expected = actual PASS(Data Types are important)
    assertEquals(expected, actual); If expected != actual FAIL
    assertTrue(true) ==> PASS
    assertTrue(false) ==> FAIL
    assertFalse(false) ==> PASS
    assertFalse(true) ==> FAIL
    __________________________

    These assertions are hard assertions
    If one of them fails Java will stop executions and rest of the tests will not be executed.
    For ex: if line 45 fails the rests will not be executed
    _________________________

    What is difference between Assertion and Verification?
    Assertion ==> Hard Assertion: In failure execution will stop.
    Verification ==> Soft Assertion : In failure execution will not stop.




     Assertion VS Verification?

    * Assertion = Hard assertion which means test case stops if this assertion fails

    * Verification = soft assertion = Not hard assertion which means the test case continue to execute even after FAILURE. Eg : if else


     */

    @Test
    public void test01() {

        assertEquals(2, 2);
        assertEquals("Expected and Actual data did not match", 2, 2); // 1=2
        assertTrue("John".endsWith("n"));
        assertFalse("John".contains("X"));//Mostly used for negative tests

    }


}