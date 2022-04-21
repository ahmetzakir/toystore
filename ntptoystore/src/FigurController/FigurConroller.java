package FigurController;

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


public class FigurConroller implements ControllerInterFace {
    
@FXML
    private ImageView backIcon;
    @FXML
    private TableView<OyuncakEntity> figurTable;
    @FXML
    private TableColumn<?, ?> figurResimColumn;
    @FXML
    private TableColumn<?, ?> figurMarkaColumn;
    @FXML
    private TableColumn<?, ?> figurEbatColumn;
    @FXML
    private TableColumn<?, ?> figurMalzemeColumn;
    @FXML
    private TableColumn<?, ?> figurFiyatColumn;
    @FXML
    private TableColumn<?, ?> figurCinsiyetColumn;
    @FXML
    private TableColumn<?, ?> figurGozRengiColumn;
    @FXML
    private TableColumn<?, ?> figurTurColumn;

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
    public void satisYap() {
        try {
            String marka, malzeme, gozRengi, tur, cinsiyet;
            int ebat, fiyat;
            Figür figür;
            fileIO file = new fileIO();

            figür = (Figür) figurTable.getSelectionModel().getSelectedItem();
            marka = figür.getMarka();
            cinsiyet = figür.getCinsiyet();
            gozRengi = figür.getGozRengi();
            ebat = figür.getEbat();
            malzeme = figür.getMalzeme();
            tur = figür.getTur();
            fiyat = figür.getFiyat();
            String deger = marka + "," + cinsiyet + "," + gozRengi + "," + ebat + "," + malzeme + "," + tur + "," + fiyat ;

            file.dosyadanSil("Figür.txt", deger);
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("Ürün başarıyla satın alınmıştır.İyi oyunlar.");
            a.show();
            urunleriListele();
        } catch (IOException ex) {
            Logger.getLogger(FigurConroller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void urunleriListele() {
        fileIO file = new fileIO("Figür.txt");
        file.dosyaOku("Figür.txt", "Oyuncak Figür");

        figurResimColumn.setCellValueFactory(new PropertyValueFactory<>("resim"));
        figurMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
        figurCinsiyetColumn.setCellValueFactory(new PropertyValueFactory<>("cinsiyet"));
        figurEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
        figurMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
        figurGozRengiColumn.setCellValueFactory(new PropertyValueFactory<>("gozRengi"));
        figurTurColumn.setCellValueFactory(new PropertyValueFactory<>("tur"));
        figurFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
        
        figurTable.setItems(file.getFigur());
    }
    
}
