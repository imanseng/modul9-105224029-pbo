import java.util.ArrayList;

public class RumahSakit {
    private String name;
    private final Ruangan[] daftarRuangan;
    private ArrayList<Dokter> daftarDokter;

    public RumahSakit(String name, Ruangan[] daftRuangan) {
        this.name = name;
        this.daftarRuangan = new Ruangan[2];
        this.daftarRuangan[0] = daftRuangan[0];
        this.daftarRuangan[1] = daftRuangan[1];
    }

    public String getName() {
        return name;
    }

    public void addDokter(Dokter dokter) {
        this.daftarDokter.add(dokter);
    }

    public void daftarDokter() {
        for (Dokter dokter : daftarDokter) {
            System.out.println("Nama Dokter: " + dokter.getName() + " Spesialisasi: " + dokter.getSpesialisasi());
        }
    }

    public void tampilkanRuangan() {
        for (Ruangan ruangan : daftarRuangan) {
            System.out.println("No. Registrasi: " + ruangan.getNoRegistrasi() + " Kapasitas Maksimal: " + ruangan.getKapasitasMaksimal());
        }
    }
}
