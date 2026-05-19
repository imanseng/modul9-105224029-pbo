public class Main {
    public static void main(String[] args) {
        Ban[] setBanBaru = new Ban[4];
        setBanBaru[0] = new Ban("Michelin", 18);
        setBanBaru[1] = new Ban("Michelin", 18);
        setBanBaru[2] = new Ban("Michelin", 18);
        setBanBaru[3] = new Ban("Michelin", 18);

        Mobil mobilPrototipe = new Mobil("Sport V8", "Merah", "Twin-Turbo", 4000);

        mobilPrototipe.pasangSetBan(setBanBaru);

        mobilPrototipe.tampilkanSpesifikasi();

        Montir montirSenior = new Montir("MTR-001", "Budi");
        montirSenior.lakukanQualityControl(mobilPrototipe);

        mobilPrototipe = null;

    }
}
