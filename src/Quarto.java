public class Quarto {
    private int numero;
    private String tipo;
    private double precoDiaria;

    public Quarto(int numero, String tipo, double precoDiaria) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoDiaria = precoDiaria;

    }

    public int getNumero() {

        return numero;
    }

    public void setNumero(int numero) {

        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {


        this.tipo = tipo;
    }

    public double getPrecoDiaria() {

        return precoDiaria;
    }

    public void setPrecoDiaria(double precoDiaria) {

        this.precoDiaria = precoDiaria;
    }

    public String toString() {

        return "Número: " + numero + ", Tipo: " + tipo + ", Preço da Diária: R$" + precoDiaria;
    }

}
