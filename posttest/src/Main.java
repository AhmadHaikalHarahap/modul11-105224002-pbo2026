public class Main {
    public static void main(String[] args) {

        AkunBank nasabah = new AkunBank("123456789", 5000000);
        AkunBank tujuan = new AkunBank("987654321", 1000000);

        try {
            System.out.println("=== TRANSAKSI ATM DIGITAL ===");
            nasabah.tarikTunai(3000000);
            nasabah.transfer(tujuan, 1000000);
            nasabah.transfer(tujuan, 3000000);
            nasabah.transfer(tujuan, 11000000);

        } catch (SaldoTidakCukupException e) {
            System.out.println("ERROR SALDO : " + e.getMessage());

        } catch (BatasTransferHarianException e) {
            System.out.println("ERROR LIMIT : " + e.getMessage());

        } catch (Exception e) {
            System.out.println("ERROR UMUM : " + e.getMessage());

        } finally {
            System.out.println("\nSesi transaksi ATM Anda telah berakhir.");
            System.out.println("Kartu dikeluarkan otomatis.");
        }
    }
}