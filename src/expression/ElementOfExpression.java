package expression;

public interface ElementOfExpression extends Expression {
    int getPriority();
    String toMiniString();
}
