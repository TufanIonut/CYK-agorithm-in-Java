import java.util.List;

class Grammar {
    private Derivations derivations;
    private String startSymbol;

    public Grammar() {
        derivations = new Derivations();
    }

    public void setStartSymbol(String symbol) {
        startSymbol = symbol;
    }

    public String getStartSymbol() {
        return startSymbol;
    }

    public void addSymbol(String symbol) {
        derivations.addSymbol(symbol);
    }

    public void addRule(String left, String right) {
        derivations.addRule(left, right);
    }

    public List<String> getSymbols() {
        return derivations.getSymbols();
    }

    public List<List<String>> getRules() {
        return derivations.getRules();
    }

    public boolean isNonTerminal(String symbol) {
        return derivations.isNonTerminal(symbol);
    }

    public List<String> getDerivations(String symbol) {
        return derivations.getDerivations(symbol);
    }
}