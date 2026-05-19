public class Dokter {
    private String name;
    private String spesialisasi;
    private Pasien pasien;

    public Dokter(String name, String spesialisasi) {
        this.name = name;
        this.spesialisasi = spesialisasi;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

    public Pasien getPasien() {
        return this.pasien;
    }

    public void periksaPasien(Pasien pasien) {
        System.out.println("Dokter " + this.name + "dengan spesialisasi " + this.spesialisasi + " sedang memeriksa pasien " + pasien.getName() + " dengan umur " + pasien.getUmur());
    }
}
