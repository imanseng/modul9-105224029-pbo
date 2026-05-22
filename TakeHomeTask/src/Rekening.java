// Kelas abstrak sebagai bluprint Rekening, mengimplementasikan Interface Otorisasi
public abstract class Rekening implements Otorisasi {
    // Enkapsulasi atribut protected agar hanya bisa diakses internal dan kelas turunan
    protected String nomorRekening;
    protected String namaPemilik;
    protected double saldo;
    protected String pin;
    // (Komposisi) Objek BukuMutasi dideklarasikan secara internal
    protected BukuMutasi mutasi;

    public Rekening(String nomorRekening, String namaPemilik, double saldoAwal, String pin) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldoAwal;
        this.pin = pin;
        // (Komposisi) Instansiasi objek dilakukan langsung di dalam constructor
        // Jika objek Rekening hancur, objek BukuMutasi ini juga otomatis ikut musnah
        this.mutasi = new BukuMutasi();
        this.mutasi.catatLog("Rekening berhasil dibuka dengan Saldo Awal: Rp" + saldoAwal);
    }

    // Getter untuk Nomor Rekening
    public String getNomorRekening() {
        return nomorRekening;
    }

    // Getter untuk Saldo
    public double getSaldo() {
        return saldo;
    }

    // Metode Enkapsulasi untuk menambah saldo
    public void setor(double jumlah) {
        if (jumlah > 0) {
            this.saldo += jumlah;
            this.mutasi.catatLog("Setoran tunai berhasil: +Rp" + jumlah + ". Saldo saat ini: Rp" + this.saldo);
            System.out.println("Setoran berhasil!");
        } else {
            System.out.println("Jumlah setoran tidak valid.");
        }
    }

    // Metode abstrak penarikan yang wajib di-override oleh kelas konkret (Polimorfisme)
    public abstract void tarik(double jumlah);

    // Implementasi metode dari Interface Otorisasi
    @Override
    public boolean verifikasiPIN(String inputPin) {
        return this.pin.equals(inputPin);
    }

    // Metode untuk menampilkan mutasi
    public void lihatMutasi() {
        this.mutasi.cetakHistori();
    }
}
