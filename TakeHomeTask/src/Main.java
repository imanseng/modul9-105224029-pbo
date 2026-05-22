import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Inisialisasi objek CustomerService untuk simulasi Asosiasi
        CustomerService csNeo = new CustomerService("Siti");
        
        // Referensi global untuk menampung objek runtime
        Nasabah nasabahAktif = null;
        
        // Variabel penampung independen di Bank Data Pusat (Pembuktian Agregasi)
        Rekening dataPusatRekening1 = null; 

        boolean berjalan = true;
        while (berjalan) {
            System.out.println("\n== MENU UTAMA ==");
            System.out.println("1. Registrasi Profil Nasabah");
            System.out.println("2. Buka Rekening Baru");
            System.out.println("3. Simulasi Login & Transaksi (Setor/Tarik/Mutasi)");
            System.out.println("4. Hubungi Customer Service");
            System.out.println("5. Keluar & Jalankan Simulasi Penghancuran Akun Paksa");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Nasabah: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NIK Nasabah: ");
                    String nik = scanner.nextLine();
                    nasabahAktif = new Nasabah(nama, nik);
                    System.out.println("Profil Nasabah Berhasil Dibuat!");
                    break;

                case 2:
                    if (nasabahAktif == null) {
                        System.out.println("Silakan registrasi nasabah terlebih dahulu di Menu 1.");
                        break;
                    }
                    System.out.print("Masukkan Nomor Rekening Baru: ");
                    String noRek = scanner.nextLine();
                    System.out.print("Masukkan PIN Akun: ");
                    String pin = scanner.nextLine();
                    System.out.print("Masukkan Setoran Awal: Rp");
                    double saldoAwal = scanner.nextDouble();
                    System.out.println("Pilih Jenis Rekening:\n1. Reguler (Biaya Admin Rp5.000)\n2. Prioritas (Bebas Admin, Min Tarik Rp500.000)");
                    int jenis = scanner.nextInt();

                    Rekening rekBaru = null;
                    if (jenis == 1) {
                        rekBaru = new RekeningReguler(noRek, nasabahAktif.getNama(), saldoAwal, pin);
                    } else if (jenis == 2) {
                        rekBaru = new RekeningPrioritas(noRek, nasabahAktif.getNama(), saldoAwal, pin);
                    }

                    if (rekBaru != null) {
                        nasabahAktif.tambahRekening(rekBaru);
                        if (dataPusatRekening1 == null) {
                            dataPusatRekening1 = rekBaru; 
                        }
                    }
                    break;

                case 3:
                    if (nasabahAktif == null) {
                        System.out.println("Silakan registrasi nasabah terlebih dahulu di Menu 1.");
                        break;
                    }
                    System.out.print("Masukkan Nomor Rekening Anda: ");
                    String cariNo = scanner.nextLine();
                    Rekening rekTujuan = nasabahAktif.cariRekening(cariNo);

                    if (rekTujuan != null) {
                        System.out.print("Masukkan PIN Anda: ");
                        String inputPin = scanner.nextLine();
                        
                        if (rekTujuan.verifikasiPIN(inputPin)) {
                            System.out.println("Login Rekening Berhasil!");
                            System.out.println("1. Setor Tunai\n2. Tarik Tunai\n3. Cetak Histori Mutasi");
                            int aksi = scanner.nextInt();
                            
                            if (aksi == 1) {
                                System.out.print("Nominal Setor: Rp");
                                double nominal = scanner.nextDouble();
                                rekTujuan.setor(nominal); // Memicu mutasi internal
                            } else if (aksi == 2) {
                                System.out.print("Nominal Tarik: Rp");
                                double nominal = scanner.nextDouble();
                                rekTujuan.tarik(nominal); // Memicu polimorfisme & mutasi internal
                            } else if (aksi == 3) {
                                rekTujuan.lihatMutasi();
                            }
                        } else {
                            System.out.println("Otorisasi Gagal: PIN Salah!");
                        }
                    } else {
                        System.out.println("Rekening tidak ditemukan pada profil nasabah ini.");
                    }
                    break;

                case 4:
                    if (nasabahAktif == null) {
                        System.out.println("Silakan registrasi nasabah terlebih dahulu di Menu 1.");
                        break;
                    }
                    System.out.print("Tuliskan keluhan Anda ke CS: ");
                    String keluhan = scanner.nextLine();
                    csNeo.layaniKeluhan(nasabahAktif, keluhan);
                    break;

                case 5:
                    berjalan = false;
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        // Skenario Penutupan Akun, Menghapus total profil nasabah dari memori
        nasabahAktif = null; 
        System.out.println("Variabel 'nasabahAktif' telah di-set menjadi null.");

        /* 
        1. BUKTI AGREGASI (Loose-Coupling Lifecycle):
            - Ketika profil 'nasabahAktif' dihancurkan secara paksa (di-set menjadi null), objek Rekening yang berada di dalamnya TIDAK IKUT MUSNAH dari sistem pusat.
            - Terbukti di bawah ini, variabel 'dataPusatRekening1' yang menangkap referensi objek Rekening tersebut sejak awal masih berfungsi, valid, dan dapat diakses mandiri.
        2. BUKTI KOMPOSISI (Strict/Strongly-Coupled Lifecycle):
            - Di sisi lain, mari kita tinjau objek 'BukuMutasi' yang terbungkus di dalam 'dataPusatRekening1'. 
            - Jika variabel 'dataPusatRekening1' di-set ke null (dihancurkan total), maka objek 'BukuMutasi' yang diinstansiasi di dalam constructor-nya akan otomatis ikut mati dan disapu oleh Garbage Collector tanpa sisa, karena ia tidak memiliki referensi eksternal independen di luar siklus hidup objek Rekening induknya.
         */

        // pembuktian prinsip Agregasi di terminal:
        if (dataPusatRekening1 != null) {
            System.out.println("Meskipun Profil Nasabah telah dihapus dari memori, Rekening dengan nomor: " + dataPusatRekening1.getNomorRekening() + " tetap eksis di bank data pusat!");
            System.out.println("Saldo aman tersimpan di server sebesar: Rp" + dataPusatRekening1.getSaldo());
        }
        scanner.close();
    }
}
