package application;
import java.util.ArrayList;
import java.util.List;

public class FighterFactory {//temp class for producing pokemon for testing replace with database
  public static Fighter getAkuma(){
      ArrayList<Ability> abilityList = new ArrayList<>();
      abilityList.add(AbilityFactory.getLightBlast());
      abilityList.add(AbilityFactory.artilleryBarrage());
      return new Fighter("Akuma",Type.FLYING, abilityList, "application/images/akuma.png", "application/images/ninja sideways.png");
  }
  
  public static Fighter getViking(){
	  ArrayList<Ability> abilityList = new ArrayList<>();
      abilityList.add(AbilityFactory.getVikingAxe());
      abilityList.add(AbilityFactory.getRage());

      return new Fighter("Viking",Type.GROUNDED, abilityList, "application/images/viking.png", "application/images/ninja sideways.png");
  }

  public static Fighter getKasumi(){
	  ArrayList<Ability> abilityList = new ArrayList<>();
      abilityList.add(AbilityFactory.getKasumiGun());
      abilityList.add(AbilityFactory.getStunBaton());

      return new Fighter("Kasumi",Type.GROUNDED, abilityList, "application/images/kasumi.png", "application/images/ninja sideways.png");
  }
  
  public static Fighter getThor(){
	  ArrayList<Ability> abilityList = new ArrayList<>();
      abilityList.add(AbilityFactory.getHammerThrow());
      abilityList.add(AbilityFactory.getThunderStorm());

      return new Fighter("Thor",Type.FLYING, abilityList, "application/images/thor.png", "application/images/ninja sideways.png");
  }
  
  public static Fighter getNinja(){
	  ArrayList<Ability> abilityList = new ArrayList<>();
      abilityList.add(AbilityFactory.getNinjaShuriken());
      abilityList.add(AbilityFactory.getLeapingKick());

      return new Fighter("Ninja",Type.GROUNDED, abilityList, "application/images/ninja_standing.png", "application/images/ninja sideways.png");
  }
  
  public static Fighter getGladiator(){
	  ArrayList<Ability> abilityList = new ArrayList<>();
      abilityList.add(AbilityFactory.getShieldBash());
      abilityList.add(AbilityFactory.getShieldThrow());

      return new Fighter("Gladiator",Type.GROUNDED, abilityList,"application/images/gladiator.png", "application/images/ninja sideways.png");
  }
  
}

