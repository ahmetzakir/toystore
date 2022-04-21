package KutuOyunlarıController;

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


public class KutuOyunuController implements ControllerInterFace {

    @FXML
    private ImageView backIcon;
    @FXML
    private TableView<OyuncakEntity> kutuTable;
    @FXML
    private TableColumn<?, ?> kutuResimColumn;
    @FXML
    private TableColumn<?, ?> kutuMarkaColumn;
    @FXML
    private TableColumn<?, ?> kutuEbatColumn;
    @FXML
    private TableColumn<?, ?> kutuMalzemeColumn;
    @FXML
    private TableColumn<?, ?> kutuZorlukColumn;
    @FXML
    private TableColumn<?, ?> kutuOyuncuSayisiColumn;
    @FXML
    private TableColumn<?, ?> kutuFiyatColumn;
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
            String marka, malzeme, zorluk;
            int ebat, fiyat, oyuncuSayisi;
            KutuOyunları kutu;
            fileIO file = new fileIO();

            kutu = (KutuOyunları) kutuTable.getSelectionModel().getSelectedItem();
            marka = kutu.getMarka();
            malzeme = kutu.getMalzeme();
            zorluk = kutu.getZorluk();
            oyuncuSayisi = kutu.getOyuncuSayisi();
            ebat = kutu.getEbat();
            fiyat = kutu.getFiyat();
            
            String deger = marka + "," + zorluk + "," + ebat + "," + malzeme + "," + oyuncuSayisi + "," + fiyat;

            file.dosyadanSil("Kutu Oyunları.txt", deger);
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("Ürün başarıyla satın alınmıştır.İyi oyunlar.");
            a.show();
            urunleriListele();
        } catch (IOException ex) {
            Logger.getLogger(KutuOyunuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    @FXML
    public void urunleriListele() {
        fileIO file = new fileIO("Kutu Oyunları.txt");
        file.dosyaOku("Kutu Oyunları.txt", "Kutu Oyunları");

        kutuResimColumn.setCellValueFactory(new PropertyValueFactory<>("resim"));
        kutuMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
        kutuZorlukColumn.setCellValueFactory(new PropertyValueFactory<>("zorluk"));
        kutuEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
        kutuMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
        kutuOyuncuSayisiColumn.setCellValueFactory(new PropertyValueFactory<>("oyuncuSayisi"));
        kutuFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));

        kutuTable.setItems(file.getKutu());
    }

}
