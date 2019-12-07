package expression;

import java.util.Objects;
import java.util.Set;

public final class Variable implements ElementOfExpression {

    private String variable;

    private Set<String> possibleArg = Set.of(
            "x", "y", "z"
    );

    public Variable(String variable) {
        if (!possibleArg.contains(variable)) {
            throw new IllegalArgumentException("Possible only x, y, z");
        }
        this.variable = variable;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public int evaluate(int x) {
        return x;
    }

    @Override
    public String toMiniString() {
        return variable;
    }

    @Override
    public boolean isImportant() {
        return false;
    }

    @Override
    public String toString() {
        return variable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Variable)) return false;
        Variable variable1 = (Variable) o;
        return variable.equals(variable1.variable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variable);
    }

    @Override
    public double evaluate(double x) {
        return x;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        switch (variable) {
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
            default:
                return 0;
        }
    }
}
