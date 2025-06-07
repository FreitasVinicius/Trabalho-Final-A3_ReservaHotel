import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Menu {
    static Scanner input = new Scanner(System.in);

    static List<Cliente> clientes = new ArrayList<>();
    static List<Hotel> hoteis = new ArrayList<>();

    static List<Quarto> quartos = new ArrayList<>();

    static List<Reserva> reservas = new ArrayList<>();
    static final String arquivoDados = "dados.txt";
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        Arquivo.carregarTudo(arquivoDados, clientes, hoteis, quartos, reservas);

        int opcao = 0;
        do {
            System.out.println("\nMenu Principal");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Hotel");
            System.out.println("3 - Cadastrar Quarto");
            System.out.println("4 - Fazer Reserva");
            System.out.println("5 - Editar Reserva");
            System.out.println("6 - Apagar Reserva");
            System.out.println("7 - Apagar Cliente");
            System.out.println("8 - Listar Registros Salvos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1: cadastrarCliente(); break;
                case 2: cadastrarHotel(); break;
                case 3: cadastrarQuarto(); break;
                case 4: fazerReserva(); break;
                case 5: editarReserva(); break;
                case 6: apagarReserva(); break;
                case 7: apagarCliente(); break;
                case 8: listarRegistros(); break;

                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida!");
            }

            Arquivo.salvarTudo(arquivoDados, clientes, hoteis, quartos, reservas);

        } while (opcao != 0);
    }

    static void cadastrarCliente() {
        System.out.print("ID do Cliente: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("CPF: ");
        String cpf = input.nextLine();
        System.out.print("Telefone: ");
        String tel = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();

        clientes.add(new Cliente(id, nome, cpf, tel, email));
        System.out.println("Cliente cadastrado!");
    }

    static void cadastrarHotel() {
        System.out.print("ID do Hotel: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.print("Nome do Hotel: ");
        String nome = input.nextLine();
        System.out.print("Endereço: ");
        String endereco = input.nextLine();
        System.out.print("Telefone: ");
        String telefone = input.nextLine();

        hoteis.add(new Hotel(id, nome, endereco, telefone));
        System.out.println("Hotel cadastrado!");
    }

    static void cadastrarQuarto() {
        System.out.print("Número do Quarto: ");

        int num = Integer.parseInt(input.nextLine());
        System.out.print("Tipo (Solteiro, Casal, etc): ");
        String tipo = input.nextLine();

        System.out.print("Preço da Diária: ");
        double preco = Double.parseDouble(input.nextLine());

        quartos.add(new Quarto(num, tipo, preco));
        System.out.println("Quarto cadastrado!");

    }

    static void fazerReserva() {

        try {

            System.out.print("ID Reserva: ");
            int idReserva = Integer.parseInt(input.nextLine());

            System.out.println("Clientes disponíveis:");
            for (Cliente c : clientes) {
                System.out.println(c.getId() + " - " + c.getNome());
            }
            System.out.print("Escolha o ID do Cliente: ");
            int idCliente = Integer.parseInt(input.nextLine());
            Cliente clienteReserva = null;
            for (Cliente c : clientes) {
                if (c.getId() == idCliente) {

                    clienteReserva = c;
                    break;
                }

            }

            if (clienteReserva == null) {
                System.out.println("Cliente não encontrado!");
                return;
            }

            System.out.println("Quartos disponíveis:");
            for (Quarto q : quartos) {

                System.out.println(q.getNumero() + " - " + q.getTipo() + " - R$" + q.getPrecoDiaria());
            }
            System.out.print("Escolha o número do Quarto: ");

            int numQuarto = Integer.parseInt(input.nextLine());
            Quarto quartoReserva = null;

            for (Quarto q : quartos) {

                if (q.getNumero() == numQuarto) {
                    quartoReserva = q;

                    break;
                }
            }
            if (quartoReserva == null) {
                System.out.println("Quarto não encontrado!");
                return;
            }

            System.out.print("Data de Entrada (dd/MM/yyyy): ");
            Date dataEntrada = sdf.parse(input.nextLine());
            System.out.print("Data de Saída (dd/MM/yyyy): ");
            Date dataSaida = sdf.parse(input.nextLine());
            System.out.print("Status da Reserva: ");
            String status = input.nextLine();

            System.out.print("Valor do Pagamento: ");
            double valor = Double.parseDouble(input.nextLine());
            System.out.print("Forma do Pagamento: ");
            String forma = input.nextLine();
            System.out.print("Data do Pagamento (dd/MM/yyyy): ");
            Date dataPag = sdf.parse(input.nextLine());

            Pagamento pagamento = new Pagamento(valor, forma, dataPag);

            Reserva reserva = new Reserva(idReserva, clienteReserva, dataEntrada, dataSaida, status, pagamento, numQuarto);

            reservas.add(reserva);

            System.out.println("Reserva realizada com sucesso!");


        } catch (Exception e) {

            System.out.println("Erro: " + e.getMessage());
        }

    }

    static void editarReserva() {
        System.out.print("Digite o ID da Reserva que deseja editar: ");

        int id = Integer.parseInt(input.nextLine());

        Reserva reservaEdit = null;
        for (Reserva r : reservas) {

            if (r.getIdReserva() == id) {

                reservaEdit = r;
                break;
            }
        }
        if (reservaEdit == null) {

            System.out.println("Reserva não encontrada!");
            return;
        }

        try {

            System.out.print("Nova Data de Entrada (dd/MM/yyyy): ");
            Date dataEntrada = sdf.parse(input.nextLine());

            System.out.print("Nova Data de Saída (dd/MM/yyyy): ");
            Date dataSaida = sdf.parse(input.nextLine());
            System.out.print("Novo Status da Reserva: ");
            String status = input.nextLine();

            reservas.remove(reservaEdit);
            Reserva novaReserva = new Reserva(reservaEdit.getIdReserva(), reservaEdit.getCliente(), dataEntrada, dataSaida, status, reservaEdit.getPagamento(), reservaEdit.getNumeroQuarto());
            reservas.add(novaReserva);

            System.out.println("Reserva atualizada!");

        } catch (Exception e) {

            System.out.println("Erro: " + e.getMessage());

        }

    }

    static void apagarReserva() {

        System.out.print("Digite o ID da Reserva que deseja apagar: ");
        int id = Integer.parseInt(input.nextLine());

        Reserva reservaDel = null;
        for (Reserva r : reservas) {
            if (r.getIdReserva() == id) {
                reservaDel = r;
                break;

            }
        }

        if (reservaDel != null) {

            reservas.remove(reservaDel);
            System.out.println("Reserva apagada!");
        } else {
            System.out.println("Reserva não encontrada!");
        }
    }

    static void apagarCliente() {
        System.out.print("Digite o ID do Cliente que deseja apagar: ");
        int id = Integer.parseInt(input.nextLine());

        Cliente clienteDel = null;
        for (Cliente c : clientes) {

            if (c.getId() == id) {

                clienteDel = c;
                break;
            }
        }
        if (clienteDel != null) {
            reservas.removeIf(r -> r.getCliente().getId() == id);
            clientes.remove(clienteDel);
            System.out.println("Cliente e suas reservas apagadas!");
        } else {


            System.out.println("Cliente não encontrado!");
        }
    }

    static void listarRegistros() {

        System.out.println("\n== Clientes ==");
        for (Cliente c : clientes) {

            System.out.println(c);


        }
        System.out.println("\n== Hoteis ==");
        for (Hotel h : hoteis) {

            System.out.println(h);

        }
        System.out.println("\n== Quartos ==");
        for (Quarto q : quartos) {

            System.out.println(q);
        }
        System.out.println("\n== Reservas ==");

        for (Reserva r : reservas) {
            System.out.println(r);
        }
    }
}
