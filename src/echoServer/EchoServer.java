package echoServer;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class EchoServer {





    private static final
    Logger logger = Logger.getLogger
            (EchoServer.class.getName());



    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        int port;

        System.out.println("<porta> ---> ");
        port = entrada.nextInt();


        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("Servidor ECHO iniciado na prota: "
                    + port);


            while (true) {
                new EchoClientHandler(
                        serverSocket.accept()).start();

            }


        } catch (IOException e) {
            logger.log(Level.SEVERE,
                    "Erro ao criar o servidor", e);
            System.exit(1);

        }

    }








}
