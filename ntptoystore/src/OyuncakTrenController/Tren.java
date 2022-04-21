package OyuncakTrenController;

import AnaOyuncak.OyuncakEntity;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tren extends OyuncakEntity {

    private ImageView resim=new ImageView(new Image(this.getClass().getResourceAsStream("/resources/tren.png")));
    private int uzunluk;
    private int parcaSayisi;

    public Tren() {
    }

    public Tren(int uzunluk, int parcaSayisi) {
        this.uzunluk = uzunluk;
        this.parcaSayisi = parcaSayisi;
    }

    public Tren(int uzunluk, int parcaSayisi, int ebat, String malzeme, int fiyat, String marka) {
        super(ebat, malzeme, fiyat, marka);
        this.uzunluk = uzunluk;
        this.parcaSayisi = parcaSayisi;
    }
    
    public int getUzunluk() {
        return uzunluk;
    }

    public void setUzunluk(int uzunluk) {
        this.uzunluk = uzunluk;
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
