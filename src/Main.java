import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<String> list = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static int end = 0;

    public static void main(String[] args) {
        while (end == 0) {
            System.out.println("1. Добавить товар");
            System.out.println("2. Показать список покупок");
            System.out.println("3. Удалить товар");
            System.out.println("4. Поиск товара");
            System.out.println("5. Завершить выполнение");
            String choice = scanner.nextLine();
            menu(choice);
        }

    }

    public static void menu(String choice) {
        switch (choice) {
            case "1":
                System.out.println();
                System.out.println("Какую покупку хотите добавить?");
                list.add(scanner.nextLine());
                System.out.println("Добавлено! Итого в списке покупок: " + list.size() + " продукта.");
                System.out.println();
                break;
            case "2":
                System.out.println();
                shoppList();
                System.out.println();
                break;
            case "3":
                System.out.println();
                shoppList();
                System.out.println("Какой товар хотите удалить? Введите номер или название");
                String product = scanner.nextLine();
                try {
                    int numberProduct = Integer.parseInt(product);
                    list.remove(numberProduct - 1);
                    System.out.println("Продукт под номером " + numberProduct + " удален!");
                    break;
                } catch (NumberFormatException e) {
                    list.remove(product);
                    System.out.println("Продукт с названием " + product + " удален!");
                    break;
                }
            case "4":
                System.out.println();
                System.out.println("Введите название продукта для поиска:");
                String productForSearch = scanner.nextLine();
                String queryLower = productForSearch.toLowerCase();
                System.out.println("По вашему запросу найдено: ");
                for (int i = 0; i < list.size(); i++) {
                    String itemLower = list.get(i).toLowerCase();
                    if (itemLower.contains(queryLower)) {
                        System.out.println((i + 1) + ". " + list.get(i));
                    }
                }
                System.out.println();
                break;
            case "5":
                System.out.println();
                System.out.println("Закрытие программы");
                end = 1;
                break;
            default:
                System.out.println("Неверное значение.");
                break;
        }
    }

    public static void shoppList(){
        int number = 0;
        System.out.println("Список покупок: ");
        for (String product : list) {
            number++;
            System.out.println(number + ". " + product);
        }
    }
}

