package expression;

import java.util.Objects;

public final class Const implements ElementOfExpression {
    private Number value;

    public Const(Number value) {
        this.value = value;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public int evaluate(int x) {
        return value.intValue();
    }

    @Override
    public String toMiniString() {
        return toString();
    }

    @Override
    public boolean isImportant() {
        return false;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Const)) return false;
        Const aConst = (Const) o;
        return Objects.equals(value, aConst.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value) * 31;
    }

    @Override
    public double evaluate(double x) {
        return value.doubleValue();
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return value.intValue();
    }
}
