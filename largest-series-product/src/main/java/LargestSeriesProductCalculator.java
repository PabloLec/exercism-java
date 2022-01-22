class LargestSeriesProductCalculator {
    private String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) throws IllegalArgumentException {
        if (inputNumber.matches(".*[^0-9].*")) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
        this.inputNumber = inputNumber;
    }

    long calculateProduct(String input) {
        if (input.length() == 0) {
            return 1;
        }
        long product = 1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '0') {
                return 0;
            }
            product *= Character.getNumericValue(input.charAt(i));
        }
        return product;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) throws IllegalArgumentException {
        if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }
        if (numberOfDigits > inputNumber.length()) {
            throw new IllegalArgumentException(
                    "Series length must be less than or equal to the length of the string to search.");
        }
        long largest = 0;

        for (int i = 0; i < inputNumber.length() - numberOfDigits; i++) {
            String series = inputNumber.substring(i, i + numberOfDigits);
            long product = calculateProduct(series);
            if (product > largest) {
                largest = product;
            }
        }

        return largest;
    }
}
