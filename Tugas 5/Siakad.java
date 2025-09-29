import java.util.ArrayList;
import java.util.Scanner;

public class SIAKAD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Dosen[] dosenList = {
            new Dosen("Imam Mustafa, P.hd"),
            new Dosen("Prof. Tohari"),
            new Dosen("Suhadi Lili, P.hd"),
            new Dosen("Steven Birch, P.hd"),
            new Dosen("Sam Altman of OpenAI")
        };

        ArrayList<MataKuliah> listMataKuliah = new ArrayList<>();
        listMataKuliah.add(new MataKuliah(1, "PBO", "Senin 08:00", dosenList[0]));
        listMataKuliah.add(new MataKuliah(2, "Dasar Pemrograman", "Rabu 10:00", dosenList[1]));
        listMataKuliah.add(new MataKuliah(3, "Jaringan Komputer", "Jumat 13:00", dosenList[2]));
        listMataKuliah.add(new MataKuliah(4, "Basis Data", "Kamis 09:00", dosenList[3]));
        listMataKuliah.add(new MataKuliah(5, "Kecerdasan Buatan", "Selasa 11:00", dosenList[4])); 

        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NRP : ");
        String nrp = scanner.nextLine();

        Mahasiswa mhs = new Mahasiswa(nama, nrp);

        String pilihan;
        do {
            System.out.println("\n===== DAFTAR MATA KULIAH =====");
            for (MataKuliah mk : listMataKuliah) {
                System.out.println(mk);
            }

            System.out.print("\nMasukkan ID Mata Kuliah yang ingin diambil: ");
            int idMK = scanner.nextInt();
            scanner.nextLine(); 

            MataKuliah dipilih = null;
            for (MataKuliah mk : listMataKuliah) {
                if (mk.getId() == idMK) {
                    dipilih = mk;
                    break;
                }
            }

            if (dipilih != null) {
                mhs.ambilMataKuliah(dipilih);
            } else {
                System.out.println("-- ID Mata Kuliah tidak ditemukan! -");
            }

            System.out.print("\nApakah ingin mengambil mata kuliah lain? (y/n): ");
            pilihan = scanner.nextLine();

        } while (pilihan.equalsIgnoreCase("y"));

        mhs.tampilkanInfo();

        scanner.close();
    }
}
