package server.impl;

import dto.Response;
import server.MyServer;
import service.RequestProcessor;
import service.impl.RequestProcessorImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import static constant.MessageConstant.SERVER_RESPONSE_PREFIX_MESSAGE;
import static constant.MessageConstant.SERVER_START_MESSAGE;
import static constant.ServerConstant.EXIT_KEY_WORD;
import static constant.ServerConstant.SERVER_PORT;

public class MyServerImpl implements MyServer {

    private static Logger log = Logger.getLogger(MyServerImpl.class.getName());

    private RequestProcessor requestProcessor = new RequestProcessorImpl();

    @Override
    public void run() throws Exception {
        System.out.println(SERVER_START_MESSAGE);
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        Socket socket = serverSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String message;
        while ((message = in.readLine()) != null) {
            if (message.equalsIgnoreCase(EXIT_KEY_WORD)) {
                break;
            }
            Response response = requestProcessor.processRequest(message);
            out.println(SERVER_RESPONSE_PREFIX_MESSAGE + response.toString());
            log.info(response.toString());
        }
        out.close();
        in.close();
        socket.close();
        serverSocket.close();
    }
}
