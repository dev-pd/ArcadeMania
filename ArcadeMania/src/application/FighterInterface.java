package application;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface FighterInterface {
	
	public static final double MAX_HEALTH = 100;
	
	abstract void executeAbilityAnimation(boolean isPlayer1, int abilityNumber);
	
	abstract ArrayList<Ability> getAbilities();
	
}

