package expression;

public final class Multiply extends BinaryOperations {
    public Multiply(ElementOfExpression firstExpression, ElementOfExpression secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public int getResultOfOperation(int first, int second) {
        return first * second;
    }

    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public String operationToString() {
        return " * ";
    }
}
