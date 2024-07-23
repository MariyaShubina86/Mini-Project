
import java.util.Scanner;


    public class Contact  {
        String name;
        String value;

        Contact(String name, String value) {
            this.name = name;
            this.value = value;
        }
    }

public class PhoneBook {
    static final int MAX_CONTACTS = 10;
    static Contact[] contacts = new Contact[MAX_CONTACTS];
    static int numContacts = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] name) {
        while (true) {
            displayMenu();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    editContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неверный выбор. Пробовать снова");
            }
            displayContacts();
        }
    }
    static void displayMenu() {
        System.out.println("Меню:");
        System.out.println("1. Новый контакт");
        System.out.println("2. Редактировать контакт");
        System.out.println("3. Удалить контакт");
        System.out.println("4. Выход");
    }

    static int getChoice() {
        System.out.print("Введите свой выбор: ");
        return scanner.nextInt();
    }

    static void addContact() {
        if (numContacts == MAX_CONTACTS) {
            System.out.println("Телефонная книга заполнена. Не удается добавить дополнительные контакты.");
            return;
        }
        System.out.print("Введите имя контакта: ");
        String name = scanner.next();
        System.print("Введите значение: ");
        String value = scanner.next();
        contacts[numContacts++] = new Contact(name, value);
    }
    static void editContact() {
        if (numContacts == 0) {
            System.out.println("Телефонная книга пуста. Не удается отредактировать контакты.");
            return;
        }
        System.out.print("Введите индекс контакта для редактирования:");
        int index = scanner.nextInt();
        if (index < 0 || index >= numContacts) {
            System.out.println("Неверный индекс.");
            return;
        }
        System.out.print("Введите новое имя:");
        String name = scanner.next();
        System.print("Введите новое значение: ");
        String value = scanner.next();
        contacts[index] = new Contact(name, value);
    }

    static void deleteContact() {
        if (numContacts == 0) {
            System.out.println("Телефонная книга пуста. Не удается удалить контакты.");
            return;
        }
        System.out.print("Введите индекс контакта для удаления: ");
        int index = scanner.nextInt();
        if (index < 0 || index >= numContacts) {
            System.out.println("Неверный индекс.");
            return;
        }
        for (int i = index; i < numContacts - 1; i++) {
            contacts[i] = contacts[i + 1];
        }
        numContacts--;
    }

    static void displayContacts() {
        System.out.println("Контакты:");
        for (int i = 0; i < numContacts; i++) {
            System.out.printf("%d. %s %s\n", i + 1, contacts[i].name, contacts[i].value);
        }
        for (int i = numContacts; i < MAX_CONTACTS; i++) {
            System.out.printf("%d. ...\n", i + 1);
        }
    }
}
