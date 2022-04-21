package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Oyuncak extends Application {
    public static Stage mystage;
    @Override
    
    public void start(Stage stage) throws Exception {
        
    
        
        mystage=stage;
        Parent root = FXMLLoader.load(getClass().getResource("LoginPane.fxml"));
        
        Scene scene = new Scene(root);
      
        mystage.setScene(scene);
        mystage.setTitle("Proje");
        mystage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
