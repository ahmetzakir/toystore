package FigurController;

import AnaOyuncak.OyuncakEntity;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Figür extends OyuncakEntity {

    private ImageView resim=new ImageView(new Image(this.getClass().getResourceAsStream("/resources/figur.png")));
    private String cinsiyet;
    private String gozRengi;
    private String tur;

    public Figür() {
    }

    public Figür(String cinsiyet, String gozRengi, String tur) {
        this.cinsiyet = cinsiyet;
        this.gozRengi = gozRengi;
        this.tur = tur;
    }

    public Figür(String cinsiyet, String gozRengi, String tur, int ebat, String malzeme, int fiyat, String marka) {
        super(ebat, malzeme, fiyat, marka);
        this.cinsiyet = cinsiyet;
        this.gozRengi = gozRengi;
        this.tur = tur;
    }
    
    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getGozRengi() {
        return gozRengi;
    }

    public void setGozRengi(String gozRengi) {
        this.gozRengi = gozRengi;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public ImageView getResim() {
        return resim;
    }

    public void setResim(ImageView resim) {
        this.resim = resim;
    }

    

}
