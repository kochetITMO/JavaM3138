package expression;

import java.util.Objects;

abstract class BinaryOperations implements ElementOfExpression {
    private final ElementOfExpression firstExpression;
    private final ElementOfExpression secondExpression;

    public BinaryOperations(ElementOfExpression firstExpression, ElementOfExpression secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }

    abstract String operationToString();

    //@TODO
    // instantof == ban
    private boolean isNeedToClose() {
        return this.getPriority() == secondExpression.getPriority() &&
                (operationToString().equals(" - ") ||
                        secondExpression instanceof Divide ||
                        this instanceof Divide
                );
    }

    @Override
    public String toMiniString() {
        String firstMiniString = firstExpression.toMiniString();
        String secondMiniString = secondExpression.toMiniString();

        StringBuilder result = new StringBuilder("");
        if (firstExpression.getPriority() > this.getPriority()) {
            result.append("(")
                    .append(firstMiniString)
                    .append(")");
        } else {
            result.append(firstMiniString);
        }

        result.append(operationToString());

        if (secondExpression.getPriority() > this.getPriority() || isNeedToClose()) {
            result.append("(")
                    .append(secondMiniString)
                    .append(")");
        } else {
            result.append(secondMiniString);
        }

        return result.toString();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("(");
        result.append(firstExpression.toString())
                .append(operationToString())
                .append(secondExpression.toString())
                .append(")");
        return result.toString();
    }

    protected abstract int getResultOfOperation(int left, int right);

    public int evaluate(int x) {
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
