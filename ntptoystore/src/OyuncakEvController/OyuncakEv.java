package OyuncakEvController;

import AnaOyuncak.OyuncakEntity;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OyuncakEv extends OyuncakEntity {
    
    private ImageView resim=new ImageView(new Image(this.getClass().getResourceAsStream("/resources/ev.png")));
    private String renk;
    private int oyuncuSayisi;
    private int parcaSayisi;

    public OyuncakEv() {
    }

    public OyuncakEv(String renk, int oyuncuSayisi, int parcaSayisi) {
        this.renk = renk;
        this.oyuncuSayisi = oyuncuSayisi;
        this.parcaSayisi = parcaSayisi;
    }

    public OyuncakEv(String renk, int oyuncuSayisi, int parcaSayisi, int ebat, String malzeme, int fiyat, String marka) {
        super(ebat, malzeme, fiyat, marka);
        this.renk = renk;
        this.oyuncuSayisi = oyuncuSayisi;
        this.parcaSayisi = parcaSayisi;
    }
    
    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public int getOyuncuSayisi() {
        return oyuncuSayisi;
    }

    public void setOyuncuSayisi(int oyuncuSayisi) {
        this.oyuncuSayisi = oyuncuSayisi;
    }

    public int getParcaSayisi() {
        return parcaSayisi;
    }

    public void setParcaSayisi(int parcaSayisi) {
        this.parcaSayisi = parcaSayisi;
    }

    public ImageView getResim() {
        return resim;
    }

    public void setResim(ImageView resim) {
        this.resim = resim;
    }

    

}
