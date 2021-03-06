/* COPYRIGHT (C) 2013 Angela M Yu, Ana Mei, Kevin Zhao, and Chris Chow. All Rights Reserved. */
package com.project.sushi;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PointTest {

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
	}
	
	@Test
	public void testPointFloatFloatIntIntBoolean() {
		assertTrue(p1.getX() ==2);
		assertTrue(p1.getY() ==4);
		assertTrue(p1.getColor() ==1111);
		assertTrue(p1.getSize() == 3);
		assertTrue(p1.getFirst() ==true);
		
		assertTrue(p2.getX() ==-2);
		assertTrue(p2.getY() ==-4);
		assertTrue(p2.getColor() ==1010);
		assertTrue(p2.getSize() == 0);
		assertTrue(p2.getFirst() ==false);
	}

	@Test
	public void testPointDoubleDouble() {
		assertTrue(c.getX() ==2);
		assertTrue(c.getY() ==4);
		assertTrue(c.getColor() ==-1);
		assertTrue(c.getSize() == -1);
		assertTrue(c.getFirst() ==false);
		
		assertTrue(n.getX() ==-2);
		assertTrue(n.getY() ==-4);
		assertTrue(n.getColor() ==-1);
		assertTrue(n.getSize() == -1);
		assertTrue(n.getFirst() ==false);
		
		assertTrue(z.getX() ==0);
		assertTrue(z.getY() ==0);
		assertTrue(z.getColor() ==-1);
		assertTrue(z.getSize() == -1);
		assertTrue(z.getFirst() ==false);
	}

	@Test
	public void testSetX() {
		z.setX(10);
		assertTrue(z.getX() ==10);
	}

	@Test
	public void testSetY() {
		z.setY(10);
		assertTrue(z.getY() ==10);
	}

	@Test
	public void testSetColor() {
		z.setColor(10);
		assertTrue(z.getColor() ==10);
	}

	@Test
	public void testSetSize() {
		z.setSize(10);
		assertTrue(z.getSize() ==10);
	}

	@Test
	public void testDistance() {
		assertTrue(z.distance(c) == Math.sqrt(20));
		assertTrue(z.distance(n) == Math.sqrt(20));
		assertTrue(c.distance(n) == Math.sqrt(80));
		assertTrue(p1.distance(p2) == Math.sqrt(80));
		assertTrue(p1.distance(c) == 0);
		//reverse direction
		assertTrue(c.distance(z) == Math.sqrt(20));
		assertTrue(n.distance(z) == Math.sqrt(20));
		assertTrue(n.distance(c) == Math.sqrt(80));
		assertTrue(c.distance(p1) == 0);
	}

}
