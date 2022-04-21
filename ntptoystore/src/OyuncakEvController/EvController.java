package OyuncakEvController;

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


public class EvController implements ControllerInterFace {

   @FXML
    private ImageView backIcon;
    @FXML
    private TableView<OyuncakEntity> evTable;
    @FXML
    private TableColumn<?, ?> evResimColumn;
    @FXML
    private TableColumn<?, ?> evMarkaColumn;
    @FXML
    private TableColumn<?, ?> evRenkColumn;
    @FXML
    private TableColumn<?, ?> evEbatColumn;
    @FXML
    private TableColumn<?, ?> evMalzemeColumn;
    @FXML
    private TableColumn<?, ?> evOyuncuSayisiColumn;
    @FXML
    private TableColumn<?, ?> evParcaSayisiColumn;
    @FXML
    private TableColumn<?, ?> evFiyatColumn;
    @FXML
    private Button satınAlButton;
    @FXML
    private Button urunListeleButton;

   

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
            String marka, malzeme, renk;
            int ebat, fiyat, oyuncuSayisi,parcaSayisi;
            OyuncakEv ev;
            fileIO file = new fileIO();

            ev = (OyuncakEv) evTable.getSelectionModel().getSelectedItem();
            marka = ev.getMarka();
            malzeme = ev.getMalzeme();
            oyuncuSayisi = ev.getOyuncuSayisi();
            renk = ev.getRenk();
            ebat = ev.getEbat();
            fiyat = ev.getFiyat();
            parcaSayisi = ev.getParcaSayisi();
            String deger = marka + "," + ebat + "," + oyuncuSayisi + "," + parcaSayisi + "," + malzeme + "," + renk + "," + fiyat;

            file.dosyadanSil("Oyuncak Ev.txt", deger);
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("Ürün başarıyla satın alınmıştır.İyi oyunlar.");
            a.show();
            urunleriListele();
        } catch (IOException ex) {
            Logger.getLogger(EvController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    @FXML
    public void urunleriListele() {
        fileIO file = new fileIO("Oyuncak Ev.txt");
        file.dosyaOku("Oyuncak Ev.txt", "Oyuncak Ev");

        evResimColumn.setCellValueFactory(new PropertyValueFactory<>("resim"));
        evMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
        evRenkColumn.setCellValueFactory(new PropertyValueFactory<>("renk"));
        evEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
        evMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
        evParcaSayisiColumn.setCellValueFactory(new PropertyValueFactory<>("parcaSayisi"));
        evOyuncuSayisiColumn.setCellValueFactory(new PropertyValueFactory<>("oyuncuSayisi"));
        evFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));

        evTable.setItems(file.getEv());
    }
    
}
