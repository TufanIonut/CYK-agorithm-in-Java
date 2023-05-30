import java.util.ArrayList;
import java.util.List;

class Derivations {
    private List<String> symbols;
    private List<List<String>> rules;

    public Derivations() {
        symbols = new ArrayList<>();
        rules = new ArrayList<>();
    }

    public void addSymbol(String symbol) {
        symbols.add(symbol);
    }

    public void addRule(String left, String right) {
        List<String> rule = new ArrayList<>();
        rule.add(left);
        rule.add(right);
        rules.add(rule);
    }

    public List<String> getSymbols() {
        return symbols;
    }

    public List<List<String>> getRules() {
        return rules;
    }

    public boolean isNonTerminal(String symbol) {
        return !symbols.contains(symbol);
    }

    public List<String> getDerivations(String symbol) {
        List<String> derivations = new ArrayList<>();
        for (List<String> rule : rules) {
            if (rule.get(0).equals(symbol)) {
                derivations.add(rule.get(1));
            }
        }
        return derivations;
    }
}