package OyuncakArabaController;

import AnaOyuncak.OyuncakEntity;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class oyuncakAraba extends OyuncakEntity {
    
    private ImageView resim=new ImageView(new Image(this.getClass().getResourceAsStream("/resources/vosvos.png")));
    private String kategori;
    private int sarjSuresi;
    private String renk;

    public oyuncakAraba() {

    }

    public oyuncakAraba(String kategori, int sarjSuresi, String renk) {
        this.kategori = kategori;
        this.sarjSuresi = sarjSuresi;
        this.renk = renk;
    }

    public oyuncakAraba(int ebat, String malzeme, int fiyat, String marka) {
        super(ebat, malzeme, fiyat, marka);
    }
    
    public oyuncakAraba(String kategori, int sarjSuresi, String renk, int ebat, String malzeme, int fiyat, String marka) {
        super(ebat, malzeme, fiyat, marka);
        this.kategori = kategori;
        this.sarjSuresi = sarjSuresi;
        this.renk = renk;
    }
    
    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getSarjSuresi() {
        return sarjSuresi;
    }

    public void setSarjSuresi(int sarjSuresi) {
        this.sarjSuresi = sarjSuresi;
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
