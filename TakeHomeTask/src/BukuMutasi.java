// Kelas yang mencatat riwayat transaksi, siklus hidupnya terikat penuh dengan Rekening
public class BukuMutasi {
    private String riwayat;

    public BukuMutasi() {
        this.riwayat = "=== LOG MUTASI REKENING AWAL ===\n";
    }

    // Metode untuk menambahkan log aktivitas transaksi
    public void catatLog(String aktivitas) {
        this.riwayat += "- " + aktivitas + "\n";
    }

    // Metode untuk mencetak seluruh histori ke layar terminal
    public void cetakHistori() {
        System.out.println(riwayat);
    }
}
