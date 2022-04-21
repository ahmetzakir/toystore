package PuzzleController;

import AnaOyuncak.OyuncakEntity;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Puzzle extends OyuncakEntity {

    private ImageView resim=new ImageView(new Image(this.getClass().getResourceAsStream("/resources/puzzle.png")));
    private String zorluk;
    private int parcaSayisi;

    public Puzzle() {
    }

    public Puzzle(String zorluk, int parcaSayisi) {
        this.zorluk = zorluk;
        this.parcaSayisi = parcaSayisi;
    }

    public Puzzle(int ebat, String malzeme, int fiyat, String marka) {
        super(ebat, malzeme, fiyat, marka);
    }
    
    
    public Puzzle(String zorluk, int parcaSayisi, int ebat, String malzeme, int fiyat, String marka) {
        super(ebat, malzeme, fiyat, marka);
        this.zorluk = zorluk;
        this.parcaSayisi = parcaSayisi;
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

    public ImageView getResim() {
        return resim;
    }

    public void setResim(ImageView resim) {
        this.resim = resim;
    }

    

}
