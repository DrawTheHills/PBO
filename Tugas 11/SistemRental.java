import java.util.ArrayList;

public class SistemRental {
    private ArrayList<Kendaraan> daftarKendaraan;
    private ArrayList<Penyewa> daftarPenyewa;

    public SistemRental() {
        daftarKendaraan = new ArrayList<Kendaraan>();
        daftarPenyewa = new ArrayList<Penyewa>();
    }

    public void tambahKendaraan(Kendaraan k) {
        daftarKendaraan.add(k);
    }

    public void tambahPenyewa(Penyewa p) {
        daftarPenyewa.add(p);
    }

    public void tampilkanKendaraan() {
        System.out.println("--- Daftar Kendaraan ---");
        for (Kendaraan k : daftarKendaraan) {
            System.out.println(k.getInfo());
        }
    }

    public void tampilkanPenyewa() {
        System.out.println("\n--- Daftar Penyewa ---");
        for (Penyewa p : daftarPenyewa) {
            System.out.println(p.getInfoPenyewa());
        }
    }

    public static void main(String[] args) {
        SistemRental rental = new SistemRental();

        rental.tambahKendaraan(new Mobil("Toyota", "Avanza", 2020, 4));
        rental.tambahKendaraan(new Motor("Honda", "Vario", 2022, 2));
        rental.tambahKendaraan(new Sepeda("Polygon", "Helios", 2021, "Balap"));

        Penyewa p1 = new Penyewa("Naufal", new Mobil("Honda", "Civic", 2019, 4));
        Penyewa p2 = new Penyewa("Daniel", new Sepeda("United", "Miami", 2023, "BMX"));

        rental.tambahPenyewa(p1);
        rental.tambahPenyewa(p2);

        rental.tampilkanKendaraan();
        rental.tampilkanPenyewa();
    }
}
