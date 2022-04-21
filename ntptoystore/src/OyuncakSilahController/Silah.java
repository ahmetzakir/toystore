package OyuncakSilahController;

import AnaOyuncak.OyuncakEntity;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Silah extends OyuncakEntity {

    private ImageView resim=new ImageView(new Image(this.getClass().getResourceAsStream("/resources/silah.png")));
    private String cesit;
    private String renk;
    private int menzil;

    public Silah() {
    }

    public Silah(String cesit, String renk, int menzil) {
        this.cesit = cesit;
        this.renk = renk;
        this.menzil = menzil;
    }

    public Silah(String cesit, String renk, int menzil, int ebat, String malzeme, int fiyat, String marka) {
        super(ebat, malzeme, fiyat, marka);
        this.cesit = cesit;
        this.renk = renk;
        this.menzil = menzil;
    }
    
    public String getCesit() {
        return cesit;
    }

    public void setCesit(String cesit) {
        this.cesit = cesit;
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

    public ImageView getResim() {
        return resim;
    }

    public void setResim(ImageView resim) {
        this.resim = resim;
    }

    

}
