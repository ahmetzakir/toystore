package Imalat;

import AnaOyuncak.OyuncakEntity;
import EğiticiOyuncaklarController.EgiticiOyuncak;
import FigurController.Figür;
import KutuOyunlarıController.KutuOyunları;
import Main.MagazaController;
import Main.Oyuncak;
import OyuncakArabaController.ArabaController;
import OyuncakArabaController.oyuncakAraba;
import OyuncakBebekController.oyuncakBebek;
import OyuncakEvController.OyuncakEv;
import OyuncakHelikopterController.Helikopter;
import OyuncakLegoController.Lego;
import OyuncakPelusController.Pelus;
import OyuncakSilahController.Silah;
import OyuncakTrenController.Tren;
import PuzzleController.Puzzle;
import dosyaIslemleri.fileIO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ImalatController implements Initializable {

    @FXML
    private ImageView backIcon;
    @FXML
    private ComboBox<String> kategoriComboBox;
    @FXML
    private TableView<OyuncakEntity> tableView;
    @FXML
    private TextField markaText;
    @FXML
    private TextField malzemeText;
    @FXML
    private TextField ebattext;
    @FXML
    private TextField fiyatText;

    fileIO file;
    ObservableList<String> liste = FXCollections.observableArrayList("Oyuncak Araba",
            "Egitici Oyuncak", "Oyuncak Figür", "Kutu Oyunları",
            "Oyuncak Bebek", "Oyuncak Ev", "Oyuncak Helikopter", "Oyuncak Lego",
            "Oyuncak Peluş", "Oyuncak Silah", "Oyuncak Tren", "Puzzle");

    private ObservableList<OyuncakEntity> araba = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> egitici = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> figur = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> ev = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> kutu = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> bebek = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> heli = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> lego = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> pelus = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> silah = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> tren = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> puzzle = FXCollections.observableArrayList();

    @FXML
    private TableView<OyuncakEntity> oyuncakArabaTable;
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
    private TextField arabaRenkText;
    @FXML
    private TextField arabaKategoriText;
    @FXML
    private TextField arabaSarjText;
    @FXML
    private TableView<OyuncakEntity> egiticiOyuncakTable;
    @FXML
    private TableColumn<?, ?> egiticiMarkaColumn;
    @FXML
    private TableColumn<?, ?> egiticiRenkColumn;
    @FXML
    private TableColumn<?, ?> egiticiEbatColumn;
    @FXML
    private TableColumn<?, ?> egiticiMalzemeColumn;
    @FXML
    private TableColumn<?, ?> egiticiParcaColumn;
    @FXML
    private TableColumn<?, ?> egiticiYasAraligiColumn;
    @FXML
    private TableColumn<?, ?> egiticiZorlukColumn;
    @FXML
    private TableColumn<?, ?> egiticiFiyatColumn;
    @FXML
    private TextField egiticiRenkText;
    @FXML
    private TextField egiticiParcaText;
    @FXML
    private TextField egiticiYasAraligiText;
    @FXML
    private TextField egiticiZorlukText;
    @FXML
    private TableView<OyuncakEntity> figurTable;
    @FXML
    private TableColumn<?, ?> figurMarkaColumn;
    @FXML
    private TableColumn<?, ?> figurCinsiyetColumn;
    @FXML
    private TableColumn<?, ?> figurGozRengiColumn;
    @FXML
    private TableColumn<?, ?> figurMalzemeColumn;
    @FXML
    private TableColumn<?, ?> figurTurColumn;
    @FXML
    private TableColumn<?, ?> figurFiyatColumn;
    @FXML
    private TextField figurCinsiyetText;
    @FXML
    private TextField figurGozRengiText;
    @FXML
    private TextField figurTurText;
    @FXML
    private TableColumn<?, ?> figurEbatColumn;
    @FXML
    private TableView<OyuncakEntity> bebekTable;
    @FXML
    private TableColumn<?, ?> bebekMarkaColumn;
    @FXML
    private TableColumn<?, ?> bebekEbatColumn;
    @FXML
    private TableColumn<?, ?> bebekCinsiyetColumn;
    @FXML
    private TableColumn<?, ?> bebekGozRengiColumn;
    @FXML
    private TableColumn<?, ?> bebekMalzemeColumn;
    @FXML
    private TableColumn<?, ?> bebekSacRengiColumn;
    @FXML
    private TableColumn<?, ?> bebekFiyatColumn;
    @FXML
    private TextField bebekCinsiyetText;
    @FXML
    private TextField bebekGozRengiText;
    @FXML
    private TextField bebekSacRengiText;
    @FXML
    private TableView<OyuncakEntity> evTable;
    @FXML
    private TableColumn<?, ?> evMarkaColumn;
    @FXML
    private TableColumn<?, ?> evEbatColumn;
    @FXML
    private TableColumn<?, ?> evOyuncuSayisiColumn;
    @FXML
    private TableColumn<?, ?> evParcaSayisiColumn;
    @FXML
    private TableColumn<?, ?> evMalzemeColumn;
    @FXML
    private TableColumn<?, ?> evRenkColumn;
    @FXML
    private TableColumn<?, ?> evFiyatColumn;
    @FXML
    private TextField evParcaSayisiText;
    @FXML
    private TextField evOyuncuSayisiText;
    @FXML
    private TextField evRenkText;
    @FXML
    private TableView<OyuncakEntity> helikopterTable;
    @FXML
    private TableColumn<?, ?> helikopterMarkaColumn;
    @FXML
    private TableColumn<?, ?> helikopterEbatColumn;
    @FXML
    private TableColumn<?, ?> helikopterMenzilColumn;
    @FXML
    private TableColumn<?, ?> helikopterSarjSuresiColumn;
    @FXML
    private TableColumn<?, ?> helikopterMalzemeColumn;
    @FXML
    private TableColumn<?, ?> helikopterRenkColumn;
    @FXML
    private TableColumn<?, ?> helikopterFiyatColumn;
    @FXML
    private TextField helikopterSarjSuresiText;
    @FXML
    private TextField helikopterMenzilText;
    @FXML
    private TextField helikopterRenkText;
    @FXML
    private TableView<OyuncakEntity> legoTable;
    @FXML
    private TableColumn<?, ?> legoMarkaColumn;
    @FXML
    private TableColumn<?, ?> legoEbatColumn;
    @FXML
    private TableColumn<?, ?> legoParcaSayisiColumn;
    @FXML
    private TableColumn<?, ?> legoZorlukColumn;
    @FXML
    private TableColumn<?, ?> legoMalzemeColumn;
    @FXML
    private TableColumn<?, ?> legoRenkColumn;
    @FXML
    private TableColumn<?, ?> legoFiyatColumn;
    @FXML
    private TextField legoParcaSayisiText;
    @FXML
    private TextField legoZorlukText;
    @FXML
    private TextField legoRenkText;
    @FXML
    private TableView<OyuncakEntity> pelusTable;
    @FXML
    private TableColumn<?, ?> pelusMarkaColumn;
    @FXML
    private TableColumn<?, ?> pelusEbatColumn;
    @FXML
    private TableColumn<?, ?> pelusTurColumn;
    @FXML
    private TableColumn<?, ?> pelusGozRengiColumn;
    @FXML
    private TableColumn<?, ?> pelusMalzemeColumn;
    @FXML
    private TableColumn<?, ?> pelusRenkColumn;
    @FXML
    private TableColumn<?, ?> pelusFiyatColumn;
    @FXML
    private TextField pelusGozRengiText;
    @FXML
    private TextField pelusTurText;
    @FXML
    private TextField pelusRenkText;
    @FXML
    private TableView<OyuncakEntity> silahTable;
    @FXML
    private TableColumn<?, ?> silahMarkaColumn;
    @FXML
    private TableColumn<?, ?> silahEbatColumn;
    @FXML
    private TableColumn<?, ?> silahCesitColumn;
    @FXML
    private TableColumn<?, ?> silahMenzilColumn;
    @FXML
    private TableColumn<?, ?> silahMalzemeColumn;
    @FXML
    private TableColumn<?, ?> silahRenkColumn;
    @FXML
    private TableColumn<?, ?> silahFiyatColumn;
    @FXML
    private TextField silahCesitText;
    @FXML
    private TextField silahMenzilText;
    @FXML
    private TextField silahRenkText;
    @FXML
    private TableView<OyuncakEntity> trenTable;
    @FXML
    private TableColumn<?, ?> trenMarkaColumn;
    @FXML
    private TableColumn<?, ?> trenEbatColumn;
    @FXML
    private TableColumn<?, ?> trenUzunlukColumn;
    @FXML
    private TableColumn<?, ?> trenMalzemeColumn;
    @FXML
    private TableColumn<?, ?> trenParcaSayisiColumn;
    @FXML
    private TableColumn<?, ?> trenFiyatColumn;
    @FXML
    private TextField trenUzunlukText;
    @FXML
    private TextField trenParcaSayisiText;
    @FXML
    private TableView<OyuncakEntity> puzzleTable;
    @FXML
    private TableColumn<?, ?> puzzleMarkaColumn;
    @FXML
    private TableColumn<?, ?> puzzleEbatColumn;
    @FXML
    private TableColumn<?, ?> puzzleZorlukColumn;
    @FXML
    private TableColumn<?, ?> puzzleMalzemeColumn;
    @FXML
    private TableColumn<?, ?> puzzleParcaSayisiColumn;
    @FXML
    private TableColumn<?, ?> puzzleFiyatColumn;
    @FXML
    private TextField puzzleZorlukText;
    @FXML
    private TextField puzzleParcaSayisiText;
    @FXML
    private TableView<OyuncakEntity> kutuTable;
    @FXML
    private TableColumn<?, ?> kutuMarkaColumn;
    @FXML
    private TableColumn<?, ?> kutuEbatColumn;
    @FXML
    private TableColumn<?, ?> kutuZorlukColumn;
    @FXML
    private TableColumn<?, ?> kutuMalzemeColumn;
    @FXML
    private TableColumn<?, ?> kutuOyuncuSayisiColumn;
    @FXML
    private TableColumn<?, ?> kutuFiyatColumn;
    @FXML
    private TextField kutuOyuncuSayisiText;
    @FXML
    private TextField kutuZorlukText;
    @FXML
    private TableColumn<?, ?> markaColumn;
    @FXML
    private TableColumn<?, ?> ebatColumn;
    @FXML
    private TableColumn<?, ?> malzemeColumn;
    @FXML
    private TableColumn<?, ?> fiyatColumn;
    @FXML
    private Button ekleButton;
    @FXML
    private Button silButton;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        kategoriComboBox.setItems(liste);

        kategoriComboBox.valueProperty().addListener((observable) -> {

            if (kategoriComboBox.getSelectionModel().getSelectedItem().equals("Oyuncak Araba")) {
                arabaKategoriText.setVisible(true);
                arabaRenkText.setVisible(true);
                arabaSarjText.setVisible(true);
                oyuncakArabaTable.setVisible(true);
                fileIO dosyaAc = new fileIO("Araba.txt");

                dosyaAc.dosyaOku("Araba.txt", "Oyuncak Araba");
                araba = dosyaAc.getAraba();

                arabaMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
                arabaRenkColumn.setCellValueFactory(new PropertyValueFactory<>("renk"));
                arabaEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
                arabaMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
                arabaKategoriColumn.setCellValueFactory(new PropertyValueFactory<>("kategori"));
                arabaSarjColumn.setCellValueFactory(new PropertyValueFactory<>("sarjSuresi"));
                arabaFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
                temizle();

                tableView.setVisible(false);
                kutuTable.setVisible(false);
                egiticiOyuncakTable.setVisible(false);
                figurTable.setVisible(false);
                bebekTable.setVisible(false);
                evTable.setVisible(false);
                helikopterTable.setVisible(false);
                legoTable.setVisible(false);
                pelusTable.setVisible(false);
                silahTable.setVisible(false);
                trenTable.setVisible(false);
                puzzleTable.setVisible(false);

                egiticiParcaText.setVisible(false);
                egiticiRenkText.setVisible(false);
                egiticiZorlukText.setVisible(false);
                egiticiYasAraligiText.setVisible(false);

                figurCinsiyetText.setVisible(false);
                figurGozRengiText.setVisible(false);
                figurTurText.setVisible(false);

                bebekCinsiyetText.setVisible(false);
                bebekGozRengiText.setVisible(false);
                bebekSacRengiText.setVisible(false);

                evParcaSayisiText.setVisible(false);
                evOyuncuSayisiText.setVisible(false);
                evRenkText.setVisible(false);

                helikopterSarjSuresiText.setVisible(false);
                helikopterMenzilText.setVisible(false);
                helikopterRenkText.setVisible(false);

                legoParcaSayisiText.setVisible(false);
                legoZorlukText.setVisible(false);
                legoRenkText.setVisible(false);

                pelusTurText.setVisible(false);
                pelusGozRengiText.setVisible(false);
                pelusRenkText.setVisible(false);

                silahCesitText.setVisible(false);
                silahMenzilText.setVisible(false);
                silahRenkText.setVisible(false);

                trenUzunlukText.setVisible(false);
                trenParcaSayisiText.setVisible(false);

                puzzleZorlukText.setVisible(false);
                puzzleParcaSayisiText.setVisible(false);

                kutuZorlukText.setVisible(false);
                kutuOyuncuSayisiText.setVisible(false);

                oyuncakArabaTable.setItems(araba);
            } else if (kategoriComboBox.getSelectionModel().getSelectedItem().equals("Egitici Oyuncak")) {
                egiticiParcaText.setVisible(true);
                egiticiRenkText.setVisible(true);
                egiticiYasAraligiText.setVisible(true);
                egiticiZorlukText.setVisible(true);
                egiticiOyuncakTable.setVisible(true);
                fileIO dosyaAc = new fileIO("Egitici Oyuncak.txt");
                dosyaAc.dosyaOku("Egitici Oyuncak.txt", "Egitici Oyuncak");
                egitici = dosyaAc.getEgitici();

                egiticiMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
                egiticiRenkColumn.setCellValueFactory(new PropertyValueFactory<>("renk"));
                egiticiEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
                egiticiMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
                egiticiParcaColumn.setCellValueFactory(new PropertyValueFactory<>("parcaSayisi"));
                egiticiYasAraligiColumn.setCellValueFactory(new PropertyValueFactory<>("yasAraligi"));
                egiticiZorlukColumn.setCellValueFactory(new PropertyValueFactory<>("zorluk"));
                egiticiFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
                temizle();

                tableView.setVisible(false);
                kutuTable.setVisible(false);
                oyuncakArabaTable.setVisible(false);
                figurTable.setVisible(false);
                bebekTable.setVisible(false);
                evTable.setVisible(false);
                helikopterTable.setVisible(false);
                legoTable.setVisible(false);
                pelusTable.setVisible(false);
                silahTable.setVisible(false);
                trenTable.setVisible(false);
                puzzleTable.setVisible(false);

                arabaKategoriText.setVisible(false);
                arabaRenkText.setVisible(false);
                arabaSarjText.setVisible(false);

                figurCinsiyetText.setVisible(false);
                figurGozRengiText.setVisible(false);
                figurTurText.setVisible(false);

                bebekCinsiyetText.setVisible(false);
                bebekGozRengiText.setVisible(false);
                bebekSacRengiText.setVisible(false);

                evParcaSayisiText.setVisible(false);
                evOyuncuSayisiText.setVisible(false);
                evRenkText.setVisible(false);

                helikopterSarjSuresiText.setVisible(false);
                helikopterMenzilText.setVisible(false);
                helikopterRenkText.setVisible(false);

                legoParcaSayisiText.setVisible(false);
                legoZorlukText.setVisible(false);
                legoRenkText.setVisible(false);

                pelusTurText.setVisible(false);
                pelusGozRengiText.setVisible(false);
                pelusRenkText.setVisible(false);

                silahCesitText.setVisible(false);
                silahMenzilText.setVisible(false);
                silahRenkText.setVisible(false);

                trenUzunlukText.setVisible(false);
                trenParcaSayisiText.setVisible(false);

                puzzleZorlukText.setVisible(false);
                puzzleParcaSayisiText.setVisible(false);

                kutuZorlukText.setVisible(false);
                kutuOyuncuSayisiText.setVisible(false);

                egiticiOyuncakTable.setItems(getList(egitici));
            } else if (kategoriComboBox.getSelectionModel().getSelectedItem().equals("Oyuncak Figür")) {
                figurCinsiyetText.setVisible(true);
                figurGozRengiText.setVisible(true);
                figurTurText.setVisible(true);
                figurTable.setVisible(true);

                fileIO dosyaAc = new fileIO("Figür.txt");
                dosyaAc.dosyaOku("Figür.txt", "Oyuncak Figür");
                figur = dosyaAc.getFigur();

                figurMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
                figurCinsiyetColumn.setCellValueFactory(new PropertyValueFactory<>("cinsiyet"));
                figurEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
                figurMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
                figurGozRengiColumn.setCellValueFactory(new PropertyValueFactory<>("gozRengi"));
                figurTurColumn.setCellValueFactory(new PropertyValueFactory<>("tur"));
                figurFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));

                temizle();

                tableView.setVisible(false);
                kutuTable.setVisible(false);
                oyuncakArabaTable.setVisible(false);
                egiticiOyuncakTable.setVisible(false);
                bebekTable.setVisible(false);
                evTable.setVisible(false);
                helikopterTable.setVisible(false);
                legoTable.setVisible(false);
                pelusTable.setVisible(false);
                silahTable.setVisible(false);
                trenTable.setVisible(false);
                puzzleTable.setVisible(false);

                arabaKategoriText.setVisible(false);
                arabaRenkText.setVisible(false);
                arabaSarjText.setVisible(false);

                egiticiParcaText.setVisible(false);
                egiticiRenkText.setVisible(false);
                egiticiZorlukText.setVisible(false);
                egiticiYasAraligiText.setVisible(false);

                bebekCinsiyetText.setVisible(false);
                bebekGozRengiText.setVisible(false);
                bebekSacRengiText.setVisible(false);

                evParcaSayisiText.setVisible(false);
                evOyuncuSayisiText.setVisible(false);
                evRenkText.setVisible(false);

                helikopterSarjSuresiText.setVisible(false);
                helikopterMenzilText.setVisible(false);
                helikopterRenkText.setVisible(false);

                legoParcaSayisiText.setVisible(false);
                legoZorlukText.setVisible(false);
                legoRenkText.setVisible(false);

                pelusTurText.setVisible(false);
                pelusGozRengiText.setVisible(false);
                pelusRenkText.setVisible(false);

                silahCesitText.setVisible(false);
                silahMenzilText.setVisible(false);
                silahRenkText.setVisible(false);

                trenUzunlukText.setVisible(false);
                trenParcaSayisiText.setVisible(false);

                puzzleZorlukText.setVisible(false);
                puzzleParcaSayisiText.setVisible(false);

                kutuZorlukText.setVisible(false);
                kutuOyuncuSayisiText.setVisible(false);

                figurTable.setItems(getList(figur));
            } else if (kategoriComboBox.getSelectionModel().getSelectedItem().equals("Oyuncak Bebek")) {
                bebekCinsiyetText.setVisible(true);
                bebekGozRengiText.setVisible(true);
                bebekSacRengiText.setVisible(true);
                bebekTable.setVisible(true);

                fileIO dosyaAc = new fileIO("Oyuncak Bebek.txt");

                dosyaAc.dosyaOku("Oyuncak Bebek.txt", "Oyuncak Bebek");
                bebek = dosyaAc.getBebek();

                bebekMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
                bebekEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
                bebekCinsiyetColumn.setCellValueFactory(new PropertyValueFactory<>("cinsiyet"));
                bebekGozRengiColumn.setCellValueFactory(new PropertyValueFactory<>("gozRengi"));
                bebekMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
                bebekSacRengiColumn.setCellValueFactory(new PropertyValueFactory<>("sacRengi"));
                bebekFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));

                temizle();

                tableView.setVisible(false);
                kutuTable.setVisible(false);
                oyuncakArabaTable.setVisible(false);
                egiticiOyuncakTable.setVisible(false);
                figurTable.setVisible(false);
                evTable.setVisible(false);
                helikopterTable.setVisible(false);
                legoTable.setVisible(false);
                pelusTable.setVisible(false);
                silahTable.setVisible(false);
                trenTable.setVisible(false);
                puzzleTable.setVisible(false);

                arabaKategoriText.setVisible(false);
                arabaRenkText.setVisible(false);
                arabaSarjText.setVisible(false);

                egiticiParcaText.setVisible(false);
                egiticiRenkText.setVisible(false);
                egiticiZorlukText.setVisible(false);
                egiticiYasAraligiText.setVisible(false);

                figurCinsiyetText.setVisible(false);
                figurGozRengiText.setVisible(false);
                figurTurText.setVisible(false);

                evParcaSayisiText.setVisible(false);
                evOyuncuSayisiText.setVisible(false);
                evRenkText.setVisible(false);

                helikopterSarjSuresiText.setVisible(false);
                helikopterMenzilText.setVisible(false);
                helikopterRenkText.setVisible(false);

                legoParcaSayisiText.setVisible(false);
                legoZorlukText.setVisible(false);
                legoRenkText.setVisible(false);

                pelusTurText.setVisible(false);
                pelusGozRengiText.setVisible(false);
                pelusRenkText.setVisible(false);

                silahCesitText.setVisible(false);
                silahMenzilText.setVisible(false);
                silahRenkText.setVisible(false);

                trenUzunlukText.setVisible(false);
                trenParcaSayisiText.setVisible(false);

                puzzleZorlukText.setVisible(false);
                puzzleParcaSayisiText.setVisible(false);

                kutuZorlukText.setVisible(false);
                kutuOyuncuSayisiText.setVisible(false);

                bebekTable.setItems(getList(bebek));
            } else if (kategoriComboBox.getSelectionModel().getSelectedItem().equals("Kutu Oyunları")) {
                kutuZorlukText.setVisible(true);
                kutuOyuncuSayisiText.setVisible(true);
                kutuTable.setVisible(true);

                fileIO dosyaAc = new fileIO("Kutu Oyunları.txt");

                dosyaAc.dosyaOku("Kutu Oyunları.txt", "Kutu Oyunları");
                kutu = dosyaAc.getKutu();

                kutuMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
                kutuZorlukColumn.setCellValueFactory(new PropertyValueFactory<>("zorluk"));
                kutuEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
                kutuMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
                kutuOyuncuSayisiColumn.setCellValueFactory(new PropertyValueFactory<>("oyuncuSayisi"));
                kutuFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));

                temizle();

                tableView.setVisible(false);
                bebekTable.setVisible(false);
                oyuncakArabaTable.setVisible(false);
                egiticiOyuncakTable.setVisible(false);
                figurTable.setVisible(false);
                evTable.setVisible(false);
                helikopterTable.setVisible(false);
                legoTable.setVisible(false);
                pelusTable.setVisible(false);
                silahTable.setVisible(false);
                trenTable.setVisible(false);
                puzzleTable.setVisible(false);

                arabaKategoriText.setVisible(false);
                arabaRenkText.setVisible(false);
                arabaSarjText.setVisible(false);

                bebekCinsiyetText.setVisible(false);
                bebekGozRengiText.setVisible(false);
                bebekSacRengiText.setVisible(false);

                egiticiParcaText.setVisible(false);
                egiticiRenkText.setVisible(false);
                egiticiZorlukText.setVisible(false);
                egiticiYasAraligiText.setVisible(false);

                figurCinsiyetText.setVisible(false);
                figurGozRengiText.setVisible(false);
                figurTurText.setVisible(false);

                evParcaSayisiText.setVisible(false);
                evOyuncuSayisiText.setVisible(false);
                evRenkText.setVisible(false);

                helikopterSarjSuresiText.setVisible(false);
                helikopterMenzilText.setVisible(false);
                helikopterRenkText.setVisible(false);

                legoParcaSayisiText.setVisible(false);
                legoZorlukText.setVisible(false);
                legoRenkText.setVisible(false);

                pelusTurText.setVisible(false);
                pelusGozRengiText.setVisible(false);
                pelusRenkText.setVisible(false);

                silahCesitText.setVisible(false);
                silahMenzilText.setVisible(false);
                silahRenkText.setVisible(false);

                trenUzunlukText.setVisible(false);
                trenParcaSayisiText.setVisible(false);

                puzzleZorlukText.setVisible(false);
                puzzleParcaSayisiText.setVisible(false);

                kutuTable.setItems(getList(kutu));

            } else if (kategoriComboBox.getSelectionModel().getSelectedItem().equals("Oyuncak Ev")) {

                evParcaSayisiText.setVisible(true);
                evOyuncuSayisiText.setVisible(true);
                evRenkText.setVisible(true);
                evTable.setVisible(true);

                fileIO dosyaAc = new fileIO("Oyuncak Ev.txt");
                dosyaAc.dosyaOku("Oyuncak Ev.txt", "Oyuncak Ev");
                ev = dosyaAc.getEv();

                evMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
                evParcaSayisiColumn.setCellValueFactory(new PropertyValueFactory<>("parcaSayisi"));
                evEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
                evMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
                evOyuncuSayisiColumn.setCellValueFactory(new PropertyValueFactory<>("oyuncuSayisi"));
                evRenkColumn.setCellValueFactory(new PropertyValueFactory<>("renk"));
                evFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));

                temizle();

                tableView.setVisible(false);
                kutuTable.setVisible(false);
                oyuncakArabaTable.setVisible(false);
                egiticiOyuncakTable.setVisible(false);
                figurTable.setVisible(false);
                bebekTable.setVisible(false);
                helikopterTable.setVisible(false);
                legoTable.setVisible(false);
                pelusTable.setVisible(false);
                silahTable.setVisible(false);
                trenTable.setVisible(false);
                puzzleTable.setVisible(false);

                arabaKategoriText.setVisible(false);
                arabaRenkText.setVisible(false);
                arabaSarjText.setVisible(false);

                egiticiParcaText.setVisible(false);
                egiticiRenkText.setVisible(false);
                egiticiZorlukText.setVisible(false);
                egiticiYasAraligiText.setVisible(false);

                figurCinsiyetText.setVisible(false);
                figurGozRengiText.setVisible(false);
                figurTurText.setVisible(false);

                bebekCinsiyetText.setVisible(false);
                bebekGozRengiText.setVisible(false);
                bebekSacRengiText.setVisible(false);

                helikopterSarjSuresiText.setVisible(false);
                helikopterMenzilText.setVisible(false);
                helikopterRenkText.setVisible(false);

                legoParcaSayisiText.setVisible(false);
                legoZorlukText.setVisible(false);
                legoRenkText.setVisible(false);

                pelusTurText.setVisible(false);
                pelusGozRengiText.setVisible(false);
                pelusRenkText.setVisible(false);

                silahCesitText.setVisible(false);
                silahMenzilText.setVisible(false);
                silahRenkText.setVisible(false);

                trenUzunlukText.setVisible(false);
                trenParcaSayisiText.setVisible(false);

                puzzleZorlukText.setVisible(false);
                puzzleParcaSayisiText.setVisible(false);

                kutuZorlukText.setVisible(false);
                kutuOyuncuSayisiText.setVisible(false);

                evTable.setItems(getList(ev));
            } else if (kategoriComboBox.getSelectionModel().getSelectedItem().equals("Oyuncak Helikopter")) {

                helikopterSarjSuresiText.setVisible(true);
                helikopterMenzilText.setVisible(true);
                helikopterRenkText.setVisible(true);
                helikopterTable.setVisible(true);

                fileIO dosyaAc = new fileIO("Oyuncak Helikopter.txt");

                dosyaAc.dosyaOku("Oyuncak Helikopter.txt", "Oyuncak Helikopter");
                heli = dosyaAc.getHeli();

                helikopterMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
                helikopterSarjSuresiColumn.setCellValueFactory(new PropertyValueFactory<>("sarjSuresi"));
                helikopterEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
                helikopterMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
                helikopterMenzilColumn.setCellValueFactory(new PropertyValueFactory<>("menzil"));
                helikopterRenkColumn.setCellValueFactory(new PropertyValueFactory<>("renk"));
                helikopterFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
                temizle();

                tableView.setVisible(false);
                kutuTable.setVisible(false);
                oyuncakArabaTable.setVisible(false);
                egiticiOyuncakTable.setVisible(false);
                figurTable.setVisible(false);
                bebekTable.setVisible(false);
                evTable.setVisible(false);
                legoTable.setVisible(false);
                pelusTable.setVisible(false);
                silahTable.setVisible(false);
                trenTable.setVisible(false);
                puzzleTable.setVisible(false);

                arabaKategoriText.setVisible(false);
                arabaRenkText.setVisible(false);
                arabaSarjText.setVisible(false);

                egiticiParcaText.setVisible(false);
                egiticiRenkText.setVisible(false);
                egiticiZorlukText.setVisible(false);
                egiticiYasAraligiText.setVisible(false);

                figurCinsiyetText.setVisible(false);
                figurGozRengiText.setVisible(false);
                figurTurText.setVisible(false);

                bebekCinsiyetText.setVisible(false);
                bebekGozRengiText.setVisible(false);
                bebekSacRengiText.setVisible(false);

                evParcaSayisiText.setVisible(false);
                evOyuncuSayisiText.setVisible(false);
                evRenkText.setVisible(false);

                legoParcaSayisiText.setVisible(false);
                legoZorlukText.setVisible(false);
                legoRenkText.setVisible(false);

                pelusTurText.setVisible(false);
                pelusGozRengiText.setVisible(false);
                pelusRenkText.setVisible(false);

                silahCesitText.setVisible(false);
                silahMenzilText.setVisible(false);
                silahRenkText.setVisible(false);

                trenUzunlukText.setVisible(false);
                trenParcaSayisiText.setVisible(false);

                puzzleZorlukText.setVisible(false);
                puzzleParcaSayisiText.setVisible(false);

                kutuZorlukText.setVisible(false);
                kutuOyuncuSayisiText.setVisible(false);

                helikopterTable.setItems(getList(heli));
            } else if (kategoriComboBox.getSelectionModel().getSelectedItem().equals("Oyuncak Lego")) {

                legoParcaSayisiText.setVisible(true);
                legoZorlukText.setVisible(true);
                legoRenkText.setVisible(true);
                legoTable.setVisible(true);

                fileIO dosyaAc = new fileIO("Oyuncak Lego.txt");

                dosyaAc.dosyaOku("Oyuncak Lego.txt", "Oyuncak Lego");
                lego = dosyaAc.getLego();

                legoMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
                legoParcaSayisiColumn.setCellValueFactory(new PropertyValueFactory<>("parcaSayisi"));
                legoEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
                legoMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
                legoZorlukColumn.setCellValueFactory(new PropertyValueFactory<>("zorluk"));
                legoRenkColumn.setCellValueFactory(new PropertyValueFactory<>("renk"));
                legoFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
                temizle();

                tableView.setVisible(false);
                kutuTable.setVisible(false);
                oyuncakArabaTable.setVisible(false);
                egiticiOyuncakTable.setVisible(false);
                figurTable.setVisible(false);
                helikopterTable.setVisible(false);
                bebekTable.setVisible(false);
                evTable.setVisible(false);
                pelusTable.setVisible(false);
                silahTable.setVisible(false);
                trenTable.setVisible(false);
                puzzleTable.setVisible(false);

                arabaKategoriText.setVisible(false);
                arabaRenkText.setVisible(false);
                arabaSarjText.setVisible(false);

                egiticiParcaText.setVisible(false);
                egiticiRenkText.setVisible(false);
                egiticiZorlukText.setVisible(false);
                egiticiYasAraligiText.setVisible(false);

                figurCinsiyetText.setVisible(false);
                figurGozRengiText.setVisible(false);
                figurTurText.setVisible(false);

                bebekCinsiyetText.setVisible(false);
                bebekGozRengiText.setVisible(false);
                bebekSacRengiText.setVisible(false);

                evParcaSayisiText.setVisible(false);
                evOyuncuSayisiText.setVisible(false);
                evRenkText.setVisible(false);

                helikopterSarjSuresiText.setVisible(false);
                helikopterMenzilText.setVisible(false);
                helikopterRenkText.setVisible(false);

                pelusTurText.setVisible(false);
                pelusGozRengiText.setVisible(false);
                pelusRenkText.setVisible(false);

                silahCesitText.setVisible(false);
                silahMenzilText.setVisible(false);
                silahRenkText.setVisible(false);

                trenUzunlukText.setVisible(false);
                trenParcaSayisiText.setVisible(false);

                puzzleZorlukText.setVisible(false);
                puzzleParcaSayisiText.setVisible(false);

                kutuZorlukText.setVisible(false);
                kutuOyuncuSayisiText.setVisible(false);

                legoTable.setItems(getList(lego));
            } else if (kategoriComboBox.getSelectionModel().getSelectedItem().equals("Oyuncak Peluş")) {

                pelusTurText.setVisible(true);
                pelusGozRengiText.setVisible(true);
                pelusRenkText.setVisible(true);
                pelusTable.setVisible(true);

                fileIO dosyaAc = new fileIO("Oyuncak Pelus.txt");

                dosyaAc.dosyaOku("Oyuncak Pelus.txt", "Oyuncak Pelus");
                pelus = dosyaAc.getPelus();

                pelusMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
                pelusGozRengiColumn.setCellValueFactory(new PropertyValueFactory<>("gozRengi"));
                pelusEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
                pelusMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
                pelusTurColumn.setCellValueFactory(new PropertyValueFactory<>("tur"));
                pelusRenkColumn.setCellValueFactory(new PropertyValueFactory<>("renk"));
                pelusFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));

                temizle();
                tableView.setVisible(false);
                kutuTable.setVisible(false);
                oyuncakArabaTable.setVisible(false);
                egiticiOyuncakTable.setVisible(false);
                figurTable.setVisible(false);
                helikopterTable.setVisible(false);
                bebekTable.setVisible(false);
                evTable.setVisible(false);
                legoTable.setVisible(false);
                silahTable.setVisible(false);
                trenTable.setVisible(false);
                puzzleTable.setVisible(false);

                arabaKategoriText.setVisible(false);
                arabaRenkText.setVisible(false);
                arabaSarjText.setVisible(false);

                egiticiParcaText.setVisible(false);
                egiticiRenkText.setVisible(false);
                egiticiZorlukText.setVisible(false);
                egiticiYasAraligiText.setVisible(false);

                figurCinsiyetText.setVisible(false);
                figurGozRengiText.setVisible(false);
                figurTurText.setVisible(false);

                bebekCinsiyetText.setVisible(false);
                bebekGozRengiText.setVisible(false);
                bebekSacRengiText.setVisible(false);

                evParcaSayisiText.setVisible(false);
                evOyuncuSayisiText.setVisible(false);
                evRenkText.setVisible(false);

                helikopterSarjSuresiText.setVisible(false);
                helikopterMenzilText.setVisible(false);
                helikopterRenkText.setVisible(false);

                legoParcaSayisiText.setVisible(false);
                legoZorlukText.setVisible(false);
                legoRenkText.setVisible(false);

                silahCesitText.setVisible(false);
                silahMenzilText.setVisible(false);
                silahRenkText.setVisible(false);

                trenUzunlukText.setVisible(false);
                trenParcaSayisiText.setVisible(false);

                puzzleZorlukText.setVisible(false);
                puzzleParcaSayisiText.setVisible(false);

                kutuZorlukText.setVisible(false);
                kutuOyuncuSayisiText.setVisible(false);

                pelusTable.setItems(getList(pelus));
            } else if (kategoriComboBox.getSelectionModel().getSelectedItem().equals("Oyuncak Silah")) {

                silahCesitText.setVisible(true);
                silahMenzilText.setVisible(true);
                silahRenkText.setVisible(true);
                silahTable.setVisible(true);

                fileIO dosyaAc = new fileIO("Oyuncak Silah.txt");

                dosyaAc.dosyaOku("Oyuncak Silah.txt", "Oyuncak Silah");
                silah = dosyaAc.getSilah();

                silahMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
                silahCesitColumn.setCellValueFactory(new PropertyValueFactory<>("cesit"));
                silahEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
                silahMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
                silahMenzilColumn.setCellValueFactory(new PropertyValueFactory<>("menzil"));
                silahRenkColumn.setCellValueFactory(new PropertyValueFactory<>("renk"));
                silahFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));

                temizle();

                tableView.setVisible(false);
                kutuTable.setVisible(false);
                oyuncakArabaTable.setVisible(false);
                egiticiOyuncakTable.setVisible(false);
                figurTable.setVisible(false);
                helikopterTable.setVisible(false);
                bebekTable.setVisible(false);
                evTable.setVisible(false);
                legoTable.setVisible(false);
                pelusTable.setVisible(false);
                trenTable.setVisible(false);
                puzzleTable.setVisible(false);

                arabaKategoriText.setVisible(false);
                arabaRenkText.setVisible(false);
                arabaSarjText.setVisible(false);

                egiticiParcaText.setVisible(false);
                egiticiRenkText.setVisible(false);
                egiticiZorlukText.setVisible(false);
                egiticiYasAraligiText.setVisible(false);

                figurCinsiyetText.setVisible(false);
                figurGozRengiText.setVisible(false);
                figurTurText.setVisible(false);

                bebekCinsiyetText.setVisible(false);
                bebekGozRengiText.setVisible(false);
                bebekSacRengiText.setVisible(false);

                evParcaSayisiText.setVisible(false);
                evOyuncuSayisiText.setVisible(false);
                evRenkText.setVisible(false);

                helikopterSarjSuresiText.setVisible(false);
                helikopterMenzilText.setVisible(false);
                helikopterRenkText.setVisible(false);

                legoParcaSayisiText.setVisible(false);
                legoZorlukText.setVisible(false);
                legoRenkText.setVisible(false);

                pelusTurText.setVisible(false);
                pelusGozRengiText.setVisible(false);
                pelusRenkText.setVisible(false);

                trenUzunlukText.setVisible(false);
                trenParcaSayisiText.setVisible(false);

                puzzleZorlukText.setVisible(false);
                puzzleParcaSayisiText.setVisible(false);

                kutuZorlukText.setVisible(false);
                kutuOyuncuSayisiText.setVisible(false);

                silahTable.setItems(getList(silah));
            } else if (kategoriComboBox.getSelectionModel().getSelectedItem().equals("Oyuncak Tren")) {

                trenUzunlukText.setVisible(true);
                trenParcaSayisiText.setVisible(true);
                trenTable.setVisible(true);

                fileIO dosyaAc = new fileIO("Oyuncak Tren.txt");

                dosyaAc.dosyaOku("Oyuncak Tren.txt", "Oyuncak Tren");
                tren = dosyaAc.getTren();

                trenMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
                trenEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
                trenMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
                trenParcaSayisiColumn.setCellValueFactory(new PropertyValueFactory<>("parcaSayisi"));
                trenUzunlukColumn.setCellValueFactory(new PropertyValueFactory<>("uzunluk"));
                trenFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));

                temizle();

                tableView.setVisible(false);
                kutuTable.setVisible(false);
                oyuncakArabaTable.setVisible(false);
                egiticiOyuncakTable.setVisible(false);
                figurTable.setVisible(false);
                bebekTable.setVisible(false);
                helikopterTable.setVisible(false);
                evTable.setVisible(false);
                legoTable.setVisible(false);
                pelusTable.setVisible(false);
                silahTable.setVisible(false);
                puzzleTable.setVisible(false);

                arabaKategoriText.setVisible(false);
                arabaRenkText.setVisible(false);
                arabaSarjText.setVisible(false);

                egiticiParcaText.setVisible(false);
                egiticiRenkText.setVisible(false);
                egiticiZorlukText.setVisible(false);
                egiticiYasAraligiText.setVisible(false);

                figurCinsiyetText.setVisible(false);
                figurGozRengiText.setVisible(false);
                figurTurText.setVisible(false);

                bebekCinsiyetText.setVisible(false);
                bebekGozRengiText.setVisible(false);
                bebekSacRengiText.setVisible(false);

                evParcaSayisiText.setVisible(false);
                evOyuncuSayisiText.setVisible(false);
                evRenkText.setVisible(false);

                helikopterSarjSuresiText.setVisible(false);
                helikopterMenzilText.setVisible(false);
                helikopterRenkText.setVisible(false);

                legoParcaSayisiText.setVisible(false);
                legoZorlukText.setVisible(false);
                legoRenkText.setVisible(false);

                pelusTurText.setVisible(false);
                pelusGozRengiText.setVisible(false);
                pelusRenkText.setVisible(false);

                silahCesitText.setVisible(false);
                silahMenzilText.setVisible(false);
                silahRenkText.setVisible(false);

                puzzleZorlukText.setVisible(false);
                puzzleParcaSayisiText.setVisible(false);

                kutuZorlukText.setVisible(false);
                kutuOyuncuSayisiText.setVisible(false);

                trenTable.setItems(getList(tren));
            } else if (kategoriComboBox.getSelectionModel().getSelectedItem().equals("Puzzle")) {

                puzzleZorlukText.setVisible(true);
                puzzleParcaSayisiText.setVisible(true);
                puzzleTable.setVisible(true);

                fileIO dosyaAc = new fileIO("Puzzle.txt");

                dosyaAc.dosyaOku("Puzzle.txt", "Puzzle");
                puzzle = dosyaAc.getPuzzle();

                puzzleMarkaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
                puzzleEbatColumn.setCellValueFactory(new PropertyValueFactory<>("ebat"));
                puzzleMalzemeColumn.setCellValueFactory(new PropertyValueFactory<>("malzeme"));
                puzzleParcaSayisiColumn.setCellValueFactory(new PropertyValueFactory<>("parcaSayisi"));
                puzzleZorlukColumn.setCellValueFactory(new PropertyValueFactory<>("zorluk"));
                puzzleFiyatColumn.setCellValueFactory(new PropertyValueFactory<>("fiyat"));

                temizle();

                tableView.setVisible(false);
                kutuTable.setVisible(false);
                oyuncakArabaTable.setVisible(false);
                egiticiOyuncakTable.setVisible(false);
                figurTable.setVisible(false);
                bebekTable.setVisible(false);
                helikopterTable.setVisible(false);
                evTable.setVisible(false);
                legoTable.setVisible(false);
                pelusTable.setVisible(false);
                silahTable.setVisible(false);
                trenTable.setVisible(false);

                arabaKategoriText.setVisible(false);
                arabaRenkText.setVisible(false);
                arabaSarjText.setVisible(false);

                egiticiParcaText.setVisible(false);
                egiticiRenkText.setVisible(false);
                egiticiZorlukText.setVisible(false);
                egiticiYasAraligiText.setVisible(false);

                figurCinsiyetText.setVisible(false);
                figurGozRengiText.setVisible(false);
                figurTurText.setVisible(false);

                bebekCinsiyetText.setVisible(false);
                bebekGozRengiText.setVisible(false);
                bebekSacRengiText.setVisible(false);

                evParcaSayisiText.setVisible(false);
                evOyuncuSayisiText.setVisible(false);
                evRenkText.setVisible(false);

                helikopterSarjSuresiText.setVisible(false);
                helikopterMenzilText.setVisible(false);
                helikopterRenkText.setVisible(false);

                legoParcaSayisiText.setVisible(false);
                legoZorlukText.setVisible(false);
                legoRenkText.setVisible(false);

                pelusTurText.setVisible(false);
                pelusGozRengiText.setVisible(false);
                pelusRenkText.setVisible(false);

                silahCesitText.setVisible(false);
                silahMenzilText.setVisible(false);
                silahRenkText.setVisible(false);

                trenUzunlukText.setVisible(false);
                trenParcaSayisiText.setVisible(false);

                kutuZorlukText.setVisible(false);
                kutuOyuncuSayisiText.setVisible(false);

                puzzleTable.setItems(getList(puzzle));
            }
        });
    }

    private void temizle() {
        markaText.setText("");
        malzemeText.setText("");
        ebattext.setText("");
        fiyatText.setText("");
    }

    @FXML
    private void previous(MouseEvent event) {
        if (event.getSource() == backIcon) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/Menu/Menu.fxml"));
                Scene scene = new Scene(root);
                Oyuncak.mystage.setScene(scene);
                Oyuncak.mystage.show();
            } catch (IOException ex) {
                Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void createOyuncak(ActionEvent event) {
        switch (kategoriComboBox.getSelectionModel().getSelectedItem()) {
            case "Oyuncak Araba": {
                String marka = markaText.getText();
                String malzeme = malzemeText.getText();
                int ebat = Integer.parseInt(ebattext.getText());
                int fiyat = Integer.parseInt(fiyatText.getText());

                String renk = arabaRenkText.getText();
                int sarjSuresi = Integer.parseInt(arabaSarjText.getText());
                String kategori = arabaKategoriText.getText();

                oyuncakAraba o = new oyuncakAraba();
                o.setEbat(ebat);
                o.setMalzeme(malzeme);
                o.setFiyat(fiyat);
                o.setMarka(marka);
                o.setRenk(renk);
                o.setSarjSuresi(sarjSuresi);
                o.setKategori(kategori);

                fileIO f = new fileIO("Araba.txt");
                f.dosyaYaz(o, "Araba");

                createWithInstance(o);

                temizle();
                arabaRenkText.setText("");
                arabaSarjText.setText("");
                arabaKategoriText.setText("");
                break;
            }
            case "Egitici Oyuncak": {
                String marka = markaText.getText();
                String malzeme = malzemeText.getText();
                int ebat = Integer.parseInt(ebattext.getText());
                int fiyat = Integer.parseInt(fiyatText.getText());
                String renk = egiticiRenkText.getText();
                String yasAraligi = egiticiYasAraligiText.getText();
                int parcaSayisi = Integer.parseInt(egiticiParcaText.getText());
                String zorluk = egiticiZorlukText.getText();

                EgiticiOyuncak o = new EgiticiOyuncak();
                o.setMarka(marka);
                o.setEbat(ebat);
                o.setMalzeme(malzeme);
                o.setFiyat(fiyat);
                o.setRenk(renk);
                o.setYasAraligi(yasAraligi);
                o.setParcaSayisi(parcaSayisi);
                o.setZorluk(zorluk);

                fileIO f = new fileIO("Egitici Oyuncak.txt");
                f.dosyaYaz(o, "Eğitici Oyuncak");

                createWithInstance(o);

                temizle();
                egiticiParcaText.setText("");
                egiticiRenkText.setText("");
                egiticiYasAraligiText.setText("");
                egiticiZorlukText.setText("");

                break;
            }
            case "Oyuncak Bebek": {
                String marka = markaText.getText();
                String malzeme = malzemeText.getText();
                int ebat = Integer.parseInt(ebattext.getText());
                int fiyat = Integer.parseInt(fiyatText.getText());
                String cinsiyet = bebekCinsiyetText.getText();
                String gozRengi = bebekGozRengiText.getText();
                String sacRengi = bebekSacRengiText.getText();

                oyuncakBebek o = new oyuncakBebek();
                o.setMarka(marka);
                o.setEbat(ebat);
                o.setCinsiyet(cinsiyet);
                o.setGozRengi(gozRengi);
                o.setMalzeme(malzeme);
                o.setSacRengi(sacRengi);
                o.setFiyat(fiyat);

                fileIO f = new fileIO("Oyuncak Bebek.txt");
                f.dosyaYaz(o, "Oyuncak Bebek");

                createWithInstance(o);

                temizle();
                bebekCinsiyetText.setText("");
                bebekGozRengiText.setText("");
                bebekSacRengiText.setText("");

                break;
            }
            case "Oyuncak Figür": {
                String marka = markaText.getText();
                String malzeme = malzemeText.getText();
                String tur = figurTurText.getText();
                int ebat = Integer.parseInt(ebattext.getText());
                int fiyat = Integer.parseInt(fiyatText.getText());
                String cinsiyet = figurCinsiyetText.getText();
                String gozRengi = figurGozRengiText.getText();

                Figür o = new Figür();
                o.setEbat(ebat);
                o.setMarka(marka);
                o.setMalzeme(malzeme);
                o.setFiyat(fiyat);
                o.setTur(tur);
                o.setGozRengi(gozRengi);
                o.setCinsiyet(cinsiyet);

                fileIO f = new fileIO("Figür.txt");
                f.dosyaYaz(o, "Figür");

                createWithInstance(o);

                temizle();
                figurCinsiyetText.setText("");
                figurGozRengiText.setText("");
                figurTurText.setText("");

                break;
            }
            case "Kutu Oyunları": {
                String marka = markaText.getText();
                String malzeme = malzemeText.getText();
                int ebat = Integer.parseInt(ebattext.getText());
                int fiyat = Integer.parseInt(fiyatText.getText());
                String zorluk = kutuZorlukText.getText();
                int oyuncuSayisi = Integer.parseInt(kutuOyuncuSayisiText.getText());
                KutuOyunları o = new KutuOyunları();

                o.setMarka(marka);
                o.setZorluk(zorluk);
                o.setOyuncuSayisi(oyuncuSayisi);
                o.setEbat(ebat);
                o.setMalzeme(malzeme);
                o.setFiyat(fiyat);

                fileIO f = new fileIO("Kutu Oyunları.txt");
                f.dosyaYaz(o, "Kutu Oyunları");

                createWithInstance(o);

                temizle();
                kutuZorlukText.setText("");
                kutuOyuncuSayisiText.setText("");

                break;
            }
            case "Oyuncak Ev": {
                String marka = markaText.getText();
                String malzeme = malzemeText.getText();
                int ebat = Integer.parseInt(ebattext.getText());
                int fiyat = Integer.parseInt(fiyatText.getText());
                int parcaSayisi = Integer.parseInt(evParcaSayisiText.getText());
                int oyuncuSayisi = Integer.parseInt(evOyuncuSayisiText.getText());
                String renk = evRenkText.getText();

                OyuncakEv o = new OyuncakEv();

                o.setEbat(ebat);
                o.setMalzeme(malzeme);
                o.setFiyat(fiyat);
                o.setMarka(marka);
                o.setOyuncuSayisi(oyuncuSayisi);
                o.setRenk(renk);
                o.setParcaSayisi(parcaSayisi);

                fileIO f = new fileIO("Oyuncak Ev.txt");
                f.dosyaYaz(o, "Oyuncak Ev");

                createWithInstance(o);

                temizle();
                evParcaSayisiText.setText("");
                evOyuncuSayisiText.setText("");
                evRenkText.setText("");

                break;
            }
            case "Oyuncak Helikopter": {
                String marka = markaText.getText();
                String malzeme = malzemeText.getText();
                int ebat = Integer.parseInt(ebattext.getText());
                int fiyat = Integer.parseInt(fiyatText.getText());
                int menzil = Integer.parseInt(helikopterMenzilText.getText());
                int sarjSuresi = Integer.parseInt(helikopterSarjSuresiText.getText());
                String renk = helikopterRenkText.getText();

                Helikopter o = new Helikopter();
                o.setMarka(marka);
                o.setEbat(ebat);
                o.setMalzeme(malzeme);
                o.setFiyat(fiyat);
                o.setSarjSuresi(sarjSuresi);
                o.setMenzil(menzil);
                o.setRenk(renk);

                fileIO f = new fileIO("Oyuncak Helikopter.txt");
                f.dosyaYaz(o, "Oyuncak Helikopter");

                createWithInstance(o);

                temizle();
                helikopterSarjSuresiText.setText("");
                helikopterMenzilText.setText("");
                helikopterRenkText.setText("");

                break;
            }
            case "Oyuncak Lego": {
                String marka = markaText.getText();
                String malzeme = malzemeText.getText();
                int ebat = Integer.parseInt(ebattext.getText());
                int fiyat = Integer.parseInt(fiyatText.getText());
                int parcaSayisi = Integer.parseInt(legoParcaSayisiText.getText());
                String renk = legoRenkText.getText();
                String zorluk = legoZorlukText.getText();

                Lego o = new Lego();

                o.setMarka(marka);
                o.setEbat(ebat);
                o.setMalzeme(malzeme);
                o.setFiyat(fiyat);
                o.setParcaSayisi(parcaSayisi);
                o.setRenk(renk);
                o.setZorluk(zorluk);

                fileIO f = new fileIO("Oyuncak Lego.txt");
                f.dosyaYaz(o, "Oyuncak Lego");

                createWithInstance(o);

                temizle();
                legoParcaSayisiText.setText("");
                legoZorlukText.setText("");
                legoRenkText.setText("");

                break;
            }
            case "Oyuncak Peluş": {
                String marka = markaText.getText();
                String malzeme = malzemeText.getText();
                String tur = pelusTurText.getText();
                int ebat = Integer.parseInt(ebattext.getText());
                int fiyat = Integer.parseInt(fiyatText.getText());
                String renk = pelusRenkText.getText();
                String gozRengi = pelusGozRengiText.getText();

                Pelus o = new Pelus();
                o.setMarka(marka);
                o.setRenk(renk);
                o.setGozRengi(gozRengi);
                o.setEbat(ebat);
                o.setMalzeme(malzeme);
                o.setFiyat(fiyat);
                o.setTur(tur);

                fileIO f = new fileIO("Oyuncak Pelus.txt");
                f.dosyaYaz(o, "Oyuncak Pelus");

                createWithInstance(o);

                temizle();
                pelusGozRengiText.setText("");
                pelusTurText.setText("");
                pelusRenkText.setText("");

                break;
            }
            case "Oyuncak Silah": {
                String marka = markaText.getText();
                String malzeme = malzemeText.getText();
                String cesit = silahCesitText.getText();
                int ebat = Integer.parseInt(ebattext.getText());
                int fiyat = Integer.parseInt(fiyatText.getText());
                int menzil = Integer.parseInt(silahMenzilText.getText());
                String renk = silahRenkText.getText();
                Silah o = new Silah();
                o.setMarka(marka);
                o.setEbat(ebat);
                o.setMalzeme(malzeme);
                o.setFiyat(fiyat);
                o.setMenzil(menzil);
                o.setCesit(cesit);
                o.setRenk(renk);

                fileIO f = new fileIO("Oyuncak Silah.txt");
                f.dosyaYaz(o, "Oyuncak Silah");

                createWithInstance(o);

                temizle();
                silahCesitText.setText("");
                silahRenkText.setText("");
                silahMenzilText.setText("");

                break;
            }
            case "Oyuncak Tren": {
                String marka = markaText.getText();
                String malzeme = malzemeText.getText();
                int ebat = Integer.parseInt(ebattext.getText());
                int fiyat = Integer.parseInt(fiyatText.getText());
                int uzunluk = Integer.parseInt(trenUzunlukText.getText());
                int parcaSayisi = Integer.parseInt(trenParcaSayisiText.getText());

                Tren o = new Tren();
                o.setMarka(marka);
                o.setUzunluk(uzunluk);
                o.setParcaSayisi(parcaSayisi);
                o.setEbat(ebat);
                o.setMalzeme(malzeme);
                o.setFiyat(fiyat);

                fileIO f = new fileIO("Oyuncak Tren.txt");
                f.dosyaYaz(o, "Oyuncak Tren");

                createWithInstance(o);

                temizle();
                trenUzunlukText.setText("");
                trenParcaSayisiText.setText("");

                break;
            }
            case "Puzzle": {
                String marka = markaText.getText();
                String malzeme = malzemeText.getText();
                int ebat = Integer.parseInt(ebattext.getText());
                int fiyat = Integer.parseInt(fiyatText.getText());
                String zorluk = puzzleZorlukText.getText();
                int parcaSayisi = Integer.parseInt(puzzleParcaSayisiText.getText());

                Puzzle o = new Puzzle();
                o.setMarka(marka);
                o.setZorluk(zorluk);
                o.setParcaSayisi(parcaSayisi);
                o.setEbat(ebat);
                o.setMalzeme(malzeme);
                o.setFiyat(fiyat);

                fileIO f = new fileIO("Puzzle.txt");
                f.dosyaYaz(o, "Puzzle");

                createWithInstance(o);

                temizle();
                puzzleZorlukText.setText("");
                puzzleParcaSayisiText.setText("");

                break;
            }
            default:
                break;
        }

    }

    @FXML
    private void deleteOyuncak(ActionEvent event) {
        switch (kategoriComboBox.getSelectionModel().getSelectedItem()) {
            case "Oyuncak Araba": {
                try {
                    String marka, malzeme, kategori, renk;
                    int ebat, fiyat, sarjSüresi;
                    oyuncakAraba araba;
                    fileIO file = new fileIO("Araba.txt");

                    araba = (oyuncakAraba) oyuncakArabaTable.getSelectionModel().getSelectedItem();//Şu her değerin tek tek alınmasında overload rahatlıkla yapılır
                    marka = araba.getMarka();
                    malzeme = araba.getMalzeme();
                    kategori = araba.getKategori();
                    renk = araba.getRenk();
                    ebat = araba.getEbat();
                    fiyat = araba.getFiyat();
                    sarjSüresi = araba.getSarjSuresi();
                    String deger = marka + "," + malzeme + "," + ebat + "," + fiyat + "," + kategori + "," + renk + "," + sarjSüresi;

                    file.dosyadanSil("Araba.txt", deger);
                    file.dosyaOku("Araba.txt", "Oyuncak Araba");

                    oyuncakArabaTable.setItems(file.getAraba());

                } catch (IOException ex) {
                    Logger.getLogger(ArabaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "Egitici Oyuncak": {
                try {
                    String marka, malzeme, yasAraligi, renk, zorluk;
                    int ebat, fiyat, parcaSayisi;
                    EgiticiOyuncak egitici;
                    fileIO file = new fileIO("Egitici Oyuncak.txt");

                    egitici = (EgiticiOyuncak) egiticiOyuncakTable.getSelectionModel().getSelectedItem();
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
                    file.dosyaOku("Egitici Oyuncak.txt", "Egitici Oyuncak");

                    egiticiOyuncakTable.setItems(file.getEgitici());

                } catch (IOException ex) {
                    Logger.getLogger(ArabaController.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            }
            case "Oyuncak Bebek": {
                try {
                    String marka, malzeme, cinsiyet, gozRengi, sacRengi;
                    int ebat, fiyat;
                    oyuncakBebek bebek;
                    fileIO file = new fileIO("Oyuncak Bebek.txt");

                    bebek = (oyuncakBebek) bebekTable.getSelectionModel().getSelectedItem();
                    marka = bebek.getMarka();
                    malzeme = bebek.getMalzeme();
                    cinsiyet = bebek.getCinsiyet();
                    gozRengi = bebek.getGozRengi();
                    ebat = bebek.getEbat();
                    fiyat = bebek.getFiyat();
                    sacRengi = bebek.getSacRengi();

                    String deger = marka + "," + ebat + "," + cinsiyet + "," + gozRengi + "," + malzeme + "," + sacRengi + "," + fiyat;

                    file.dosyadanSil("Oyuncak Bebek.txt", deger);
                    file.dosyaOku("Oyuncak Bebek.txt", "Oyuncak Bebek");

                    bebekTable.setItems(file.getBebek());

                } catch (IOException ex) {
                    Logger.getLogger(ArabaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "Oyuncak Figür": {
                try {
                    String marka, malzeme, cinsiyet, gozRengi, tur;
                    int ebat, fiyat;
                    Figür f;
                    fileIO file = new fileIO("Figür.txt");

                    f = (Figür) figurTable.getSelectionModel().getSelectedItem();
                    marka = f.getMarka();
                    malzeme = f.getMalzeme();
                    cinsiyet = f.getCinsiyet();
                    gozRengi = f.getGozRengi();
                    ebat = f.getEbat();
                    fiyat = f.getFiyat();
                    tur = f.getTur();
                    String deger = marka + "," + cinsiyet + "," + gozRengi + "," + ebat + "," + malzeme + "," + tur + "," + fiyat;

                    file.dosyadanSil("Figür.txt", deger);
                    file.dosyaOku("Figür.txt", "Oyuncak Figür");

                    figurTable.setItems(file.getFigur());

                } catch (IOException ex) {
                    Logger.getLogger(ArabaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "Kutu Oyunları": {
                try {
                    String marka, malzeme, zorluk;
                    int ebat, fiyat, oyuncuSayisi;
                    KutuOyunları kutuOyun;
                    fileIO file = new fileIO("Kutu Oyunları.txt");

                    kutuOyun = (KutuOyunları) kutuTable.getSelectionModel().getSelectedItem();
                    marka = kutuOyun.getMarka();
                    malzeme = kutuOyun.getMalzeme();
                    oyuncuSayisi = kutuOyun.getOyuncuSayisi();
                    ebat = kutuOyun.getEbat();
                    fiyat = kutuOyun.getFiyat();
                    zorluk = kutuOyun.getZorluk();
                    String deger = marka + "," + zorluk + "," + ebat + "," + malzeme + "," + oyuncuSayisi + "," + fiyat;

                    file.dosyadanSil("Kutu Oyunları.txt", deger);
                    file.dosyaOku("Kutu Oyunları.txt", "Kutu Oyunları");

                    kutuTable.setItems(file.getKutu());

                } catch (IOException ex) {
                    Logger.getLogger(ArabaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "Oyuncak Ev": {
                try {
                    String marka, malzeme, renk;
                    int ebat, fiyat, oyuncuSayisi, parcaSayisi;
                    OyuncakEv ev;
                    fileIO file = new fileIO("Oyuncak Ev.txt");

                    ev = (OyuncakEv) evTable.getSelectionModel().getSelectedItem();
                    marka = ev.getMarka();
                    malzeme = ev.getMalzeme();
                    oyuncuSayisi = ev.getOyuncuSayisi();
                    parcaSayisi = ev.getParcaSayisi();
                    ebat = ev.getEbat();
                    fiyat = ev.getFiyat();
                    renk = ev.getRenk();
                    String deger = marka + "," + ebat + "," + oyuncuSayisi + "," + parcaSayisi + "," + malzeme + "," + renk + "," + fiyat;

                    file.dosyadanSil("Oyuncak Ev.txt", deger);
                    file.dosyaOku("Oyuncak Ev.txt", "Oyuncak Ev");

                    evTable.setItems(file.getEv());

                } catch (IOException ex) {
                    Logger.getLogger(ArabaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "Oyuncak Helikopter": {
                try {
                    String marka, malzeme, renk;
                    int ebat, fiyat, boyut, menzil, sarjSüresi;
                    Helikopter helikopter;
                    fileIO file = new fileIO("Oyuncak Helikopter.txt");

                    helikopter = (Helikopter) helikopterTable.getSelectionModel().getSelectedItem();
                    marka = helikopter.getMarka();
                    malzeme = helikopter.getMalzeme();
                    renk = helikopter.getRenk();
                    boyut = helikopter.getBoyut();
                    ebat = helikopter.getEbat();
                    fiyat = helikopter.getFiyat();
                    menzil = helikopter.getMenzil();
                    sarjSüresi = helikopter.getSarjSuresi();
                    String deger = marka + "," + sarjSüresi + "," + ebat + "," + malzeme + "," + menzil + "," + renk + "," + fiyat;

                    file.dosyadanSil("Oyuncak Helikopter.txt", deger);
                    file.dosyaOku("Oyuncak Helikopter.txt", "Oyuncak Helikopter");

                    helikopterTable.setItems(file.getHeli());

                } catch (IOException ex) {
                    Logger.getLogger(ArabaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "Oyuncak Lego": {
                try {
                    String marka, malzeme, zorluk, renk;
                    int ebat, fiyat, parcaSayisi;
                    Lego lego;
                    fileIO file = new fileIO("Oyuncak Lego.txt");

                    lego = (Lego) legoTable.getSelectionModel().getSelectedItem();
                    marka = lego.getMarka();
                    malzeme = lego.getMalzeme();
                    renk = lego.getRenk();
                    parcaSayisi = lego.getParcaSayisi();
                    ebat = lego.getEbat();
                    fiyat = lego.getFiyat();
                    zorluk = lego.getZorluk();

                    String deger = marka + "," + parcaSayisi + "," + ebat + "," + malzeme + "," + zorluk + "," + renk + "," + fiyat;

                    file.dosyadanSil("Oyuncak Lego.txt", deger);
                    file.dosyaOku("Oyuncak Lego.txt", "Oyuncak Lego");

                    legoTable.setItems(file.getLego());

                } catch (IOException ex) {
                    Logger.getLogger(ArabaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "Oyuncak Peluş": {
                try {
                    String marka, malzeme, tur, renk, gozRengi;
                    int ebat, fiyat;
                    Pelus pelus;
                    fileIO file = new fileIO("Oyuncak Pelus.txt");

                    pelus = (Pelus) pelusTable.getSelectionModel().getSelectedItem();
                    marka = pelus.getMarka();
                    malzeme = pelus.getMalzeme();
                    renk = pelus.getRenk();
                    gozRengi = pelus.getGozRengi();
                    ebat = pelus.getEbat();
                    fiyat = pelus.getFiyat();
                    tur = pelus.getTur();

                    String deger = marka + "," + gozRengi + "," + ebat + "," + malzeme + "," + tur + "," + renk + "," + fiyat;

                    file.dosyadanSil("Oyuncak Pelus.txt", deger);
                    file.dosyaOku("Oyuncak Pelus.txt", "Oyuncak Pelus");

                    pelusTable.setItems(file.getPelus());

                } catch (IOException ex) {
                    Logger.getLogger(ArabaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "Oyuncak Silah": {
                try {
                    String marka, malzeme, cesit, renk;
                    int ebat, fiyat, menzil;
                    Silah silah;
                    fileIO file = new fileIO("Oyuncak Silah.txt");

                    silah = (Silah) silahTable.getSelectionModel().getSelectedItem();
                    marka = silah.getMarka();
                    malzeme = silah.getMalzeme();
                    renk = silah.getRenk();
                    menzil = silah.getMenzil();
                    ebat = silah.getEbat();
                    fiyat = silah.getFiyat();
                    cesit = silah.getCesit();

                    String deger = marka + "," + cesit + "," + ebat + "," + malzeme + "," + menzil + "," + renk + "," + fiyat;

                    file.dosyadanSil("Oyuncak Silah.txt", deger);
                    file.dosyaOku("Oyuncak Silah.txt", "Oyuncak Silah");

                    silahTable.setItems(file.getSilah());

                } catch (IOException ex) {
                    Logger.getLogger(ArabaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "Oyuncak Tren": {
                try {
                    String marka, malzeme;
                    int parcaSayisi, ebat, fiyat, uzunluk;
                    Tren tren;
                    fileIO file = new fileIO("Oyuncak Tren.txt");

                    tren = (Tren) trenTable.getSelectionModel().getSelectedItem();
                    marka = tren.getMarka();
                    malzeme = tren.getMalzeme();
                    parcaSayisi = tren.getParcaSayisi();
                    ebat = tren.getEbat();
                    fiyat = tren.getFiyat();
                    uzunluk = tren.getUzunluk();
                    String deger = marka + "," + ebat + "," + malzeme + "," + parcaSayisi + "," + uzunluk + "," + fiyat;

                    file.dosyadanSil("Oyuncak Tren.txt", deger);
                    file.dosyaOku("Oyuncak Tren.txt", "Oyuncak Tren");

                    trenTable.setItems(file.getTren());

                } catch (IOException ex) {
                    Logger.getLogger(ArabaController.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            }
            case "Puzzle": {
                try {
                    String zorluk, marka, malzeme;
                    int parcaSayisi, ebat, fiyat;
                    Puzzle puzzle;
                    fileIO file = new fileIO("Puzzle.txt");

                    puzzle = (Puzzle) puzzleTable.getSelectionModel().getSelectedItem();
                    marka = puzzle.getMarka();
                    malzeme = puzzle.getMalzeme();
                    parcaSayisi = puzzle.getParcaSayisi();
                    ebat = puzzle.getEbat();
                    fiyat = puzzle.getFiyat();
                    zorluk = puzzle.getZorluk();
                    String deger = marka + "," + ebat + "," + malzeme + "," + parcaSayisi + "," + zorluk + "," + fiyat;

                    file.dosyadanSil("Puzzle.txt", deger);
                    file.dosyaOku("Puzzle.txt", "Puzzle");
                    
                    puzzleTable.setItems(file.getPuzzle());

                } catch (IOException ex) {
                    Logger.getLogger(ArabaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            default:
                break;
        }
    }

    private void createWithInstance(OyuncakEntity o) {
        if (o instanceof oyuncakAraba) {
            araba.add(o);
        } else if (o instanceof EgiticiOyuncak) {
            egitici.add(o);
        } else if (o instanceof oyuncakBebek) {
            bebek.add(o);
        } else if (o instanceof Figür) {
            figur.add(o);
        } else if (o instanceof KutuOyunları) {
            kutu.add(o);
        } else if (o instanceof OyuncakEv) {
            ev.add(o);
        } else if (o instanceof Helikopter) {
            heli.add(o);
        } else if (o instanceof Lego) {
            lego.add(o);
        } else if (o instanceof Pelus) {
            pelus.add(o);
        } else if (o instanceof Silah) {
            silah.add(o);
        } else if (o instanceof Tren) {
            tren.add(o);
        } else if (o instanceof Puzzle) {
            puzzle.add(o);
        }
    }

    public ObservableList<OyuncakEntity> getList(ObservableList<OyuncakEntity> o) {
        return o;
    }

}
