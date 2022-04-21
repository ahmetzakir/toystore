package EğiticiOyuncaklarController;

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

public class EgiticiOyuncakController implements ControllerInterFace {

    @FXML
    private ImageView backIcon;
    @FXML
    private Button urunListeleButton;
    @FXML
    private Button satınAlButton;
    @FXML
    private TableColumn<?, ?> egiticiResimColumn;
    @FXML
    private TableColumn<?, ?> egiticiMarkaColumn;
    @FXML
    private TableColumn<?, ?> egiticiRenkColumn;
    @FXML
    private TableColumn<?, ?> egiticiEbatColumn;
    @FXML
    private TableColumn<?, ?> egiticiMalzemeColumn;
    @FXML
    private TableColumn<?, ?> egiticiParcaSayisiColumn;
    @FXML
    private TableColumn<?, ?> egiticiYasAraligiColumn;
    @FXML
    private TableColumn<?, ?> egiticiZorlukColumn;
    @FXML
    private TableColumn<?, ?> egiticiFiyatColumn;
    @FXML
    private TableView<OyuncakEntity> egiticiTable;

    
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

    @FXML
    @Override
    public void satisYap() {
        try {
            String marka, malzeme, yasAraligi, renk, zorluk;
            int ebat, fiyat, parcaSayisi;
            EgiticiOyuncak egitici;
            fileIO file = new fileIO();

            egitici = (EgiticiOyuncak) egiticiTable.getSelectionModel().getSelectedItem();
            marka = egitici.getMarka();
            malzeme = egitici.getMalzeme();
            parcaSayisi = egitici.getParcaSayisi();
            renk = egitici.getRenk();
            ebat = egitici.getEbat();
            fiyat = egitici.getFiyat();
            yasAraligi = egitici.getYasAraligi();
            zorluk = egitici.getZorluk();
            String deger = marka + "," + renk + "," + ebat + "," + malzeme + "," + parcaSayisi + "," + yasAraligi + "," + zorluk + "," + fiyat;

            file.dosyadanSil("Egitici Oyuncak.txt", deger);
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("Ürün başarıyla satın alınmıştır.İyi oyunlar.");
            a.show();
            urunleriListele();
        } catch (IOException ex) {
            Logger.getLogger(EgiticiOyuncakController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @FXML
    @Override
    public void urunleriListele() {
        fileIO file = new fileIO("Egitici Oyuncak.txt");
        file.dosyaOku("Egitici Oyuncak.txt", "Egitici Oyuncak");

        egiticiResimColumn.setCellValueFactory(new PropertyValueFactory<>("resim"));
        egiticiMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
        egiticiRenkColumn.setCellValueFactory(new PropertyValueFactory<>("renk"));
        egiticiEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
        egiticiMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
        egiticiParcaSayisiColumn.setCellValueFactory(new PropertyValueFactory<>("parcaSayisi"));
        egiticiYasAraligiColumn.setCellValueFactory(new PropertyValueFactory<>("yasAraligi"));
        egiticiZorlukColumn.setCellValueFactory(new PropertyValueFactory<>("zorluk"));
        egiticiFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
        
        egiticiTable.setItems(file.getEgitici());
    }

}
