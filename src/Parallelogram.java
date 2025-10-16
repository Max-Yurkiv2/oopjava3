public class Parallelogram extends Shape {

    private double A;
    private double H;
    protected String color; // Protected: доступно у дочірніх класах і в тому ж пакеті
    public String material = "Wood"; // Public: доступно всюди

    private static int objectCount = 0;

    public Parallelogram() throws InvalidDimensionException {
        this(1.0, 1.0, "Undefined");
    }

    // Основний конструктор
    public Parallelogram(double A, double H, String color) throws InvalidDimensionException {
        if (A <= 0 || H <= 0) {
            throw new InvalidDimensionException("Розмір основи та висоти паралелограма має бути додатнім.");
        }
        // Використання this. для усунення конфлікту імен
        this.A = A;
        this.H = H;
        this.color = color;
        objectCount++; // 3. Збільшуємо лічильник
    }


    public double getA() { return A; }
    public double getH() { return H; }

    public void setH(double H) throws InvalidDimensionException {
        if (H <= 0) {
            throw new InvalidDimensionException("Висота має бути додатною!");
        }
        this.H = H;
    }

    public static int getObjectCount() {
        return objectCount;
    }

    @Override
    public double getArea() {
        return A * H;
    }

    @Override
    public String toString() {
        return String.format("Паралелограм (A=%.2f, H=%.2f, Color=%s, Material=%s)",
                A, H, color, material);
    }
}