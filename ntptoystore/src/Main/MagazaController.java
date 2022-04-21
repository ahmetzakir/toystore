package Main;

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

public class MagazaController implements Initializable {

    @FXML
    private ImageView logout;
    @FXML
    private ImageView backIcon;
    @FXML
    private ImageView arabaImage;
    @FXML
    private ImageView bebekImage;
    @FXML
    private ImageView legoImage;
    @FXML
    private ImageView evImage;
    @FXML
    private ImageView egiticiImage;
    @FXML
    private ImageView pelusImage;
    @FXML
    private ImageView kutuImage;
    @FXML
    private ImageView silahImage;
    @FXML
    private ImageView puzzleImage;
    @FXML
    private ImageView figurImage;
    @FXML
    private ImageView helikopterImage;
    @FXML
    private ImageView trenImage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clickIcon(MouseEvent event) {
        if (event.getSource() == arabaImage) {
            try {

                Parent root = FXMLLoader.load(getClass().getResource("/OyuncakArabaController/Araba.fxml"));

                Scene scene = new Scene(root);

                Oyuncak.mystage.setScene(scene);
                Oyuncak.mystage.show();
            } catch (IOException ex) {
                Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getSource() == bebekImage) {
            try {

                Parent root = FXMLLoader.load(getClass().getResource("/OyuncakBebekController/Bebek.fxml"));

                Scene scene = new Scene(root);

                Oyuncak.mystage.setScene(scene);
                Oyuncak.mystage.show();
            } catch (IOException ex) {
                Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getSource() == legoImage) {
            try {

                Parent root = FXMLLoader.load(getClass().getResource("/OyuncakLegoController/Lego.fxml"));

                Scene scene = new Scene(root);

                Oyuncak.mystage.setScene(scene);
                Oyuncak.mystage.show();
            } catch (IOException ex) {
                Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getSource() == evImage) {
            try {

                Parent root = FXMLLoader.load(getClass().getResource("/OyuncakEvController/Ev.fxml"));

                Scene scene = new Scene(root);

                Oyuncak.mystage.setScene(scene);
                Oyuncak.mystage.show();
            } catch (IOException ex) {
                Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getSource() == egiticiImage) {
            try {

                Parent root = FXMLLoader.load(getClass().getResource("/EğiticiOyuncaklarController/EgiticiOyuncak.fxml"));

                Scene scene = new Scene(root);

                Oyuncak.mystage.setScene(scene);
                Oyuncak.mystage.show();
            } catch (IOException ex) {
                Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getSource() == pelusImage) {
            try {

                Parent root = FXMLLoader.load(getClass().getResource("/OyuncakPelusController/Pelus.fxml"));

                Scene scene = new Scene(root);

                Oyuncak.mystage.setScene(scene);
                Oyuncak.mystage.show();
            } catch (IOException ex) {
                Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getSource() == kutuImage) {
            try {

                Parent root = FXMLLoader.load(getClass().getResource("/KutuOyunlarıController/KutuOyunu.fxml"));

                Scene scene = new Scene(root);

                Oyuncak.mystage.setScene(scene);
                Oyuncak.mystage.show();
            } catch (IOException ex) {
                Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getSource() == silahImage) {
            try {

                Parent root = FXMLLoader.load(getClass().getResource("/OyuncakSilahController/Silah.fxml"));

                Scene scene = new Scene(root);

                Oyuncak.mystage.setScene(scene);
                Oyuncak.mystage.show();
            } catch (IOException ex) {
                Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getSource() == puzzleImage) {
            try {

                Parent root = FXMLLoader.load(getClass().getResource("/PuzzleController/Puzzle.fxml"));

                Scene scene = new Scene(root);

                Oyuncak.mystage.setScene(scene);
                Oyuncak.mystage.show();
            } catch (IOException ex) {
                Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getSource() == figurImage) {
            try {

                Parent root = FXMLLoader.load(getClass().getResource("/FigurController/Figur.fxml"));

                Scene scene = new Scene(root);

                Oyuncak.mystage.setScene(scene);
                Oyuncak.mystage.show();
            } catch (IOException ex) {
                Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getSource() == helikopterImage) {
            try {

                Parent root = FXMLLoader.load(getClass().getResource("/OyuncakHelikopterController/Helikopter.fxml"));

                Scene scene = new Scene(root);

                Oyuncak.mystage.setScene(scene);
                Oyuncak.mystage.show();
            } catch (IOException ex) {
                Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getSource() == trenImage) {
            try {

                Parent root = FXMLLoader.load(getClass().getResource("/OyuncakTrenController/Tren.fxml"));

                Scene scene = new Scene(root);

                Oyuncak.mystage.setScene(scene);
                Oyuncak.mystage.show();
            } catch (IOException ex) {
                Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getSource() == logout) {
            try {

                Parent root = FXMLLoader.load(getClass().getResource("LoginPane.fxml"));

                Scene scene = new Scene(root);

                Oyuncak.mystage.setScene(scene);
                Oyuncak.mystage.show();
            } catch (IOException ex) {
                Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getSource() == backIcon) {
            try {

                Parent root = FXMLLoader.load(getClass().getResource("/Menu/Menu.fxml"));

                Scene scene = new Scene(root);

                Oyuncak.mystage.setScene(scene);
                Oyuncak.mystage.show();
            } catch (IOException ex) {
                Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
