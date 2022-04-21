package OyuncakHelikopterController;

import AnaOyuncak.OyuncakEntity;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Helikopter extends OyuncakEntity {

    private ImageView resim=new ImageView(new Image(this.getClass().getResourceAsStream("/resources/helikopter.png")));
    private int boyut;
    private String renk;
    private int menzil;
    private int sarjSuresi;

    public Helikopter() {
    }

    public Helikopter(int boyut, String renk, int menzil, int sarjSuresi) {
        this.boyut = boyut;
        this.renk = renk;
        this.menzil = menzil;
        this.sarjSuresi = sarjSuresi;
    }

    public Helikopter(int boyut, String renk, int menzil, int sarjSuresi, int ebat, String malzeme, int fiyat, String marka) {
        super(ebat, malzeme, fiyat, marka);
        this.boyut = boyut;
        this.renk = renk;
        this.menzil = menzil;
        this.sarjSuresi = sarjSuresi;
    }

    public int getBoyut() {
        return boyut;
    }

    public void setBoyut(int boyut) {
        this.boyut = boyut;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public int getMenzil() {
        return menzil;
    }

    public void setMenzil(int menzil) {
        this.menzil = menzil;
    }

    public int getSarjSuresi() {
        return sarjSuresi;
    }

    public void setSarjSuresi(int sarjSuresi) {
        this.sarjSuresi = sarjSuresi;
    }

    public ImageView getResim() {
        return resim;
    }

    public void setResim(ImageView resim) {
        this.resim = resim;
    }

}
