package server.impl;

import server.MyServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import static constant.ServerConstant.EXIT_KEY_WORD;
import static constant.ServerConstant.SERVER_PORT;

public class MyServerImpl implements MyServer {

    private static Logger log = Logger.getLogger(MyServerImpl.class.getName());

    @Override
    public void run() throws Exception {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        Socket socket = serverSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String message;
        while ((message = in.readLine()) != null) {
            if (message.equalsIgnoreCase(EXIT_KEY_WORD)) {
                break;
            }
            out.println("server answer: " + message);
            log.info(message);
        }
        out.close();
        in.close();
        socket.close();
        serverSocket.close();
    }
}
