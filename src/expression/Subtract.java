package expression;

public final class Subtract extends BinaryOperations {
    public Subtract(ElementOfExpression firstExpression, ElementOfExpression secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public int getPriority() {
        return 6;
    }

    @Override
    String operationToString() {
        return " - ";
    }

    public int getResultOfOperation(int first, int second) {
        return first - second;
    }
}
