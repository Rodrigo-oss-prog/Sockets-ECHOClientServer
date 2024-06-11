# Introdução aos Conceitos de Redes e Sockets
## Redes de Computadores

  Redes de Computadores: Conjunto de computadores conectados entre si que podem trocar informações e compartilhar recursos.
  Protocolo de Comunicação: Conjunto de regras que define como os dados são transmitidos e recebidos em uma rede.
  O protocolo mais comum é o TCP/IP (Transmission Control Protocol/Internet Protocol).

# Sockets

  Socket: Ponto final de uma conexão de rede. É utilizado para estabelecer a comunicação entre dois dispositivos.
  Servidor: Programa que espera por conexões de clientes e processa suas requisições.
  Cliente: Programa que inicia uma conexão com um servidor para enviar e receber dados.

## Pacotes Utilizados

        java.net: Contém classes para a construção de aplicações de rede. As principais classes que usaremos são:
        ServerSocket: Utilizada pelo servidor para ouvir requisições de clientes.
        Socket: Utilizada tanto pelo cliente quanto pelo servidor para enviar e receber dados.

### Implementação do Servidor ECHO


Passos para Implementar o Servidor:

  Criar uma instância de ServerSocket para ouvir em uma porta específica.
  
  Aguardar conexões de clientes.
  Ler dados enviados pelo cliente.
  Enviar os dados de volta ao cliente (ECHO).
  Fechar a conexão.


  ## Explicação do Código:

    ServerSocket serverSocket = new ServerSocket(port): Inicializa o servidor na porta especificada.
    Socket clientSocket = serverSocket.accept(): Aguarda e aceita uma conexão de cliente.
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true): Cria um stream de saída para enviar dados ao cliente.
    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())): Cria um stream de entrada para ler dados do cliente.
    out.println(inputLine): Envia de volta ao cliente a mesma mensagem recebida (ECHO).

  ####  Implementação do Cliente ECHO


Passos para Implementar o Cliente:

  Criar uma instância de Socket para conectar ao servidor.
  
  Ler dados do teclado.
  Enviar dados ao servidor.
  Receber e imprimir a resposta do servidor.
  Repetir até que o usuário digite um comando de saída.

## Explicação do Código:

    Socket socket = new Socket(serverAddress, port): Conecta ao servidor no endereço e porta especificados.
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true): Cria um stream de saída para enviar dados ao servidor.
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())): Cria um stream de entrada para ler dados do servidor.
    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)): Cria um stream de entrada para ler dados do teclado.
    out.println(userInput): Envia a mensagem digitada pelo usuário ao servidor.
    System.out.println("ECHO: " + in.readLine()): Imprime a resposta do servidor.

## este e Execução da Aplicação
Passos para Testar:

  * Compile ambos os arquivos Java (EchoServer.java e EchoClient.java).
  * Inicie o servidor executando java EchoServer.
  *  Inicie o cliente executando java EchoClient.
  *  Digite mensagens no cliente e veja-as sendo ecoadas de volta pelo servidor.

## Estrutura do Projeto

`````
/meu-projeto
    /src
        /echoserver
            EchoServer.java
            EchoClient.java

`````

# Usando uma IDE

Se você está usando uma IDE como IntelliJ IDEA ou Eclipse, siga estes passos:
## IntelliJ IDEA

    Configurar Argumentos de Execução no EchoClient:
        Abra EchoClient.java.
        Clique com o botão direito e selecione Edit 'EchoClient.main()'.
        No campo Program arguments, insira localhost 12345.
        Clique em OK.

    Executar o EchoServer:
        Abra EchoServer.java.
        Clique com o botão direito e selecione Run 'EchoServer.main()'.

    Executar o EchoClient:
        Abra EchoClient.java.
        Clique com o botão direito e selecione Run 'EchoClient.main()'.

Eclipse

    Configurar Argumentos de Execução no EchoClient:
        Abra EchoClient.java.
        Clique com o botão direito e selecione Run As > Run Configurations....
        Selecione a configuração de execução para EchoClient.
        No campo Program arguments, insira localhost 12345.
        Clique em Apply e depois em Run.

    Executar o EchoServer:
        Abra EchoServer.java.
        Clique com o botão direito e selecione Run As > Java Application.

    Executar o EchoClient:
        Abra EchoClient.java.
        Clique com o botão direito e selecione Run As > Java Application.

Verificação

Certifique-se de que:

    O servidor está em execução antes de iniciar o cliente.
    O cliente está sendo executado com os argumentos corretos (localhost 12345).

Se tudo estiver configurado corretamente, o EchoClient deve se conectar ao EchoServer e solicitar a entrada do usuário.

Se você ainda encontrar problemas, por favor, compartilhe a mensagem de erro específica para que eu possa ajudar a resolver.

### Compilação
````
cd /caminho/para/seu/projeto/src
javac echoserver/EchoServer.java echoserver/EchoClientHandler.java echoserver/EchoClient.java

````

### Execução do Servidor
`````
java echoserver.EchoClient localhost 12345

`````

### Execução do Cliente

````
java echoserver.EchoClient localhost 12345

````

## Explicação do bloco:
````
try (
    Socket socket = new Socket(serverAddress, port);
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
) {

````

  * try: Inicia um bloco de código que vai tentar executar as instruções fornecidas e liberar automaticamente os recursos declarados no final do bloco.
  * Socket socket = new Socket(serverAddress, port);: Cria um socket e conecta-o ao servidor no endereço serverAddress e porta port.
  * Este socket será usado para comunicação entre o cliente e o servidor.
  * PrintWriter out = new PrintWriter(socket.getOutputStream(), true);:
   Cria um PrintWriter para enviar dados para o servidor através do socket.
  * O segundo argumento true ativa o autoflush, o que significa que o PrintWriter irá automaticamente enviar os dados após cada chamada ao método print ou println.
  * BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));:
   Cria um BufferedReader para ler dados enviados pelo servidor através do socket.
    O InputStreamReader converte o fluxo de bytes do socket (InputStream) em um fluxo de caracteres (Reader).
  * BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));:
    Cria um BufferedReader para ler a entrada do usuário a partir do teclado (System.in).
    O InputStreamReader converte o fluxo de bytes da entrada padrão em um fluxo de caracteres.

## Explicação da Linha:
````
private static final Logger logger = Logger.getLogger(EchoClient.class.getName());

````

* private static final Logger logger: Declara uma variável estática e final chamada logger do tipo Logger. A palavra-chave static indica que esta variável pertence à classe, e não a uma instância específica da classe. final indica que a variável não pode ser alterada depois de inicializada.
* Logger.getLogger(EchoClient.class.getName()): Este método estático da classe Logger retorna uma instância de Logger associada ao nome da classe EchoClient.
* Logger: A classe Logger pertence ao pacote java.util.logging e é usada para registrar informações de log.
* getLogger(String name): Método estático que retorna um Logger com o nome especificado. Se um Logger com esse nome já existir, ele será retornado. Caso contrário, um novo Logger será criado.
* EchoClient.class.getName(): Este método retorna o nome completo da classe EchoClient, incluindo o pacote. Isso garante que o Logger esteja associado especificamente a esta classe, o que ajuda a identificar facilmente as mensagens de log no contexto correto.

Propósito

  * Registro de Log: Usar um Logger permite que a aplicação registre mensagens de diferentes níveis de importância (INFO, WARNING, SEVERE, etc.). Isso é útil para depuração, monitoramento, e manutenção da aplicação.
  * Identificação: Ao associar o Logger com o nome da classe (EchoClient), fica fácil identificar de qual parte do código (ou de qual classe) as mensagens de log estão vindo.
  
