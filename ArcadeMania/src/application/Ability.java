package application;

public class Ability {

	private String name;
	private Type type;
	private double baseDamage;
	
	public Ability(String name, Type type, double baseDamage) {
		this.name = name;
		this.type = type;
		this.baseDamage = baseDamage;
	}
	
	
	String getName() {return name;}
	Type getType() {return type;}
	double getBaseDamage() {return baseDamage;}
	void setBaseDamage(double damage) {baseDamage = damage;}
}
