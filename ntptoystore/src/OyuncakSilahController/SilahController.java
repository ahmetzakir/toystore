package OyuncakSilahController;

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

public class SilahController implements ControllerInterFace {

    @FXML
    private ImageView backIcon;
    @FXML
    private TableView<OyuncakEntity> silahTable;
    @FXML
    private TableColumn<?, ?> silahResimColumn;
    @FXML
    private TableColumn<?, ?> silahMarkaColumn;
    @FXML
    private TableColumn<?, ?> silahCesitColumn;
    @FXML
    private TableColumn<?, ?> silahEbatColumn;
    @FXML
    private TableColumn<?, ?> silahMalzemeColumn;
    @FXML
    private TableColumn<?, ?> silahMenzilColumn;
    @FXML
    private TableColumn<?, ?> silahRenkColumn;
    @FXML
    private TableColumn<?, ?> silahFiyatColumn;

    
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
    public void satisYap() {
        try {
            String marka, malzeme, cesit, renk;
            int ebat, fiyat, menzil;
            Silah silah;
            fileIO file = new fileIO();

            silah = (Silah) silahTable.getSelectionModel().getSelectedItem();
            marka = silah.getMarka();
            cesit = silah.getCesit();
            ebat = silah.getEbat();
            malzeme = silah.getMalzeme();
            menzil = silah.getMenzil();
            renk = silah.getRenk();
            fiyat = silah.getFiyat();
            String deger = marka + "," + cesit + "," + ebat + "," + malzeme + "," + menzil + "," + renk + "," + fiyat;

            file.dosyadanSil("Oyuncak Silah.txt", deger);
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("Ürün başarıyla satın alınmıştır.İyi oyunlar.");
            a.show();
            urunleriListele();
        } catch (IOException ex) {
            Logger.getLogger(SilahController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void urunleriListele() {
        fileIO file = new fileIO("Oyuncak Silah.txt");
        file.dosyaOku("Oyuncak Silah.txt", "Oyuncak Silah");

        silahResimColumn.setCellValueFactory(new PropertyValueFactory<>("resim"));
        silahMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
        silahCesitColumn.setCellValueFactory(new PropertyValueFactory<>("cesit"));
        silahEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
        silahMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
        silahMenzilColumn.setCellValueFactory(new PropertyValueFactory<>("menzil"));
        silahRenkColumn.setCellValueFactory(new PropertyValueFactory<>("renk"));
        silahFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
        
        silahTable.setItems(file.getSilah());
    }

}
