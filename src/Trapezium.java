public class Trapezium extends Shape {

    private double C;
    private double D;
    private double H;
    private String name;

    public Trapezium() throws InvalidDimensionException {
        this(1.0, 1.0, 1.0, "DefaultTrapezium");
    }

    // Основний конструктор
    public Trapezium(double C, double D, double H, String name) throws InvalidDimensionException {
        if (C <= 0 || D <= 0 || H <= 0) {
            throw new InvalidDimensionException("Всі основи (C, D) та висота (H) трапеції мають бути додатними.");
        }
        this.C = C;
        this.D = D;
        this.H = H;
        this.name = name;
    }

    // 4. Метод порівняння двох об'єктів (за площею)
    public boolean compareArea(Trapezium other) {
        // Використовуємо невеликий допуск для порівняння чисел з плаваючою комою
        final double EPSILON = 0.0001;
        // Порівнюємо абсолютну різницю площ з допуском
        return Math.abs(this.getArea() - other.getArea()) < EPSILON;
    }

    @Override
    public double getArea() {
        return ((C + D) / 2.0) * H;
    }

    @Override
    public String toString() {
        return String.format("Трапеція (%s, C=%.2f, D=%.2f, H=%.2f)",
                name, C, D, H);
    }
}

