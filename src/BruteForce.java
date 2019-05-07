import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author megankale
 */
public class BruteForce {

    BruteForce(String inputFile, PrintWriter print) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(inputFile));
        HashSet<Character> universe = new HashSet<Character>();
        char c;

        System.out.println(
                "Elements of DataSet");
        while (sc.hasNextLine()) {
            String current = sc.next();
            if (current.charAt(0) == '[') {
                c = current.charAt(1);
            } else {
                c = current.charAt(0);
            }
            System.out.println(c);
            universe.add(c);
        }

        Set<Set<Character>> result = powerSet(universe);
        print.print("Power Set of Universe:\n ");
        Iterator iterator = result.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            count++;
            if (count % 8 == 0) {
                print.println();
                print.print(iterator.next() + " ");
            } else {
                print.print(iterator.next() + " ");
            }
        }
        print.println();
        print.println();
        print.print("Total Elements in Power Set: " + count);
        
        
        //debugging
        System.out.println(
                "Sorted Universe " + universe);
        System.out.println(
                "Number of Elements in Powerset " + result.size());
    }

    static <T> Set<Set<T>> powerSet(Set<T> set) {
        T[] element = (T[]) set.toArray();
        final int SET_LENGTH = 1 << element.length;
        Set<Set<T>> hittingSet = new HashSet<>();
        for (int binarySet = 0; binarySet < SET_LENGTH; binarySet++) {
            Set<T> subset = new HashSet<>();
            for (int bit = 0; bit < element.length; bit++) {
                int mask = 1 << bit;
                if ((binarySet & mask) != 0) {
                    subset.add(element[bit]);
                }
            }
            hittingSet.add(subset);
        }
        return hittingSet;
    }
}
