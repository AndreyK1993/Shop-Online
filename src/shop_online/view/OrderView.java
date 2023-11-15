// OrderView.java
package shop_online.view;

import java.util.Locale;
import java.util.Scanner;

public class OrderView {

    private final Scanner scanner = new Scanner(System.in);

    public String[] getData() {
        scanner.useLocale(Locale.ENGLISH);
        System.out.print("Enter buyer name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter buyer phone: ");
        String phone = scanner.nextLine().trim();

        System.out.print("Enter order amount: ");
        String order = scanner.nextLine().trim();

        return new String[]{name, phone, order};
    }

    public boolean wantDelivery() {
        System.out.println("Choose delivery option:" +
                "\n1 - Delivery." +
                "\n2 - In-store.");
        int choice = scanner.nextInt();
        return choice == 1;
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
