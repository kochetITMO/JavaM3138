import expression.*;

public class Main {

    public static void main(String[] args) {
        int x = args.length > 0 ? Integer.parseInt(args[0]) : 0;

        ElementOfExpression expression = new Multiply(
                new Const(1.1),
                new Add(new Variable("x"), new Variable("x"))
        );

        System.out.println(expression.toString());
        System.out.println(expression.toMiniString());
        System.out.println(expression.evaluate(0.0));
    }
}
