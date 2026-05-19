public class Ruangan {
    private String noRegistrasi;
    private int kapasitasMaksimal;

    public Ruangan(String noRegistrasi, int kapasitasMaksimal) {
        this.noRegistrasi = noRegistrasi;
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }

    public String getNoRegistrasi() {
        return noRegistrasi;
    }
}
