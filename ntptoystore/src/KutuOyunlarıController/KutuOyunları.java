package KutuOyunlarıController;

import AnaOyuncak.OyuncakEntity;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class KutuOyunları extends OyuncakEntity {

    private ImageView resim=new ImageView(new Image(this.getClass().getResourceAsStream("/resources/kutu.png")));
    private String zorluk;
    private int oyuncuSayisi;

    public KutuOyunları() {
    }

    public KutuOyunları(int ebat, String malzeme, int fiyat, String marka) {
        super(ebat, malzeme, fiyat, marka);
    }

    public KutuOyunları(String zorluk, int oyuncuSayisi) {
        this.zorluk = zorluk;
        this.oyuncuSayisi = oyuncuSayisi;
    }

    public KutuOyunları(String zorluk, int oyuncuSayisi, int ebat, String malzeme, int fiyat, String marka) {
        super(ebat, malzeme, fiyat, marka);
        this.zorluk = zorluk;
        this.oyuncuSayisi = oyuncuSayisi;
    }

    public String getZorluk() {
        return zorluk;
    }

    public void setZorluk(String zorluk) {
        this.zorluk = zorluk;
    }

    public int getOyuncuSayisi() {
        return oyuncuSayisi;
    }

    public void setOyuncuSayisi(int oyuncuSayisi) {
        this.oyuncuSayisi = oyuncuSayisi;
    }

    public ImageView getResim() {
        return resim;
    }

    public void setResim(ImageView resim) {
        this.resim = resim;
    }

    
    
    
    


}
