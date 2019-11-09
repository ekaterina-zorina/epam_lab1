package by.epam.tour_agency;

import by.epam.tour_agency.controller.Controller;

public class Main {
    public static void main(String[] args) {
        String response;
        Controller controller = Controller.getInstance();

        response = controller.executeTask("sign_in login 314159");
        System.out.println(response);

        response = controller.executeTask("create_tour Minsk Belarus plane 19-11-2019 18:10 01-12-2019 12:15 500");
        System.out.println(response);

        response = controller.executeTask("create_tour Amsterdam Netherlands plane 21-11-2019 23:10 03-12-2019 15:10 520");
        System.out.println(response);

        response = controller.executeTask("update_tour 1 Rome Italy ship 22-12-2019 21:15 02-01-2020 14:15 264");
        System.out.println(response);

        response = controller.executeTask("read_tour 1");
        System.out.println(response);

        response = controller.executeTask("delete_tour 1");
        System.out.println(response);

        response = controller.executeTask("read_tour 1");
        System.out.println(response);

        response = controller.executeTask("remove_tour 4");
        System.out.println(response);
    }
}
