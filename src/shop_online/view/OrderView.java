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
        System.out.println("""
                Do you want delivery?
                1 - Yes.
                2 - No.
                """);
        scanner.close();
        return new String[]{name, phone, order};
    }

    public void getOutput(String output) {

        System.out.println(output);
    }
}
