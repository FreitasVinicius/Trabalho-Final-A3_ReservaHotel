import java.util.Date;

public class Pagamento {
    private double valor;
    private String forma;
    private Date dataPagamento;

    public Pagamento(double valor, String forma, Date dataPagamento) {
        this.valor = valor;
        this.forma = forma;
        this.dataPagamento = dataPagamento;
    }

    public double getValor() {

        return valor;

    }

    public void setValor(double valor) {

        this.valor = valor;
    }

    public String getForma() {
        return forma;

    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public Date getDataPagamento() {

        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String toString() {

        return "Valor: R$" + valor + ", Forma: " + forma + ", Data: " + dataPagamento;
    }
}