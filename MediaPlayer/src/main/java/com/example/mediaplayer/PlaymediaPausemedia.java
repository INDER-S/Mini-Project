package com.example.mediaplayer;
import javafx.fxml.FXML;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Button;
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
        playmedia.setText("Play");
        //playmedia.setGraphic((new ImageView(new Image(new FileInputStream(src / icons / play.png)))));
        // taking input so put whole block in try and catch
    }
         else
    {
        mp.play();
        playmedia.setText("Pause");
        //playmedia.setGraphic((new ImageView(new Image(new FileInputStream(src / icons / play.png)))));
    }
}
}
