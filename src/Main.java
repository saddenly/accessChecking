import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        User user = getUserByLoginAndPassword(login, password);
        validateUser(user);

        System.out.println("Доступ предоставлен");
    }

    public static User[] getUsers() {
        User u1 = new User("Pudge", "stinkyPudge@mail.com", "someCrazyPassword", 20);
        User u2 = new User("Lina", "gorgLina@gmail.com", "someCrazy", 17);
        User u3 = new User("Sven", "cruelSven@outlook.com", "crazyPassword", 15);
        User u4 = new User("StormSpirit", "spirit_lol@gmail.com", "password", 21);
        return new User[]{u1, u2, u3, u4};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("User is not found");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException("Пользователям до 18 лет доступ запрещен");
        }
    }
}