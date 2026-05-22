// Kelas independen yang berinteraksi dengan Nasabah via Asosiasi Umum
public class CustomerService {
    private String namaCS;

    public CustomerService(String namaCS) {
        this.namaCS = namaCS;
    }

    // (Metode Asosiasi) Menerima objek Nasabah sebagai parameter tanpa memilikinya
    public void layaniKeluhan(Nasabah nasabah, String keluhan) {
        System.out.println("\n[Customer Service - " + namaCS + "] Melayani Nasabah: " + nasabah.getNama());
        System.out.println("[Keluhan Diterima]: \"" + keluhan + "\"");
        System.out.println("[Solusi CS]: Keluhan Anda telah dicatat oleh sistem pusat NeoBank dan akan segera diproses.");
    }
}
