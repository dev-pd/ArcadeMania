package application;
import application.FighterFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

public class GameController extends SceneController implements Initializable {
	private MediaPlayer screenMediaPlayer;
	private MediaPlayer animationMediaPlayer;
	@FXML
	private TextFlow playerTurnTextFlow;
	@FXML
	private Text playerTurnText;
    @FXML
    private Label player2AvengerLabel;
    @FXML
    private Label player1AvengerLabel;
    @FXML
    private ProgressBar player2HpBar;
    @FXML
    private ProgressBar player1HpBar;
    @FXML
    private Label player2HpLabel;
    @FXML
    private Label player1HpLabel;
    @FXML
    private ImageView player1ImageView;
    @FXML
    private ImageView player2ImageView;
    @FXML
    private ImageView player1SideAnimationView;
    @FXML
    private ImageView player2SideAnimationView;
    @FXML
    private GridPane playerAbilityBox;
    @FXML
    private Button abilityBtn1;
    @FXML
    private Button abilityBtn2;
    @FXML
    private Button swapBtn;
    @FXML
    private Button cancelSwapBtn;
    @FXML
    private FlowPane PartySwapPane;
    @FXML
    private Button Avenger1Btn;
    @FXML
    private Button Avenger2Btn;
    @FXML
    private Pane dialogBox;
    @FXML
    private Text dialogText;

    private BattleUIHolder player1UI;
    private BattleUIHolder player2UI;
    private BattleSlot player1Slot;
    private BattleSlot player2Slot;
    private Player p1;
    private Player p2;
    boolean isP1Turn = true;
    
    public class UI{

        public  void updateSwapUI(){ // needs to be called before each toggle true of swap menu.
        	
        	Player player = isP1Turn ? p1 : p2;
        	
        	int index = 0, aliveCount = 0;
        	// Setting swappable avenger buttons based on current party situation ( dead / staged)
        	while(index < player.party.size() &&
        			(player.party.get(index).isDead() || player.party.get(index) == player.getStagedAvenger())) {index++;}
        	if(index < player.party.size()) {
        		Fighter swappableAvenger = player.party.get(index);
        		Avenger1Btn.setText(swappableAvenger.name);
        		Avenger1Btn.setVisible(true);
        		Avenger1Btn.setDisable(false);
        		Avenger1Btn.setOnAction(e -> {
        			// if swapping away from Viking, restore base dmg on smash in case its been buffed
        			if(player.getStagedAvenger().name.equals("Viking")) {
        				player.getStagedAvenger().getAbility(1).setBaseDamage(20);
        			}
        			player.swapAvenger(swappableAvenger);
        			updateAbilityUI(); // update abilities with swapped avenger's abilities
        			toggleSwapMenu(false); // hide the swap UI because swap performed
        		});
        		index++;
        		aliveCount++;
        	}
        	while(index < player.party.size() &&
        			(player.party.get(index).isDead() || player.party.get(index) == player.getStagedAvenger())) {index++;}
        	if(index < player.party.size()) {
        		Fighter swappableAvenger = player.party.get(index);
        		Avenger2Btn.setText(swappableAvenger.name);
        		Avenger2Btn.setVisible(true);
        		Avenger2Btn.setDisable(false);
        		Avenger2Btn.setOnAction(e->{
        			// if swapping away from Viking, restore base dmg on smash in case its been buffed
        			if(player.getStagedAvenger().name.equals("Viking")) {
        				player.getStagedAvenger().getAbility(1).setBaseDamage(20);
        			}
        			player.swapAvenger(swappableAvenger);
        			updateAbilityUI(); // update abilities with swapped avenger's abilities
        			toggleSwapMenu(false);
        		});
        		aliveCount++;
        	}
        	
        	if(aliveCount == 0) {
        		Avenger1Btn.setVisible(false);
        		Avenger1Btn.setDisable(true);
        		Avenger2Btn.setVisible(false);
        		Avenger2Btn.setDisable(true);
        	}
        	if(aliveCount == 1) {
        		Avenger2Btn.setVisible(false);
        		Avenger2Btn.setDisable(true);
        	}
        	
        }
        
        public void updateAbilityUI() {
        	Player player = isP1Turn ? p1 : p2;
        	player.prepTurn(); // check if player's current avenger not dead to show abilities.
        	if(!player.canCancelSwap()) {
        		updateSwapUI();
        		toggleSwapMenu(true); // if dead, then show swap ui
        	}else {
        		Fighter stagedAvenger = player.getStagedAvenger();
            	abilityBtn1.setText(stagedAvenger.getAbility(1).getName());
            	abilityBtn2.setText(stagedAvenger.getAbility(2).getName());
            	
            	abilityBtn1.setOnAction(e -> {
            		// get animation for chosen ability
            		String abilityName = stagedAvenger.getAbility(1).getName();
            		SequentialTransition animation = AnimationFactory.getAnimationFor(abilityName, isP1Turn, player1ImageView, player1SideAnimationView, player2ImageView);
            		//play ability
            		animation.play();
            		
            		//play animation sounds snippets
            		animationMediaPlayer = MediaPlayerFactory.getMediaPlayerFor(abilityName);
            		animationMediaPlayer.play();
            		
            		//disable btns during animation play of chosen ability
            		abilityBtn1.setDisable(true);
            		abilityBtn2.setDisable(true);
            		swapBtn.setDisable(true);
            		
            		// set and display dialog box text with damage done
            		double[] damageTakenArr = player.enemySlot.getHitDamage(stagedAvenger.getAbility(1));
            		double baseDamage = damageTakenArr[0];
            		double bonus = damageTakenArr[1];
            		double damageTaken = baseDamage + bonus;
            		
        			dialogText.setText(stagedAvenger.name + " uses " + stagedAvenger.getAbility(1).getName() +"!!\nABILITY BASE DAMAGE : " + String.format("%.0f",baseDamage) +
        					(bonus >= 0 ? ("\nMATCH-UP ABILITY BONUS DAMAGE: " + String.format("%.0f",bonus)) : 
        								 ("\nMATCH-UP ABILITY PENALTY: " + String.format("%.0f",bonus)))+
        							  	  "\nTOTAL DAMAGE: " + String.format("%.0f",damageTaken));
            		
            		dialogBox.setVisible(true);
      
            		animation.setOnFinished(e1 -> {
            			// clear any transforms set for animation purposes
            			player1SideAnimationView.getTransforms().clear();
            			player1SideAnimationView.setTranslateX(0);
            			// enable btns after animation
            			abilityBtn1.setDisable(false);
                		abilityBtn2.setDisable(false);
                		swapBtn.setDisable(false);
                		// remove dialog text and disappear dialogBox
                		dialogText.setText("");
                		dialogBox.setVisible(false);
                		
            			player.enemySlot.takeHit(stagedAvenger.getAbility(1));
            	
                		
                		if(isOver()) {
                			screenMediaPlayer.stop();
                			try {
    							switchToEndGameScreen(e,isP1Turn? "Player 1 is victorious!" : "Player 2 is victorious!");
    						} catch (IOException ex) {
    							// TODO Auto-generated catch block
    							ex.printStackTrace();
    						}
                		}
                		
            			player1SideAnimationView.setScaleX(1);
            			player1SideAnimationView.setScaleY(1);
                		player1SideAnimationView.setOpacity(1);
                		
                		Image imageObject = new Image(stagedAvenger.frontImage);
	               		if (isP1Turn) {
	               			player1ImageView.setImage(imageObject);
	             		}
	             		else {
	             			player2ImageView.setImage(imageObject);
	             		}
                		
               		 	isP1Turn = !isP1Turn;
                		playerTurnText.setText(isP1Turn? "Player 1's Turn" : "Player 2's Turn");

                		updateAbilityUI();
            		});
            	});
            	
            	abilityBtn2.setOnAction(e -> {
            		// get animation according to selected btn
            		String abilityName = stagedAvenger.getAbility(2).getName();
            		SequentialTransition animation = AnimationFactory.getAnimationFor(abilityName, isP1Turn, player1ImageView, player1SideAnimationView, player2ImageView);
            		// play animation
            		animation.play();
            		
            		//play animation sound snippets
            		animationMediaPlayer = MediaPlayerFactory.getMediaPlayerFor(abilityName);
            		animationMediaPlayer.play();
            		
            		//disable btns during animation play of chosen ability
            		abilityBtn1.setDisable(true);
            		abilityBtn2.setDisable(true);
            		swapBtn.setDisable(true);
            		
            		// if Viking uses Viking Spear, need to update damage of Viking Axe
            		if(stagedAvenger.getAbility(2).getName().equals("Viking Spear")){
            			stagedAvenger.getAbility(1).setBaseDamage(stagedAvenger.getAbility(1).getBaseDamage() + 10);
            		}
            		
            		// set and display dialog box text with damage done
            		double[] damageTakenArr = player.enemySlot.getHitDamage(stagedAvenger.getAbility(2));
            		double baseDamage = damageTakenArr[0];
            		double bonus = damageTakenArr[1];
            		double damageTaken = baseDamage + bonus;
            		
            		if(damageTaken == 0) {
            			dialogText.setText(stagedAvenger.name + " uses " + stagedAvenger.getAbility(2).getName() +".\nViking is getting angry!! Viking Spear causes " + stagedAvenger.getAbility(1).getBaseDamage() + " base damage!");
            		}
            		else {
            			dialogText.setText(stagedAvenger.name + " uses " + stagedAvenger.getAbility(2).getName() +"!!\nABILITY BASE DAMAGE : " + String.format("%.0f",baseDamage) +
            					(bonus >= 0 ? ("\nMATCH-UP ABILITY BONUS DAMAGE: " + String.format("%.0f",bonus)) : 
            								 ("\nMATCH-UP ABILITY PENALTY: " + String.format("%.0f",bonus)))+
            							  	  "\nTOTAL DAMAGE: " + String.format("%.0f",damageTaken));
            		}
            		dialogBox.setVisible(true);
            		
            		animation.setOnFinished(e1 -> {
            			// clear any transforms set for animation purposes
            			player1SideAnimationView.getTransforms().clear();
            			player1SideAnimationView.setTranslateX(0);
            			// enable ability btns
            			abilityBtn1.setDisable(false);
                		abilityBtn2.setDisable(false);
                		swapBtn.setDisable(false);
                		// remove dialog text and disappear dialogBox
                		dialogText.setText("");
                		dialogBox.setVisible(false);
                		
                		
            			player.enemySlot.takeHit(stagedAvenger.getAbility(2));
            			
                		if(isOver()) {
                			screenMediaPlayer.stop();
                			try {
    							switchToEndGameScreen(e,isP1Turn? "Player 1 is victorious!" : "Player 2 is victorious!");
    						} catch (IOException ex) {
    							// TODO Auto-generated catch block
    							ex.printStackTrace();
    						}
                		}
                		
                		player1SideAnimationView.setScaleX(1);
            			player1SideAnimationView.setScaleY(1);
                		player1SideAnimationView.setOpacity(1);
                		
                		Image imageObject = new Image(stagedAvenger.frontImage);
                		
                		if (isP1Turn) {
                			player1ImageView.setImage(imageObject);
                		}
                		else {
                			player2ImageView.setImage(imageObject);
                		}
               		 	
                		isP1Turn = !isP1Turn;
                		
                		// Render appropriate player turn text
                		playerTurnText.setText(isP1Turn? "Player 1's Turn" : "Player 2's Turn");
          
                		updateAbilityUI();
            		});
            	});
        	}

        }
        
        public void addEventHandlersToSwapBtns() {
        	// on click of swap button
	        swapBtn.setOnAction(event -> {
	        	updateSwapUI();
	            toggleSwapMenu(true);
	        });
	        
	        // on click of cancel Swap button
	        cancelSwapBtn.setOnAction(event -> {
	        		Player player = isP1Turn? p1 : p2;
	        		player.prepTurn();
	        		if(player.canCancelSwap())
		                toggleSwapMenu(false);
		            else
		                System.out.println("You must swap");
	        }
	        );
        }
    }
        
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		playGameScreenMedia();

		Fighter a1 = FighterFactory.getAkuma();
        Fighter a2 = FighterFactory.getThor();
        Fighter a3 = FighterFactory.getKasumi();
        Fighter a4 = FighterFactory.getNinja();
        Fighter a5 = FighterFactory.getGladiator();
        Fighter a6 = FighterFactory.getViking();
        
        ArrayList<Fighter> p1Party = new ArrayList<>();
        ArrayList<Fighter> p2Party = new ArrayList<>();
        
        Fighter[] avengerPool = new Fighter[] {a1,a2,a3,a4,a5,a6};
        initializePlayersParty(p1Party, p2Party, avengerPool);
        p1 = new Player("Player 1", p1Party);
        p2 = new Player("Player 2", p2Party);
        setFxml(p1, p2);
	}
	
	private void initializePlayersParty(List<Fighter> p1Party, List<Fighter> p2Party, Fighter[] avengerPool) {
		HashSet<Integer> hs = new HashSet<>();
        int randomlySelectedIndex = -1;
//        int count = 0;
        while(hs.size() < 3) {
//        	if (count == 0) {
//        		randomlySelectedIndex = 4;
//        	}
//        	else {
        		randomlySelectedIndex = (int)(Math.random() * (avengerPool.length - 1));
//        	}
        	
        	if(!hs.contains(randomlySelectedIndex)) {
        		p1Party.add(avengerPool[randomlySelectedIndex]);
        		hs.add(randomlySelectedIndex);
        	}
        	
//        	count += 1;
        }
        for(int i = 0; i < avengerPool.length; i++) {
        	if(!hs.contains(i)) {
        		p2Party.add(avengerPool[i]);
        	}
        }
	}
	
	 private void setFxml(Player p1,Player p2){
		 	
		 	player1UI = new BattleUIHolder(player1AvengerLabel, player1HpBar, player1HpLabel,player1ImageView);
	        player2UI = new BattleUIHolder(player2AvengerLabel, player2HpBar, player2HpLabel,player2ImageView);
	
	        player1Slot = new BattleSlot(player1UI,player1SideAnimationView);
	        player2Slot = new BattleSlot(player2UI,player2SideAnimationView);
	        
	        p1.prepareForBattle(player1Slot, player2Slot);
	        p2.prepareForBattle(player2Slot, player1Slot);
	        
	        UI ui = new UI();
	        ui.updateAbilityUI(); //update ability btns with current avenger's abilities, and add event handlers to them
	        ui.addEventHandlersToSwapBtns();
	        
        }
	 
		public boolean isOver(){
		   return !p1.canFight() || !p2.canFight();
		}

		public void toggleSwapMenu(boolean isSwapEnabled){
	       if(isSwapEnabled){
	            PartySwapPane.setVisible(true);
	            PartySwapPane.setDisable(false);
	            cancelSwapBtn.setVisible(true);
	            cancelSwapBtn.setDisable(false);
	            swapBtn.setVisible(false);
	            swapBtn.setDisable(true);
	        }else{
	        	PartySwapPane.setVisible(false);
	            PartySwapPane.setDisable(true);
	            cancelSwapBtn.setVisible(false);
	            cancelSwapBtn.setDisable(true);
	            swapBtn.setVisible(true);
	            swapBtn.setDisable(false);
	        }
		}
		
		public void playGameScreenMedia() {
			Media media = null;
			try {
				media = new Media(new File("src/application/media/game_track.mp3").toURI().toURL().toString());
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			screenMediaPlayer = new MediaPlayer(media);
			screenMediaPlayer.setStartTime(Duration.seconds(36.5));
			screenMediaPlayer.setVolume(0.1);
			screenMediaPlayer.setOnEndOfMedia(new Runnable() {
			       public void run() {
			         screenMediaPlayer.seek(Duration.seconds(36.5));
			       }
			   });
			screenMediaPlayer.play();
		}
		
 }
	

