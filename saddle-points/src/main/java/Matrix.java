import java.util.List;
import java.util.Set;
import java.util.*;

class Matrix {

    ArrayList<ArrayList<MatrixCoordinate>> matrix;

    Map<MatrixCoordinate, Integer> coordinates = new HashMap<MatrixCoordinate, Integer>();

    Matrix(List<List<Integer>> values) {
        this.matrix = new ArrayList<>(values.size());

        int i = 0;

        for (List<Integer> line : values) {
            matrix.add(new ArrayList<>(line.size()));

            int j = 0;

            for (Integer value : line) {
                MatrixCoordinate coordinate = new MatrixCoordinate(i + 1, j + 1);
                coordinates.put(coordinate, value);
                matrix.get(i).add(coordinate);
                j++;
            }

            i++;
        }
    }

    boolean checkRow(int row, MatrixCoordinate coordinate) {
        int value = coordinates.get(coordinate);
        ArrayList<MatrixCoordinate> rowCoordinates = matrix.get(row);

        for (MatrixCoordinate c : rowCoordinates) {
            if (c.equals(coordinate)) {
                continue;
            }
            int cValue = coordinates.get(c);
            if (cValue > value) {
                return false;
            }
        }

        return true;
    }

    boolean checkColumn(int column, MatrixCoordinate coordinate) {
        int value = coordinates.get(coordinate);

        for (ArrayList<MatrixCoordinate> row : matrix) {
            MatrixCoordinate c = row.get(column);
            if (c.equals(coordinate)) {
                continue;
            }
            int cValue = coordinates.get(c);
            if (cValue < value) {
                return false;
            }
        }

        return true;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> result = new HashSet<MatrixCoordinate>();

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                MatrixCoordinate c = matrix.get(i).get(j);
                if (checkRow(i, c) && checkColumn(j, c)) {
                    result.add(c);
                }
            }
        }

        return result;
    }
}
