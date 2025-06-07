import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Arquivo {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void salvarTudo(String nomeArquivo, List<Cliente> clientes, List<Hotel> hoteis, List<Quarto> quartos, List<Reserva> reservas) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nomeArquivo))) {

            // Salvar Clientes
            for (Cliente c : clientes) {
                pw.println("CLIENTE;" + c.getId() + ";" + c.getNome() + ";" + c.getCpf() + ";" + c.getTelefone() + ";" + c.getEmail());
            }

            // Salvar Hoteis
            for (Hotel h : hoteis) {

                pw.println("HOTEL;" + h.getId() + ";" + h.getNome() + ";" + h.getEndereco() + ";" + h.getTelefone());
            }

            // Salvar Quartos
            for (Quarto q : quartos) {
                pw.println("QUARTO;" + q.getNumero() + ";" + q.getTipo() + ";" + q.getPrecoDiaria());
            }

            // Salvar Reservas
            for (Reserva r : reservas) {

                String dataEntrada = sdf.format(r.getDataEntrada());
                String dataSaida = sdf.format(r.getDataSaida());

                String dataPagamento = sdf.format(r.getPagamento().getDataPagamento());

                pw.println("RESERVA;" + r.getIdReserva() + ";" + r.getCliente().getId() + ";" + r.getNumeroQuarto() + ";" +

                        dataEntrada + ";" + dataSaida + ";" + r.getStatus() + ";" +
                        r.getPagamento().getValor() + ";" + r.getPagamento().getForma() + ";" + dataPagamento);
            }

        } catch (IOException e) {

            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }

    }

    public static void carregarTudo(String nomeArquivo, List<Cliente> clientes, List<Hotel> hoteis, List<Quarto> quartos, List<Reserva> reservas) {

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            // Para ligar reservas aos clientes e pagamentos;
            Map<Integer, Cliente> mapaClientes = new HashMap<>();
            Map<Integer, Quarto> mapaQuartos = new HashMap<>();

            // Limpar listas para evitar duplicação
            clientes.clear();
            hoteis.clear();
            quartos.clear();

            reservas.clear();

            while ((linha = br.readLine()) != null) {

                String[] partes = linha.split(";");
                if (partes[0].equals("CLIENTE")) {

                    int id = Integer.parseInt(partes[1]);
                    String nome = partes[2];

                    String cpf = partes[3];

                    String telefone = partes[4];
                    String email = partes[5];
                    Cliente c = new Cliente(id, nome, cpf, telefone, email);
                    clientes.add(c);
                    mapaClientes.put(id, c);

                } else if (partes[0].equals("HOTEL")) {

                    int id = Integer.parseInt(partes[1]);
                    String nome = partes[2];
                    String endereco = partes[3];
                    String telefone = partes[4];
                    hoteis.add(new Hotel(id, nome, endereco, telefone));

                } else if (partes[0].equals("QUARTO")) {

                    int numero = Integer.parseInt(partes[1]);
                    String tipo = partes[2];
                    double preco = Double.parseDouble(partes[3]);
                    Quarto q = new Quarto(numero, tipo, preco);
                    quartos.add(q);
                    mapaQuartos.put(numero, q);

                } else if (partes[0].equals("RESERVA")) {

                    int idReserva = Integer.parseInt(partes[1]);
                    int idCliente = Integer.parseInt(partes[2]);
                    int numQuarto = Integer.parseInt(partes[3]);
                    Date dataEntrada = sdf.parse(partes[4]);
                    Date dataSaida = sdf.parse(partes[5]);
                    String status = partes[6];
                    double valorPagamento = Double.parseDouble(partes[7]);
                    String formaPagamento = partes[8];
                    Date dataPagamento = sdf.parse(partes[9]);

                    Cliente cliente = mapaClientes.get(idCliente);
                    Pagamento pagamento = new Pagamento(valorPagamento, formaPagamento, dataPagamento);

                    Reserva reserva = new Reserva(idReserva, cliente, dataEntrada, dataSaida, status, pagamento, numQuarto);
                    reservas.add(reserva);
                }

            }

        } catch (FileNotFoundException e) {

        } catch (Exception e) {

            System.out.println("Erro ao carregar arquivo: " + e.getMessage());

        }
    }
}