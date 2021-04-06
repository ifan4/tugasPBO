import java.util.Scanner;

public class GameEngine {
    // user interface game
    Scanner sc = new Scanner(System.in);
    Player objPlayer = new Player();
    Ruangan objRuangan = new Ruangan(); //cuma satu ruangan
    GameInfo objGameInfo = new GameInfo();

    public static void main(String[] args) {
        GameEngine objGameEngine;
        objGameEngine = new GameEngine();
        objGameEngine.mulai();
    }

    //constructor
    public GameEngine() {
        //init ruangannya
        objRuangan.setObjGameInfo(objGameInfo);
        objRuangan.setDeskripsi("Ruangan kecil, dengan satu pintu dan jendela");
        objPlayer.setRuanganAktif(objRuangan);  //set ruangan aktif player
        objPlayer.setObjGameInfo(objGameInfo);

        objGameInfo.setObjPlayer(objPlayer);
        objGameInfo.setObjRuangan(objRuangan);
    }


    private void aksi() {
        System.out.println();
        System.out.println("==============================================");
        System.out.println("1. Aksi yang dapat dilakukan di ruangan");
        System.out.println("2. Aksi terhadap player");
        System.out.println("3. Keluar");
        System.out.println("==============================================");
        System.out.print("Pilihan anda?");
        int pil = sc.nextInt();
        System.out.println("--");
        if (pil==3) {
            objGameInfo.setGameOver(true); //keluar
        } else if (pil==1) {
            objRuangan.pilihanAksi(); //
        } else if (pil==2) {
            objPlayer.pilihanAksi();
        }
    }

    public void mulai() {
        while (!objGameInfo.getGameOver()) {
            aksi();
        }
    }
}
