package client.impl;

import client.MyClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static constant.MessageConstant.CLIENT_START_MESSAGE;
import static constant.ServerConstant.CLIENT_HOST;
import static constant.ServerConstant.EXIT_KEY_WORD;
import static constant.ServerConstant.SERVER_PORT;

public class MyClientImpl implements MyClient {

    @Override
    public void run() throws Exception {
        System.out.println(CLIENT_START_MESSAGE);
        Socket socket = new Socket(CLIENT_HOST, SERVER_PORT);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        String message, reply;
        while ((message = userInput.readLine()) != null) {
            out.println(message);
            reply = in.readLine();
            System.out.println(reply);
            if (message.equalsIgnoreCase(EXIT_KEY_WORD)) {
                break;
            }
        }
        out.close();
        in.close();
        userInput.close();
        socket.close();
    }
}
