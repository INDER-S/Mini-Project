package com.example.mediaplayer;

import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Backward {
    public MediaPlayer mp;
    Backward(javafx.scene.media.MediaPlayer player){
        this.mp=player;
    }
    public void subtractten()

    {
        double currentdur = mp.getCurrentTime().toSeconds();
        currentdur = currentdur - 10;
        mp.seek(new Duration(currentdur * 1000));
    }

}
