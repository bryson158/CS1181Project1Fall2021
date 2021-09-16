import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GeneticAlgorithm {
    private static Random rng = new Random();

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Item> items = readData("items.txt");

        ArrayList<Chromosome> population = new ArrayList<>(initializePopulation(items, 10));

        //Epochs loop
        for(int i = 0; i < 1000; i++){
            population.sort(Chromosome::compareTo);

            ArrayList<Chromosome> childChromosomes = new ArrayList<>();

            //Creates child chromosomes
            for(int p = 0; p < population.size(); p++){
                childChromosomes.add(population.get(p).crossover(population.get(rng.nextInt(population.size()))));
            }

            for(int p = 0; p < 10; p++){
                population.add(childChromosomes.get(p));
            }

            for(Chromosome c: population){
                if(rng.nextInt(10) == 1){
                    c.mutate();
                }
            }
        }
        population.sort(Chromosome::compareTo);

        System.out.println(population.get(population.size()-1).toString());
    }

    //Reads in the file and adds all the items in the file to an array list
    public static ArrayList<Item> readData(String filename) throws FileNotFoundException{
        File itemsFile = new File(filename);
        Scanner input = new Scanner(new FileReader((itemsFile)));
        input.useDelimiter(",|\\n");

        ArrayList<Item> items = new ArrayList<>();

        while (input.hasNext()){
            String name = input.next();
            Double weight = Double.parseDouble(input.next().trim());
            int value = Integer.parseInt(input.next().trim());
            items.add(new Item(name, weight, value));
        }
        return items;
    }

    //Builds out the initial population of chromosomes
    public static ArrayList<Chromosome> initializePopulation(ArrayList<Item> items, int populationSize){
        ArrayList<Chromosome> chromosomes = new ArrayList<>();

        for(int i = 0; i < populationSize; i++) {
            chromosomes.add(new Chromosome(items));
        }
        return chromosomes;
    }
}
