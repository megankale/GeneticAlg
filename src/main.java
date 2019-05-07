
import java.io.IOException;
import java.io.PrintWriter;

public class main {

    public static void main(String[] args) throws IOException {
        PrintWriter outBF = new PrintWriter(args[1]);
        
        BruteForce bf = new BruteForce(args[0], outBF);
        GeneticAlg ga = new GeneticAlg(args[0]);
        
        outBF.close();
    }
    }

