package echoServer;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/*
execute run na classe EchoServer o sistema pedirá a porta, informe..."".
O EchoServer abrirá conexão.

Com o echoServer aberto, abra um novo terminal na classe EchoClient e navegue até a pasta src,
 e para compilar execute:

javac echoserver/EchoServer.java echoserver/EchoClientHandler.java echoserver/EchoClient.java

 depois,incie o EchoClient um novo terminal:

 java -cp . echoServer.EchoClient localhost 12345

 *Obs: 12345 foi a porta informada
 esta porta deve ser a mesma informada após executar o EchoServer
* _______________________________________________________________________________________________________________
*                                                                                             {host, port}     */

@SuppressWarnings("ALL")
public class EchoServer {

    private static final
    Logger logger = Logger.getLogger
            (EchoServer.class.getName());



    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int port;

        System.out.println("<porta> ---> ");
        port = entrada.nextInt();

        /*  Inicializa o servidor na porta especificada.*/
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("Servidor ECHO iniciado na porta: "
                    + port);

            /*


            serverSocket.accept()
            *
            *

            Loop infinito para aceitar conexões de clientes*/
            while (true) {
                // Loop infinito para aceitar conexões de clientes
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
