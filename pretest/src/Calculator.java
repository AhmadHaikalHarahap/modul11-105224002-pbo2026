public class Calculator {

    public double divide(int pembilang, int penyebut) {
        if (penyebut == 0) {
            throw new ArithmeticException("Penyebut tidak boleh nol.");
        }
        return (double) pembilang / penyebut;
    }
}