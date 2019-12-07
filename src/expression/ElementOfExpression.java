package expression;

public interface ElementOfExpression extends Expression, DoubleExpression, TripleExpression {
    int getPriority();
    String toMiniString();
    boolean isImportant();
}
