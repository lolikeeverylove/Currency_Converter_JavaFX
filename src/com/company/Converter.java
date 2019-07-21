package com.company;
//ctrl +o метод создать фастом (при extends)
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;
import java.text.DecimalFormat;

public class Converter extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Конвертор валют"); label.setFont(new Font("Times New Roman", 30));
        Menu menu=new Menu("Валюты");
        MenuBar menuBar=new MenuBar(menu);menuBar.setMaxWidth(80);
        final TextField textField=new TextField();
        Button button=new Button("Сосчитать");
        Label kurs = new Label("1 rubels = 0,14$");
        final Label answer = new Label();
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                answer.setText("Ответ: " + Integer.toString(Integer.parseInt(textField.getText())/60)+" dollars");
            }
        });
        menu.getItems().addAll(menuItem("Rubels","$",0.014, kurs, button,answer,textField),menuItem("Rubels","Dolars",0.017 ,kurs, button,answer,textField),
                menuItem("Euro","Rubels", 70,kurs, button,answer,textField),menuItem("$","Rubels", 60,kurs, button,answer,textField));

        FlowPane flowPane=new FlowPane(textField,button,kurs);
        FlowPane flowPane1=new FlowPane(Orientation.VERTICAL,label,menuBar,flowPane,answer);flowPane1.setPrefHeight(120);
        Scene scene=new Scene(flowPane1);
        primaryStage.setTitle("Converter"); primaryStage.setScene(scene);primaryStage.show();
    }

    private static MenuItem menuItem (final String currencyImport, final String currencyExport, final double kurs, final Label kursLabel, final Button answerButton, final Label answer, final TextField textField){
        MenuItem menu = new MenuItem(currencyImport+" to "+currencyExport);
        menu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                kursLabel.setText("1 "+currencyImport+" = " +Double.toString(kurs)+" "+ currencyExport);
        answerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                answer.setText("Ответ: " + new DecimalFormat("#0.00").format((Integer.parseInt(textField.getText())*kurs))+" "+currencyExport);
            }
        }); }
        });
        return menu;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
//import java.net.*;
//import java.io.*;
//
//public class Converter  {
//    public static void main(String[] args) throws Exception {
//
//        URL oracle = new URL("http://www.oracle.com/");
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(oracle.openStream()));
//
//        String inputLine;
//        while ((inputLine = in.readLine()) != null)
//            System.out.println(inputLine); //Можно   накапливать в StringBuilder а потом присвоить перемной String результат накопления
//        in.close();
//    }
//}
