import java.util.ArrayList;
import java.util.Random;

public class Chromosome extends ArrayList<Item> implements Comparable<Chromosome>{
    private static Random rng = new Random();

    //Empty constructor
    public Chromosome(){}

    //Constructor for the chromosome class and randomizes if the item is included in the chromosome
    public Chromosome(ArrayList<Item> items){
        for (int i = 0; i < items.size(); i++){
            if(rng.nextInt(10) == 1){
                this.add(new Item(items.get(i)));
                this.get(i).setIncluded(true);
            }
            else {
                this.add(new Item(items.get(i)));
                this.get(i).setIncluded(false);
            }
        }
    }

    //Creates a child chromosome and randomly adds items from one parent or the other
    public Chromosome crossover(Chromosome other){
        for(int i = 0; i < this.size(); i++){
            if (rng.nextBoolean()){
                this.get(i).setIncluded(this.get(i).isIncluded());
            }
            else {
                this.get(i).setIncluded(other.get(i).isIncluded());
            }
        }
        return this;
    }

    //Determines if the chromosome will mutate or not
    public void mutate(){
        for(Item i: this){
            if(rng.nextInt(5) == 1){
                if(i.isIncluded()){
                    i.setIncluded(false);
                }
                else {
                    i.setIncluded(true);
                }
            }
        }
    }

    //Scores the fitness of the chromosome if the chromosome weighs more than 10 pounds the result will be 0
    // otherwise this will return the rounded weight of the chromosome
    public int getFitness(){
        double totalWeight = 0;

        for(Item i: this){
            if(i.isIncluded()){
                totalWeight += i.getWeight();
            }
            if(totalWeight > 10){
                return 0;
            }
        }
        return (int) Math.round(totalWeight);
    }

    //Compares the chromosomes to each other using their fitness scores
    public int compareTo(Chromosome other){
        if(this.getFitness() > other.getFitness()){
            return 1;
        }
        else if(this.getFitness() < other.getFitness()){
            return -1;
        }
        else {
            return 0;
        }
    }

    //Displays all items in the chromosome
    public String toString(){
        String returnedString = "";

        for(Item i: this){
            if(i.isIncluded()){
                returnedString += i.getName() + " " + i.getWeight() + " " + i.getValue() + " ";
            }
        }

        if(returnedString.toString().equals("")){
            return "There's no items in this chromosome";
        }
        return returnedString + this.getFitness();
    }
}
