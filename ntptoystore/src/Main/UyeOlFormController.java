package Main;

import Kullanici.Kullanıcı;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import dosyaIslemleri.fileIO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class UyeOlFormController implements Initializable {

    @FXML
    private JFXTextField firstNameText;
    @FXML
    private JFXTextField emailText;
    @FXML
    private JFXTextField phoneNoText;
    @FXML
    private JFXTextField lastNameText;
    @FXML
    private JFXComboBox<String> countryComboBox;
    @FXML
    private JFXTextField userPassText;
    @FXML
    private JFXButton resetAll;
    @FXML
    private JFXButton registerNow;
    @FXML
    private Label uyeFormExitButton;
    @FXML
    private JFXTextField userIdText;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    ObservableList<String> countries = FXCollections.observableArrayList("Türkiye",
            "Amerika", "İngiltere", "Almanya", "İtalya", "Azerbeycan", "Suriye");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RequiredFieldValidator validator = new RequiredFieldValidator();

        NumberValidator numValidator = new NumberValidator();

        phoneNoText.getValidators().add(numValidator);
        numValidator.setMessage("Sadece rakam giriniz !");
        phoneNoText.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    phoneNoText.validate();
                }
            }
        });

        firstNameText.getValidators().add(validator);
        lastNameText.getValidators().add(validator);
        emailText.getValidators().add(validator);
        userIdText.getValidators().add(validator);
        userPassText.getValidators().add(validator);
        validator.setMessage("Bu alanı boş bıraktınız");

        firstNameText.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    firstNameText.validate();
                }
            }
        });
        
       

        lastNameText.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    lastNameText.validate();
                }
            }
        });
        
        

        emailText.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    emailText.validate();
                }
            }
        });
        
        

        userIdText.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    userIdText.validate();
                }
            }
        });
        
        

        userPassText.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    userPassText.validate();
                }
            }
        });
         
    }

    public boolean isValid(String deger) {
        int flag = 0, i = 0;
        while (i < deger.length()) {
            if (!(deger.charAt(i) >= '0' && deger.charAt(i) <= '9')) {
                flag = 1;
            }
            if (flag == 1) {
                return false;
            }
            i++;
        }
        return true;
    }

    @FXML
    private void Kaydol(ActionEvent event) {

        if (event.getSource() == registerNow) {
            if (!(firstNameText.getText().equals("") || lastNameText.getText().equals("") || userIdText.getText().equals("") || userPassText.getText().equals("") || emailText.getText().equals(""))) {
                try {
                    if ((!phoneNoText.getText().equals("")) && isValid(phoneNoText.getText())) {
                        Kullanıcı tmp = new Kullanıcı(firstNameText.getText(),
                                lastNameText.getText(), userPassText.getText(), userIdText.getText(),
                                emailText.getText(), countryComboBox.getValue(), Integer.parseInt(phoneNoText.getText()));

                        fileIO file = new fileIO("Kullanıcılar.txt");
                        file.kullaniciKaydet(tmp);
                        Parent root = FXMLLoader.load(getClass().getResource("/Main/LoginPane.fxml"));
                        Scene scene = new Scene(root);
                        Oyuncak.mystage.setScene(scene);
                        Oyuncak.mystage.show();
                    } else if (phoneNoText.getText().equals("")) {
                        Kullanıcı tmp = new Kullanıcı(firstNameText.getText(),
                                lastNameText.getText(), userPassText.getText(), userIdText.getText(),
                                emailText.getText(), countryComboBox.getValue(), 0);

                        fileIO file = new fileIO("Kullanıcılar.txt");
                        file.kullaniciKaydet(tmp);
                        Parent root = FXMLLoader.load(getClass().getResource("/Main/LoginPane.fxml"));
                        Scene scene = new Scene(root);
                        Oyuncak.mystage.setScene(scene);
                        Oyuncak.mystage.show();
                    } else {
                        Alert a = new Alert(AlertType.NONE);

                        a.setAlertType(AlertType.WARNING);

                        a.setContentText("Lütfen geçerli bir telefon numarası girdiğinizden emin olun !");

                        a.show();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(UyeOlFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {

                Alert a = new Alert(AlertType.NONE);

                a.setAlertType(AlertType.WARNING);

                a.setContentText("Lütfen tüm gerekli alanları doldurduğunuzdan emin olun !");

                a.show();
            }

        } else if (event.getSource() == resetAll) {
            firstNameText.setText("");
            lastNameText.setText("");
            emailText.setText("");
            userPassText.setText("");
            userIdText.setText("");
            phoneNoText.setText("");
        }
    }

    @FXML
    private void backToLoginPane(MouseEvent event) {
        if (event.getSource() == uyeFormExitButton) {
            try {

                Parent root = FXMLLoader.load(getClass().getResource("/Main/LoginPane.fxml"));

                Scene scene = new Scene(root);

                Oyuncak.mystage.setScene(scene);
                Oyuncak.mystage.show();
            } catch (IOException ex) {
                Logger.getLogger(MagazaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    private void addCountries(MouseEvent event) {
        if (event.getSource() == countryComboBox) {
            countryComboBox.setItems(countries);
        }
    }

}
