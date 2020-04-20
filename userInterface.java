/**
 * 
 */
package application;

import java.io.FileInputStream;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*; 
import javafx.scene.canvas.*; 
import javafx.scene.layout.*; 

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * @author Y
 *
 *references https://www.geeksforgeeks.org/javafx-hbox-class/
 *http://tutorials.jenkov.com/javafx/index.html
 *
 */
public class userInterface extends Application {
  private List<String> args;
  private static final int WINDOW_WIDTH = 600;
  private static final int WINDOW_HEIGHT = 500;
  
  @Override
  public void start(Stage mainStage) throws Exception {
    // TODO Auto-generated method stub
    args = this.getParameters().getRaw();
    
    BorderPane mainroot = new BorderPane();
    Scene mainScene = new Scene(mainroot, WINDOW_WIDTH, WINDOW_HEIGHT);
    
    BorderPane alterRoot = new BorderPane();
    Scene alterScene = new Scene(alterRoot, WINDOW_WIDTH, WINDOW_HEIGHT);
    
    BorderPane dataRoot = new BorderPane();
    Scene dataScene = new Scene(dataRoot, WINDOW_WIDTH, WINDOW_HEIGHT);
    
    // create buttons to navigate between scenes and add them to borderpanes of scenes
    Button toAlterBtn = new Button("Change data screen");
    Button toDataBtn = new Button("View data screen");
    Button toMainBtn = new Button("Main screen");
    Button toMainBtn2 = new Button("Main screen");
    
    toAlterBtn.setOnAction(new EventHandler<ActionEvent>() {
       public void handle(ActionEvent e) {
        mainStage.setScene(alterScene);
    }});   
    toMainBtn.setOnAction(new EventHandler<ActionEvent>() {
       public void handle(ActionEvent e) {
        mainStage.setScene(mainScene);
    }});
    toMainBtn2.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
       mainStage.setScene(mainScene);
   }});
    toDataBtn.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
       mainStage.setScene(dataScene);
   }});
    
    // setup main scene
    
    Label label = new Label("Main Screen");
    mainroot.setTop(label);
    
    
    HBox mainBtm = new HBox(40);
    mainBtm.setAlignment(Pos.CENTER);
    mainBtm.getChildren().add(toAlterBtn);
    mainBtm.getChildren().add(toDataBtn);
    mainroot.setBottom(mainBtm);
    
    // setup scene to modify or add data
    VBox alterTop = new VBox(10);
    alterTop.setAlignment(Pos.CENTER);
    alterRoot.setTop(alterTop);
    
    Text alterDirections = new Text("Choose your desired action");
    HBox alterChoices = new HBox(10);
    alterChoices.setAlignment(Pos.CENTER);
    Button addData = new Button("Add data");
    Button editData = new Button("Edit data");
    Button removeData = new Button("Remove data");
    Button inputData = new Button("Input file as data");
    alterChoices.getChildren().addAll(addData, editData, removeData, inputData);
    alterTop.getChildren().addAll(alterDirections, alterChoices);
    
    VBox inputCenter = new VBox(30);
    inputCenter.setAlignment(Pos.TOP_CENTER);
    alterRoot.setCenter(inputCenter);
    Text currInputType = new Text("Current input type");
    Button processBtn = new Button("Process instruction");
    
    Text farmDesc = new Text("Enter in the number of the farm");
    TextField farmInput = new TextField();
    HBox farmBox = new HBox(20);
    farmBox.setAlignment(Pos.CENTER);
    farmBox.getChildren().addAll(farmDesc,farmInput);
    
    Text monthDesc = new Text("Enter in the month as a number (1 = Jan, 12 = Dec)");
    TextField monthInput = new TextField();
    HBox monthBox = new HBox(20);
    monthBox.setAlignment(Pos.CENTER);
    monthBox.getChildren().addAll(monthDesc,monthInput);
    
    Text yearDesc = new Text("Enter in the year");
    TextField yearInput = new TextField();
    HBox yearBox = new HBox(20);
    yearBox.setAlignment(Pos.CENTER);
    yearBox.getChildren().addAll(yearDesc,yearInput);
    
    Text weightDesc = new Text("Enter in the milk weight");
    TextField weightInput = new TextField();
    HBox weightBox = new HBox(20);
    weightBox.setAlignment(Pos.CENTER);
    weightBox.getChildren().addAll(weightDesc,weightInput);
    
    Text fileInDesc = new Text("Type the name of the file you want to input here");
    TextField fileInput = new TextField();
    HBox fileInBox = new HBox(20);
    fileInBox.setAlignment(Pos.CENTER);
    fileInBox.getChildren().addAll(fileInDesc,fileInput);
    
    inputCenter.getChildren().add(currInputType);
    
    addData.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
       inputCenter.getChildren().clear();
       currInputType.setText("Adding data");
       inputCenter.getChildren().addAll(currInputType, farmBox, monthBox, yearBox, processBtn);
   }});
    editData.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
       inputCenter.getChildren().clear();
       currInputType.setText("Editing data");
       inputCenter.getChildren().addAll(currInputType, farmBox, monthBox, yearBox, weightBox, processBtn);
   }});
    removeData.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
       inputCenter.getChildren().clear();
       currInputType.setText("Removing data");
       inputCenter.getChildren().addAll(currInputType, farmBox, monthBox, yearBox, processBtn);
   }});
    inputData.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
       inputCenter.getChildren().clear();
       currInputType.setText("Inputting a file as data");
       inputCenter.getChildren().addAll(currInputType, fileInBox, processBtn);
   }});
    
    
    
    HBox alterBtm = new HBox(toMainBtn);
    alterBtm.setAlignment(Pos.CENTER);
    alterRoot.setBottom(alterBtm);
    
    
    //setup scene to display data
    Label dataDirections = new Label("See the data here");
    dataRoot.setTop(dataDirections);
    
    HBox dataBtm = new HBox(toMainBtn2);
    dataBtm.setAlignment(Pos.CENTER);
    dataRoot.setBottom(dataBtm);
    
    
    mainStage.setTitle("Milk Weights Program");
    mainStage.setScene(mainScene);
    mainStage.show();
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    launch(args);
  }

}
