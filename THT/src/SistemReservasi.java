import java.util.ArrayList;

public class SistemReservasi {

    private ArrayList<Kereta> daftarKereta = new ArrayList<>();

    public SistemReservasi() {

        daftarKereta.add(
            new Kereta("K01",
                    "Argo Bromo",
                    "JKT - SBY",
                    50));

        daftarKereta.add(
            new Kereta("K02",
                    "Parahyangan",
                    "JKT - BDG",
                    15));
    }

    public void tampilkanJadwal() {

        System.out.println("\n=== DAFTAR KERETA ===");

        for (Kereta k : daftarKereta) {
            System.out.println(k);
        }
    }

    public void pesanTiket(
            String kodeKereta,
            String nik,
            String nama,
            int jumlahTiket)

            throws RuteTidakDitemukanException,
                   TiketHabisException {

        if (!nik.matches("\\d{16}")) {
            throw new DataPenumpangTidakValidException(
                    "NIK harus terdiri dari 16 digit angka.");
        }

        Kereta keretaDipilih = null;

        for (Kereta k : daftarKereta) {
            if (k.getKode().equalsIgnoreCase(kodeKereta)) {
                keretaDipilih = k;
                break;
            }
        }

        if (keretaDipilih == null) {
            throw new RuteTidakDitemukanException(
                    "Kode kereta tidak ditemukan.");
        }

        if (jumlahTiket > keretaDipilih.getSisaKursi()) {
            throw new TiketHabisException(
                    keretaDipilih.getNama(),
                    keretaDipilih.getSisaKursi());
        }

        keretaDipilih.kurangiKursi(jumlahTiket);

        System.out.println("\n===== TIKET BERHASIL DIPESAN =====");
        System.out.println("Nama : " + nama);
        System.out.println("NIK  : " + nik);
        System.out.println("Kereta : " + keretaDipilih.getNama());
        System.out.println("Jumlah Tiket : " + jumlahTiket);
    }
}