public class Main {
    public static void main(String[] args) {
        // 1. Penciptaan 4 ban mandiri
        Ban[] setBanBaru = new Ban[4];
        setBanBaru[0] = new Ban("Michelin", 18);
        setBanBaru[1] = new Ban("Michelin", 18);
        setBanBaru[2] = new Ban("Michelin", 18);
        setBanBaru[3] = new Ban("Michelin", 18);

        // 2. Pembentukan 1 unit mobil (Mesin otomatis tercipta di dalam)
        Mobil mobilPrototipe = new Mobil("Sport V8", "Merah", "Twin-Turbo", 4000);

        // 3. Pemasangan ban ke mobil
        mobilPrototipe.pasangSetBan(setBanBaru);

        // Tampilkan spesifikasi awal
        mobilPrototipe.tampilkanSpesifikasi();

        // 4. Inspeksi kelayakan oleh 1 orang montir
        Montir montirSenior = new Montir("MTR-001", "Budi");
        montirSenior.lakukanQualityControl(mobilPrototipe);

        // 5. Skenario mobil "Gagal" dan dihancurkan (di-set null)
        System.out.println("\n--- PROSES PENGHANCURAN MOBIL ---");
        mobilPrototipe = null; // Objek mobil dan mesin internalnya lepas dari memori

        // Bukti melalui kode dan komentar:
        // A. Mesin ikut musnah:
        // Kode di bawah ini tidak bisa dijalankan (Compile Error) karena objek mobilPrototipe sudah null 
        // dan kita tidak punya referensi langsung ke variabel mesin di luar class Mobil.
        // mobilPrototipe.tampilkanSpesifikasi(); // NullPointerException jika dipaksa jalan.
        System.out.println("[BUKTI] Objek mobil dan mesin internalnya telah dihancurkan bersama.");

        // B. Ban mandiri tetap ada di memori:
        System.out.println("[BUKTI] Entitas ban masih utuh di gudang/memori:");
        for (int i = 0; i < setBanBaru.length; i++) {
            System.out.println("Simpanan Gudang - Ban " + (i + 1) + ": " + setBanBaru[i].getSpesifikasi());
        }
    }
}
