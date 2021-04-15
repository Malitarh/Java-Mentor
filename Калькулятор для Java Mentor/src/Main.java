import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //**************************************************************************************************************
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            String in = scanner.nextLine();
            args = Calculator.commands(in);
            if (RomeNumber.isRomeNumber(args[0])) {
                if (RomeNumber.decode(args[0]) < 1 || RomeNumber.decode(args[0]) > 10 || RomeNumber.decode(args[2]) < 1 || RomeNumber.decode(args[2]) > 10)
                    throw new InputDataException("Входные числа не могут быть больше 10, меньше 1, должны быть целыми и записаны в одном формате (или римские, или арабские цифры).");
            } else {
                if (Integer.decode(args[0]) < 1 || Integer.decode(args[0]) > 10 || Integer.decode(args[2]) < 1 || Integer.decode(args[2]) > 10)
                    throw new InputDataException("Входные числа не могут быть больше 10, меньше 1 и должны быть целыми и записаны в одном формате (или римские, или арабские цифры).");
            }
        }
        //**************************************************************************************************************

        if (RomeNumber.isRomeNumber(args[0]))
            System.out.println(Calculator.calcRome(args));
        else
            System.out.println(Calculator.calcArabic(args));
    }
}
