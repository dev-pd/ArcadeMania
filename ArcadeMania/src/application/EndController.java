package application;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class EndController extends SceneController implements Initializable{
	private MediaPlayer screenMediaPlayer;
	@FXML
	public Text Winner;
	@FXML
	public Pane textPane;
	@FXML
	public Button toHome;
	
void setWinner(String winnerText) {
	Winner.setText(winnerText);
	}


@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	System.out.println("Reached here in end initializable");
	Media media = null;
	try {
		media = new Media(new File("src/application/media/victory.mp3").toURI().toURL().toString());
	} catch (MalformedURLException e1) {
		e1.printStackTrace();
	}
	screenMediaPlayer = new MediaPlayer(media);
	screenMediaPlayer.play();
	
	toHome.setOnAction(e -> {
		screenMediaPlayer.stop();
		try {
			switchToHomeScreen(e);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});
}
	
	 
}
