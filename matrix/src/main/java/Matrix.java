import java.util.*;

class Matrix {
    ArrayList<ArrayList<Integer>> matrix; // = new ArrayList<>(vertexCount);

    Matrix(String matrixAsString) {
        String lines[] = matrixAsString.split("\\r?\\n");
        this.matrix = new ArrayList<>(lines.length);

        int i = 0;

        for (String line : lines) {

            String[] numbers = line.split("\\s+");
            matrix.add(new ArrayList<>(numbers.length));

            for (String number : numbers) {
                matrix.get(i).add(Integer.parseInt(number));
            }

            i++;
        }
    }

    int[] getRow(int rowNumber) {
        rowNumber -= 1;

        int[] result = new int[matrix.get(rowNumber).size()];

        for (int i = 0; i < matrix.get(rowNumber).size(); i++) {
            result[i] = matrix.get(rowNumber).get(i);
        }

        return result;
    }

    int[] getColumn(int columnNumber) {
        columnNumber -= 1;

        int[] result = new int[matrix.size()];

        for (int i = 0; i < matrix.size(); i++) {
            result[i] = matrix.get(i).get(columnNumber);
        }

        return result;
    }
}
