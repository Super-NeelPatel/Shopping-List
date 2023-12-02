import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArrayList<Item> list = new ArrayList<>();
        makeMyList(list);

    }

    public static Item makeItemObject(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter item Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter item Quantity: ");
        int quantity = scanner.nextInt();
        System.out.println("Enter item Price: ");
        double price = scanner.nextDouble();
        return new Item(name, quantity, price*quantity);
    }
    public static void addItem(ArrayList<Item> myList){
        Item item = makeItemObject();
        myList.add(item);
    }
    public static void printList(ArrayList<Item> myList){
        System.out.printf("--------------------------------%n");
        System.out.printf("         Shopping List          %n");
        System.out.printf("--------------------------------%n");
        System.out.printf("| %-10s | %-10s | %5s |%n", "ITEM", "QUANTITY", "PRICE");
        for(Item i : myList){
        System.out.printf("| %-10s | %-10s | %5s |%n", i.itemName, i.itemQuantity, "$"+i.itemPrice);
        }
    }
    public static void makeMyList(ArrayList<Item> myList){
        Scanner scanner = new Scanner(System.in);

        addItem(myList);
        int actionCode;
        do{
            System.out.println("\n");
            System.out.println(
                    """ 
                        ++++++++++++++++++++++
                        1. Continue Shopping.\s
                        2. Print List.\s
                        3. Sort by prices.\s
                        4. Remove Item.\s
                        5. Quit shopping list.""");
            System.out.println("\nType your Response: ");
            actionCode = scanner.nextInt();
            switch (actionCode) {
                case 1:
                    addItem(myList);
                    break;
                case 2:
                    printList(myList);
                    break;
                case 3:
                    sortArrayByPrice(myList);
                    break;
                case 4:
                    removeItem(myList);
                    break;
                default:
                    System.out.println("Choose valid action code.");
            }
        }while (actionCode != 5);
    }

    public static void removeItem(ArrayList<Item>myList){
        System.out.println("Please Enter Item name that you want to remove: ");
        Scanner scanner = new Scanner(System.in);
        String itemRemove = scanner.nextLine();
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).itemName.toLowerCase().equals(itemRemove.toLowerCase())){
                myList.remove(i);
                printList(myList);
                break;
            }
        }

        printList(myList);
    }
    public static void sortArrayByPrice(ArrayList<Item> myList){
        for (int i = 0; i < myList.size()-1; i++) {
            for (int j = i+1; j < myList.size(); j++) {
                if (myList.get(i).itemPrice > myList.get(j).itemPrice){
                    Item tempItem = myList.get(i);
                    myList.set(i, myList.get(j));
                    myList.set(j, tempItem);
                }
            }
        }
        printList(myList);
    }
}