import java.util.ArrayList;

public class Mahasiswa {
    private String nama;
    private String nrp;
    private ArrayList<MataKuliah> daftarMatkul; 

    public Mahasiswa(String nama, String nrp) {
        this.nama = nama;
        this.nrp = nrp;
        this.daftarMatkul = new ArrayList<>();
    }

    public void ambilMataKuliah(MataKuliah mk) {
        if (daftarMatkul.contains(mk)) {
            System.out.println("# Kelas sudah diambil sebelumnya!");
        } else {
            if (mk.tambahMahasiswa()) {
                daftarMatkul.add(mk);
                System.out.println("# Berhasil mengambil " + mk.getNama());
            } else {
                System.out.println("# Gagal! Kapasitas penuh.");
            }
        }
    }

    public void tampilkanInfo() {
        System.out.println("\n===== DATA MAHASISWA =====");
        System.out.println("Nama : " + nama);
        System.out.println("NRP  : " + nrp);
        if (daftarMatkul.isEmpty()) {
            System.out.println("Belum ambil mata kuliah.");
        } else {
            System.out.println("Mata kuliah yang diambil:");
            for (MataKuliah mk : daftarMatkul) {
                System.out.println("- " + mk.getNama() + " (" + mk.getJam() + 
                                   ") - Dosen: " + mk.getDosen().getName());
            }
        }
    }
}
