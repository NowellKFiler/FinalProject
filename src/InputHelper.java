import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    private InputHelper() {
    }

    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public static String readValidString(String prompt, int maxLength) {
    while (true) {
        String input = readString(prompt);
        if (input.isBlank()) {
            System.out.println("Input tidak boleh kosong.");
        } else if (input.length() > maxLength) {
            System.out.println("Maksimal " + maxLength + " karakter (saat ini: " + input.length() + ").");
        } else {
            return input;
        }
    }
}

    public static int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(readString(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka bulat yang valid.");
            }
        }
    }

    public static int readMinInt(String prompt, int min) {
        while (true) {
            int val = readInt(prompt);
            if (val < min) {
                System.out.println("Nilai minimal adalah " + min + ".");
            } else {
                return val;
            }
        }
    }

    public static double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(readString(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid.");
            }
        }
    }
    
    public static double readMinDouble(String prompt, double min, boolean inclusive) {
        while (true) {
            double val = readDouble(prompt);
            boolean valid = inclusive ? (val >= min) : (val > min);
            if (!valid) {
                System.out.println("Nilai harus " + (inclusive ? ">= " : "> ") + min + ".");
            } else {
                return val;
            }
        }
    }

    public static void close() {
        scanner.close();
    }
}