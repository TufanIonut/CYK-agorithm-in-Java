import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class test{
public static void main(String[] args) {
    try {
        // read grammar from file
        File grammarFile = new File("grammar.txt");
        BufferedReader grammarReader = new BufferedReader(new FileReader(grammarFile));
        Grammar grammar = new Grammar();
        String line;
        while ((line = grammarReader.readLine()) != null) {
            String[] rule = line.split("->");
            grammar.addSymbol(rule[0].trim());
            grammar.addRule(rule[0].trim(), rule[1].trim());
        }
        grammar.setStartSymbol("S");
        grammarReader.close();
        // read input from file
        File inputFile = new File("input.txt");
        BufferedReader inputReader = new BufferedReader(new FileReader(inputFile));
        String input = inputReader.readLine();
        inputReader.close();
        CYK cyk = new CYK(grammar, input);
        cyk.solve();
        cyk.displayMatrix();
        System.out.println("Accepted? " + cyk.parse());
    } catch (IOException e) {
        System.err.println("An error occurred while reading the files: " + e.getMessage());
    }

}
}