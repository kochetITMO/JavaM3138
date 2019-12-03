import expression.*;

public class Main {

    public static void main(String[] args) {
        int x = args.length > 0 ? Integer.parseInt(args[0]) : 0;

        ElementOfExpression a = new Add(
                new Multiply(
                        new Variable(new String("x")),
                        new Variable("x")
                ),
                new Variable("x")
        );
        ElementOfExpression b = new Add(
                new Variable("x"),
                new Multiply(
                        new Variable("x"),
                        new Variable("x")
                )
        );
        System.out.println(a.equals(b));
        System.out.println(a.toMiniString());
        System.out.println(a.toString());
    }
}
