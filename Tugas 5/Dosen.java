public class Dosen {
    private String nama;
    
    public Dosen(String nama) {
        this.nama = nama;
    }
    
    public String getName() {
        return nama;
    }

    @Override
    public String toString() {
        return nama;
    }
}
