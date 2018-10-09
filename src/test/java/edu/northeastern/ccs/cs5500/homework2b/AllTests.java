package edu.northeastern.ccs.cs5500.homework2b;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(TestCases.class);
		//$JUnit-END$
		return suite;
	}

}
