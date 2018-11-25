package com.alcock.num;

public class Complex {
	public static Complex Zero = new Complex(0, 0); // identity element for addition
	public static Complex One = new Complex(1, 0); // identity element for multiplication
	public static Complex I = new Complex(0, 1);
	public static Complex Pi = new Complex(Math.PI, 0);
	public static Complex E = new Complex(Math.E, 0);
	
	protected double real, imag;
	
	public Complex(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}
	
	public double len() {
		return Math.sqrt(real*real + imag*imag);
	}
	
	public Complex neg() { // additive inverse, negation
		return this.equals(Zero) ? this : new Complex(-real, -imag);
	}
	
	public Complex rec() { // multiplicative inverse, reciprocal
		return this.equals(One) ? this : new Complex();
	}

	public Complex add(Complex other) {
		return other.equals(Zero) ? this : new Complex(real + other.real, imag + other.imag);
	}
	
	public Complex sub(Complex other) {
		return add(other.neg());
	}
	
	public Complex mul(Complex other) {
		return other.equals(One) ? this : new Complex(real * other.real - imag*other.imag, real*other.imag + imag*other.real);
	}
	
	public Complex div(Complex other) {
		return mul(other.rec());
	}
	
	public Complex pow(Complex other) {
		return other.equals(One) ? this :
				other.equals(Zero) ? One :
				new Complex(Math.pow(value, other.value));
	}
	
	public boolean lt(Complex other) {
		return this.value < other.value;
	}
	
	public boolean gt(Complex other) {
		return this.value > other.value;
	}
	
	public boolean eq(Complex other) {
		return this.value == other.value;
	}
	
	public boolean lte(Complex other) {
		return lt(other) || eq(other);
	}
	
	public boolean gte(Complex other) {
		return gt(other) || eq(other);
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		else if (other == null || this.getClass() != other.getClass())
			return false;
		else {
			Complex that = (Complex) other;
			
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
	
	public boolean equals(Complex other, Complex epsilon) {
		return this.sub(other).len().lte(epsilon.len());
	}
}
