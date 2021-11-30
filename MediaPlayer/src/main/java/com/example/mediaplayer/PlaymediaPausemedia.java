package com.example.mediaplayer;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Button;

import java.io.FileInputStream;

public class PlaymediaPausemedia {
    public MediaPlayer mp;
    public Button playmedia;
    PlaymediaPausemedia(Button pl, MediaPlayer player){
        this.mp=player;
        this.playmedia=pl;
    }

    public void playmed(){
    MediaPlayer.Status stat =mp.getStatus();
         if(stat== MediaPlayer.Status.PLAYING)
    {
        mp.pause();
        //playmedia.setText("Play");
        try {
            //setting play icon as we change song
            //playmedia.setText("Play");
            playmedia.setGraphic((new ImageView(new Image(new FileInputStream("src/main/images/pause.png")))));
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
         else
    {
        mp.play();
        //playmedia.setText("Pause");
        //playmedia.setGraphic((new ImageView(new Image(new FileInputStream(src / icons / play.png)))));
        try {
            //setting play icon as we change song
            //playmedia.setText("Play");
            playmedia.setGraphic((new ImageView(new Image(new FileInputStream("src/main/images/play.png")))));
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
}
