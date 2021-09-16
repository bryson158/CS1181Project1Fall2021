import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class GeneticAlgorithm {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Item> items = readData("items.txt");
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

        return chromosomes;
    }
}
