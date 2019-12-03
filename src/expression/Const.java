package expression;

import java.util.Objects;

public final class Const implements ElementOfExpression {
    private int value;

    public Const(int value) {
        this.value = value;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public int evaluate(int x) {
        return value;
    }

    @Override
    public String toMiniString() {
        return toString();
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Const)) return false;
        Const aConst = (Const) o;
        return value == aConst.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
