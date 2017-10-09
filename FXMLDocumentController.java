/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.system;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author A. Yitzkak
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML
    private Label label;
    @FXML
    private Connect conn;
    @FXML
    private TextField username;
    @FXML
    private Label error_message;
    @FXML
    private TextField password;
    private PreparedStatement pst;
    ResultSet rs = null;
    
    
    // cls = getClass().getClassLoader().getResourceAsStream("/homepage/Main_Window.fxml");
    
    // CLOSE BUTTON HANDLER
    @FXML
    private void handleCloseButtonAction(ActionEvent event) {
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.close();
    }
    
    //LOGIN BUTTON HANDLER
    @FXML
    //@SuppressWarnings("empty-statement")
    private void handleLoginButtonAction( ActionEvent event) throws IOException {
        Connection dbConn = conn.Connect();
        try {
            String sql= "select * from user where username=? and password=?";
            pst = dbConn.prepareStatement(sql);
            pst.setString(1, username.getText());
            pst.setString(2, password.getText());
            // System.out.println("username= "+uname+" and password ="+pwd );
            rs =  pst.executeQuery();
            if(rs.next()){
               String name = (String) getClass().getName();
               System.out.println("The Class name is name "+name);
               Parent homepage = FXMLLoader.load(getClass().getClassLoader().getResource("school/management/system/homepage/Main_Window.fxml"));
               Scene homepage_scene = new Scene(homepage);
                     
               //Scene homepage_scene = new Scene(homepage);
               
               homepage_scene.setRoot(homepage);
               Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               app_stage.hide();
               Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
               app_stage.setX(bounds.getMinX());
               app_stage.setY(bounds.getMinY());
               app_stage.setWidth(bounds.getWidth());
               app_stage.setHeight(bounds.getHeight());
               app_stage.setScene(homepage_scene);
               //app_stage.initStyle(StageStyle.DECORATED);
               app_stage.show();
            }
            else{
                error_message.setText("Incorrect Login Details!");
            }
            
            
        } catch (SQLException ex) {
            System.out.print("Not Working");
           // Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        //Connect.Connect();
        //conn = new Connect();
    }
    

    
}
