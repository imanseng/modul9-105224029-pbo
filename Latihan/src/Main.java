public class Main {
    public static void main(String[] args) throws Exception {
        Dokter dokter1 = new Dokter("Dokter 1", "Dokter Umum");
        Dokter dokter2 = new Dokter("Dokter 2", "Dokter Gigi");

        Pasien pasien1 = new Pasien("Pasien 1", "20 tahun");
        Pasien pasien2 = new Pasien("Pasien 2", "25 tahun");

        dokter1.periksaPasien(pasien2);

        RumahSakit sehatSelalu = new RumahSakit("RS Sehat Selalu");

        sehatSelalu.addDokter(dokter1);
        sehatSelalu.addDokter(dokter2);

        sehatSelalu.tampilkanRuangan();
        sehatSelalu.daftarDokter();

        sehatSelalu = null;                                                                                                                                                                                                                                                                 
    }
}
