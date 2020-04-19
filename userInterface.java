/**
 * 
 */
package application;

import java.io.FileInputStream;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Y
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
    Label label = new Label("Main Screen");
    mainroot.setTop(label);
    
    BorderPane inputRoot = new BorderPane();
    Scene inputScene = new Scene(inputRoot, WINDOW_WIDTH, WINDOW_HEIGHT);
    Label inputDirections = new Label("Input your files here");
    inputRoot.setTop(inputDirections);
    
    BorderPane dataRoot = new BorderPane();
    Scene dataScene = new Scene(dataRoot, WINDOW_WIDTH, WINDOW_HEIGHT);
    Label dataDirections = new Label("See the data here");
    dataRoot.setTop(dataDirections);
    
    
    // create buttons to navigate between scenes and add them to borderpanes of scenes
    Button toInputBtn = new Button("Input screen");
    Button toDataBtn = new Button("Data screen");
    Button toMainBtn = new Button("Main screen");
    Button toMainBtn2 = new Button("Main screen");
    
    FlowPane botbox = new FlowPane();
    botbox.getChildren().add(toInputBtn);
    botbox.getChildren().add(toDataBtn);
    mainroot.setBottom(botbox);
    
    toInputBtn.setOnAction(new EventHandler<ActionEvent>() {
       public void handle(ActionEvent e) {
        mainStage.setScene(inputScene);
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
    
    HBox inputBtm = new HBox(toMainBtn);
    inputRoot.setBottom(inputBtm);
    
    HBox dataBtm = new HBox(toMainBtn2);
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
