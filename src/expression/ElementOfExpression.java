package expression;

public interface ElementOfExpression extends Expression, DoubleExpression {
    int getPriority();
    String toMiniString();
    boolean isImportant();
}
