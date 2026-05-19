public class KomputerServer {
    public Harddisk harddisk; // Untuk composisi
    public Monitor monitors; // Untuk agregasi
    
    // Hubungan komposisi komputer server dengan harddisk
    public KomputerServer(Harddisk harddisk) {
        this.harddisk = harddisk;
    }

    // Hubungan agregasi komputer server dengan monitor
    public void addMonitor(Monitor monitor) {
        this.monitors = monitor;
    }
}

// Penjelasan: Agregasi hubungan antara komputer server dengan monitor adalah hubungan dimana di mana objek-objek yang terhubung bisa hidup sendiri-sendiri secara mandiri. Mereka saling memiliki, tapi tidak saling bergantung untuk bertahan hidup.
// Penjelasan: Komposisi hubungan antara komputer server dengan harddisk adalah hubungan dimana objek-objek yang terhubung tidak bisa hidup sendiri-sendiri secara mandiri. Mereka saling memiliki, dan saling bergantung untuk bertahan hidup.
