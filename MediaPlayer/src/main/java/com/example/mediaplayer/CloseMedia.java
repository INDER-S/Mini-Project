package com.example.mediaplayer;

import com.jfoenix.controls.JFXSlider;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;

public class CloseMedia {
     public MediaPlayer mp;
     public Button playmedia;
     public JFXSlider slidermedia;
     CloseMedia(MediaPlayer player, Button btn, JFXSlider slide){
         this.mp=player;
         this.playmedia=btn;
         this.slidermedia=slide;
     }
     public void closemed()

    {
        if (mp != null) {
            mp.dispose(); // if a song till rinning so it dispose all resources so that we can use it again if do open media again
            slidermedia.setValue(0);
            //aas we schange song it again becomes play icon
            playmedia.setText("Play");
            //playmedia.setGraphic((new ImageView(new Image(new FileInputStream(src / icons / play.png)))));
        }
    }
}
