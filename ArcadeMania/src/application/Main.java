package application;
	
import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);
//			ActionEvent myEvent = new ActionEvent();
//			Scene gameScene = new Scene(gameRoot);
//			homeScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			gameScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			Media media = new Media(new File("src/application/media/avengers-theme-song-download.mp3").toURI().toURL().toString());
//			MediaPlayer mediaPlayer = new MediaPlayer(media);
//			mediaPlayer.setOnEndOfMedia(new Runnable() {
//			       public void run() {
//			         mediaPlayer.seek(Duration.ZERO);
//			       }
//			   });
//			mediaPlayer.
//			mediaPlayer.play();
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
//			SceneController sceneController = new SceneController();
//			sceneController.switchToHomeScreen(primaryStage);
//			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
