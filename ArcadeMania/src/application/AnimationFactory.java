package application;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

// need to return sequential transition end product back to gameController
public class AnimationFactory {
	 public static SequentialTransition getNinjaShuriken(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/ninja_fighting.png");
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		
		Image superpowerObject = new Image("application/images/ninja_shuriken.png");
		player1SideAnimationView.setImage(superpowerObject);
		 
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(500);
		scale.setByY(270);
		
		FadeTransition fade = new FadeTransition();
		fade.setNode(player1SideAnimationView);
		fade.setDuration(Duration.millis(1500));
		fade.setFromValue(1);
		fade.setToValue(0.5);
		 
	 	return new SequentialTransition(scale, fade);
	 }

	 public static SequentialTransition getLeapingKick(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/ninja_fighting.png");
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		 
		Image superpowerObject = new Image("application/images/giphy.gif");
		player1SideAnimationView.setImage(superpowerObject);
		
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(400);
		scale.setByY(500);
	 	
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(1);
	 	fadeOut.setToValue(0);
	
		return new SequentialTransition(scale, fadeOut);
	 }
	 
	 public static SequentialTransition getVikingAxe(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View){
	 	Image imageObject = new Image("application/images/viking_fighting.png");
	 	if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		 
		Image superpowerObject = new Image("application/images/viking_axe.png");
		player1SideAnimationView.setImage(superpowerObject);
		if(!isPlayer1) {
			Rotate flipRotation = new Rotate(180,Rotate.Y_AXIS);
			player1SideAnimationView.getTransforms().add(flipRotation);
			player1SideAnimationView.setTranslateX(200);
		}
		
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(200);
		scale.setByY(200);
	 	
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(1);
	 	fadeOut.setToValue(0);
	
		return new SequentialTransition(scale, fadeOut);
    }
	 
	 public static SequentialTransition getRage(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/viking_fighting.png");
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		 
		Image superpowerObject = new Image("application/images/viking_spear.png");
		player1SideAnimationView.setImage(superpowerObject);
		if(!isPlayer1) {
			Rotate flipRotation = new Rotate(180,Rotate.Y_AXIS);
			player1SideAnimationView.getTransforms().add(flipRotation);
			player1SideAnimationView.setTranslateX(200);
		}
		
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(200);
		scale.setByY(200);
	 	
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(1);
	 	fadeOut.setToValue(0);
	
		return new SequentialTransition(scale, fadeOut);
	 }
	 
	 public static SequentialTransition getKasumiGun(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/kasumi_fight.png");
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		 
		Image superpowerObject = new Image("application/images/kasumi_gun.png");
		player1SideAnimationView.setImage(superpowerObject);
		if(!isPlayer1) {
			Rotate flipRotation = new Rotate(180,Rotate.Y_AXIS);
			player1SideAnimationView.getTransforms().add(flipRotation);
			player1SideAnimationView.setTranslateX(200);
		}
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(200);
		scale.setByY(200);
		
		
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(1);
	 	fadeOut.setToValue(0);
	 	
	 	
		return new SequentialTransition(scale, fadeOut);
	 }
	 
	 public static SequentialTransition getStunBaton(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/kasumi_fight.png");
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		 
		Image superpowerObject = new Image("application/images/kasumi_sword.png");
		player1SideAnimationView.setImage(superpowerObject);
		if(!isPlayer1) {
			Rotate flipRotation = new Rotate(180,Rotate.Y_AXIS);
			player1SideAnimationView.getTransforms().add(flipRotation);
			player1SideAnimationView.setTranslateX(200);
		}
		
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(200);
		scale.setByY(200);
	 	
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(1);
	 	fadeOut.setToValue(0);
	
		return new SequentialTransition(scale, fadeOut);
	 }
	 
	 public static SequentialTransition getHammerThrow(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/thor sideways.png");
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		 
		Image superpowerObject = new Image("application/images/thor-hammer.png");
		player1SideAnimationView.setImage(superpowerObject);
		if(!isPlayer1) {
			Rotate flipRotation = new Rotate(180,Rotate.Y_AXIS);
			player1SideAnimationView.getTransforms().add(flipRotation);
			player1SideAnimationView.setTranslateX(200);
		}
		
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(200);
		scale.setByY(200);
	 	
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(1);
	 	fadeOut.setToValue(0);
	
		return new SequentialTransition(scale, fadeOut);
	 }
	 
	 public static SequentialTransition getThunderStorm(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/thor sideways.png");
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		 
		Image superpowerObject = new Image("application/images/thor-thunderstorm.png");
		player1SideAnimationView.setImage(superpowerObject);
		if(!isPlayer1) {
			Rotate flipRotation = new Rotate(180,Rotate.Y_AXIS);
			player1SideAnimationView.getTransforms().add(flipRotation);
			player1SideAnimationView.setTranslateX(200);
		}
		
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(200);
		scale.setByY(200);
	 	
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(1);
	 	fadeOut.setToValue(0);
	
		return new SequentialTransition(scale, fadeOut);
	 }
	 
	 public static SequentialTransition getLightBlast(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/akuma_fighting.png");
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		 
		Image superpowerObject = new Image("application/images/akuma_wings.png");
		player1SideAnimationView.setOpacity(0.7);
		player1SideAnimationView.setImage(superpowerObject);
		
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(1200));
		scale.setByX(1200);
		scale.setByY(1200);
	 	
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(0.7);
	 	fadeOut.setToValue(0);
	
		return new SequentialTransition(scale, fadeOut);
	 }
	 public static SequentialTransition getArtileryBarrage(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/akuma_fighting.png");
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		 
		Image superpowerObject = new Image("application/images/akuma_sword.png");
		player1SideAnimationView.setImage(superpowerObject);
		if(!isPlayer1) {
			Rotate flipRotation = new Rotate(180,Rotate.Y_AXIS);
			player1SideAnimationView.getTransforms().add(flipRotation);
			player1SideAnimationView.setTranslateX(200);
		}
		
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(200);
		scale.setByY(200);
	 	
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(1);
	 	fadeOut.setToValue(0);
	
		return new SequentialTransition(scale, fadeOut);
	 }
	 
	 public static SequentialTransition getShieldBash(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/gladiator_fighting.png");
		
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}

		Image superpowerObject = new Image("application/images/gladiator_sword.png");
		player1SideAnimationView.setImage(superpowerObject);
		
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(200);
		scale.setByY(200);
	 	
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(1);
	 	fadeOut.setToValue(0);
	
		return new SequentialTransition(scale, fadeOut);
	 }
	 
	 public static SequentialTransition getShieldThrow(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/gladiator_fighting.png");
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		 
		Image superpowerObject = new Image("application/images/flying-shield.png");
		player1SideAnimationView.setImage(superpowerObject);
		
		if(!isPlayer1) {
			Rotate flipRotation = new Rotate(180,Rotate.Y_AXIS);
			player1SideAnimationView.getTransforms().add(flipRotation);
			player1SideAnimationView.setTranslateX(200);
		}
		
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(400);
		scale.setByY(400);
	 	
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(1);
	 	fadeOut.setToValue(0);
	
		return new SequentialTransition(scale, fadeOut);
	 }
	 
	 public static SequentialTransition getAnimationFor(String abilityName, boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
	    	switch(abilityName) {
	    		case "Ninja Shuriken":
	    			return getNinjaShuriken(isPlayer1, player1View, player1SideAnimationView, player2View);
	    			
	    		case "Ninja Katana":
	    			return getLeapingKick(isPlayer1, player1View, player1SideAnimationView, player2View);
	    			
	    		case "Viking Spear":
	    			return getRage(isPlayer1, player1View, player1SideAnimationView, player2View);
	    		
	    		case "Viking Axe":
	    			return getVikingAxe(isPlayer1, player1View, player1SideAnimationView, player2View);
	    		
				case "Kasumi Gun":
	    			return getKasumiGun(isPlayer1, player1View, player1SideAnimationView, player2View);
	    		
	    		case "Kasumi Sword":
	    			return getStunBaton(isPlayer1, player1View, player1SideAnimationView, player2View);
	    				
	    		case "Hammer Throw":
	    			return getHammerThrow(isPlayer1, player1View, player1SideAnimationView, player2View);
	    			
	    		case "Thunder Storm":
	    			return getThunderStorm(isPlayer1, player1View, player1SideAnimationView, player2View);
	    			
	    		case "Akuma Wings":
	    			return getLightBlast(isPlayer1, player1View, player1SideAnimationView, player2View);
	    			
	    		case "Akuma Sword":
	    			return getArtileryBarrage(isPlayer1, player1View, player1SideAnimationView, player2View);
	    			
	    		case "Sword":
	    			return getShieldBash(isPlayer1, player1View, player1SideAnimationView, player2View);
	    			
	    		case "ShieldThrow":
	    			return getShieldThrow(isPlayer1, player1View, player1SideAnimationView, player2View);	
	    		
	    		default:
	    			return null;
	    	}
	    }
	 
}
