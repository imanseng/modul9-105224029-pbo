// Warisan (Inheritance) dari kelas Rekening
public class RekeningReguler extends Rekening {
    // Biaya admin tetap untuk setiap kali penarikan akun reguler
    private final double BIAYA_ADMIN = 5000;

    public RekeningReguler(String nomorRekening, String namaPemilik, double saldoAwal, String pin) {
        super(nomorRekening, namaPemilik, saldoAwal, pin);
    }

    // Overriding metode tarik dengan aturan biaya admin tetap
    @Override
    public void tarik(double jumlah) {
        double totalTagihan = jumlah + BIAYA_ADMIN;
        if (this.saldo >= totalTagihan) {
            this.saldo -= totalTagihan;
            this.mutasi.catatLog("Penarikan: Rp" + jumlah + " | Admin: Rp" + BIAYA_ADMIN + " | Total: Rp" + totalTagihan);
            System.out.println("Penarikan reguler berhasil (Dipotong admin Rp5.000).");
        } else {
            System.out.println("Transaksi Gagal: Saldo tidak mencukupi untuk penarikan + biaya admin.");
        }
    }
}
