*****RESERVA DE HOTEL*****

Olá professor Montanha! Este é o README do trabalho final da A3 da diciplina de programação de soluções computacionais!

Os alunos envolvidos na elaboração do programa e do Diagrama de Classes são:

- Pedro Freitas Rufino (RA - 1242022027).
- Vinícius Freitas dos Anjos ( RA - 125111401428).

Bom, este é um sistema simples feito para ajudar a gerenciar o funcionamento do hotel. O programa atua na organização dos clientes, quartos e reservas que acontecem no hotel!

O programa foi escrito em java e tem a sua funcionalidade o mais simplificada possível. O sistema é capaz de:
- Cadastrar novos clientes, guardando seus dados como: CPF, telefone e email.
- Cadastrar Hotéis, registrando seu nome, endereço e telefone. (Essa função é importante caso o proprietário ho hotel queira abrir um novo hotel em uma nova cidade ou bairro. Ele pode utilziar do mesmo sistema!)
- Cadastrar quartos, registrando os quartos que o hotél possui, seus respectivos números, preço da diária e tipo de quarto (Se é de solteiro, casal ou outro.)
- O programa é capaz de fazer reservas também! É possível ligar um cliente a um quarto por um determinado período, detalhando o pagamento e status da reserva.
- É possível editar as reservas, mudadndo as datas ou o status de uma reserva que já existe.
- Apagar reservas! caso seja necessário, é possível cancelar uma reserva.
- Apagar clientes! caso necessário, o sistema consegue remover um cliente juntamente com todas as reservas que ele tiver feito.
- O programa é capaz de listar todas as informações, mostrando todos os clientes, hotéis, quartos e reservas que foram registrados nele.
- Salvar e carregar dados! Todos as informações são salvas em um arquivo de texto, desta forma o usuário do sistema não perde nada quando fechar o programa, e pode continuar sempre de onde parou!

***Como usar o programa?***

O programa foi escrito para ser o mais simples e intuitivo para o usuário. para utiliza-lo basta compilar o código na sua IDE de preferência e executar a classe "Menu"! Após isso você verá um menu com várias opções (Cadastrar Cliente, Fazer Reserva, etc.). Basta escolher o número da opção desejada e confirmar apertando Enter!

***Como o código está organizado?***

O código está dividido em várias Classes escritas em Java, cada uma com uma função específica.

- A classe "Menu" é a classe principal desse código, como se fosse o cérebro do programa. Ele que quando executado mostra o menu na tela, recebe o que você digita e chama as outras partes do programa para fazer o que você pediu.
- A classe "Cliente" cuida de tudo relacionado aos clientes. Nessa classe fica as informações de cada cliente e como podemos pegá-las ou modifica-las.
- A classe "Hotel" guarda as informações de cada hotel.
- A classe "Quarto" é importante para gerenciar os quartos, seu tipo e a diária de cada um.
- A classe "Pagamento" lida com os detalhes de pagamentos de uma reserva, como: valores, forma de pagamento e data.
- A classe "Reserva" reúne todas as informações de uma reserva: qual cliente, qual quarto, datas de entrada e saída, status e o pagamento.
- A classe "Arquivo" é fundamental para que nada se perca no código, ele salva e carrega todas as informações em um arquivo de texto.