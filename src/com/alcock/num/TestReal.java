package com.alcock.num;

import static org.junit.jupiter.api.Assertions.*;

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
}
