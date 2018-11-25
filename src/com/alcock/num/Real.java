package com.alcock.num;

public class Real {
	public static Real Zero = new Real(0); // identity element for addition
	public static Real One = new Real(1); // identity element for multiplication
	public static Real Pi = new Real(Math.PI);
	public static Real E = new Real(Math.E);
	
	protected double value;
	
	public Real(double value) {
		this.value = value;
	}
	
	public Real len() {
		return value >= 0 ? this : new Real(-value);
	}
	
	public Real neg() { // additive inverse, negation
		return this.equals(Zero) ? this : new Real(-value);
	}
	
	public Real rec() { // multiplicative inverse, reciprocal
		return this.equals(One) ? this : new Real(1.0 / value);
	}

	public Real add(Real other) {
		return other.equals(Zero) ? this : new Real(value + other.value);
	}
	
	public Real sub(Real other) {
		return add(other.neg());
	}
	
	public Real mul(Real other) {
		return other.equals(One) ? this : new Real(value * other.value);
	}
	
	public Real div(Real other) {
		return mul(other.rec());
	}
	
	public Real pow(Real other) {
		return other.equals(One) ? this :
				other.equals(Zero) ? One :
				new Real(Math.pow(value, other.value));
	}
	
	public boolean lt(Real other) {
		return this.value < other.value;
	}
	
	public boolean gt(Real other) {
		return this.value > other.value;
	}
	
	public boolean eq(Real other) {
		return this.value == other.value;
	}
	
	public boolean lte(Real other) {
		return lt(other) || eq(other);
	}
	
	public boolean gte(Real other) {
		return gt(other) || eq(other);
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		else if (other == null || this.getClass() != other.getClass())
			return false;
		else {
			Real that = (Real) other;
			
			return eq(that);
		}
	}
	
	@Override
	public int hashCode() {
		return Double.hashCode(value);
	}
	
	@Override
	public String toString() {
		return "Real(" + value + ")";
	}
	
	public boolean equals(Real other, Real epsilon) {
		return this.sub(other).len().lte(epsilon.len());
	}
}
