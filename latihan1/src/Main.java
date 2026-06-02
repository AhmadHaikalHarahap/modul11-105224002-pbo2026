import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== SOAL 1 =====");

        int[] kuota = new int[3];

        try {

            for (int i = 0; i < kuota.length; i++) {
                System.out.print("Masukkan kuota matkul ke-" + (i + 1) + ": ");
                kuota[i] = input.nextInt();
            }

        } catch (InputMismatchException e) {
            System.out.println(
                "Error: Input harus berupa angka!"
            );
            input.nextLine();
        }

        try {

            for (int i = 0; i < 4; i++) {
                System.out.println(
                    "Kuota indeks " + i + " = " + kuota[i]
                );
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(
                "Error: Indeks array melebihi batas!"
            );
        }

        System.out.println("\n===== SOAL 2 =====");

        Mahasiswa mhs = new Mahasiswa();

        try {

            mhs.setSksMaksimal(30);

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }

        System.out.println("\n===== SOAL 3 =====");

        try {

            mhs.setSksMaksimal(6);

            mhs.ambilMataKuliah("Pemrograman Java", 3);

            mhs.ambilMataKuliah("Basis Data", 5);

        } catch (SksTidakCukupException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }

        System.out.println("\n===== SOAL 4 =====");

        SistemAkademik sistem = new SistemAkademik();

        try {

            sistem.gabungKelas("IF101", 0);

        } catch (KelasPenuhException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }

        System.out.println("\n===== SOAL 5 =====");

        try {

            sistem.cetakDokumenKrs("salah.txt");

        } catch (FileNotFoundException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );

        } finally {

            System.out.println(
                "Sesi Sistem Rencana Studi telah ditutup. Koneksi database diputuskan."
            );
        }

        input.close();
    }
}