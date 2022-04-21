package OyuncakHelikopterController;

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

public class HelikopterConroller implements ControllerInterFace {

    @FXML
    private ImageView backIcon;
    @FXML
    private TableView<OyuncakEntity> helikopterTable;
    @FXML
    private TableColumn<?, ?> helikopterResimColumn;
    @FXML
    private TableColumn<?, ?> helikopterMarkaColumn;
    @FXML
    private TableColumn<?, ?> helikopterSarjSuresiColumn;
    @FXML
    private TableColumn<?, ?> helikopterEbatColumn;
    @FXML
    private TableColumn<?, ?> helikopterMalzemeColumn;
    @FXML
    private TableColumn<?, ?> helikopterMenzilColumn;
    @FXML
    private TableColumn<?, ?> helikopterRenkColumn;
    @FXML
    private TableColumn<?, ?> helikopterFiyatColumn;

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
            String marka, malzeme, renk;
            int ebat, fiyat, menzil,sarjSuresi;
            Helikopter helikopter;
            fileIO file = new fileIO();

            helikopter = (Helikopter) helikopterTable.getSelectionModel().getSelectedItem();
            marka = helikopter.getMarka();
            sarjSuresi = helikopter.getSarjSuresi();
            ebat = helikopter.getEbat();
            malzeme = helikopter.getMalzeme();
            menzil = helikopter.getMenzil();
            renk = helikopter.getRenk();
            fiyat = helikopter.getFiyat();
            
            String deger = marka + "," + sarjSuresi + "," + ebat + "," + malzeme + "," + menzil + "," + renk + "," + fiyat;

            file.dosyadanSil("Oyuncak Helikopter.txt", deger);
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("Ürün başarıyla satın alınmıştır.İyi oyunlar.");
            a.show();
            urunleriListele();
        } catch (IOException ex) {
            Logger.getLogger(HelikopterConroller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void urunleriListele() {
    
        fileIO file = new fileIO("Oyuncak Helikopter.txt");
        file.dosyaOku("Oyuncak Helikopter.txt", "Oyuncak Helikopter");

        helikopterResimColumn.setCellValueFactory(new PropertyValueFactory<>("resim"));
        helikopterMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
        helikopterEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
        helikopterMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
        helikopterSarjSuresiColumn.setCellValueFactory(new PropertyValueFactory<>("sarjSuresi"));
        helikopterMenzilColumn.setCellValueFactory(new PropertyValueFactory<>("menzil"));
        helikopterFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
        helikopterRenkColumn.setCellValueFactory(new PropertyValueFactory<>("renk"));

        
        helikopterTable.setItems(file.getHeli());
    }
    

}
