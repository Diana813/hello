package resources.strings;

public class AppStrings {

    public static String appTitle = "Hello";
    public static String enterYourNickname = "Podaj swoje imię: ";

    public static String me = "Ja888123";

    public static String usersList = "Użytkownicy:";

    public static String anonymousUser = "John Doe";

    public static String userAdded = "dołączył/a do rozmowy!";

    public static String userRemoved = "opuścił/a rozmowę!";

    public static String userConnected(String nickname) {
        return String.format("%s " + userAdded, nickname);
    }

    public static String userDisconnected(String nickname) {
        return String.format("%s " + userRemoved, nickname);
    }
}

