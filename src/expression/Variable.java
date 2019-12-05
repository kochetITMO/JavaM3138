package expression;

import java.util.Objects;

public final class Variable implements ElementOfExpression {

    private String variable;

    public Variable(String variable) {
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
        return Objects.equals(variable, variable1.variable);
    }

    @Override
    public int hashCode() {
        return variable.hashCode();
    }

    @Override
    public double evaluate(double x) {
        return x;
    }
}
