package expression;

public final class Add extends BinaryOperations {

    public Add(ElementOfExpression firstExpression, ElementOfExpression secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public int getPriority() {
        return 6;
    }

    @Override
    public boolean isImportant() {
        return false;
    }

    @Override
    String operationToString() {
        return " + ";
    }

    @Override
    public int getResultOfOperation(int first, int second) {
        return first + second;
    }

    @Override
    protected double getResultOfOperation(double left, double right) {
        return left + right;
    }
}
