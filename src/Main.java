import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            Parallelogram pDefault = new Parallelogram();
            Trapezium tDefault = new Trapezium();
            System.out.println("--- Об'єкти за замовчуванням (Ініціалізатори) ---");
            printArea(pDefault);
            printArea(tDefault);

            // --- Введення даних для демонстрації ---

            System.out.println("\n--- Введення даних для Паралелограма ---");
            System.out.print("Введіть основу A: ");
            double baseA = scanner.nextDouble();
            System.out.print("Введіть висоту H: ");
            double heightP = scanner.nextDouble();

            System.out.println("\n--- Введення даних для Трапеції ---");
            System.out.print("Введіть першу основу C: ");
            double baseC = scanner.nextDouble();
            System.out.print("Введіть другу основу D: ");
            double baseD = scanner.nextDouble();
            System.out.print("Введіть висоту H: ");
            double heightT = scanner.nextDouble();

            // Створення об'єктів з користувацькими даними
            // Демонстрація поліморфізму (Shape посилається на Parallelogram/Trapezium)
            Parallelogram p1 = new Parallelogram(baseA, heightP, "Blue");
            Trapezium t1 = new Trapezium(baseC, baseD, heightT, "UserTrapezium");

            System.out.println("\n--- Результати обчислень (Поліморфізм та Валідація) ---");
            printArea(p1);
            printArea(t1);

            System.out.println("\n--- Демонстрація Інкапсуляції ---");
            System.out.println("Основа P1 через Getter: " + p1.getA());
            p1.setH(p1.getH() + 2.0);
            System.out.println("Нова площа P1 після setH: " + p1.getArea());

            System.out.println("\n--- Демонстрація Статичного Поля ---");
            System.out.println("Загальна кількість створених паралелограмів: " + Parallelogram.getObjectCount());

            Trapezium t2 = new Trapezium(10.0, 2.0, 3.0, "CompareTrapezium"); // Площа: 18.0
            System.out.println("\n--- Демонстрація Порівняння ---");
            System.out.println("T1: " + t1.toString());
            System.out.println("T2: " + t2.toString());
            System.out.println("Площі T1 та T2 рівні? " + t1.compareArea(t2));

        } catch (InputMismatchException e) {
            System.err.println("Помилка вводу: Будь ласка, вводьте лише числа.");
        } catch (InvalidDimensionException e) {
            System.err.println("\n--- ПОМИЛКА ВАЛІДАЦІЇ ---");
            System.err.println(e.getMessage());
            System.err.println("Програма завершує роботу через недійсні розміри.");
        } catch (Exception e) {
            System.err.println("Виникла непередбачена помилка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void printArea(Shape shape) {
        System.out.printf("%s: Площа = %.2f\n",
                shape.toString(),
                shape.getArea());
    }
}