package OyuncakArabaController;

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

public class ArabaController implements ControllerInterFace {

    @FXML
    private ImageView backIcon;
    @FXML
    private TableView<OyuncakEntity> arabaTable;
    @FXML
    private TableColumn<?, ?> arabaResimColumn;
    @FXML
    private TableColumn<?, ?> arabaMarkaColumn;
    @FXML
    private TableColumn<?, ?> arabaRenkColumn;
    @FXML
    private TableColumn<?, ?> arabaEbatColumn;
    @FXML
    private TableColumn<?, ?> arabaMalzemeColumn;
    @FXML
    private TableColumn<?, ?> arabaKategoriColumn;
    @FXML
    private TableColumn<?, ?> arabaSarjColumn;
    @FXML
    private TableColumn<?, ?> arabaFiyatColumn;
    @FXML
    private Button satınAlButton;
    @FXML
    private Button urunListeleButton;

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
    public void urunleriListele() {
        fileIO file = new fileIO("Araba.txt");
        file.dosyaOku("Araba.txt", "Oyuncak Araba");

        arabaResimColumn.setCellValueFactory(new PropertyValueFactory<>("resim"));
        arabaMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
        arabaRenkColumn.setCellValueFactory(new PropertyValueFactory<>("renk"));
        arabaEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
        arabaMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
        arabaKategoriColumn.setCellValueFactory(new PropertyValueFactory<>("kategori"));
        arabaSarjColumn.setCellValueFactory(new PropertyValueFactory<>("sarjSuresi"));
        arabaFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));

        arabaTable.setItems(file.getAraba());
    }

    @FXML
    @Override
    public void satisYap() {
        try {
            String marka, malzeme, kategori, renk;
            int ebat, fiyat, sarjSüresi;
            oyuncakAraba araba;
            fileIO file = new fileIO();

            araba = (oyuncakAraba) arabaTable.getSelectionModel().getSelectedItem();
            marka = araba.getMarka();
            malzeme = araba.getMalzeme();
            kategori = araba.getKategori();
            renk = araba.getRenk();
            ebat = araba.getEbat();
            fiyat = araba.getFiyat();
            sarjSüresi = araba.getSarjSuresi();
            String deger = marka + "," + malzeme + "," + ebat + "," + fiyat + "," + kategori + "," + renk + "," + sarjSüresi;

            file.dosyadanSil("Araba.txt", deger);
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("Ürün başarıyla satın alınmıştır.İyi oyunlar.");
            a.show();
            urunleriListele();
        } catch (IOException ex) {
            Logger.getLogger(ArabaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
