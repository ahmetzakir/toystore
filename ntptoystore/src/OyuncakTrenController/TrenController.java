package OyuncakTrenController;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class TrenController implements ControllerInterFace {

    @FXML
    private ImageView backIcon;
    @FXML
    private TableView<OyuncakEntity> trenTable;
    @FXML
    private TableColumn<?, ?> trenResimColumn;
    @FXML
    private TableColumn<?, ?> trenMarkaColumn;
    @FXML
    private TableColumn<?, ?> trenMalzemeColumn;
    @FXML
    private TableColumn<?, ?> trenParcaSayisiColumn;
    @FXML
    private TableColumn<?, ?> trenFiyatColumn;
    @FXML
    private TableColumn<?, ?> trenEbatColumn;
    @FXML
    private TableColumn<?, ?> trenUzunlukColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
    public void satisYap() { try {
            String marka, malzeme;
            int ebat, fiyat, parcaSayisi, uzunluk;
            Tren tren;
            fileIO file = new fileIO();

            tren = (Tren) trenTable.getSelectionModel().getSelectedItem();
            marka = tren.getMarka();
            ebat = tren.getEbat();
            malzeme = tren.getMalzeme();
            parcaSayisi = tren.getParcaSayisi();
            uzunluk = tren.getUzunluk();            
            fiyat = tren.getFiyat();
            
            String deger = marka + "," + ebat + "," + malzeme + "," + parcaSayisi + "," + uzunluk + "," + fiyat;

            file.dosyadanSil("Oyuncak Tren.txt", deger);
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("Ürün başarıyla satın alınmıştır.İyi oyunlar.");
            a.show();
            urunleriListele();
        } catch (IOException ex) {
            Logger.getLogger(TrenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void urunleriListele() {
        fileIO file = new fileIO("Oyuncak Tren.txt");
        file.dosyaOku("Oyuncak Tren.txt", "Oyuncak Tren");

        trenResimColumn.setCellValueFactory(new PropertyValueFactory<>("resim"));
        trenMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
        trenEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
        trenMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
        trenUzunlukColumn.setCellValueFactory(new PropertyValueFactory<>("uzunluk"));
        trenFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
        trenParcaSayisiColumn.setCellValueFactory(new PropertyValueFactory<>("parcaSayisi"));
        
        
        trenTable.setItems(file.getTren());
    }

}
