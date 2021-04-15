public class Calculator {

    static String[] commands(String s) {
        return s.split(" ");
    }

    static String calcRome(String[] commands) {
        int result;
        if (!RomeNumber.isRomeNumber(commands[0]) || !RomeNumber.isRomeNumber(commands[2]))
            throw new InputDataException("Все числа должны быть написаны в одном формате. (римскими или арабскими цифрами)");
        switch (commands[1]) {
            case "+":
                result = RomeNumber.decode(commands[0]) + RomeNumber.decode(commands[2]);
                break;
            case "-":
                result = RomeNumber.decode(commands[0]) - RomeNumber.decode(commands[2]);
                break;
            case "*":
                result = RomeNumber.decode(commands[0]) * RomeNumber.decode(commands[2]);
                break;
            case "/":
                result = RomeNumber.decode(commands[0]) / RomeNumber.decode(commands[2]);
                break;
            default:
                throw new InputDataException("2 командой должно быть арифметическое действие: '+', '-', '*' или '/'.");
        }
        return RomeNumber.toRomeNumber(result);
    }

    static int calcArabic(String[] commands) {
        int result;
        switch (commands[1]) {
            case "+":
                result = Integer.decode(commands[0]) + Integer.decode(commands[2]);
                break;
            case "-":
                result = Integer.decode(commands[0]) - Integer.decode(commands[2]);
                break;
            case "*":
                result = Integer.decode(commands[0]) * Integer.decode(commands[2]);
                break;
            case "/":
                result = Integer.decode(commands[0]) / Integer.decode(commands[2]);
                break;
            default:
                throw new InputDataException("2 командой должно быть арифметическое действие: '+', '-', '*' или '/'.");
        }
        return result;
    }
}