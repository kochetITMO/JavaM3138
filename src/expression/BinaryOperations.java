package expression;

import java.util.Objects;

abstract class BinaryOperations implements ElementOfExpression {
    private final ElementOfExpression firstExpression;
    private final ElementOfExpression secondExpression;

    enum Position {
        BEFORE, AFTER
    }

    public BinaryOperations(ElementOfExpression firstExpression, ElementOfExpression secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }

    abstract String operationToString();

    private String addParantheses(ElementOfExpression expression, Position position) {
        if (isNeedToClose(expression, position)) {
            return "(" + expression.toMiniString() + ")";
        } else {
            return expression.toMiniString();
        }
    }

    private boolean isNeedToClose(ElementOfExpression expression, Position position) {
        boolean result = expression.getPriority() > this.getPriority();

        if (result) {
            return true;
        }

        result = position == Position.AFTER &&
                expression.getPriority() == this.getPriority() &&
                (expression.isImportant() || this.isImportant());

        return result;
    }

    @Override
    public String toMiniString() {
        return addParantheses(firstExpression, Position.BEFORE) +
                operationToString() +
                addParantheses(secondExpression, Position.AFTER);
    }

    @Override
    public String toString() {
        return "(" +
                firstExpression.toString() +
                operationToString() +
                secondExpression.toString() +
                ")";
    }

    protected abstract int getResultOfOperation(int left, int right);

    protected abstract double getResultOfOperation(double left, double right);

    @Override
    public int evaluate(int x) {
        return getResultOfOperation(firstExpression.evaluate(x), secondExpression.evaluate(x));
    }

    @Override
    public double evaluate(double x) {
        return getResultOfOperation(firstExpression.evaluate(x), secondExpression.evaluate(x));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof BinaryOperations)) return false;

        BinaryOperations that = (BinaryOperations) o;
        return Objects.equals(firstExpression, that.firstExpression) &&
                this.operationToString().equals(that.operationToString()) &&
                Objects.equals(secondExpression, that.secondExpression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationToString(), firstExpression, secondExpression);
    }
}
