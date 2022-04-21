package Main;

import Kullanici.Kullanıcı;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dosyaIslemleri.fileIO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class LoginC implements Initializable {

   
    @FXML
    private JFXTextField kullaniciAdi;
    @FXML
    private JFXPasswordField sifreText;
    @FXML
    private JFXButton girisbuton;
    @FXML
    private JFXButton iptalbuton;
    @FXML
    private Label uyeOlLabel;

    public static Kullanıcı admin = new Kullanıcı("admin", "admin", "admin", "admin", "admin@gmail.com", "admin", 999);
    public static Kullanıcı aktifKullanıcı = new Kullanıcı();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void clickButon(ActionEvent event) {
        fileIO file = new fileIO("Kullanıcılar.txt");
        if (!("".equals(sifreText.getText()) || "".equals(kullaniciAdi.getText()))) {
            if (event.getSource() == girisbuton) {
                if (file.girisKontrol(kullaniciAdi.getText(), sifreText.getText())) {//Kullanıcı adı ve şifre ile girilen kısım
                    try {
                        aktifKullanıcı.setUserId(kullaniciAdi.getText());
                        aktifKullanıcı.setPass(sifreText.getText());
                        Parent root = FXMLLoader.load(getClass().getResource("/Menu/Menu.fxml"));
                        Scene scene = new Scene(root);
                        Oyuncak.mystage.setScene(scene);
                        Oyuncak.mystage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (file.girisKontrol(kullaniciAdi.getText())) {//Telefon numarası ile girilen kısım
                    if (file.girisKontrol(Integer.parseInt(kullaniciAdi.getText()),
                            sifreText.getText()) && Integer.parseInt(kullaniciAdi.getText()) != 0) {// 0'a eşit olmamasını kontrol etmemizin sebeni eğer telefon numarası girmemiş ise kullanıcı varsayılan değer olan 0 ile giriş yapamasın.
                        try {
                            aktifKullanıcı.setPhoneNo(Integer.parseInt(kullaniciAdi.getText()));
                            aktifKullanıcı.setPass(sifreText.getText());
                            Parent root = FXMLLoader.load(getClass().getResource("/Menu/Menu.fxml"));
                            Scene scene = new Scene(root);
                            Oyuncak.mystage.setScene(scene);
                            Oyuncak.mystage.show();
                        } catch (IOException ex) {
                            Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        Alert alert1 = new Alert(Alert.AlertType.ERROR);
                        alert1.setTitle("Hata Mesajı");
                        alert1.setHeaderText("Hata");
                        alert1.setContentText("Hatalı Kullanıcı Adı Veya Şifre");
                        alert1.showAndWait();
                    }

                } else if (kullaniciAdi.getText().contains("@")) {
                    if (file.girisKontrol(kullaniciAdi.getText(), sifreText.getText(), 1)) {
                        try {
                            aktifKullanıcı.setEmail(kullaniciAdi.getText());
                            aktifKullanıcı.setPass(sifreText.getText());
                            Parent root = FXMLLoader.load(getClass().getResource("/Menu/Menu.fxml"));
                            Scene scene = new Scene(root);
                            Oyuncak.mystage.setScene(scene);
                            Oyuncak.mystage.show();
                        } catch (IOException ex) {
                            Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        Alert alert1 = new Alert(Alert.AlertType.ERROR);
                        alert1.setTitle("Hata Mesajı");
                        alert1.setHeaderText("Hata");
                        alert1.setContentText("Hatalı Kullanıcı Adı Veya Şifre");
                        alert1.showAndWait();
                    }
                } else {
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.setTitle("Hata Mesajı");
                    alert1.setHeaderText("Hata");
                    alert1.setContentText("Hatalı Kullanıcı Adı Veya Şifre");
                    alert1.showAndWait();
                }
            } else if (event.getSource() == iptalbuton) {
                System.exit(0);
            }
        }else if(event.getSource() == iptalbuton){
            System.exit(0);
        }
    }

    @FXML
    private void clickIcon(MouseEvent event) {
        if (event.getSource() == uyeOlLabel) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/Main/UyeOlForm.fxml"));
                Scene scene = new Scene(root);
                Oyuncak.mystage.setScene(scene);
                Oyuncak.mystage.show();
            } catch (IOException ex) {
                Logger.getLogger(LoginC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
