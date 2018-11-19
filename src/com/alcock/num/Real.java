package com.alcock.num;

public class Real {
	protected static Real Zero = new Real(0);
	protected static Real One = new Real(1);
	
	protected double value;
	
	public Real(double value) {
		this.value = value;
	}
	
	public Real abs() {
		return new Real(Math.abs(value));
	}

	public Real add(Real other) {
		return other.equals(Zero) ? this : new Real(value + other.value);
	}
	
	public Real sub(Real other) {
		return other.equals(Zero) ? this : new Real(value - other.value);
	}
	
	public Real mul(Real other) {
		return other.equals(One) ? this : new Real(value * other.value);
	}
	
	public Real div(Real other) {
		return other.equals(One) ? this : new Real(value / other.value);
	}
}
