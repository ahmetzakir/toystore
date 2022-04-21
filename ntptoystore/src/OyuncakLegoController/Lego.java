package OyuncakLegoController;

import AnaOyuncak.OyuncakEntity;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Lego extends OyuncakEntity {

    private ImageView resim=new ImageView(new Image(this.getClass().getResourceAsStream("/resources/lego.png")));
    private int parcaSayisi;
    private String zorluk;
    private String renk;

    public Lego() {
    }

    public Lego(int parcaSayisi, String zorluk, String renk) {
        this.parcaSayisi = parcaSayisi;
        this.zorluk = zorluk;
        this.renk = renk;
    }

    public Lego(int parcaSayisi, String zorluk, String renk, int ebat, String malzeme, int fiyat, String marka) {
        super(ebat, malzeme, fiyat, marka);
        this.parcaSayisi = parcaSayisi;
        this.zorluk = zorluk;
        this.renk = renk;
    }
    
    public int getParcaSayisi() {
        return parcaSayisi;
    }

    public void setParcaSayisi(int parcaSayisi) {
        this.parcaSayisi = parcaSayisi;
    }

    public String getZorluk() {
        return zorluk;
    }

    public void setZorluk(String zorluk) {
        this.zorluk = zorluk;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public ImageView getResim() {
        return resim;
    }

    public void setResim(ImageView resim) {
        this.resim = resim;
    }

    

}
