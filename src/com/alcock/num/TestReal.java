package com.alcock.num;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestReal {

	@Test
	void testAdd() {
		Real two = new Real(2);
		Real ten = new Real(10);
		Real twelve = new Real(12);
		Real sum = two.add(ten);
		
		assertEquals(sum, twelve);
	}
	
	protected ArrayList<Real> quadraticRoots(Real a, Real b, Real c) {
		Real discriminant = b.pow(new Real(2)).sub(new Real(4).mul(a).mul(c)).pow(new Real(0.5));
		Real root1 = b.neg().add(discriminant).div(new Real(2).mul(a));
		Real root2 = b.neg().sub(discriminant).div(new Real(2).mul(a));
				
		ArrayList<Real> roots = new ArrayList<>(2);
		roots.add(root1);
		roots.add(root2);
		return roots;
	}
	
	@Test
	void testQuadratic() {
		// (x - 2)(x - 3)
		Real a = new Real(1);
		Real b = new Real(-5);
		Real c = new Real(6);
		ArrayList<Real> roots = quadraticRoots(a, b, c);
		
		assertEquals(roots.size(), 2);
		Real root1 = roots.get(0);
		Real root2 = roots.get(1);
		Real epsilon = new Real(0.00000001);
		Real ans1 = new Real(2);
		Real ans2 = new Real(3);
		
		assertTrue(root1.equals(ans1, epsilon) || root1.equals(ans2, epsilon));
		assertTrue(root2.equals(ans1, epsilon) || root2.equals(ans2, epsilon));
	}
}
