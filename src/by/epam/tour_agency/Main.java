package by.epam.tour_agency;

import by.epam.tour_agency.controller.Controller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String response;
        String request;
        Controller controller = Controller.getInstance();

        while (true) {
            System.out.println("Enter command:");
            Scanner sc = new Scanner(System.in);
            request = sc.nextLine();
            response = controller.executeTask(request);
            if (request.toLowerCase().equals("Exit".toLowerCase())) {
                break;
            }
            System.out.println(response);
        }
    }
}
