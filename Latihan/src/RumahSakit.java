public class RumahSakit {
    private String name;
    private final Ruangan[] daftarRuangan;

    public String getName() {
        return name;
    }

    public RumahSakit(String name, Ruangan[] daftRuangan) {
        this.name = name;
        this.daftarRuangan = new Ruangan[2];
        this.daftarRuangan[0] = daftRuangan[0];
        this.daftarRuangan[1] = daftRuangan[1];
    }

    public void tampilkanRuangan() {
        for (Ruangan ruangan : daftarRuangan) {
            System.out.println("No. Registrasi: " + ruangan.getNoRegistrasi() + " Kapasitas Maksimal: " + ruangan.getKapasitasMaksimal());
        }
    }
}
