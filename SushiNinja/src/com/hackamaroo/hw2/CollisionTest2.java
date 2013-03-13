package com.hackamaroo.hw2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CollisionTest2 {

	Collision c;
	Point p1;
	Point p2;
	List<Point> pdrawn; 
	
	@Before
	public void setUp() {
		// line from (0,0) to (12,6)
		// circle centered at (8,0) with radius 5
		// Should intersect, min distance should be 4 ish
		c = new Collision();
		p1 = new Point(0, 0, 1, 1, false);
		p2 = new Point(12, 6, 1, 1, true);
		pdrawn = new ArrayList<Point>(); 
		pdrawn.add(p1);
		pdrawn.add(p1);
		pdrawn.add(p2);
	}
	
	@Test
	public void test() {
		boolean result = c.checkCollisionAY(p1, p2, 8, 0, 8);
		assertTrue(result);
		System.out.println(c.getMinDist());
	}
	
	@Test
	public void testFalse() {
		boolean result = c.checkCollisionAY(p1, p2, 8, 0, 2);
		assertFalse(result);
		System.out.println(c.getMinDist());
	}
	
	@Test
	public void testList() {
		boolean result = c.checkCollisionAY(pdrawn.get(pdrawn.size()-2), pdrawn.get(pdrawn.size()-1), 8, 0, 8);
		assertTrue(result);
		System.out.println(c.getMinDist());
	}
}
