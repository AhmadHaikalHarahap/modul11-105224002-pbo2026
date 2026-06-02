import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Calculator calc = new Calculator();

        try {
            System.out.print("Masukkan angka pertama (pembilang): ");
            int pembilang = input.nextInt();

            System.out.print("Masukkan angka kedua (penyebut): ");
            int penyebut = input.nextInt();

            double hasil = calc.divide(pembilang, penyebut);

            System.out.println("Hasil pembagian = " + hasil);

        } catch (ArithmeticException e) {
            System.out.println("Error: Tidak dapat melakukan pembagian dengan nol!");

        } catch (InputMismatchException e) {
            System.out.println("Error: Input harus berupa angka, bukan huruf atau karakter lain!");

        } finally {
            input.close();
            System.out.println("Proses kalkulasi selesai dan resource memori telah dibersihkan.");
        }
    }
}