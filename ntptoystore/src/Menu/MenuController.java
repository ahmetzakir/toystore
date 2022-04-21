package Menu;

import Main.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class MenuController implements Initializable {

    @FXML
    private ImageView magazaImage;
    @FXML
    private ImageView imalatImage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (!(LoginC.admin.getUserId().equals(LoginC.aktifKullanıcı.getUserId())
                && LoginC.admin.getPass().equals(LoginC.aktifKullanıcı.getPass())
                || (LoginC.admin.getPass().equals(LoginC.aktifKullanıcı.getPass())
                && (LoginC.admin.getPhoneNo() == LoginC.aktifKullanıcı.getPhoneNo()))
                || (LoginC.admin.getEmail().equals(LoginC.aktifKullanıcı.getEmail())
                && LoginC.admin.getPass().equals(LoginC.aktifKullanıcı.getPass())))) {
            imalatImage.setVisible(false);
        }

    }

    @FXML
    private void clickIcon(MouseEvent event) {
        if (event.getSource() == magazaImage) {
            try {

                Parent root = FXMLLoader.load(getClass().getResource("/Main/Magaza.fxml"));
                Scene scene = new Scene(root);
                Oyuncak.mystage.setScene(scene);
                Oyuncak.mystage.show();
            } catch (IOException ex) {
                Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (event.getSource() == imalatImage) {

            try {
                Parent root = FXMLLoader.load(getClass().getResource("/Imalat/Imalat.fxml"));
                Scene scene = new Scene(root);
                Oyuncak.mystage.setScene(scene);
                Oyuncak.mystage.show();
            } catch (IOException ex) {
                Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
