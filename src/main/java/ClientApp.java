import client.impl.MyClientImpl;

import java.io.IOException;

public class ClientApp {

    public static void main(String[] args) throws IOException {
        try {
            new MyClientImpl().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}