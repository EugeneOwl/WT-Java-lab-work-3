import client.impl.MyClientImpl;

public class ClientApp {

    public static void main(String[] args) {
        try {
            new MyClientImpl().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}