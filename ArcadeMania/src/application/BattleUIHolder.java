package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class BattleUIHolder {
    private Label NameLabel;
    private ProgressBar HpBar;
    private Label HpLabel;
    private ImageView imageView;
    
    public BattleUIHolder(Label nameLabel, ProgressBar hpBar, Label hpLabel, ImageView imageView) {
        NameLabel = nameLabel;
        HpBar = hpBar;
        HpLabel = hpLabel;
        this.imageView = imageView;
    }
    
    public void load(Fighter avenger){
        if(avenger == null)
            System.out.println("avenger null");
        HpBar.setProgress(avenger.getHealthRatio());
        HpLabel.setText(String.format("%.0f",avenger.getCurrentHealth()) + " / " + String.format("%.0f",FighterInterface.MAX_HEALTH));
        imageView.setImage(new Image(avenger.frontImage));
        NameLabel.setText(avenger.name);
        
    }

    public void setHealth(double curHealth, double maxHealth){
        if(curHealth > 0) {
            HpLabel.setText(String.format("%.0f", curHealth) + " / " + String.format("%.0f", maxHealth));
            HpBar.setProgress(((double) curHealth) / maxHealth);
        }else{
            HpLabel.setText(0 + " / " + maxHealth);
            HpBar.setProgress(((double) 0) / maxHealth);
        }
    }

}

