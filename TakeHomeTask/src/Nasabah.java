// Kelas Nasabah menerapkan prinsip Agregasi (Loose Coupling) terhadap Rekening
public class Nasabah {
    private String nama;
    private String nik;
    // (Agregasi) Menampung referensi objek Rekening eksternal menggunakan Array (Maksimal 3)
    private Rekening[] daftarRekening;
    private int jumlahRekening;

    public Nasabah(String nama, String nik) {
        this.nama = nama;
        this.nik = nik;
        this.daftarRekening = new Rekening[3]; // Batasan kapasitas array
        this.jumlahRekening = 0;
    }

    public String getNama() {
        return nama;
    }

    public String getNik() {
        return nik;
    }

    // Metode untuk menambahkan rekening yang sudah dibuat ke dalam profil nasabah
    public void tambahRekening(Rekening rek) {
        if (jumlahRekening < 3) {
            daftarRekening[jumlahRekening] = rek;
            jumlahRekening++;
            System.out.println("Rekening " + rek.getNomorRekening() + " berhasil ditambahkan ke profil " + this.nama);
        } else {
            System.out.println("Gagal: Profil Nasabah sudah mencapai batas maksimal 3 rekening.");
        }
    }

    // Metode untuk mencari rekening berdasarkan nomor di dalam array profil
    public Rekening cariRekening(String noRek) {
        for (int i = 0; i < jumlahRekening; i++) {
            if (daftarRekening[i].getNomorRekening().equals(noRek)) {
                return daftarRekening[i];
            }
        }
        return null;
    }
}
