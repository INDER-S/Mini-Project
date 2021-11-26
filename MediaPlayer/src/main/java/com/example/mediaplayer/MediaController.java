package com.example.mediaplayer;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.MalformedURLException;

public class MediaController {

    MediaPlayer mp;


    @FXML
    void openMedia(ActionEvent event) throws MalformedURLException {

        FileChooser fc = new FileChooser();
        File fl = fc.showOpenDialog(null);
        Media m=new Media(fl.toURI().toURL().toString());

        if(mp!=null) {
            mp.dispose();
        }
        mp=new MediaPlayer(m);

//       mediaView.setMediaPlayer(mp);
// helloo

    }





    }


