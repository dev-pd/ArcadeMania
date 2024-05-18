package application;


public class AbilityFactory {
		// Viking abilities
	 	public  static  Ability getVikingAxe(){
	        return new Ability("Viking Axe", Type.PHYSICAL, 20);
	    }
	 	public  static  Ability getRage(){
	        return new Ability("Viking Spear", Type.PHYSICAL, 0);
	    }
	 	
	 	// Ninja abilities
	    public static Ability getNinjaShuriken(){
	        return new Ability("Ninja Shuriken", Type.GADGETS, 20);
	    }
	    public static Ability getLeapingKick(){
	        return new Ability("Ninja Katana", Type.PHYSICAL, 20);
	    }
	    
	    // Kasumi abilities
	    public static Ability getKasumiGun(){
	        return new Ability("Kasumi Gun", Type.GADGETS, 20);
	    }
	    public static Ability getStunBaton(){
	        return new Ability("Kasumi Sword", Type.GADGETS, 20);
	    }
	    
	    // thor abilities
	    public static Ability getHammerThrow(){
	        return new Ability("Hammer Throw", Type.PHYSICAL, 20);
	    }
	    public static Ability getThunderStorm(){
	        return new Ability("Thunder Storm", Type.LIGHTNING, 20);
	    }
	    
	    //Akuma abilities
	    public static Ability getLightBlast(){
	        return new Ability("Akuma Wings", Type.LIGHT, 20);
	    }
	    public static Ability artilleryBarrage(){
	        return new Ability("Akuma Sword", Type.GADGETS, 20);
	    }
	    
	    //Gladiator abilities
	    public static Ability getShieldBash(){
	        return new Ability("Sword", Type.PHYSICAL, 20);
	    }
	    public static Ability getShieldThrow(){
	        return new Ability("ShieldThrow", Type.PHYSICAL, 20);
	    }
	    
}
