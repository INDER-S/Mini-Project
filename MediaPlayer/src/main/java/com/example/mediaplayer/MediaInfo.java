package com.example.mediaplayer;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

public class MediaInfo {
    public Media m;
    public File fl;
    MediaInfo(Media med, File f)
    {
        this.m=med;
        this.fl=f;
    }
    public void print()
    {
        Double totdur = m.getDuration().toMinutes();
        long lastmodi= fl.lastModified();
        String path =fl.getAbsolutePath();
        String name= fl.getName();
        long space = fl.getTotalSpace();
        String print= "Name of the file\t\t"+name+"\nTotal Duration\t\t"+totdur+"\nLast Modified\t\t"+lastmodi+"\nTotal space\t\t"+space+"\nAbsolute path\t\t"+path+"\n";
        Text info = new Text();
        info.setText(print);
        info.setFont(new Font("Roboto",20));
        BorderPane pane = new BorderPane();
        pane.setCenter(info);
        Stage stage = new Stage();
        Scene scene = new Scene( pane, 650, 400);
        stage.setTitle("Media Information");
        stage.setScene(scene);
        stage.show();
    }
}
