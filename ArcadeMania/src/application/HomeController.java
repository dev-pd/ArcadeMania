package application;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class HomeController extends SceneController implements Initializable {
	
	private MediaPlayer mediaPlayer;
	
	@FXML
	private ImageView ninja;
	
	@FXML
	private ImageView ninjaShuriken;
	
	@FXML
	private ImageView Akuma;
	
	@FXML
	private Circle AkumaLight;
	
	@FXML
	private ImageView kasumi;
	
	@FXML
	private Button startGameButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// Setup home screen music
		Media media = null;
		try {
			media = new Media(new File("src/application/media/landing.mp3").toURI().toURL().toString());
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setOnEndOfMedia(new Runnable() {
		       public void run() {
		         mediaPlayer.seek(Duration.ZERO);
		       }
		   });
		mediaPlayer.play();
		
		// on click of start game btn, stop home screen music
		startGameButton.setOnAction(e -> {
			mediaPlayer.stop();
			try {
				switchToGameScreen(e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		ninjaShuriken.setDisable(true); // prevent web from obscuring start btn
		AkumaLight.setDisable(true); // prevent light circle from obscuring start btn
		startGameButton.setDisable(true);
		TranslateTransition ninjaEntry = this.ninjaEntry();
		ScaleTransition ninjaShurikenExpand = this.ninjaShurikenExpand();
		FadeTransition ninjaShurikenFadeOut = this.fadeOutninjaShuriken();
		TranslateTransition AkumaEntry = this.AkumaEntry();
		ScaleTransition AkumaLightExpand = this.AkumaLightExpand();
		FadeTransition AkumaLightFadeOut = this.fadeOutAkumaLight();
		TranslateTransition kasumiEntry = this.kasumiEntry();
		FadeTransition startGameButtonFadeIn = this.fadeInButton();
		
		SequentialTransition seqT = new SequentialTransition(ninjaEntry, ninjaShurikenExpand, ninjaShurikenFadeOut, AkumaEntry, AkumaLightExpand, AkumaLightFadeOut, kasumiEntry, startGameButtonFadeIn);
		seqT.play();
		seqT.setOnFinished(e -> startGameButton.setDisable(false));
	}
	
	private TranslateTransition ninjaEntry() {
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(ninja);
		translate.setDuration(Duration.millis(2000));
		translate.setByY(655);
		return translate;
		
	}
	
	private TranslateTransition AkumaEntry() {
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(Akuma);
		translate.setDuration(Duration.millis(1700));
		translate.setByY(450);
		return translate;
	}
	
	private TranslateTransition kasumiEntry() {
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(kasumi);
		translate.setDuration(Duration.millis(1200));
		translate.setByX(334);
		return translate;
	}
	
	private ScaleTransition ninjaShurikenExpand() {
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(ninjaShuriken);
		scale.setDuration(Duration.millis(1500));
		scale.setByX(1800);
		scale.setByY(1800);
		return scale;
	}
	
	private ScaleTransition AkumaLightExpand() {
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(AkumaLight);
		scale.setDuration(Duration.millis(1200));
		scale.setByX(9000);
		scale.setByY(9000);
		return scale;
	}
	
	private FadeTransition fadeOutninjaShuriken() {
		FadeTransition fade = new FadeTransition();
		fade.setNode(ninjaShuriken);
		fade.setDuration(Duration.millis(700));
		fade.setFromValue(1);
		fade.setToValue(0);
		return fade;
	}
	
	private FadeTransition fadeOutAkumaLight() {
		FadeTransition fade = new FadeTransition();
		fade.setNode(AkumaLight);
		fade.setDuration(Duration.millis(800));
		fade.setFromValue(0.75);
		fade.setToValue(0);
		return fade;
	}
	
	private FadeTransition fadeInButton() {
		FadeTransition fade = new FadeTransition();
		fade.setNode(startGameButton);
		fade.setDuration(Duration.millis(1500));
		fade.setFromValue(0);
		fade.setToValue(1);
		return fade;
	}
	
}
