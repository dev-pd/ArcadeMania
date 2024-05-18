package application;

import java.io.File;
import java.net.MalformedURLException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class MediaPlayerFactory {
	public static MediaPlayer getMediaPlayerFor(String abilityName) {
		switch(abilityName) {
		case "Ninja Shuriken":
			return getninjaShurikenPlayer();
			
		case "Ninja Katana":
			return getLeapingKickPlayer();
			
		case "Viking Spear":
			return getRagePlayer();
		
		case "Viking Axe":
			return getVikingAxePlayer();
		
		case "Kasumi Gun":
			return getKasumiGunPlayer();
		
		case "Kasumi Sword":
			return getStunBatonPlayer();
			
		case "Hammer Throw":
			return getHammerThrowPlayer();
			
		case "Thunder Storm":
			return getThunderStormPlayer();
			
		case "Akuma Wings":
			return getLightBlastPlayer();
			
		case "Akuma Sword":
			return getArtileryBarragePlayer();
			
		case "Sword":
			return getShieldBashPlayer();
			
		case "ShieldThrow":
			return getShieldThrowPlayer();	
		
		default:
			return null;
		}
	}
	private static MediaPlayer createMediaPlayer(String mediaPath) {
		Media media = null;
		try {
			media = new Media(new File(mediaPath).toURI().toURL().toString());
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		return new MediaPlayer(media); 
	}
	
	private static MediaPlayer getVikingAxePlayer() {
		String path = "src/application/media/viking_axe.mp3";
		MediaPlayer player = createMediaPlayer(path);
		player.setStartTime(Duration.seconds(2));
		player.setStopTime(Duration.seconds(4));
		return player;
	}
	private static MediaPlayer getRagePlayer() {
		String path = "src/application/media/viking_spear.mp3";
		MediaPlayer player = createMediaPlayer(path);
		player.setStartTime(Duration.seconds(0));
		player.setStopTime(Duration.seconds(2));
		return player;
	}
	private static MediaPlayer getninjaShurikenPlayer() {
		String path = "src/application/media/shuriken.mp3";
		return createMediaPlayer(path);
	}
	private static MediaPlayer getLeapingKickPlayer() {
		String path = "src/application/media/leaping-kick.mp3";
		return createMediaPlayer(path);
	}
	private static MediaPlayer getKasumiGunPlayer() {
		String path = "src/application/media/kasumi_gun.mp3";
		MediaPlayer player = createMediaPlayer(path);
		player.setStartTime(Duration.seconds(93));
		player.setStopTime(Duration.seconds(96));
		return player;
	}
	private static MediaPlayer getStunBatonPlayer() {
		String path = "src/application/media/kasumi_gun.mp3";
		MediaPlayer player = createMediaPlayer(path);
		player.setStartTime(Duration.seconds(26));
		player.setStopTime(Duration.seconds(29));
		return player;
	}
	private static MediaPlayer getLightBlastPlayer() {
		String path = "src/application/media/light-blast.mp3";
		MediaPlayer player = createMediaPlayer(path);
		player.setStartTime(Duration.seconds(0));
		player.setStopTime(Duration.seconds(2));
		return player;
	}
	private static MediaPlayer getArtileryBarragePlayer() {
		String path = "src/application/media/akuma_sword.mp3";
		return createMediaPlayer(path);
	}
	private static MediaPlayer getThunderStormPlayer() {
		String path = "src/application/media/thunder-sound-effect.mp3";
		MediaPlayer player = createMediaPlayer(path);
		player.setStartTime(Duration.seconds(0));
		player.setStopTime(Duration.seconds(2));
		return player;
	}
	private static MediaPlayer getHammerThrowPlayer() {
		String path = "src/application/media/hammer_1.mp3";
		MediaPlayer player = createMediaPlayer(path);
		player.setStartTime(Duration.seconds(0));
		player.setStopTime(Duration.seconds(2));
		return player;
	}
	private static MediaPlayer getShieldThrowPlayer() {
		String path = "src/application/media/shield-throw.mp3";
		return createMediaPlayer(path);
	}
	private static MediaPlayer getShieldBashPlayer() {
		String path = "src/application/media/shield-bash.mp3";
		return createMediaPlayer(path);
	}
}
