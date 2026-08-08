package q6;

public class LifecycleDemo {

    public static void main(String[] args) {

        System.out.println("=== Servlet Container Lifecycle Demonstration ===");

        System.out.println();
        System.out.println("1. Servlet Loading");
        System.out.println("The servlet container loads the servlet class.");

        System.out.println();
        System.out.println("2. Servlet Initialization");
        System.out.println("The container calls init() once.");

        System.out.println();
        System.out.println("3. Request Processing");
        System.out.println("The container calls service() for each client request.");

        System.out.println();
        System.out.println("4. Servlet Destruction");
        System.out.println("The container calls destroy() before removing the servlet.");

        System.out.println();
        System.out.println("=== Container Responsibilities ===");
        System.out.println("• Loading and instantiating servlets");
        System.out.println("• Managing the servlet lifecycle");
        System.out.println("• Receiving HTTP requests");
        System.out.println("• Providing request and response objects");
        System.out.println("• Managing servlet sessions");
        System.out.println("• Destroying servlets when they are no longer needed");
    }
}
