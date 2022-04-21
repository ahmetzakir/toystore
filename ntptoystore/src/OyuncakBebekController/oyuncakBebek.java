package OyuncakBebekController;

import AnaOyuncak.OyuncakEntity;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class oyuncakBebek extends OyuncakEntity {

    private ImageView resim=new ImageView(new Image(this.getClass().getResourceAsStream("/resources/bebek.png")));
    private String cinsiyet;
    private String gozRengi;
    private String sacRengi;

    public oyuncakBebek() {
    }

    public oyuncakBebek(String cinsiyet, String gozRengi, String sacRengi) {
        this.cinsiyet = cinsiyet;
        this.gozRengi = gozRengi;
        this.sacRengi = sacRengi;
    }

    public oyuncakBebek(String cinsiyet, String gozRengi, String sacRengi, int ebat, String malzeme, int fiyat, String marka) {
        super(ebat, malzeme, fiyat, marka);
        this.cinsiyet = cinsiyet;
        this.gozRengi = gozRengi;
        this.sacRengi = sacRengi;
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

    public String getSacRengi() {
        return sacRengi;
    }

    public void setSacRengi(String sacRengi) {
        this.sacRengi = sacRengi;
    }

    public ImageView getResim() {
        return resim;
    }

    public void setResim(ImageView resim) {
        this.resim = resim;
    }

    

}
