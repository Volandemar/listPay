import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        list.add("Сыр");
        list.add("Помидор");
        list.add("Памперсы");
        list.add("Вода");
        list.add("Вода Демиодовская");
        list.add("Водка");
        list.add("вода");


        while (true) {
            System.out.println();
            System.out.println("Выберите действие");
            System.out.println("1 - Добавить товар в корзину");
            System.out.println("2 - Показать список товаров в корзине");
            System.out.println("3 - Удалить товар из корзины");
            System.out.println("4 - Поиск товара в корзине");
            System.out.println("end - Завершить работу программы");
            String enterUser = scanner.nextLine();
            if ("end".equals(enterUser)) {
                break;
            }

            try {
                int choiceUser = Integer.parseInt(enterUser);
                switch (choiceUser) {
                    case 1:
                        System.out.println("Введите название товара:");
                        String getNameProduct = scanner.nextLine();
                        list.add(getNameProduct);
                        System.out.println("Итого товаров в Вашей корзине: " + list.size());
                        break;
                    case 2:
                        System.out.println("Список Ваших товаров:");
                        showAllList(list);
                        break;
                    case 3:
                        System.out.println("Какой товар хотите удалить? Выберите номер товара из списка: ");
                        showAllList(list);
                        String productForDelete = scanner.nextLine();
                        try {
                            int selectForDelete = Integer.parseInt(productForDelete) - 1;
                            System.out.println("Товар " + list.get(selectForDelete) + " был удален из корзины, список товаров:");
                            list.remove(selectForDelete);
                        } catch (NumberFormatException e) {
                            System.out.println("Товар " + productForDelete + " был удален из корзины, список товаров:");
                            list.remove(productForDelete);
                        }
                        showAllList(list);
                        break;
                    case 4:
                        System.out.println("Введите название товара для поиска:");
                        String itemLower = scanner.nextLine().toLowerCase();
                        System.out.println("Найдено:");
                        for (int i = 0; i < list.size(); i++) {
                            String queryLower = list.get(i).toLowerCase();
                            int number = i + 1;
                            if (queryLower.contains(itemLower)) {
                                System.out.println(number + ". " + list.get(i));
                            }
                        }
                        break;
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка. Действие выбрано не корректно.");
                continue;
            }
        }
    }

    private static void showAllList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String resultList = list.get(i);
            int number = i + 1;
            System.out.println(number + ". " + resultList);
        }
    }
}