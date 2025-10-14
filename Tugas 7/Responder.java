import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class Responder {
    private final HashMap<String, String> responseMap;
    private final ArrayList<String> defaultResponses;
    private final Random random;

    public Responder() {
        responseMap = new HashMap<>();
        defaultResponses = new ArrayList<>();
        random = new Random();

        fillResponseMap();
        fillDefaultResponses();
    }

    public String generateResponse(String input) {
        String[] words = input.split("\\s+");

        for (String word : words) {
            if (responseMap.containsKey(word)) {
                return responseMap.get(word);
            }
        }

        return getRandomDefaultResponse();
    }

    private void fillResponseMap() {
        responseMap.put("lambat", "Coba tutup program yang tidak diperlukan atau restart komputer Anda.");
        responseMap.put("lemot", "Coba restart komputer Anda, atau periksa apakah hard disk penuh.");
        responseMap.put("wifi", "Pastikan Anda terhubung ke jaringan WiFi yang benar dan sinyalnya cukup kuat.");
        responseMap.put("internet", "Periksa koneksi kabel modem dan router Anda, lalu coba restart perangkatnya.");
        responseMap.put("layar", "Pastikan kabel monitor terpasang dengan benar dan layar menyala.");
        responseMap.put("error", "Bisa kirimkan pesan error-nya? Itu akan membantu saya memberikan solusi.");
        responseMap.put("printer", "Periksa koneksi kabel printer dan pastikan ada kertas serta tinta yang cukup.");
        responseMap.put("cetak", "Pastikan printer menyala dan terhubung. Coba lakukan test print sederhana.");
        responseMap.put("keyboard", "Periksa apakah keyboard tersambung dengan baik atau coba di port USB lain.");
        responseMap.put("mouse", "Pastikan mouse tersambung dengan baik. Jika wireless, cek baterainya.");
    }

    private void fillDefaultResponses() {
        defaultResponses.add("Hmm... saya belum yakin dengan masalah itu. Bisa dijelaskan lebih detail?");
        defaultResponses.add("Coba ulangi langkah terakhir sebelum error terjadi.");
        defaultResponses.add("Masalah ini cukup umum. Coba restart perangkat Anda dulu.");
        defaultResponses.add("Saya sarankan menghubungi teknisi jika masalah berlanjut.");
        defaultResponses.add("Bisa coba gunakan kata kunci lain agar saya bisa membantu lebih tepat.");
    }


    private String getRandomDefaultResponse() {
        int index = random.nextInt(defaultResponses.size());
        return defaultResponses.get(index);
    }
}
