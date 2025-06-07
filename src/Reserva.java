import java.util.Date;

public class Reserva {
    private int idReserva;
    private Cliente cliente;
    private Date dataEntrada;
    private Date dataSaida;
    private String status;
    private Pagamento pagamento;
    private int numeroQuarto;

    public Reserva(int idReserva, Cliente cliente, Date dataEntrada, Date dataSaida, String status, Pagamento pagamento, int numeroQuarto) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.status = status;
        this.pagamento = pagamento;
        this.numeroQuarto = numeroQuarto;

    }

    public int getIdReserva() {

        return idReserva;

    }

    public void setIdReserva(int idReserva) {

        this.idReserva = idReserva;

    }

    public Cliente getCliente() {
        return cliente;

    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataEntrada() {
        return dataEntrada;

    }

    public void setDataEntrada(Date dataEntrada) {

        this.dataEntrada = dataEntrada;

    }

    public Date getDataSaida() {

        return dataSaida;

    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;

    }

    public String getStatus() {
        return status;

    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Pagamento getPagamento() {
        return pagamento;
    }


    public void setPagamento(Pagamento pagamento) {

        this.pagamento = pagamento;

    }

    public int getNumeroQuarto() {
        return numeroQuarto;

    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public String toString() {

        return "ID Reserva: " + idReserva + ", Cliente: " + cliente.getNome() + ", Quarto: " + numeroQuarto +
                ", Entrada: " + dataEntrada + ", Saída: " + dataSaida + ", Status: " + status + ", Pagamento: [" + pagamento + "]";
    }

}