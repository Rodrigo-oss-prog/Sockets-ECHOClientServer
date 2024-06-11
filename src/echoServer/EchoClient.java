package echoServer;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;




public class EchoClient {

    // Obtém uma instância de Logger para a classe EchoClient usando o nome completo da classe
    // Logger é usado para registrar mensagens que podem ajudar na depuração e monitoramento
   private static final Logger logger =
           Logger.getLogger(EchoClient.class.getName());
   public static void main(String[] args) {
       if(args.length != 2){
           System.err.println("Usage: java echoServer.EchoClient <servidor> <port>");
           System.exit(1);

       }

       // endereço do servidor
       String host = args[0];

       // porta do servidor
       int port = Integer.parseInt(args[1]);

       // Tenta executar o bloco de código com os recursos declarados
       // Cria um novo socket e conecta ao servidor no endereço e porta fornecidos
       try(Socket socket = new Socket(host, port);

           // Cria um PrintWriter para enviar dados ao servidor.
           // 'true' indica que o fluxo será autoflush (flush automático após cada write)
           PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

           // Cria um BufferedReader para ler dados do servidor.
           // O InputStreamReader é usado para converter o InputStream do socket em um Reader
           BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

           // Cria um BufferedReader para ler a entrada do usuário (teclado).
           // O InputStreamReader é usado para converter o InputStream System.in em um Reader
           BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
           String userInput;
           System.out.println("Conectado ao servidor ECHO na porta: "
                   + port);
           System.out.println("Digite uma mensagem(ou sair para terminar):");

           // Loop para ler mensagens do usuário, enviar ao servidor e exibir a resposta
           while ((userInput = stdIn.readLine())!= null) {

               // Termina o loop se o usuário digitar "sair"
               if("sair".equalsIgnoreCase(userInput)) {
               break;}
           }
           logger.info("Eviando: "+ userInput);
           // Envia a mensagem ao servidor
           out.println(userInput);
           // Lê a resposta do servidor
           String response = in.readLine();
           // Exibe a resposta do servidor
           logger.info("Recebido: "+ response);
           System.out.println("ECHO: " + response);

       }catch (IOException e) {
           logger.log(Level.SEVERE, "Erro ao conectar ao servidor", e);
           System.err.println("Erro ao conectar ao servidor: " + e.getMessage());
           System.exit(1);
       }


       /*No bloco try-with-resources,
       esses recursos (Socket, PrintWriter, BufferedReader) são automaticamente fechados
       ao final do bloco, o que garante que os recursos de rede e I/O
       sejam liberados corretamente sem necessidade de um finally explícito.*/









   }



}
