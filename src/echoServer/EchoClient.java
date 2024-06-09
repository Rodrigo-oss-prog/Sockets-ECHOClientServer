package echoServer;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;




public class EchoClient {
   private static final Logger logger =
           Logger.getLogger(EchoClient.class.getName());
   public static void main(String[] args) {
       if(args.length != 2){
           System.err.println("Usage: java echoServer.EchoClient <servidor> <port>");
           System.exit(1);

       }
       String host = args[0];
       int port = Integer.parseInt(args[1]);
       try(Socket socket = new Socket(host, port);
           PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
           BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
           String userInput;
           System.out.println("Conectado ao servidor ECHO na porta: "
                   + port);
           System.out.println("Digite uma mensagem(ou sair par terminar):");
           while ((userInput = stdIn.readLine())!= null) {
               if("sair".equalsIgnoreCase(userInput)) {
               break;}
           }
           logger.info("Eviando: "+ userInput);
           out.println(userInput);
           String response = in.readLine();
           logger.info("Recebido: "+ response);
           System.out.println("ECHO: " + response);

       }catch (IOException e) {
           logger.log(Level.SEVERE, "Erro ao conectar ao servidor", e);
           System.err.println("Erro ao conectar ao servidor: " + e.getMessage());
           System.exit(1);
       }










   }



}
