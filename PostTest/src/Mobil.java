public class Mobil {
    private String merkMobil;
    private String warna;
    private Mesin mesin;
    private Ban[] daftarBan;

    public Mobil(String merkMobil, String warna, String tipeMesin, int ccMesin) {
        this.merkMobil = merkMobil;
        this.warna = warna;
        this.mesin = new Mesin(tipeMesin, ccMesin); 
        this.daftarBan = new Ban[4]; 
    }

    public void pasangSetBan(Ban[] setBan) {
        if (setBan.length <= 4) {
            for (int i = 0; i < setBan.length; i++) {
                this.daftarBan[i] = setBan[i];
            }
            System.out.println("Berhasil memasang " + setBan.length + " ban ke mobil.");
        } else {
            System.out.println("Gagal! Jumlah ban melebihi kapasitas maksimal (4).");
        }
    }

    public void tampilkanSpesifikasi() {
        System.out.println("Merk Mobil: " + merkMobil);
        System.out.println("Warna: " + warna);
        mesin.tampilkanDetail();
        for (int i = 0; i < daftarBan.length; i++) {
            if (daftarBan[i] != null) {
                System.out.println("Ban " + (i + 1) + ": " + daftarBan[i].getSpesifikasi());
            } else {
                System.out.println("Ban " + (i + 1) + ": [Kosong]");
            }
        }
    }
}
