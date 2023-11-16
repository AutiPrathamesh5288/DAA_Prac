
import java.util.Arrays;
import java.util.Comparator;

class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

class ItemComparator implements Comparator<Item> {
    public int compare(Item item1, Item item2) {
        double ratio1 = (double) item1.value / item1.weight;
        double ratio2 = (double) item2.value / item2.weight;
        return Double.compare(ratio2, ratio1);
    }
}

public class FractionalKnapsack {

    public static double fractionalKnapsack(int capacity, Item[] items) {
        Arrays.sort(items, new ItemComparator());

        double totalValue = 0.0;
        int currentWeight = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                // Take the whole item
                currentWeight += item.weight;
                totalValue += item.value;
            } else {
                // Take a fraction of the item
                int remainingWeight = capacity - currentWeight;
                double fraction = (double) remainingWeight / item.weight;
                totalValue += fraction * item.value;
                break; // Knapsack is full
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        int capacity = 50;
        Item[] items = {
                new Item(10, 60),
                new Item(20, 100),
                new Item(30, 120),
        };

        double maxValue = fractionalKnapsack(capacity, items);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}

