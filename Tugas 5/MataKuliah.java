public class MataKuliah {
    private int id;
    private String nama;
    private String jam;       
    private Dosen dosen;
    private int kapasitas;   
    private int jumlah;       

    public MataKuliah(int id, String nama, String jam, Dosen dosen) {
        this.id = id;
        this.nama = nama;
        this.jam = jam;
        this.dosen = dosen;
        this.kapasitas = 10; 
        this.jumlah = 0;  
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getJam() {
        return jam;
    }

    public Dosen getDosen() {
        return dosen;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public boolean tambahMahasiswa() {
        if (jumlah < kapasitas) {
            jumlah++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return id + ". " + nama + " (" + jam + ") - Dosen: " + dosen.getName() +
               " [" + jumlah + "/" + kapasitas + "]";
    }
}
