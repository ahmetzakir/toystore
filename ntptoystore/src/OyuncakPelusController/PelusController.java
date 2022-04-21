package OyuncakPelusController;

import AnaOyuncak.ControllerInterFace;
import AnaOyuncak.OyuncakEntity;
import Main.MagazaController;
import Main.Oyuncak;
import dosyaIslemleri.fileIO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class PelusController implements ControllerInterFace {

    @FXML
    private ImageView backIcon;
    @FXML
    private TableView<OyuncakEntity> pelusTable;
    @FXML
    private TableColumn<?, ?> pelusResimColumn;
    @FXML
    private TableColumn<?, ?> pelusMarkaColumn;
    @FXML
    private TableColumn<?, ?> pelusRenkColumn;
    @FXML
    private TableColumn<?, ?> pelusEbatColumn;
    @FXML
    private TableColumn<?, ?> pelusMalzemeColumn;
    @FXML
    private TableColumn<?, ?> pelusTurColumn;
    @FXML
    private TableColumn<?, ?> pelusGozRengiColumn;
    @FXML
    private TableColumn<?, ?> pelusFiyatColumn;
    @FXML
    private Button satınAlButton;
    @FXML
    private Button urunListeleButton;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void previous(MouseEvent event) {
        if (event.getSource() == backIcon) {
            try {

                Parent root = FXMLLoader.load(getClass().getResource("/Main/Magaza.fxml"));

                Scene scene = new Scene(root);

                Oyuncak.mystage.setScene(scene);
                Oyuncak.mystage.show();
            } catch (IOException ex) {
                Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    @FXML
    public void satisYap() {
        try {
            String marka, malzeme, tur, renk,gozRengi;
            int ebat, fiyat;
            Pelus pelus;
            fileIO file = new fileIO();

            pelus = (Pelus) pelusTable.getSelectionModel().getSelectedItem();
            marka = pelus.getMarka();
            malzeme = pelus.getMalzeme();
            tur = pelus.getTur();
            renk = pelus.getRenk();
            ebat = pelus.getEbat();
            fiyat = pelus.getFiyat();
            gozRengi = pelus.getGozRengi();
            String deger = marka + "," + gozRengi + "," + ebat + "," + malzeme + "," + tur + "," + renk + "," + fiyat;

            file.dosyadanSil("Oyuncak Pelus.txt", deger);
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("Ürün başarıyla satın alınmıştır.İyi oyunlar.");
            a.show();
            urunleriListele();
        } catch (IOException ex) {
            Logger.getLogger(PelusController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    @FXML
    public void urunleriListele() {
        fileIO file = new fileIO("Oyuncak Pelus.txt");
        file.dosyaOku("Oyuncak Pelus.txt", "Oyuncak Pelus");

        pelusResimColumn.setCellValueFactory(new PropertyValueFactory<>("resim"));
        pelusMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
        pelusRenkColumn.setCellValueFactory(new PropertyValueFactory<>("renk"));
        pelusEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
        pelusMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
        pelusTurColumn.setCellValueFactory(new PropertyValueFactory<>("tur"));
        pelusGozRengiColumn.setCellValueFactory(new PropertyValueFactory<>("gozRengi"));
        pelusFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));

        pelusTable.setItems(file.getPelus());
    }
    
}
