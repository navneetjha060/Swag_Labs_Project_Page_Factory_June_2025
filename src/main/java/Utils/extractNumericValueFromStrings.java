package Utils;

public class extractNumericValueFromStrings {

	public static double extractNumericValue(String input) {

		String numericPart = input.replaceAll("[^\\d.]", "");
		return Double.parseDouble(numericPart);

	}

}
