package q5;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TemperatureClient {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            TemperatureService service =
                    (TemperatureService) registry.lookup("TemperatureService");

            double celsius = 25.0;
            double fahrenheit = service.celsiusToFahrenheit(celsius);

            System.out.println("Temperature Conversion:");
            System.out.println(celsius + "°C = " + fahrenheit + "°F");

            double fahrenheitInput = 77.0;
            double celsiusResult =
                    service.fahrenheitToCelsius(fahrenheitInput);

            System.out.println(fahrenheitInput + "°F = "
                    + celsiusResult + "°C");

        } catch (Exception e) {
            System.err.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

