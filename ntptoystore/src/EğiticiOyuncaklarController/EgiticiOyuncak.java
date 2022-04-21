package EğiticiOyuncaklarController;

import AnaOyuncak.OyuncakEntity;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EgiticiOyuncak extends OyuncakEntity {

    private ImageView resim=new ImageView(new Image(this.getClass().getResourceAsStream("/resources/rubik.png")));
    private String zorluk;
    private int parcaSayisi;
    private String renk;
    private String yasAraligi;
    
    public EgiticiOyuncak() {
    }

    public EgiticiOyuncak(String zorluk, int parcaSayisi, String renk, String yasAraligi) {
        this.zorluk = zorluk;
        this.parcaSayisi = parcaSayisi;
        this.renk = renk;
        this.yasAraligi = yasAraligi;
    }

    public EgiticiOyuncak(String zorluk, int parcaSayisi, String renk, String yasAraligi, int ebat, String malzeme, int fiyat, String marka) {
        super(ebat, malzeme, fiyat, marka);
        this.zorluk = zorluk;
        this.parcaSayisi = parcaSayisi;
        this.renk = renk;
        this.yasAraligi = yasAraligi;
    }
    
    public String getZorluk() {
        return zorluk;
    }

    public void setZorluk(String zorluk) {
        this.zorluk = zorluk;
    }

    public int getParcaSayisi() {
        return parcaSayisi;
    }

    public void setParcaSayisi(int parcaSayisi) {
        this.parcaSayisi = parcaSayisi;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public String getYasAraligi() {
        return yasAraligi;
    }

    public void setYasAraligi(String yasAraligi) {
        this.yasAraligi = yasAraligi;
    }

    public ImageView getResim() {
        return resim;
    }

    public void setResim(ImageView resim) {
        this.resim = resim;
    }

    

   

    

}
