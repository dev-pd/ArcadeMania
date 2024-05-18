package application;

import java.util.ArrayList;


public class Fighter implements FighterInterface{
	
	String name;
	private double currentHealth = FighterInterface.MAX_HEALTH ;
	Type movementMode;
	ArrayList<Ability> abilityList;
	public final String frontImage;
    public final String actionImage;
    
	public Fighter(String name, Type movementMode, ArrayList<Ability> abilityList, String frontImage, String actionImage) {
		this.name = name;
		this.movementMode = movementMode;
		this.abilityList = abilityList;
		this.frontImage = frontImage;
		this.actionImage = actionImage;
	}
	
	public double getCurrentHealth() {
		return this.currentHealth;
	}
	
	@Override
	public void executeAbilityAnimation(boolean isPlayer1, int abilityNumber) {
		Ability selectedAbility = abilityList.get(abilityNumber);
		if(isPlayer1) {
			System.out.println("Player 1 animation goes off for ability : " + abilityList.get(abilityNumber).getName() + " from player 1 to player 2");
		}else {
			System.out.println("Player  animation goes off for ability : " + abilityList.get(abilityNumber).getName() + " from player 2 to player 1");
		}
	}
	
	@Override
	public ArrayList<Ability> getAbilities() {
		// TODO Auto-generated method stub
		return abilityList;
	}
	
	public double[] takeHit(Ability ability) {
		double[] damageTaken = calculateEffectiveDamage(ability);
		currentHealth -= (damageTaken[0] + damageTaken[1]);
		return damageTaken;
	}
	
	public double[] getHitDamage(Ability ability) {
		double[] damageTaken = calculateEffectiveDamage(ability);
		return damageTaken;
	}
	
	private double[] calculateEffectiveDamage(Ability ability) {
		switch(ability.getName()) {
			/* Ninja */
			// Ability : Shuriken
			case "Ninja Shuriken":
				//strong against
				if(name.equals("Akuma")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				//weak against
				if(name.equals("Viking") || name.equals("Thor")) {
					return new double[] {ability.getBaseDamage(),-ability.getBaseDamage()*0.5};
				}
				break;
			
			// Ability : Ninja Katana
			case "Ninja Katana":
				// strong against
				if(name.equals("Kasumi")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				// weak against
				if(name.equals("Viking") || name.equals("Gladiator")) {
					return new double[] {ability.getBaseDamage(),-ability.getBaseDamage()*0.5};
				}
				break;
			
			/* Viking */
			// Ability : Viking Axe
			case "Viking Axe":
				// strong against
				if(name.equals("Gladiator")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				// weak against
				if(name.equals("Ninja") || name.equals("Kasumi")) {
					return new double[] {ability.getBaseDamage(),-ability.getBaseDamage()*0.5};
				}
				break;
			
			// Ability : Viking Spear
			case "Viking Spear":
				// no damage interaction; return
				return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
			
			/* kasumi */
			// Ability : Gun
			case "Gun":
				// strong against
				if(name.equals("Thor")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				// no weak against
				break;
			
			// Ability : Kasumi Sword
			case "Kasumi Sword":
				// strong against
				if(name.equals("Ninja")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				// weak against
				if(name.equals("Viking") || name.equals("Thor") || name.equals("Akuma")) {
					return new double[] {ability.getBaseDamage(),-ability.getBaseDamage()*0.5};
				}
				break;
			
			/* Thor */
			// Ability : Thunder Storm
			case "Thunder Storm":
				// strong against
				if(name.equals("Akuma") || name.equals("Viking")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				// weak against
				if(name.equals("Gladiator")) {
					return new double[] {ability.getBaseDamage(),-ability.getBaseDamage()*0.5};
				}
				break;
			
			// Ability : Hammer Throw
			case "Hammer Throw":
				// strong against
				if(name.equals("Kasumi")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				// weak against
				if(name.equals("Ninja") || name.equals("Kasumi")) {
					return new double[] {ability.getBaseDamage(),-ability.getBaseDamage()*0.5};
				}
				break;
			
			/* Akuma */
			// Ability : Akuma Wings
			case "Akuma Wings":
				// strong against
				if(name.equals("Gladiator") || name.equals("Viking")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				// no weak against
				break;
			
			// Ability : Akuma Sword
			case "Akuma Sword":
				// strong against
				if(name.equals("Ninja")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				// weak against
				if(name.equals("Gladiator") || name.equals("Viking")) {
					return new double[] {ability.getBaseDamage(),-ability.getBaseDamage()*0.5};
				}
				break;
			
			/* Gladiator */
			// Ability : ShieldBash
			case "Sword":
				// strong against
				if(name.equals("Ninja")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				// weak against
				if(name.equals("Viking")) {
					return new double[] {ability.getBaseDamage(),-ability.getBaseDamage()*0.5};
				}
				break;
			
			// Ability : Shield Throw
			case "ShieldThrow":
				// strong against
				if(name.equals("Thor")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				// weak against
				if(name.equals("Ninja") || name.equals("Kasumi")) {
					return new double[] {ability.getBaseDamage(),-ability.getBaseDamage()*0.5};
				}
				break;
		}
		return new double[] {ability.getBaseDamage(), 0};
	}
	
	public boolean isDead(){
        return currentHealth <=0;
    }
	
	 public Ability getAbility(int abilityNumber){
	        if(abilityNumber > abilityList.size() || abilityNumber <1)
	            abilityNumber = 1;
	        return  abilityList.get(abilityNumber-1);
	    }
	 
	public double getHealthRatio(){return  ((double)(currentHealth)) / FighterInterface.MAX_HEALTH ;}
	
}
