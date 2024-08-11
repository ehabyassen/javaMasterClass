package academy.learnprogramming;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<>();

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public void modify(String item, String newItem) {
        groceryList.set(groceryList.indexOf(item), newItem);
    }

    public void remove(String item) {
        groceryList.remove(item);
    }

    public String findItem(String item) {
        int i = groceryList.indexOf(item);
        return i >= 0 ? "Found at index " + i : "Not found";
    }

    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in the list.");
        System.out.println(groceryList.stream().collect(Collectors.joining(", ", "[", "]")));
    }
}
