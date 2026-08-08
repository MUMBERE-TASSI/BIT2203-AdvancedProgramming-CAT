package q5;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TemperatureServer {

    public static void main(String[] args) {
        try {
            TemperatureService service = new TemperatureServiceImpl();

            Registry registry = LocateRegistry.createRegistry(1099);

            registry.rebind("TemperatureService", service);

            System.out.println("Temperature RMI Server is running...");
            System.out.println("Service registered as: TemperatureService");
            System.out.println("Waiting for client requests...");

        } catch (Exception e) {
            System.err.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
