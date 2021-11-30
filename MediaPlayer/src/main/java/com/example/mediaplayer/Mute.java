package com.example.mediaplayer;

import com.jfoenix.controls.JFXSlider;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;

import java.io.FileInputStream;

public class Mute {
    public MediaPlayer mp;
    public Button mutemed;
    public JFXSlider volumeslider;
    Mute(MediaPlayer player, Button btn,JFXSlider slider)
    {
        this.mp=player;
        this.mutemed=btn;
        this.volumeslider=slider;
    }
    public void muteUnmute() {
        double volume = mp.getVolume();
        if (volume > 0) {
            mp.setVolume(0);
            //mutemed.setText("Unmute");
            try {
                mutemed.setGraphic((new ImageView(new Image(new FileInputStream("src/main/images/mute.png")))));
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            volumeslider.setValue(0);
        } else {
            mp.setVolume(100);
            //mutemed.setText("Mute");
            try {
                mutemed.setGraphic((new ImageView(new Image(new FileInputStream("src/main/images/unmute.png")))));
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            volumeslider.setValue(100);

        }
    }
}
