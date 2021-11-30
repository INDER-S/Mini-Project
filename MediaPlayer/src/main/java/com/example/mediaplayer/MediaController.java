package com.example.mediaplayer;


import com.jfoenix.controls.JFXSlider;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class MediaController implements Initializable {

    MediaPlayer mp;
    @FXML
    private MediaView mediaview;

    @FXML
    private Button playmedia;

    @FXML
    private Button backwardmedia;

    @FXML
    private Button forwardmedia;

    @FXML
    private JFXSlider slidermedia;

    @FXML
    private JFXSlider volumeslider;

    @FXML
    private Button mutemed;

    @FXML
    private SplitMenuButton mediainf;

    public File fl;
    public Media m;

    //opening window to select media
    @FXML
    void openMedia(ActionEvent event) throws MalformedURLException {
        try {
            FileChooser fc = new FileChooser();
            fl = fc.showOpenDialog(null);
            m = new Media(fl.toURI().toURL().toString());

            if (mp != null) {
                mp.dispose(); //To open another media we must dispose the resources
            }
            mp = new MediaPlayer(m);
            mediaview.setMediaPlayer(mp);
            DoubleProperty width = mediaview.fitWidthProperty();
            DoubleProperty height = mediaview.fitHeightProperty();
            width.bind(Bindings.selectDouble(mediaview.sceneProperty(),"width"));
            height.bind(Bindings.selectDouble(mediaview.sceneProperty(),"height"));
            MediaOpen mo = new MediaOpen(mp,playmedia,slidermedia,volumeslider,mutemed);
            mo.basic();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //closing media
    @FXML
    void closemedia(ActionEvent event){
        CloseMedia c = new CloseMedia(mp, playmedia, slidermedia);
                c.closemed();
    }

    //playing media
    @FXML
    void playpause(ActionEvent event){
        PlaymediaPausemedia p = new PlaymediaPausemedia(playmedia,mp);
        p.playmed();
    }

    //forwarding media by 10sec
    @FXML
    void forwardmed(ActionEvent event){
        Forward f= new Forward(mp);
        f.addten();

    }

    //backwarding media by 10sec
    @FXML
    void backwardmed(ActionEvent event){
        Backward b = new Backward(mp);
        b.subtractten();

    }

    //mute and unmuting the media
    @FXML
    void mutemedia(ActionEvent event){
        Mute mut = new Mute(mp,mutemed,volumeslider);
        mut.muteUnmute();
    }

    //playback speed 0.5
    @FXML
    void pointfive(ActionEvent event)
    {
       Playbackcontrol playback = new Playbackcontrol(mp);
       playback.low();
    }

    //playback speed normal
    @FXML
    void normal(ActionEvent event)
    {
        Playbackcontrol playback = new Playbackcontrol(mp);
        playback.norm();
    }

    //playback speed 1.5
    @FXML
    void onepointfive(ActionEvent event)
    {
        Playbackcontrol playback = new Playbackcontrol(mp);
        playback.high();
    }

    //About the media Player
    @FXML
    void aboutmedia(ActionEvent event)
    {
        About ab= new About();
        ab.show();
    }

    //media information
    @FXML
    void mediainfo(ActionEvent event)
    {
        MediaInfo mediainf=new MediaInfo(m,fl);
        mediainf.print();
    }

    //intialization
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       try {
            playmedia.setGraphic(new ImageView(new Image(new FileInputStream("src/main/images/pause.png"))));
            forwardmedia.setGraphic(new ImageView(new Image(new FileInputStream("src/main/images/forward.png"))));
            backwardmedia.setGraphic(new ImageView(new Image(new FileInputStream("src/main/images/backward.png"))));
           mediainf.setGraphic(new ImageView(new Image(new FileInputStream("src/main/images/info.png"))));
           mutemed.setGraphic(new ImageView(new Image(new FileInputStream("src/main/images/unmute.png"))));

        } catch(Exception e)
        {
            e.printStackTrace();
        }
        slidermedia.setValue(0);
        volumeslider.setValue(100);
    }
}


