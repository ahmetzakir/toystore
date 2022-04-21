package OyuncakBebekController;

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

public class BebekController implements ControllerInterFace {

    @FXML
    private ImageView backIcon;
    @FXML
    private TableView<OyuncakEntity> bebekTable;
    @FXML
    private TableColumn<?, ?> bebekResimColumn;
    @FXML
    private TableColumn<?, ?> bebekMarkaColumn;
    @FXML
    private TableColumn<?, ?> bebekCinsiyetColumn;
    @FXML
    private TableColumn<?, ?> bebekEbatColumn;
    @FXML
    private TableColumn<?, ?> bebekMalzemeColumn;
    @FXML
    private TableColumn<?, ?> bebekGozRengiColumn;
    @FXML
    private TableColumn<?, ?> bebekSacRengiColumn;
    @FXML
    private TableColumn<?, ?> bebekFiyatColumn;
    @FXML
    private Button urunListeleButton;
    @FXML
    private Button satınAlButton;

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
            String marka, malzeme, cinsiyet, gozRengi,sacRengi;
            int ebat, fiyat;
            oyuncakBebek bebek;
            fileIO file = new fileIO();

            bebek = (oyuncakBebek) bebekTable.getSelectionModel().getSelectedItem();
            marka = bebek.getMarka();
            malzeme = bebek.getMalzeme();
            cinsiyet = bebek.getCinsiyet();
            sacRengi = bebek.getSacRengi();
            ebat = bebek.getEbat();
            fiyat = bebek.getFiyat();
            gozRengi = bebek.getGozRengi();
            String deger = marka + "," + ebat + "," + cinsiyet + "," + gozRengi + "," + malzeme + "," + sacRengi + "," + fiyat;

            file.dosyadanSil("Oyuncak Bebek.txt", deger);
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("Ürün başarıyla satın alınmıştır.İyi oyunlar.");
            a.show();
            urunleriListele();
        } catch (IOException ex) {
            Logger.getLogger(BebekController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    @FXML
    public void urunleriListele() {
        fileIO file = new fileIO("Oyuncak Bebek.txt");
        file.dosyaOku("Oyuncak Bebek.txt", "Oyuncak Bebek");

        bebekResimColumn.setCellValueFactory(new PropertyValueFactory<>("resim"));
        bebekMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
        bebekSacRengiColumn.setCellValueFactory(new PropertyValueFactory<>("sacRengi"));
        bebekEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
        bebekMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
        bebekCinsiyetColumn.setCellValueFactory(new PropertyValueFactory<>("cinsiyet"));
        bebekGozRengiColumn.setCellValueFactory(new PropertyValueFactory<>("gozRengi"));
        bebekFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));

        bebekTable.setItems(file.getBebek());
    }

}
