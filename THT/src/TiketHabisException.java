public class TiketHabisException extends Exception {

    public TiketHabisException(String namaKereta, int sisaKursi) {
        super("Tiket kereta " + namaKereta +
              " tidak mencukupi. Sisa kursi: " + sisaKursi);
    }
}