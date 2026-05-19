// Entitas independen yang diproduksi terpisah
public class Ban {
    private String merk;
    private int ukuranRing;

    public Ban(String merk, int ukuranRing) {
        this.merk = merk;
        this.ukuranRing = ukuranRing;
    }

    public String getSpesifikasi() {
        return "Merk: " + merk + ", Ring: " + ukuranRing;
    }
}
