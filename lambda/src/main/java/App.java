import java.util.function.Consumer;
import java.util.function.Function;

public class App {
    public static void main(String[] args) {
        AppendSymbol appendSymbol = string -> {
            StringBuilder stringBuilder = new StringBuilder("*");
            stringBuilder.append(string);
            stringBuilder.append("*");
            System.out.println(stringBuilder.toString());
        };
        Consumer<String> consumer = string -> {
            StringBuilder stringBuilder = new StringBuilder("*");
            stringBuilder.append(string);
            stringBuilder.append("*");
            System.out.println(stringBuilder.toString());
        };
        CalculatorSquare calculatorSquare = number -> number * number;
        Function<Integer, Integer> function = e -> e * e;

        appendSymbolByFunctional("加星号", appendSymbol);
        appendSymbolByConsumer("加星号", consumer);
        System.out.println(squareByFunctional(2, calculatorSquare));
        System.out.println(squareByFunction(2, function));
    }

    @FunctionalInterface
    interface AppendSymbol {
        void print(String string);
    }

    @FunctionalInterface
    interface CalculatorSquare {
        int numberSquare(int number);
    }

    static void appendSymbolByFunctional(String string, AppendSymbol appendSymbol) {
        appendSymbol.print(string);
    }

    static void appendSymbolByConsumer(String string, Consumer<String> consumer) {
        consumer.accept(string);
    }

    static int squareByFunctional(int number, CalculatorSquare calculatorSquare) {
        return calculatorSquare.numberSquare(number);
    }

    static int squareByFunction(int number, Function<Integer, Integer> function) {
        return function.apply(number);
    }
}
