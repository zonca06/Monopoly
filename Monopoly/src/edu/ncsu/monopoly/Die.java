package edu.ncsu.monopoly;

public class Die {
	public int getRoll() {
		return (int)(Math.random() * 5) + 1;
	}
}
