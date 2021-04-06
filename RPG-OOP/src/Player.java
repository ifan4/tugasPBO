import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.String.format;

public class Player {
    //item defulat yang dimiliki player
    private Item objCincin = new Item("Cincin Emas");
    private ArrayList<Item> arrItem;
    private Ruangan ruanganAktif;  //ruangan tempat player saat ini berada
    private int kesehatan = 100;
    private int kebahagiaan;
    private String nama = "Fulan";
    private Scanner sc = new Scanner(System.in);
    private GameInfo objGameInfo;

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public GameInfo getObjGameInfo() {
        return objGameInfo;
    }

    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
        objCincin.setObjGameInfo(objGameInfo);
    }

    public Player() {
        arrItem = new ArrayList<>();
        objCincin.setDeskripsi("Cincin emas bertuliskan suatu kalimat..");
        //Menambahkan nilai atribut kebahagiaan
        objCincin.setKebahagiaanPower(60);
        addItem(objCincin);
    }

    public void addItem(Item objItem) {
        arrItem.add(objItem);
        this.kebahagiaan += objItem.getKebahagiaanPower();//Menambahkan kebahagiaan jika mendapatkan barang
    }

    //cari item yang dimiliki oleh player, return TRUE jika ada
    //salah satu yg menggunakan: pintu untuk mengecek apakah player sudah punya kunci
    public boolean cariItem(String namaItem) {
        for (Item objItem:arrItem) {
             if (namaItem.equals(objItem.getNama())) {
                 return (true);
            }
        }
        return(false); //tidak ketemu
    }

    public void printPlayer() {
        System.out.println("Nama Player:"+nama);
        System.out.println("Kesehatan Player:"+kesehatan);
        System.out.println("Kebahagiaan Player:"+this.kebahagiaan);
    }

    public void printItem() {
        System.out.println("Item milik player");
        int cc = 0;
        for (Item objItem:arrItem) {
            cc++;
            System.out.printf("%d. %s%n",cc,objItem.getNama());
            System.out.println(objItem.getDeskripsi());
        }
    }

    // hapus item di ruangan berdasarkan namanya
    // digunakan saat suatu item diambil oleh player misalnya
    public void hapusItem(Item objItem) {
        this.kebahagiaan -= objItem.getKebahagiaanPower();//Mengurangi kebahagiaan karena item dihapus
        arrItem.remove(objItem);  //buang item

    }


    public void pilihanAksi() {
        System.out.println("**** Pilihan Aksi pada Player *** ");
        //disamakan dengan  ruangan
        //bisa direfactoring nanti supaya tdk duplikasi

        //aksi2 item yang dimiliki player
        int urutPil = 0;  //item
        int subPil;   //aksinya
        System.out.println("Item yang dimiliki player");
        for (Item objItem:arrItem) {
            urutPil++;
            subPil = 0;   //sistem penomorannya 11  12  13 dst
            System.out.println(objItem.getNama());
            //ambil pilihannya
            ArrayList <String> arrPil = objItem.getAksi();
            //print pilihan
            for (String strPil:arrPil) {
                subPil++;
                System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
            }
        }

        //info seputar player
        urutPil++;
        subPil = 0;
        int pilInfoPlayer  = urutPil; //catat untuk pintu
        System.out.println("Info Player");
        //hanya satu
        subPil++;
        System.out.printf("%d%d. info player%n", urutPil, subPil);

        System.out.print("Pilihan anda?");
        String strPil = sc.next();
        System.out.println("--");

        int pil    =  Integer.parseInt(strPil.substring(0,1)); //ambil digit pertama, asumsikan jumlah tidak lebih dari 10
        subPil     =  Integer.parseInt(strPil.substring(1,2)); //ambil digit kedua, asumsikan jumlah tidak lebih dari 10

        if (pil == pilInfoPlayer) {
            printPlayer();
        } else {
            Item objItemPilih = arrItem.get(pil-1);
            objItemPilih.prosesAksi(subPil); //aksi item
        }
//        System.out.println("2. Item milik player");
//        System.out.print("Pilihan anda?");
//        int pil = sc.nextInt();
//        System.out.println("--");
//        if (pil==1) {
//            printPlayer();
//        } else if (pil==2) {
//            printItem();
//        }
    }

    public void setRuanganAktif(Ruangan ruanganAktif) {
        this.ruanganAktif = ruanganAktif;
    }
    public void tambahKesehatan(int value){
        this.kesehatan += value;
    }
    public Ruangan getRuanganAktif() {
        return ruanganAktif;
    }

}
