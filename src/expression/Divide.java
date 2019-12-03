package expression;

public final class Divide extends BinaryOperations {
    public Divide(ElementOfExpression firstExpression, ElementOfExpression secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public int getResultOfOperation(int first, int second) {
        return first / second;
    }

    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    String operationToString() {
        return " / ";
    }
}
