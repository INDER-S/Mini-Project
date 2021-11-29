package com.example.mediaplayer;

import javafx.scene.media.MediaPlayer;

public class Playbackcontrol {
    public MediaPlayer mp;
    Playbackcontrol(MediaPlayer player)
    {
        this.mp=player;
    }
    public void low()
    {
        mp.setRate(0.5);
    }
    public void norm()
    {
        mp.setRate(1.0);
    }
    public void high()
    {
        mp.setRate(1.5);
    }
}
