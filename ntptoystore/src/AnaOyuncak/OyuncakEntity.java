package AnaOyuncak;

public class OyuncakEntity {

    private int ebat;
    private String malzeme;
    private int fiyat;
    private String marka;

    public OyuncakEntity() {
    }

    public OyuncakEntity(int ebat, String malzeme, int fiyat, String marka) {
        this.ebat = ebat;
        this.malzeme = malzeme;
        this.fiyat = fiyat;
        this.marka = marka;
    }

    public int getEbat() {
        return ebat;
    }

    public void setEbat(int ebat) {
        this.ebat = ebat;
    }

    public String getMalzeme() {
        return malzeme;
    }

    public void setMalzeme(String malzeme) {
        this.malzeme = malzeme;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

}
