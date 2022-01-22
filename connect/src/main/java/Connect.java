import java.util.*;

class Connect {
    public List<String> board = new ArrayList<String>();

    public Connect(String[] board) {
        for (String s : board) {
            this.board.add(s.replace(" ", "").trim());
        }
    }

    public boolean isInBoard(int x, int y) {
        return x >= 0 && x < board.size() && y >= 0 && y < board.get(x).length();
    }

    public boolean checkHorizontal(int x, int y, List<String> seen) {
        String coords = String.format("%s-%s", x, y);
        if (seen.contains(coords)) {
            return false;
        }
        seen.add(coords);

        if (this.board.get(x).charAt(y) != 'X') {
            return false;
        }

        if (y == this.board.get(x).length() - 1) {
            return true;
        }

        if (isInBoard(x - 1, y) && checkHorizontal(x - 1, y, seen)) {
            return true;
        }
        if (isInBoard(x - 1, y + 1) && checkHorizontal(x - 1, y + 1, seen)) {
            return true;
        }
        if (isInBoard(x, y - 1) && checkHorizontal(x, y - 1, seen)) {
            return true;
        }
        if (isInBoard(x, y + 1) && checkHorizontal(x, y + 1, seen)) {
            return true;
        }
        if (isInBoard(x + 1, y - 1) && checkHorizontal(x + 1, y - 1, seen)) {
            return true;
        }
        if (isInBoard(x + 1, y) && checkHorizontal(x + 1, y, seen)) {
            return true;
        }

        return false;
    }

    public boolean checkVertical(int x, int y, List<String> seen) {
        String coords = String.format("%s-%s", x, y);
        if (seen.contains(coords)) {
            return false;
        }
        seen.add(coords);

        if (this.board.get(x).charAt(y) != 'O') {
            return false;
        }

        if (x == this.board.size() - 1) {
            return true;
        }

        if (isInBoard(x - 1, y) && checkVertical(x - 1, y, seen)) {
            return true;
        }
        if (isInBoard(x - 1, y + 1) && checkVertical(x - 1, y + 1, seen)) {
            return true;
        }
        if (isInBoard(x, y - 1) && checkVertical(x, y - 1, seen)) {
            return true;
        }
        if (isInBoard(x, y + 1) && checkVertical(x, y + 1, seen)) {
            return true;
        }
        if (isInBoard(x + 1, y - 1) && checkVertical(x + 1, y - 1, seen)) {
            return true;
        }
        if (isInBoard(x + 1, y) && checkVertical(x + 1, y, seen)) {
            return true;
        }

        return false;
    }

    public Winner computeWinner() {
        for (int i = 0; i < this.board.size(); i++) {
            if (checkHorizontal(i, 0, new ArrayList<String>())) {
                return Winner.PLAYER_X;
            }
        }
        for (int i = 0; i < this.board.get(0).length(); i++) {
            if (checkVertical(0, i, new ArrayList<String>())) {
                return Winner.PLAYER_O;
            }
        }

        return Winner.NONE;
    }
}
