package com.example.mediaplayer;

import com.jfoenix.controls.JFXSlider;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;

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
            mutemed.setText("Unmute");
            volumeslider.setValue(0);
        } else {
            mp.setVolume(100);
            mutemed.setText("Mute");
            volumeslider.setValue(100);

        }
    }
}
