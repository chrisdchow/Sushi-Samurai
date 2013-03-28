package com.hackamaroo.hw2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VectorTest {

	private Vector vcn; 
	private Vector vcnUnit; 
	private Vector vp1p2; 
	private Vector vzp1; 
	private Point p1;
	private Point p2; 
	private Point c; 
	private Point n; 
	private Point z;
	
	@Before
	public void setUp() {
		p1 = new Point(2, 4, 1111, 3, true); 
		p2 = new Point(-2, -4, 1010, 0, false); 
		c = new Point(2, 4); 
		n = new Point(-2, -4);
		z = new Point(0,0);
		vcn = new Vector(c, n);
		vcnUnit = new Vector(c,n);
		vcnUnit.makeUnit();
		vp1p2 = new Vector(p1,p2);
		vzp1 = new Vector(z,p1);
	}

	@Test
	public void testMakeUnit() {
		assertTrue(vcnUnit.magnitude() - 1.0 < 0.0000001);
	}

	@Test
	public void testMagnitude() {
		assertTrue(vcnUnit.magnitude() - 1.0 < 0.0000001);
		assertTrue(vcn.magnitude() == Math.sqrt(80));
		assertTrue(vp1p2.magnitude() == Math.sqrt(80));
		assertTrue(vzp1.magnitude() == Math.sqrt(20));
	}

	@Test
	public void testDot() {
		assertTrue(vcnUnit.dot(vcn) == 8.94427190999916);
		assertTrue(vcnUnit.dot(vcnUnit) - 1.0 < 0.0000001);
		//Can add more here
	}

	@Test
	public void testTimesAdd() {
		Point tacn = vcn.timesAdd(2, p2);
		System.out.println(tacn.getX());
		System.out.println(tacn.getY());
		assertTrue(tacn.getX() == -10);
		assertTrue(tacn.getY() == -20);
		//Can add more here
	}


}
