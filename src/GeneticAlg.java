import java.io.FileNotFoundException;
import java.util.Random;

public class GeneticAlg {

    GeneticAlg(String inputFile) throws FileNotFoundException {
        int populationSize = 1000;
        Population population = new Population(populationSize);

        while (!population.isDone()) {
            population.generateNewPop();
            System.out.println(population.toString());
        }
        System.out.println("------------Final Phrase--------------");
        System.out.println(population.toString());
    }
}


