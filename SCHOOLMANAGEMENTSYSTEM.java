/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.system;

import java.sql.Connection;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author A. Yitzkak
 */
public class SCHOOLMANAGEMENTSYSTEM extends Application {
    private double xoffset = 0;
    private double yoffset = 0;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        stage.initStyle(StageStyle.TRANSPARENT);
        root.setOnMousePressed(new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event){
            xoffset = event.getSceneX();
            yoffset = event.getSceneY();
        }
        });
        
        root.setOnMouseDragged(new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event){
            stage.setX(event.getScreenX() - xoffset); ;
            stage.setY(event.getScreenY() - yoffset); ;
        }
        });
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
       
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
