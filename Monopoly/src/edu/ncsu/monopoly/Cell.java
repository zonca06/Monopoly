package edu.ncsu.monopoly;

public abstract class Cell {
	public static int InflationParameter = 1;
	public static int NoInflationParameter = 0;
	
	private boolean available = true;
	private String name;
	protected Player owner;

	public String getName() {
		return name;
	}

	public Player getOwner() {
		return owner;
	}
	
	public int getPrice() {
		return 0;
	}

	public boolean isAvailable() {
		return available;
	}
	
	public abstract void playAction();

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
    
    public String toString() {
        return name;
    }
}

