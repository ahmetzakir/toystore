package dosyaIslemleri;

import AnaOyuncak.OyuncakEntity;
import EğiticiOyuncaklarController.EgiticiOyuncak;
import FigurController.Figür;
import Imalat.ImalatController;
import Kullanici.Kullanıcı;
import KutuOyunlarıController.KutuOyunları;
import OyuncakArabaController.oyuncakAraba;
import OyuncakBebekController.oyuncakBebek;
import OyuncakEvController.OyuncakEv;
import OyuncakHelikopterController.Helikopter;
import OyuncakLegoController.Lego;
import OyuncakPelusController.Pelus;
import OyuncakSilahController.Silah;
import OyuncakTrenController.Tren;
import PuzzleController.Puzzle;
import java.io.*;
import java.nio.file.Files;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class fileIO implements fileInterface {

    private ObservableList<OyuncakEntity> araba = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> egitici = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> figur = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> ev = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> kutu = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> bebek = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> heli = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> lego = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> pelus = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> silah = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> tren = FXCollections.observableArrayList();
    private ObservableList<OyuncakEntity> puzzle = FXCollections.observableArrayList();
    File fl;

    public fileIO() {
    }

    public fileIO(String fileName) {
        try {
            fl = new File(fileName);
            if (!fl.exists()) {
                fl.createNewFile();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void kullaniciKaydet(Kullanıcı o) {

        try {
            FileWriter fw = new FileWriter(fl, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(o.getUserId() + "$" + o.getPass() + "+" + o.getLastName()
                    + "," + o.getName() + "#" + o.getEmail() + "&" + o.getCountry() + "%" + o.getPhoneNo());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean girisKontrol(String username, String password) {
        FileReader fr;
        BufferedReader br;
        String s, id, pass;
        int flag = 0;
        try {
            fr = new FileReader(fl);
            br = new BufferedReader(fr);
            while ((s = br.readLine()) != null) {

                pass = s.substring(s.indexOf("$") + 1, s.indexOf("+"));
                id = s.substring(0, s.indexOf("$"));
                if (username.equals(id) && password.equals(pass)) {
                    flag = 1;
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
        if (flag == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean girisKontrol(int telNo, String password) {

        FileReader fr;
        BufferedReader br;
        String s, pass;
        int phoneNo;
        int flag = 0;
        try {
            fr = new FileReader(fl);
            br = new BufferedReader(fr);
            while ((s = br.readLine()) != null) {
                pass = s.substring(s.indexOf("$") + 1, s.indexOf("+"));
                phoneNo = Integer.parseInt(s.substring(s.indexOf("%") + 1, s.length()));
                if (telNo == phoneNo && password.equals(pass)) {
                    flag = 1;
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
        if (flag == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean girisKontrol(String email, String password, int type) {
        FileReader fr;
        BufferedReader br;
        String s, emailAdress, pass;
        int flag = 0;
        try {
            fr = new FileReader(fl);
            br = new BufferedReader(fr);
            while ((s = br.readLine()) != null) {
                pass = s.substring(s.indexOf("$") + 1, s.indexOf("+"));
                emailAdress = (s.substring(s.indexOf("#") + 1, s.indexOf("&")));
                if (emailAdress.equals(email) && password.equals(pass)) {
                    flag = 1;
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
        if (flag == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean girisKontrol(String deger) {
        int flag = 0, i = 0;
        while (i < deger.length()) {
            if (!(deger.charAt(i) >= '0' && deger.charAt(i) <= '9')) {
                flag = 1;
            }
            if (flag == 1) {
                return false;
            }
            i++;
        }
        return true;
    }

    @Override
    public void dosyaYaz(OyuncakEntity o, String Kategori) {
        switch (Kategori) {
            case "Araba":
                oyuncakAraba araba;
                araba = (oyuncakAraba) o;
                try {
                    FileWriter fw = new FileWriter(fl, true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write(araba.getMarka() + "," + araba.getMalzeme() + ","
                            + araba.getEbat() + "," + araba.getFiyat() + ","
                            + araba.getKategori() + "," + araba.getRenk() + "," + araba.getSarjSuresi());
                    bw.newLine();
                    bw.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "Eğitici Oyuncak":
                EgiticiOyuncak egitici;
                egitici = (EgiticiOyuncak) o;
                try {
                    FileWriter fw = new FileWriter(fl, true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write(egitici.getMarka() + "," + egitici.getRenk() + ","
                            + egitici.getEbat() + "," + egitici.getMalzeme() + ","
                            + egitici.getParcaSayisi() + "," + egitici.getYasAraligi()
                            + "," + egitici.getZorluk() + "," + egitici.getFiyat());
                    bw.newLine();
                    bw.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "Figür":
                Figür figur;
                figur = (Figür) o;
                try {
                    FileWriter fw = new FileWriter(fl, true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write(figur.getMarka() + "," + figur.getCinsiyet() + ","
                            + figur.getGozRengi() + "," + figur.getEbat() + ","
                            + figur.getMalzeme() + "," + figur.getTur()
                            + "," + figur.getFiyat());
                    bw.newLine();
                    bw.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "Oyuncak Bebek":
                oyuncakBebek bebek;
                bebek = (oyuncakBebek) o;
                try {
                    FileWriter fw = new FileWriter(fl, true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write(bebek.getMarka() + "," + bebek.getEbat() + ","
                            + bebek.getCinsiyet() + "," + bebek.getGozRengi() + ","
                            + bebek.getMalzeme() + "," + bebek.getSacRengi()
                            + "," + bebek.getFiyat());
                    bw.newLine();
                    bw.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "Oyuncak Ev":
                OyuncakEv ev;
                ev = (OyuncakEv) o;
                try {
                    FileWriter fw = new FileWriter(fl, true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write(ev.getMarka() + "," + ev.getEbat() + ","
                            + ev.getOyuncuSayisi() + "," + ev.getParcaSayisi() + ","
                            + ev.getMalzeme() + "," + ev.getRenk()
                            + "," + ev.getFiyat());
                    bw.newLine();
                    bw.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "Kutu Oyunları":
                KutuOyunları kutu;
                kutu = (KutuOyunları) o;
                try {
                    FileWriter fw = new FileWriter(fl, true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write(kutu.getMarka() + "," + kutu.getZorluk() + ","
                            + kutu.getEbat() + "," + kutu.getMalzeme() + ","
                            + kutu.getOyuncuSayisi() + "," + kutu.getFiyat());
                    bw.newLine();
                    bw.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "Oyuncak Lego":
                Lego lego;
                lego = (Lego) o;
                try {
                    FileWriter fw = new FileWriter(fl, true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write(lego.getMarka() + "," + lego.getParcaSayisi() + ","
                            + lego.getEbat() + "," + lego.getMalzeme() + ","
                            + lego.getZorluk() + "," + lego.getRenk() + "," + lego.getFiyat());
                    bw.newLine();
                    bw.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "Oyuncak Helikopter":
                Helikopter helikopter;
                helikopter = (Helikopter) o;
                try {
                    FileWriter fw = new FileWriter(fl, true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write(helikopter.getMarka() + "," + helikopter.getSarjSuresi() + ","
                            + helikopter.getEbat() + "," + helikopter.getMalzeme() + ","
                            + helikopter.getMenzil() + "," + helikopter.getRenk() + ","
                            + helikopter.getFiyat());
                    bw.newLine();
                    bw.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "Oyuncak Tren":
                Tren tren;
                tren = (Tren) o;
                try {
                    FileWriter fw = new FileWriter(fl, true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write(tren.getMarka() + "," + tren.getEbat() + ","
                            + tren.getMalzeme() + "," + tren.getParcaSayisi() + ","
                            + tren.getUzunluk() + "," + tren.getFiyat());
                    bw.newLine();
                    bw.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "Oyuncak Silah":
                Silah silah;
                silah = (Silah) o;
                try {
                    FileWriter fw = new FileWriter(fl, true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write(silah.getMarka() + "," + silah.getCesit() + ","
                            + silah.getEbat() + "," + silah.getMalzeme() + ","
                            + silah.getMenzil() + ","
                            + silah.getRenk() + "," + silah.getFiyat());
                    bw.newLine();
                    bw.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "Oyuncak Pelus":
                Pelus pelus;
                pelus = (Pelus) o;
                try {
                    FileWriter fw = new FileWriter(fl, true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write(pelus.getMarka() + "," + pelus.getGozRengi() + ","
                            + pelus.getEbat() + "," + pelus.getMalzeme() + ","
                            + pelus.getTur() + ","
                            + pelus.getRenk() + "," + pelus.getFiyat());
                    bw.newLine();
                    bw.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "Puzzle":
                Puzzle puzzle;
                puzzle = (Puzzle) o;
                try {
                    FileWriter fw = new FileWriter(fl, true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write(puzzle.getMarka() + "," + puzzle.getEbat() + ","
                            + puzzle.getMalzeme() + "," + puzzle.getParcaSayisi() + ","
                            + puzzle.getZorluk() + "," + puzzle.getFiyat());
                    bw.newLine();
                    bw.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                break;

        }

    }

    public void dosyaOku(String fileName, String Kategori) {

        if (Kategori.equals("Oyuncak Araba")) {

            Collection<oyuncakAraba> list;
            try {
                list = Files.readAllLines(new File(fileName).toPath())
                        .stream()
                        .map(line -> {
                            String[] details = line.split(",");
                            oyuncakAraba araba = new oyuncakAraba();
                            araba.setMarka(details[0]);
                            araba.setMalzeme(details[1]);
                            araba.setEbat(Integer.parseInt(details[2]));
                            araba.setFiyat(Integer.parseInt(details[3]));
                            araba.setKategori(details[4]);
                            araba.setRenk(details[5]);
                            araba.setSarjSuresi(Integer.parseInt(details[6]));
                            return araba;
                        })
                        .collect(Collectors.toList());
                araba = FXCollections.observableArrayList(list);
            } catch (IOException ex) {
                Logger.getLogger(ImalatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Kategori.equals("Egitici Oyuncak")) {
            Collection<EgiticiOyuncak> list;
            try {
                list = Files.readAllLines(new File(fileName).toPath())
                        .stream()
                        .map(line -> {
                            String[] details = line.split(",");
                            EgiticiOyuncak egitici = new EgiticiOyuncak();
                            egitici.setMarka(details[0]);
                            egitici.setRenk(details[1]);
                            egitici.setEbat(Integer.parseInt(details[2]));
                            egitici.setMalzeme(details[3]);
                            egitici.setParcaSayisi(Integer.parseInt(details[4]));
                            egitici.setYasAraligi(details[5]);
                            egitici.setZorluk(details[6]);
                            egitici.setFiyat(Integer.parseInt(details[7]));

                            return egitici;
                        })
                        .collect(Collectors.toList());
                egitici = FXCollections.observableArrayList(list);
            } catch (IOException ex) {
                Logger.getLogger(ImalatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Kategori.equals("Oyuncak Figür")) {
            Collection<Figür> list;
            try {
                list = Files.readAllLines(new File(fileName).toPath())
                        .stream()
                        .map(line -> {
                            String[] details = line.split(",");
                            Figür figur = new Figür();
                            figur.setMarka(details[0]);
                            figur.setCinsiyet(details[1]);
                            figur.setGozRengi(details[2]);
                            figur.setEbat(Integer.parseInt(details[3]));
                            figur.setMalzeme(details[4]);
                            figur.setTur(details[5]);
                            figur.setFiyat(Integer.parseInt(details[6]));

                            return figur;
                        })
                        .collect(Collectors.toList());
                figur = FXCollections.observableArrayList(list);
            } catch (IOException ex) {
                Logger.getLogger(ImalatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Kategori.equals("Oyuncak Bebek")) {
            Collection<oyuncakBebek> list;
            try {
                list = Files.readAllLines(new File(fileName).toPath())
                        .stream()
                        .map(line -> {
                            String[] details = line.split(",");
                            oyuncakBebek bebek = new oyuncakBebek();
                            bebek.setMarka(details[0]);
                            bebek.setEbat(Integer.parseInt(details[1]));
                            bebek.setCinsiyet(details[2]);
                            bebek.setGozRengi(details[3]);
                            bebek.setMalzeme(details[4]);
                            bebek.setSacRengi(details[5]);
                            bebek.setFiyat(Integer.parseInt(details[6]));

                            return bebek;
                        })
                        .collect(Collectors.toList());
                bebek = FXCollections.observableArrayList(list);
            } catch (IOException ex) {
                Logger.getLogger(ImalatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Kategori.equals("Kutu Oyunları")) {

            Collection<KutuOyunları> list;
            try {
                list = Files.readAllLines(new File(fileName).toPath())
                        .stream()
                        .map(line -> {
                            String[] details = line.split(",");
                            KutuOyunları kutu = new KutuOyunları();
                            kutu.setMarka(details[0]);
                            kutu.setZorluk(details[1]);
                            kutu.setEbat(Integer.parseInt(details[2]));
                            kutu.setMalzeme(details[3]);
                            kutu.setOyuncuSayisi(Integer.parseInt(details[4]));
                            kutu.setFiyat(Integer.parseInt(details[5]));

                            return kutu;
                        })
                        .collect(Collectors.toList());
                kutu = FXCollections.observableArrayList(list);
            } catch (IOException ex) {
                Logger.getLogger(ImalatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Kategori.equals("Oyuncak Ev")) {

            Collection<OyuncakEv> list;
            try {
                list = Files.readAllLines(new File(fileName).toPath())
                        .stream()
                        .map(line -> {
                            String[] details = line.split(",");
                            OyuncakEv ev = new OyuncakEv();
                            ev.setMarka(details[0]);
                            ev.setEbat(Integer.parseInt(details[1]));
                            ev.setOyuncuSayisi(Integer.parseInt(details[2]));
                            ev.setParcaSayisi(Integer.parseInt(details[3]));
                            ev.setMalzeme(details[4]);
                            ev.setRenk(details[5]);
                            ev.setFiyat(Integer.parseInt(details[6]));

                            return ev;
                        })
                        .collect(Collectors.toList());
                ev = FXCollections.observableArrayList(list);
            } catch (IOException ex) {
                Logger.getLogger(ImalatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Kategori.equals("Oyuncak Helikopter")) {
            Collection<Helikopter> list;
            try {
                list = Files.readAllLines(new File(fileName).toPath())
                        .stream()
                        .map(line -> {
                            String[] details = line.split(",");
                            Helikopter heli = new Helikopter();
                            heli.setMarka(details[0]);
                            heli.setSarjSuresi(Integer.parseInt(details[1]));
                            heli.setEbat(Integer.parseInt(details[2]));
                            heli.setMalzeme(details[3]);
                            heli.setMenzil(Integer.parseInt(details[4]));
                            heli.setRenk(details[5]);
                            heli.setFiyat(Integer.parseInt(details[6]));

                            return heli;
                        })
                        .collect(Collectors.toList());
                heli = FXCollections.observableArrayList(list);
            } catch (IOException ex) {
                Logger.getLogger(ImalatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Kategori.equals("Oyuncak Lego")) {

            Collection<Lego> list;
            try {
                list = Files.readAllLines(new File(fileName).toPath())
                        .stream()
                        .map(line -> {
                            String[] details = line.split(",");
                            Lego lego = new Lego();
                            lego.setMarka(details[0]);
                            lego.setParcaSayisi(Integer.parseInt(details[1]));
                            lego.setEbat(Integer.parseInt(details[2]));
                            lego.setMalzeme(details[3]);
                            lego.setZorluk(details[4]);
                            lego.setRenk(details[5]);
                            lego.setFiyat(Integer.parseInt(details[6]));

                            return lego;
                        })
                        .collect(Collectors.toList());
                lego = FXCollections.observableArrayList(list);
            } catch (IOException ex) {
                Logger.getLogger(ImalatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Kategori.equals("Oyuncak Pelus")) {

            Collection<Pelus> list;
            try {
                list = Files.readAllLines(new File("Oyuncak Pelus.txt").toPath())
                        .stream()
                        .map(line -> {
                            String[] details = line.split(",");
                            Pelus pelus = new Pelus();
                            pelus.setMarka(details[0]);
                            pelus.setGozRengi(details[1]);
                            pelus.setEbat(Integer.parseInt(details[2]));
                            pelus.setMalzeme(details[3]);
                            pelus.setTur(details[4]);
                            pelus.setRenk(details[5]);
                            pelus.setFiyat(Integer.parseInt(details[6]));

                            return pelus;
                        })
                        .collect(Collectors.toList());
                pelus = FXCollections.observableArrayList(list);
            } catch (IOException ex) {
                Logger.getLogger(ImalatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Kategori.equals("Oyuncak Tren")) {

            Collection<Tren> list;
            try {
                list = Files.readAllLines(new File(fileName).toPath())
                        .stream()
                        .map(line -> {
                            String[] details = line.split(",");
                            Tren tren = new Tren();
                            tren.setMarka(details[0]);
                            tren.setEbat(Integer.parseInt(details[1]));
                            tren.setMalzeme(details[2]);
                            tren.setParcaSayisi(Integer.parseInt(details[3]));
                            tren.setUzunluk(Integer.parseInt(details[4]));
                            tren.setFiyat(Integer.parseInt(details[5]));

                            return tren;
                        })
                        .collect(Collectors.toList());
                tren = FXCollections.observableArrayList(list);
            } catch (IOException ex) {
                Logger.getLogger(ImalatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Kategori.equals("Oyuncak Silah")) {

            Collection<Silah> list;
            try {
                list = Files.readAllLines(new File(fileName).toPath())
                        .stream()
                        .map(line -> {
                            String[] details = line.split(",");
                            Silah silah = new Silah();
                            silah.setMarka(details[0]);
                            silah.setCesit(details[1]);
                            silah.setEbat(Integer.parseInt(details[2]));
                            silah.setMalzeme(details[3]);
                            silah.setMenzil(Integer.parseInt(details[4]));
                            silah.setRenk(details[5]);
                            silah.setFiyat(Integer.parseInt(details[6]));

                            return silah;
                        })
                        .collect(Collectors.toList());
                silah = FXCollections.observableArrayList(list);
            } catch (IOException ex) {
                Logger.getLogger(ImalatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Kategori.equals("Puzzle")) {

            Collection<Puzzle> list;
            try {
                list = Files.readAllLines(new File(fileName).toPath())
                        .stream()
                        .map(line -> {
                            String[] details = line.split(",");
                            Puzzle puzzle = new Puzzle();
                            puzzle.setMarka(details[0]);
                            puzzle.setEbat(Integer.parseInt(details[1]));
                            puzzle.setMalzeme(details[2]);
                            puzzle.setParcaSayisi(Integer.parseInt(details[3]));
                            puzzle.setZorluk(details[4]);
                            puzzle.setFiyat(Integer.parseInt(details[5]));

                            return puzzle;
                        })
                        .collect(Collectors.toList());
                puzzle = FXCollections.observableArrayList(list);
            } catch (IOException ex) {
                Logger.getLogger(ImalatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void dosyadanSil(String inputFile, String lineContent) throws IOException {
        File file = new File(inputFile);
        File temp = new File("MyTempFile.txt");
        PrintWriter out = new PrintWriter(new FileWriter(temp));
        Files.lines(file.toPath())
                .filter(line -> !line.contains(lineContent))
                .forEach(out::println);
        out.flush();
        out.close();
        file.delete();
        temp.renameTo(file);
    }

    public ObservableList<OyuncakEntity> getAraba() {
        return araba;
    }

    public void setAraba(ObservableList<OyuncakEntity> araba) {
        this.araba = araba;
    }

    public ObservableList<OyuncakEntity> getEgitici() {
        return egitici;
    }

    public void setEgitici(ObservableList<OyuncakEntity> egitici) {
        this.egitici = egitici;
    }

    public ObservableList<OyuncakEntity> getFigur() {
        return figur;
    }

    public void setFigur(ObservableList<OyuncakEntity> figur) {
        this.figur = figur;
    }

    public ObservableList<OyuncakEntity> getEv() {
        return ev;
    }

    public void setEv(ObservableList<OyuncakEntity> ev) {
        this.ev = ev;
    }

    public ObservableList<OyuncakEntity> getKutu() {
        return kutu;
    }

    public void setKutu(ObservableList<OyuncakEntity> kutu) {
        this.kutu = kutu;
    }

    public ObservableList<OyuncakEntity> getBebek() {
        return bebek;
    }

    public void setBebek(ObservableList<OyuncakEntity> bebek) {
        this.bebek = bebek;
    }

    public ObservableList<OyuncakEntity> getHeli() {
        return heli;
    }

    public void setHeli(ObservableList<OyuncakEntity> heli) {
        this.heli = heli;
    }

    public ObservableList<OyuncakEntity> getLego() {
        return lego;
    }

    public void setLego(ObservableList<OyuncakEntity> lego) {
        this.lego = lego;
    }

    public ObservableList<OyuncakEntity> getPelus() {
        return pelus;
    }

    public void setPelus(ObservableList<OyuncakEntity> pelus) {
        this.pelus = pelus;
    }

    public ObservableList<OyuncakEntity> getSilah() {
        return silah;
    }

    public void setSilah(ObservableList<OyuncakEntity> silah) {
        this.silah = silah;
    }

    public ObservableList<OyuncakEntity> getTren() {
        return tren;
    }

    public void setTren(ObservableList<OyuncakEntity> tren) {
        this.tren = tren;
    }

    public ObservableList<OyuncakEntity> getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(ObservableList<OyuncakEntity> puzzle) {
        this.puzzle = puzzle;
    }

}
