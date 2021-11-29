package com.example.mediaplayer;

import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Forward {
    public MediaPlayer mp;
    Forward(MediaPlayer player){
        this.mp=player;
    }
    public void addten()

    {
        double currentdur = mp.getCurrentTime().toSeconds();
        currentdur = currentdur + 10;
        mp.seek(new Duration(currentdur * 1000));
    }
}
