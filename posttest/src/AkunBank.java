public class AkunBank {
    private String nomorRekening;
    private double saldo;
    private double totalTransferHarian;

    private final double LIMIT_TRANSFER_HARIAN = 10000000; // 10 juta

    public AkunBank(String nomorRekening, double saldo) {
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
        this.totalTransferHarian = 0;
    }

    public void tarikTunai(double nominal) throws SaldoTidakCukupException {
        if (nominal > saldo) {
            throw new SaldoTidakCukupException(
                    "Saldo tidak mencukupi untuk tarik tunai.");
        }

        saldo -= nominal;
        System.out.println("Tarik tunai berhasil sebesar Rp" + nominal);
    }

    public void transfer(AkunBank tujuan, double nominal)
            throws SaldoTidakCukupException, BatasTransferHarianException {

        if (nominal > saldo) {
            throw new SaldoTidakCukupException(
                    "Saldo tidak mencukupi untuk transfer.");
        }

        if ((totalTransferHarian + nominal) > LIMIT_TRANSFER_HARIAN) {
            throw new BatasTransferHarianException(
                    "Transfer melebihi batas harian Rp10.000.000");
        }

        saldo -= nominal;
        tujuan.saldo += nominal;
        totalTransferHarian += nominal;

        System.out.println("Transfer berhasil sebesar Rp" + nominal +
                " ke rekening " + tujuan.nomorRekening);
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }
}