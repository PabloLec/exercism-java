class ResistorColorDuo {
    String[] colors = { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white" };

    int colorCode(String color) {
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == color) {
                return i;
            }
        }

        return -1;
    }

    int value(String[] colors) {
        String value = "";
        for (int i = 0; i < 2; i++) {
            value += colorCode(colors[i]);
        }
        return Integer.valueOf(value);
    }
}
