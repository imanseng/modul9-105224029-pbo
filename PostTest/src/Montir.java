public class Montir {
    private String idMontir;
    private String nama;

    public Montir(String idMontir, String nama) {
        this.idMontir = idMontir;
        this.nama = nama;
    }

    public void lakukanQualityControl(Mobil m) {
        System.out.println("Montir " + nama + " (ID: " + idMontir + ") sedang memeriksa mobil...");
    }
}
