import java.util.Scanner;

public class NumberConverter {

  // Method to convert a decimal number to hexadecimal
  public static String decimalToHeximal(int decimalNumber) {
    String hexword = "";
    while (decimalNumber > 0) {
      int remainder = decimalNumber % 16;
      if (remainder < 10) {
        hexword = remainder + hexword;
      } else {
        char hexChar = (char) ('A' + remainder - 10);
        hexword = hexChar + hexword;
      }
      decimalNumber /= 16;
    }
    return hexword;
  }

  // Method to convert a hexadecimal number to decimal
  public static int heximalToDecimal(String hexword) {
    int decimal = 0;
    for (int i = 0; i < hexword.length(); i++) {
      char hexChar = hexword.charAt(i);
      if (hexChar >= '0' && hexChar <= '9') {
        decimal = 16 * decimal + (hexChar - '0');
      } else if (hexChar >= 'A' && hexChar <= 'F') {
        decimal = 16 * decimal + (hexChar - 'A' + 10);
      } else if (hexChar >= 'a' && hexChar <= 'f') {
        decimal = 16 * decimal + (hexChar - 'a' + 10);
      } else {
        throw new IllegalArgumentException("Invalid hexadecimal string: " + hexword);
      }
    }
    return decimal;
  }

  // Main method for testing the conversion methods
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Convert decimal to hexadecimal
    System.out.print("Enter a decimal number: ");
    int decimalNumber = scanner.nextInt();
    String hexword = decimalToHeximal(decimalNumber);
    System.out.println(decimalNumber + " in hexadecimal is " + hexword);

    // Convert hexadecimal to decimal
    System.out.print("Enter a hexadecimal number: ");
    String hexString = scanner.next();
    int decimal = heximalToDecimal(hexString);
    System.out.println(hexString + " in decimal is " + decimal);

    scanner.close();
  }

}
