public class Mahasiswa {

    private int sksMaksimal;
    private int sisaSks;

    public void setSksMaksimal(int sks) {

        if (sks < 2 || sks > 24) {
            throw new IllegalArgumentException(
                "Kesalahan sistem: Batas SKS tidak valid (harus antara 2 - 24 SKS)!"
            );
        }

        this.sksMaksimal = sks;
        this.sisaSks = sks;
    }

    public void ambilMataKuliah(String namaMatkul, int bebanSks) {

        if (bebanSks > sisaSks) {
            throw new SksTidakCukupException(
                "SKS tidak cukup untuk mengambil mata kuliah "
                + namaMatkul +
                ". Sisa SKS: " + sisaSks
            );
        }

        sisaSks -= bebanSks;

        System.out.println(
            "Berhasil mengambil mata kuliah "
            + namaMatkul +
            " (" + bebanSks + " SKS)"
        );
    }

    public int getSisaSks() {
        return sisaSks;
    }
}