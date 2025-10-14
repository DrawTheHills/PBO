public class TechSupportSystem {
    private final InputReader reader;
    private final Responder responder;

    public TechSupportSystem() {
        reader = new InputReader();
        responder = new Responder();
    }

    public void start() {
        boolean finished = false;

        printWelcome();

        while (!finished) {
            String input = reader.getInput();

            if (input.equals("selesai") || input.equals("exit")) {
                finished = true;
            } else {
                String response = responder.generateResponse(input);
                System.out.println("\nBot: " + response);
            }
        }

        printGoodbye();
    }

    private void printWelcome() {
        System.out.println("==========================================");
        System.out.println(" Selamat datang di Sistem Bantuan Teknis!");
        System.out.println(" Ketik masalah Anda dan saya akan mencoba membantu.");
        System.out.println(" Ketik 'selesai' atau 'exit' untuk keluar.");
        System.out.println("==========================================");
    }

    private void printGoodbye() {
        System.out.println("\n==========================================");
        System.out.println(" Terima kasih telah menggunakan layanan kami!");
        System.out.println(" Semoga harimu menyenangkan. 😊");
        System.out.println("==========================================");
    }
}
