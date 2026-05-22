// Warisan (Inheritance) dari kelas Rekening
public class RekeningPrioritas extends Rekening {
    // Batas minimum penarikan yang ketat untuk akun prioritas
    private final double MINIMAL_TARIK = 500000;

    public RekeningPrioritas(String nomorRekening, String namaPemilik, double saldoAwal, String pin) {
        super(nomorRekening, namaPemilik, saldoAwal, pin);
    }

    // Overriding metode tarik dengan bebas biaya admin namun syarat nominal minimum ketat
    @Override
    public void tarik(double jumlah) {
        // Validasi aturan bisnis minimum penarikan
        if (jumlah < MINIMAL_TARIK) {
            System.out.println("Transaksi Gagal: Batas penarikan minimum akun Prioritas adalah Rp" + MINIMAL_TARIK);
            return;
        }

        // Cek kecukupan saldo (Tanpa potongan biaya admin)
        if (this.saldo >= jumlah) {
            this.saldo -= jumlah;
            this.mutasi.catatLog("Penarikan Prioritas (Bebas Admin): Rp" + jumlah);
            System.out.println("Penarikan prioritas berhasil! Bebas biaya admin.");
        } else {
            System.out.println("Transaksi Gagal: Saldo tidak mencukupi.");
        }
    }
}
