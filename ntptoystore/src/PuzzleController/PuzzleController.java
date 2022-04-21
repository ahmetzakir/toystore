package PuzzleController;

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


public class PuzzleController implements ControllerInterFace {

    
    @FXML
    private ImageView backIcon;
    @FXML
    private TableView<OyuncakEntity> puzzleTable;
    @FXML
    private TableColumn<?, ?> puzzleResimColumn;
    @FXML
    private TableColumn<?, ?> puzzleMarkaColumn;
    @FXML
    private TableColumn<?, ?> puzzleEbatColumn;
    @FXML
    private TableColumn<?, ?> puzzleMalzemeColumn;
    @FXML
    private TableColumn<?, ?> puzzleParcaSayisiColumn;
    @FXML
    private TableColumn<?, ?> puzzleZorlukColumn;
    @FXML
    private TableColumn<?, ?> puzzleFiyatColumn;
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
            String marka, malzeme, zorluk;
            int ebat, fiyat, parcaSayisi;
            Puzzle puzzle;
            fileIO file = new fileIO();

            puzzle = (Puzzle) puzzleTable.getSelectionModel().getSelectedItem();
            marka = puzzle.getMarka();
            malzeme = puzzle.getMalzeme();
            parcaSayisi = puzzle.getParcaSayisi();
            ebat = puzzle.getEbat();
            fiyat = puzzle.getFiyat();
            zorluk = puzzle.getZorluk();
            String deger = marka + "," + ebat + "," + malzeme + "," + parcaSayisi + "," + zorluk + "," + fiyat;

            file.dosyadanSil("Puzzle.txt", deger);
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("Ürün başarıyla satın alınmıştır.İyi oyunlar.");
            a.show();
            urunleriListele();
        } catch (IOException ex) {
            Logger.getLogger(PuzzleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    @FXML
    public void urunleriListele() {
        fileIO file = new fileIO("Puzzle.txt");
        file.dosyaOku("Puzzle.txt", "Puzzle");

        puzzleResimColumn.setCellValueFactory(new PropertyValueFactory<>("resim"));
        puzzleMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
        puzzleEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
        puzzleMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
        puzzleParcaSayisiColumn.setCellValueFactory(new PropertyValueFactory<>("parcaSayisi"));
        puzzleZorlukColumn.setCellValueFactory(new PropertyValueFactory<>("zorluk"));
        puzzleFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
        
        puzzleTable.setItems(file.getPuzzle());
    }
    
}
