class ResistorColor {
    private String[] colors = { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey",
            "white" };

    int colorCode(String color) {
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == color) {
                return i;
            }
        }

        return -1;
    }

    String[] colors() {
        return this.colors;
    }
}
