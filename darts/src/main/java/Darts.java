class Darts {
    private double x;
    private double y;

    Darts(double x, double y) {
        this.x = x;
        this.y = y;
    }

    int distance() {
        return (int) Math.ceil(Math.sqrt(x * x + y * y));
    }

    int score() {
        int distance = distance();
        if (distance <= 1)
            return 10;
        if (distance <= 5)
            return 5;
        if (distance <= 10)
            return 1;
        else
            return 0;
    }

}
