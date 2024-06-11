package echoServer;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EchoClientHandler extends Thread{
    private final Socket clientSocket;
    private static final Logger logger =
            Logger.getLogger(EchoClientHandler.class.getName());




    public EchoClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    /*

    * ServerSocket serverSocket = new ServerSocket(port): Inicializa o servidor na porta especificada.
    Socket clientSocket = serverSocket.accept(): Aguarda e aceita uma conexão de cliente.
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true): Cria um stream de saída para enviar dados ao cliente.
    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())): Cria um stream de entrada para ler dados do cliente.
    out.println(inputLine): Envia de volta ao cliente a mesma mensagem recebida (ECHO).
    *
    *


    Logging serve para monitorar e depurar a aplicação, é útil adicionar logging.
    Isso pode ser feito utilizando a classe java.util.logging.Logger

    Exemplo: mensagens capturadas pelo logger
    oi
    vc está ai?
    sair
    jun. 10, 2024 8:43:47 PM echoServer.EchoClient main
    INFO: Eviando: sair
    jun. 10, 2024 8:43:48 PM echoServer.EchoClient main
    INFO: Recebido: sair
    ECHO: sair

    * */

    // Método que será executado quando a thread iniciar
    public void run(){
        try(InputStream in = clientSocket.getInputStream();
            OutputStream out = clientSocket.getOutputStream()){
                String inputLine;
                BufferedReader reader = new BufferedReader

                        (new InputStreamReader(in));
                PrintWriter writer = new PrintWriter(out, true);
                // Loop para ler e ecoar mensagens do cliente

                while ((inputLine = reader.readLine())!= null) {
                    logger.info("Recebido: ");

                    // Envia de volta a mensagem recebida
                    writer.println(inputLine);
                }


        }catch (IOException e) {
            logger.log(Level.SEVERE, "Erro ao receber mensagem", e);
        }finally {
            try {

                // Fecha o socket do cliente
                clientSocket.close();
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Erro ao fechar conexão", e);
            }

        }
    }
}
