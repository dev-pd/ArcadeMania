package application;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SceneController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToGameScreen(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Game.fxml"));
		stage = (Stage)((Node)(event.getSource())).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToHomeScreen(ActionEvent event) throws IOException  {
		root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		stage = (Stage)((Node)(event.getSource())).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToEndGameScreen(ActionEvent event, String winnerText) throws IOException {
//		root = FXMLLoader.load(getClass().getResource("End.fxml"));
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("End.fxml"));
		root = loader.load();
		EndController controller = loader.getController();
		controller.setWinner(winnerText);
		stage = (Stage)((Node)(event.getSource())).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
