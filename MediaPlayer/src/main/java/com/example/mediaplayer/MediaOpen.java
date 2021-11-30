package com.example.mediaplayer;

import com.jfoenix.controls.JFXSlider;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.FileInputStream;

public class MediaOpen {
    public MediaPlayer mp;
    public Button playmedia;
    public JFXSlider slidermedia;
    public JFXSlider volumeslider;
    public Button mutemed;
    MediaOpen(MediaPlayer player,Button btn,JFXSlider slider1, JFXSlider slider2 , Button mut)
    {
        this.mp=player;
        this.playmedia=btn;
        this.slidermedia=slider1;
        this.volumeslider=slider2;
        this.mutemed=mut;
    }
    public void basic() {
        try {
            //time slider functions
            mp.setOnReady(() -> {
                slidermedia.setMin(0);
                slidermedia.setMax(mp.getMedia().getDuration().toMinutes());

                slidermedia.setValue(0);
                try {
                    //setting play icon as we change song
                    //playmedia.setText("Play");
                    playmedia.setGraphic((new ImageView(new Image(new FileInputStream("src/main/images/pause.png")))));
                }catch(Exception e)
                {
                    e.printStackTrace();
                }

            });
            //tracking time of slider (listener on player)
            mp.currentTimeProperty().addListener(new ChangeListener<Duration>() {
                @Override
                public void changed(ObservableValue<? extends Duration> observableValue, Duration duration, Duration t1) {
                    Duration dur = mp.getCurrentTime();
                    slidermedia.setValue(dur.toMinutes());
                }
            });

            //listener on time slider to skip video at the point where clicked
            slidermedia.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    if (slidermedia.isPressed()) { //as player moving forward like this also until pressed we will not seek
                        double val = slidermedia.getValue();
                        mp.seek(new Duration(val * 60 * 1000));
                    }
                }
            });


            //volume slider
            volumeslider.setValue(mp.getVolume() * 100);
            volumeslider.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    mp.setVolume(volumeslider.getValue() / 100);
                    try {
                        if (volumeslider.getValue() > 0) {
                            mutemed.setGraphic((new ImageView(new Image(new FileInputStream("src/main/images/unmute.png")))));
                        } else {
                            mutemed.setGraphic((new ImageView(new Image(new FileInputStream("src/main/images/mute.png")))));
                        }
                    }catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
