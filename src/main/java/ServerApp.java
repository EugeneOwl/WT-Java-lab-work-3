import server.impl.MyServerImpl;

public class ServerApp {

    public static void main(String[] args) {
        try {
            new MyServerImpl().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}