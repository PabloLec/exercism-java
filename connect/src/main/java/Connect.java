import java.util.*;

class Connect {
    public List<String> board = new ArrayList<String>();

    public Connect(String[] board) {
        for (String s : board) {
            this.board.add(s.replace(" ", "").trim());
        }
    }

    public boolean checkVertical(int line, int column) {
        if (line == this.board.size()) {
            return true;
        }
        if (column > 0 && this.board.get(line + 1).charAt(column - 1) == 'O') {
            if (checkVertical(line + 1, column - 1)) {
                return true;
            }
        }
        if (checkVertical(line + 1, column)) {
            return true;
        }

        return false;
    }

    public boolean checkO() {
        String topLine = this.board.get(0);
        for (int i = 0; i < topLine.length(); i++) {
            if (topLine.charAt(i) != 'O')
                continue;
            if (checkVertical(0, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkX() {
        for (int i = 0; i < this.board.size(); i++) {
            String line = this.board.get(i);
            if (line.charAt(0) != 'X')
                continue;
            if (checkHorizontal(i, 0)) {
                return true;
            }
        }
        return false;
    }

    public Winner computeWinner() {
        if (checkO()) {
            return Winner.PLAYER_O;
        }
        return Winner.NONE;
    }
}
