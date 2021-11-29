package com.example.mediaplayer;

import com.jfoenix.controls.JFXSlider;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.util.Duration;

public class MediaOpen {
    public MediaPlayer mp;
    public Button playmedia;
    public JFXSlider slidermedia;
    public JFXSlider volumeslider;
    MediaOpen(MediaPlayer player,Button btn,JFXSlider slider1, JFXSlider slider2 )
    {
        this.mp=player;
        this.playmedia=btn;
        this.slidermedia=slider1;
        this.volumeslider=slider2;
    }
    public void basic() {
        try {
            //time slider functions
            mp.setOnReady(() -> {
                slidermedia.setMin(0);
                slidermedia.setMax(mp.getMedia().getDuration().toMinutes());

                slidermedia.setValue(0);

                //setting play icon as we change song
                playmedia.setText("Play");
                //playmedia.setGraphic((new ImageView(new Image(new FileInputStream(src / icons / play.png)))));


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
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
