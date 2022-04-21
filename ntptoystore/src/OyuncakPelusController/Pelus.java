package OyuncakPelusController;

import AnaOyuncak.OyuncakEntity;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pelus extends OyuncakEntity {

     private ImageView resim=new ImageView(new Image(this.getClass().getResourceAsStream("/resources/pelus.png")));
    private String renk;
    private String tur;
    private String gozRengi;

    public Pelus() {
    }

    public Pelus(String renk, String tur, String gozRengi) {
        this.renk = renk;
        this.tur = tur;
        this.gozRengi = gozRengi;
    }

    public Pelus(String renk, String tur, String gozRengi, int ebat, String malzeme, int fiyat, String marka) {
        super(ebat, malzeme, fiyat, marka);
        this.renk = renk;
        this.tur = tur;
        this.gozRengi = gozRengi;
    }
    
    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getGozRengi() {
        return gozRengi;
    }

    public void setGozRengi(String gozRengi) {
        this.gozRengi = gozRengi;
    }

    public ImageView getResim() {
        return resim;
    }

    public void setResim(ImageView resim) {
        this.resim = resim;
    }
    

    
}
