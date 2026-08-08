package q1;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

public class URLParser {

    public static void main(String[] args) {

        String urlString =
                "https://api.techstore.com:8443/products/category/electronics"
                + "?sort=price&limit=20#reviews";

        try {
            URL url = new URL(urlString);

            System.out.println("=== URL Components ===");
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());

            System.out.println("Query Parameters:");

            String query = url.getQuery();

            Map<String, String> parameters = new LinkedHashMap<>();

            if (query != null && !query.isEmpty()) {

                String[] pairs = query.split("&");

                for (String pair : pairs) {

                    String[] keyValue = pair.split("=", 2);

                    if (keyValue.length == 2) {
                        parameters.put(keyValue[0], keyValue[1]);
                    }
                }
            }

            for (Map.Entry<String, String> entry : parameters.entrySet()) {

                System.out.println(
                        "  " + entry.getKey() + " = " + entry.getValue()
                );
            }

            System.out.println("Fragment: " + url.getRef());

        } catch (Exception e) {

            System.out.println(
                    "Error parsing URL: " + e.getMessage()
            );
        }
    }
}
