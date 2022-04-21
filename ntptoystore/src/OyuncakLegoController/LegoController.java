package OyuncakLegoController;

import AnaOyuncak.ControllerInterFace;
import AnaOyuncak.OyuncakEntity;
import Main.MagazaController;
import Main.Oyuncak;
import OyuncakArabaController.ArabaController;
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

public class LegoController implements ControllerInterFace {

    @FXML
    private ImageView backIcon;
    @FXML
    private TableView<OyuncakEntity> legoTable;
    @FXML
    private TableColumn<?, ?> legoResimColumn;
    @FXML
    private TableColumn<?, ?> legoMarkaColumn;
    @FXML
    private TableColumn<?, ?> legoRenkColumn;
    @FXML
    private TableColumn<?, ?> legoEbatColumn;
    @FXML
    private TableColumn<?, ?> legoMalzemeColumn;
    @FXML
    private TableColumn<?, ?> legoParcaSayisiColumn;
    @FXML
    private TableColumn<?, ?> legoZorlukColumn;
    @FXML
    private TableColumn<?, ?> legoFiyatColumn;
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
            String marka, malzeme, zorluk, renk;
            int ebat, fiyat, parcaSayisi;
            Lego lego;
            fileIO file = new fileIO();

            lego = (Lego) legoTable.getSelectionModel().getSelectedItem();
            marka = lego.getMarka();
            malzeme = lego.getMalzeme();
            zorluk = lego.getZorluk();
            renk = lego.getRenk();
            ebat = lego.getEbat();
            fiyat = lego.getFiyat();
            parcaSayisi = lego.getParcaSayisi();
            String deger = marka + "," + parcaSayisi + "," + ebat + "," + malzeme + "," + zorluk + "," + renk + "," + fiyat;

            file.dosyadanSil("Oyuncak Lego.txt", deger);
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("Ürün başarıyla satın alınmıştır.İyi oyunlar.");
            a.show();
            urunleriListele();
        } catch (IOException ex) {
            Logger.getLogger(ArabaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    @FXML
    public void urunleriListele() {
        fileIO file = new fileIO("Oyuncak Lego.txt");
        file.dosyaOku("Oyuncak Lego.txt", "Oyuncak Lego");

        legoResimColumn.setCellValueFactory(new PropertyValueFactory<>("resim"));
        legoMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
        legoRenkColumn.setCellValueFactory(new PropertyValueFactory<>("renk"));
        legoEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
        legoMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
        legoParcaSayisiColumn.setCellValueFactory(new PropertyValueFactory<>("parcaSayisi"));
        legoZorlukColumn.setCellValueFactory(new PropertyValueFactory<>("zorluk"));
        legoFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));

        legoTable.setItems(file.getLego());
    }

}
