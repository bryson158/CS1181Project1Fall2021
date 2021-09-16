public class Item {
    private final String name;
    private final double weight;
    private final int value;
    private boolean included;

    //Constructor for the item class
    public Item(String name, double weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    //Makes this item the same as another item's
    public Item(Item other){
        this.name = other.name;
        this.weight = other.weight;
        this.value = other.value;
    }

    public String getName() {
        return name;
    }

    public double getWeight(){
        return weight;
    }

    public boolean isIncluded(){
        return included;
    }

    public int getValue(){
        return value;
    }

    @Override
    public String toString() {
        return name + " (" + weight + " lbs, $" + value + ")";
    }
}
