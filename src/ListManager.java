import java.util.ArrayList;
import java.util.Scanner;

public class ListManager {
    private static ArrayList<String> itemList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            displayMenu();
            String choice = getRegExString("Enter your choice: ", "[AaDdPpQq]");
            switch (choice.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    quit = SafeInput.getYNConfirm(sc,"Are you sure you want to quit? ");
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }

    private static void addItem() {
        String item = getNonEmptyString("Enter the item to add: ");
        itemList.add(item);
        System.out.println("Item added: " + item);
    }

    private static void deleteItem() {
        if (itemList.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        int index = getItemIndex("Enter the number of the item to delete: ", itemList.size());
        String item = itemList.remove(index - 1);
        System.out.println("Item deleted: " + item);
    }

    private static void printList() {
        if (itemList.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("List:");
        for (int i = 0; i < itemList.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, itemList.get(i));
        }
    }

    private static String getNonEmptyString(String prompt) {
        String input = "";
        while (input.isEmpty()) {
            System.out.print(prompt);
            input = sc.nextLine().trim();
        }
        return input;
    }

    private static String getRegExString(String prompt, String regex) {
        String input = "";
        while (!input.matches(regex)) {
            input = getNonEmptyString(prompt);
            if (!input.matches(regex)) {
                System.out.println("Invalid input.");
            }
        }
        return input;
    }

    private static int getItemIndex(String prompt, int maxIndex) {
        int index = SafeInput.getRangedInt(sc,prompt, 1, maxIndex);
        if (index > itemList.size()) {
            System.out.println("Invalid item number.");
            return getItemIndex(prompt, maxIndex);
        }
        return index;
    }
}