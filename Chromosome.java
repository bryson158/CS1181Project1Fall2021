import java.util.ArrayList;
import java.util.Random;

public class Chromosome extends ArrayList<Item> implements Comparable<Chromosome>{
    private static Random rng;

    //Empty constructor
    public Chromosome(){}

    //Constructor for the chromosome class and randomizes if the item is included in the chromosome
    public Chromosome(ArrayList<Item> items){
        for (int i = 0; i < this.size(); i++){
            if(rng.nextInt(10) == 1){
                this.add(new Item(items.get(i)));
                this.get(i).setIncluded(true);
                this.get(i);
            }
            else {
                this.add(new Item(items.get(i)));
                this.get(i).setIncluded(false);
            }
        }
    }

    //Creates a child chromosome and randomly adds items from one parent or the other
    public Chromosome crossover(Chromosome other){
        ArrayList<Item> newChromosome = this;

        for(int i = 0; i < this.size(); i++){
            if (rng.nextBoolean()){
                if(other.get(i).isIncluded()){
                    newChromosome.get(i).setIncluded(true);
                }
                else {
                    newChromosome.get(i).setIncluded(false);
                }
            }
        }
    }

    //Determines if the chromosome will mutate or not
    public void mutate(){
        //50% chance the chromosome will mutate
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

    //Compares the chromosomes to each other
    public int compareTo(Chromosome other){
        return 0;
    }

    //TODO- display all items included in the chromosome
    public String toString(){
        StringBuilder returnedString = new StringBuilder();

        for(Item i: this){
            if(i.isIncluded()){
                returnedString.append(i.toString());
            }
        }

        if(returnedString.toString().equals("")){
            return "There's no items in this chromosome";
        }
        return returnedString.toString();
    }
}
