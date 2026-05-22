// Interface untuk standarisasi sistem keamanan login
public interface Otorisasi {
    // Metode yang wajib diimplementasikan oleh kelas turunan untuk verifikasi keamanan
    boolean verifikasiPIN(String pin);
}
