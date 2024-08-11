package academy.learnprogramming;

import java.util.ArrayList;
import java.util.List;

public class Lists {

    public static void main(String[] args) {
//        ArrayList<Object> elements = new ArrayList<>();
//        elements.add(1);
//        elements.add("Ehab");
//        elements.add(new ArrayChallenge());
//        System.out.println(elements);
//
//        System.out.println();
//
//        GroceryList groceryList = new GroceryList();
//        groceryList.addGroceryItem("Pepsi");
//        groceryList.addGroceryItem("Milk");
//        groceryList.addGroceryItem("Water");
//        groceryList.printGroceryList();
//        groceryList.modify("Milk", "Gum");
//        groceryList.printGroceryList();
//        groceryList.remove("Gum");
//        groceryList.printGroceryList();
//        System.out.println(groceryList.findItem("Gum"));
//        System.out.println(groceryList.findItem("Water"));

        List<String> names = List.of("a", "b", "c", "d");
        List<String> strings = new ArrayList<>(names);
        strings.add("e");
        System.out.println(strings);

        Classes s = Classes.valueOf("Saturday");

        System.out.println(s);
        System.out.println(s.name());

        System.out.println(s.equals(Classes.Sunday));
        System.out.println(s.ordinal());

        Classes[] values = Classes.values();
        for (Classes value : values) {
            System.out.println(value);
        }
    }

}
enum Classes {
    Saturday, Sunday
}
