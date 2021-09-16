import java.util.ArrayList;
import java.util.Random;

public class Chromosome extends ArrayList<Item> implements Comparable<Chromosome>{
    private static Random rng;

    //Empty constructor
    public Chromosome(){}

    //Constructor for the chromosome class
    public Chromosome(ArrayList<Item> items){}

    //Logic for determining a crossover between two chromosomes
    public Chromosome crossover(Chromosome other){}

    //Determines if the chromosome will mutate or not
    public void mutate(){}

    //Scores the fitness of the chromosome if the chromosome weighs more than 10 pounds the result will be 0
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
        String returnedString = "";

        for(Item i: this){
            if(i.isIncluded() == true){
                returnedString += i.toString();
            }
        }

        if(returnedString == ""){
            return "There's no items in this chromosome";
        }
        return returnedString;
    }
}
