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
  private static final int WINDOW_WIDTH = 750;
  private static final int WINDOW_HEIGHT = 500;
  
  // retain which command is being used in show data screen, 0 = none, 1 = farm, 2 = annual, 3 = monthly, 4 = date range
  private int dataVal = 0;
  
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
    Text welcomeTxt = new Text("Welcome to our Milk Weights Program! This program allows you to add data of farms' daily added weights through csv files or manual entry. Once data is entered, you can also view statistics based off on entered dates. Use the two buttons below to navigate between the data input and statistics screen.");
    welcomeTxt.setWrappingWidth(WINDOW_WIDTH/2);
    welcomeTxt.setFont(new Font(20));
    HBox mainCenter = new HBox(welcomeTxt);
    mainCenter.setAlignment(Pos.CENTER);
    mainroot.setCenter(mainCenter);
    
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
    
    VBox inputCenter = new VBox(20);
    inputCenter.setAlignment(Pos.TOP_CENTER);
    alterRoot.setCenter(inputCenter);
    Text currInputType = new Text("Current input type");
    Button processBtn = new Button("Process instruction");
    inputCenter.getChildren().add(currInputType);
    
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
    
    Text dayDesc = new Text("Enter in the day you want to change as a number");
    TextField dayInput = new TextField();
    HBox dayBox = new HBox(20);
    dayBox.setAlignment(Pos.CENTER);
    dayBox.getChildren().addAll(dayDesc,dayInput);
    
    Text fileInDesc = new Text("Type the name of the file you want to input here");
    TextField fileInput = new TextField();
    HBox fileInBox = new HBox(20);
    fileInBox.setAlignment(Pos.CENTER);
    fileInBox.getChildren().addAll(fileInDesc,fileInput);
    
      
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
       inputCenter.getChildren().addAll(currInputType, farmBox, monthBox, yearBox, weightBox, dayBox, processBtn);
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
    VBox dataTop = new VBox(10);
    dataTop.setAlignment(Pos.CENTER);
    dataRoot.setTop(dataTop);
    
    Text dataDirections = new Text("Choose your desired action");
    HBox dataChoices = new HBox(10);
    dataChoices.setAlignment(Pos.CENTER);
    Button farmReport = new Button("Single farm (annual)");
    Button annualReport = new Button("Annual (all farms)");
    Button monthlyReport = new Button("Monthly (all farms)");
    Button dateRange = new Button("Date range (all farms)");
    dataChoices.getChildren().addAll(farmReport, annualReport, monthlyReport, dateRange);
    dataTop.getChildren().addAll(dataDirections, dataChoices);
    
    VBox dataCenter = new VBox(20);
    dataCenter.setAlignment(Pos.TOP_CENTER);
    dataRoot.setCenter(dataCenter);
    
    Text currDataType = new Text("Current data type");
    dataCenter.getChildren().add(currDataType);
    
    Button showDataBtn = new Button("Show Data");
    
    // new boxes for data display screen to not have issues when switching screens
    // othewise same 
    Text farmDescD = new Text("Enter in the number of the farm");
    TextField farmInputD = new TextField();
    HBox farmBoxD = new HBox(20);
    farmBoxD.setAlignment(Pos.CENTER);
    farmBoxD.getChildren().addAll(farmDescD,farmInputD);
    
    Text monthDescD = new Text("Enter in the month as a number (1 = Jan, 12 = Dec)");
    TextField monthInputD = new TextField();
    HBox monthBoxD = new HBox(20);
    monthBoxD.setAlignment(Pos.CENTER);
    monthBoxD.getChildren().addAll(monthDescD,monthInputD);
    
    Text yearDescD = new Text("Enter in the year");
    TextField yearInputD = new TextField();
    HBox yearBoxD = new HBox(20);
    yearBoxD.setAlignment(Pos.CENTER);
    yearBoxD.getChildren().addAll(yearDescD,yearInputD);
    
    Text startDescD = new Text("Enter in the starting day (yyyy-mm-dd)");
    TextField startInputD = new TextField();
    HBox startBoxD = new HBox(20);
    startBoxD.setAlignment(Pos.CENTER);
    startBoxD.getChildren().addAll(startDescD,startInputD);
    
    Text endDescD = new Text("Enter in the ending day (mm-dd)");
    TextField endInputD = new TextField();
    HBox endBoxD = new HBox(20);
    endBoxD.setAlignment(Pos.CENTER);
    endBoxD.getChildren().addAll(endDescD,endInputD);
    
    farmReport.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
       dataCenter.getChildren().clear();
       currDataType.setText("Input farm id and year");
       dataVal = 1;
       dataCenter.getChildren().addAll(currDataType, farmBoxD, yearBoxD, showDataBtn);
   }});   
    annualReport.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
       dataCenter.getChildren().clear();
       currDataType.setText("Input a year");
       dataVal = 2;
       dataCenter.getChildren().addAll(currDataType, yearBoxD, showDataBtn);
   }});
    monthlyReport.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
       dataCenter.getChildren().clear();
       currDataType.setText("Input month and year");
       dataVal = 3;
       dataCenter.getChildren().addAll(currDataType, monthBoxD, yearBoxD, showDataBtn);
   }});
    dateRange.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
       dataCenter.getChildren().clear();
       currDataType.setText("Input start day and end day");
       dataVal = 4;
       dataCenter.getChildren().addAll(currDataType, startBoxD, endBoxD, showDataBtn);
   }});
    

    showDataBtn.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        dataCenter.getChildren().clear();
        VBox showedData = new VBox(15);
        showedData.setAlignment(Pos.CENTER);
        
        // add buttons to change between sets of farms
        VBox nextFarms = new VBox(15);
        nextFarms.setAlignment(Pos.CENTER);
        nextFarms.getChildren().add(new Button("Next farms"));
        VBox lastFarms = new VBox(15);
        lastFarms.setAlignment(Pos.CENTER);
        lastFarms.getChildren().add(new Button("Last farms"));
        
         // set up slots for data display
            Text IDVal = new Text();
            HBox r1 = new HBox(10);
            Text s1 = new Text();
            Text s2 = new Text();
            Text s3 = new Text();
            Text s4 = new Text();
            r1.getChildren().addAll(s1, s2, s3, s4);
            r1.setAlignment(Pos.CENTER);
            HBox r2 = new HBox(10);
            Text s5 = new Text();
            Text s6 = new Text();
            Text s7 = new Text();
            Text s8 = new Text();
            r2.getChildren().addAll(s5, s6, s7, s8);
            r2.setAlignment(Pos.CENTER);
            HBox r3 = new HBox(10);
            Text s9 = new Text();
            Text s10 = new Text();
            Text s11 = new Text();
            Text s12 = new Text();
            r3.getChildren().addAll(s9, s10, s11, s12);
            r3.setAlignment(Pos.CENTER);
            Text summaryStats = new Text();
            showedData.getChildren().addAll(IDVal, r1, r2,r3);
            
        switch (dataVal) {
          case 0:
            dataCenter.getChildren().add(new Text("No command recognized"));
            break;
            // temporary for display purposes
          case 1: // farm report
            dataCenter.getChildren().addAll(currDataType, farmBoxD, yearBoxD, showDataBtn, showedData);
            IDVal.setText("Farm #" + farmInputD.getText() + " Year: " + yearInputD.getText());
            s1.setText("jan: 3253, 8.33");
            s2.setText("feb: 3253, 8.33");
            s3.setText("mar: 3253, 8.33");
            s4.setText("apr: 3253, 8.33");
            
            s5.setText("may: 3253, 8.33");
            s6.setText("jun: 3253, 8.33");
            s7.setText("jul: 3253, 8.33");
            s8.setText("aug: 3253, 8.33");
            
            s9.setText("sep: 3253, 8.33");
            s10.setText("oct: 3253, 8.33");
            s11.setText("nov: 3253, 8.33");
            s12.setText("dec: 3253, 8.33");
            summaryStats.setText("year total: 45354 year min: 43  year max: 5234 year avg: 3323");
            showedData.getChildren().add(summaryStats);
            dataRoot.setRight(null);
            dataRoot.setLeft(null);
            break;
          case 2: // annual report
            dataCenter.getChildren().addAll(currDataType, yearBoxD, showDataBtn, showedData);
            IDVal.setText("Year: " + yearInputD.getText());
            s1.setText("farm: 3253, 8.33");
            s2.setText("farm: 3253, 8.33");
            s3.setText("farm: 3253, 8.33");
            s4.setText("farm: 3253, 8.33");
            
            s5.setText("farm: 3253, 8.33");
            s6.setText("farm: 3253, 8.33");
            s7.setText("farm: 3253, 8.33");
            s8.setText("farm: 3253, 8.33");
            
            s9.setText("farm: 3253, 8.33");
            s10.setText("farm: 3253, 8.33");
            s11.setText("farm: 3253, 8.33");
            s12.setText("farm: 3253, 8.33");
            summaryStats.setText("year total: 45354 year min: 43  year max: 5234 year avg: 3323");
            showedData.getChildren().add(summaryStats);
            dataRoot.setRight(nextFarms);
            dataRoot.setLeft(lastFarms);
            break;
          case 3: // month report
            dataCenter.getChildren().addAll(currDataType, monthBoxD, yearBoxD, showDataBtn, showedData);
            IDVal.setText("Month: " + monthInputD.getText() + " Year: " + yearInputD.getText());
            s1.setText("farm: 3253, 8.33");
            s2.setText("farm: 3253, 8.33");
            s3.setText("farm: 3253, 8.33");
            s4.setText("farm: 3253, 8.33");
            
            s5.setText("farm: 3253, 8.33");
            s6.setText("farm: 3253, 8.33");
            s7.setText("farm: 3253, 8.33");
            s8.setText("farm: 3253, 8.33");
            
            s9.setText("farm: 3253, 8.33");
            s10.setText("farm: 3253, 8.33");
            s11.setText("farm: 3253, 8.33");
            s12.setText("farm: 3253, 8.33");
            summaryStats.setText("total: 45354 min: 43  max: 5234 avg: 3323");
            showedData.getChildren().add(summaryStats);
            dataRoot.setRight(nextFarms);
            dataRoot.setLeft(lastFarms);
            break;
          case 4: // date report
            dataCenter.getChildren().addAll(currDataType, startBoxD, endBoxD, showDataBtn, showedData);
            IDVal.setText("start day: " + startInputD.getText() + " end day: " + endInputD.getText());
            s1.setText("farm: 3253, 8.33");
            s2.setText("farm: 3253, 8.33");
            s3.setText("farm: 3253, 8.33");
            s4.setText("farm: 3253, 8.33");
            
            s5.setText("farm: 3253, 8.33");
            s6.setText("farm: 3253, 8.33");
            s7.setText("farm: 3253, 8.33");
            s8.setText("farm: 3253, 8.33");
            
            s9.setText("farm: 3253, 8.33");
            s10.setText("farm: 3253, 8.33");
            s11.setText("farm: 3253, 8.33");
            s12.setText("farm: 3253, 8.33");
            summaryStats.setText("total weight: 3432 min: 342  max: 2353  avg: 2222");
            showedData.getChildren().add(summaryStats);
            dataRoot.setRight(nextFarms);
            dataRoot.setLeft(lastFarms);
            break;
        }
   }});
    
    
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
