package com.example.mediaplayer;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class About {
    public void show() {
        String about = "This is a simple media player which is created for project evaluation by \n Thanmai Deepthi\t\tIIT2020184\n Mohit Rathour\t\tIIT2020194\n Inder Sonu\t\t\tIIT2020195\n Sandhya Boddu\t\tIIT2020210\n";
        Text abt = new Text();
        abt.setText(about);
        abt.setFont(new Font("Roboto", 20));
        BorderPane pane = new BorderPane();
        pane.setCenter(abt);
        Stage stage = new Stage();
        Scene scene = new Scene(pane, 650, 400);
        stage.setTitle("About the Media_Player");
        stage.setScene(scene);
        stage.show();
    }
}
