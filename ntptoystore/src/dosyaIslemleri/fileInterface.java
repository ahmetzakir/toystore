/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dosyaIslemleri;

import AnaOyuncak.OyuncakEntity;
import Kullanici.Kullanıcı;

/**
 *
 * @author Talha Yılmaz
 */
public interface fileInterface {

    public void dosyaYaz(OyuncakEntity o, String kategori);
    
    
    public boolean girisKontrol(String username, String password);
    public boolean girisKontrol(int telNo,String password);
    public boolean girisKontrol(String email, String password, int type);
    public boolean girisKontrol(String deger);
    public void kullaniciKaydet(Kullanıcı o);
}
