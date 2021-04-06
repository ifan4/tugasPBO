import java.util.ArrayList;

public class ItemPintu extends Item{

    public ItemPintu(String nama) {
        super(nama);//Memanggil pada parent yaitu pada class item
        super.arrAksi.add("Deskripsi Item");
        super.arrAksi.add("Buka Item");
    }

    @Override//Overiding method yang sudah ada dengan modifikasi untuk Item Pintu
    public void prosesAksi(int pil) {
        if (pil==1)printDescription();
        else if (pil==2){
            if (objGameInfo.getObjPlayer().cariItem("Kunci")) {
                System.out.println("Player menggunakan kunci untuk membuka pintu dan pintu terbuka!");


                objGameInfo.setGameOver(true);
            }
            else System.out.println("Player mencboa membuka pintu. TERKUNCI!");
        }
    }

    @Override
    public ArrayList<String> getAksi() {
        return (arrAksi);
    }
}