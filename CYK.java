import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CYK {
    private Grammar grammar;
    private String input;
    private String[][] matrix;

    public CYK(Grammar grammar, String input) {
        this.grammar = grammar;
        this.input = input;
        matrix = new String[input.length()][input.length()];
    }

    public void solve() {
        for (int i = 0; i < matrix.length; i++) {
            for ( int j =0 ; j <matrix.length; j++){
                matrix[i][j]="";
            }
        }
        for (int i = 0; i < input.length(); i++) {
            String symbol = input.substring(i, i + 1);
            List<String> derivations = grammar.getDerivations(symbol);
            if (derivations.isEmpty()) {
                derivations.add("a");
            }
            matrix[0][i] = String.join(",", derivations);
        }

        for (int i = 1; i < input.length(); i++) {
            for (int j = 0; j < input.length() - i; j++) {
                List<String> cells = new ArrayList<>();
                for (int k = 0; k < i; k++) {
                    List<String> left = Arrays.asList(matrix[k][j].split("->"));
                    List<String> right = Arrays.asList(matrix[i - k - 1][j + k + 1].split("->"));
                    for (String symbol1 : left) {
                        for (String symbol2 : right) {
                            List<String> derivations = grammar.getDerivations(symbol1 + symbol2);
                            if (!derivations.isEmpty()) {
                                cells.addAll(derivations);
                            }
                        }
                    }
                }
                if (cells.isEmpty()) {
                    cells.add("null");
                }
                matrix[i][j] = String.join(",", cells);
            }
        }
    }

    public void displayMatrix() {
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < input.length(); j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public boolean parse() {
        solve();
        return matrix[input.length() - 1][0].contains(grammar.getStartSymbol());
    }
}