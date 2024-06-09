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

    public void run(){
        try(InputStream in = clientSocket.getInputStream();
            OutputStream out = clientSocket.getOutputStream()){
                String inputLine;
                BufferedReader reader = new BufferedReader
                        (new InputStreamReader(in));
                PrintWriter writer = new PrintWriter(out, true);
                while ((inputLine = reader.readLine())!= null) {
                    logger.info("Recebido: ");
                    writer.println(inputLine);
                }


        }catch (IOException e) {
            logger.log(Level.SEVERE, "Erro ao receber mensagem", e);
        }finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Erro ao fechar conexão", e);
            }

        }
    }
}
