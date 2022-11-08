package resources.strings;

/**
 * Klasa zbiorcza dla wszystkich informacji tekstowych wyświetlanych w aplikacji
 */
public class AppStrings {

    public static String appTitle = "Hello";
    public static String enterYourNickname = "Podaj swoje imię: ";

    public static String me = "Ja888123";

    public static String usersList = "Użytkownicy:";

    public static String anonymousUser = "John Doe";

    public static String userAdded = "dołączył/a do rozmowy!";

    public static String userRemoved = "opuścił/a rozmowę!";

    public static String loginError = "Nie jesteś zalogowany/a!";

    /**
     * Metoda odpowiadająca za wyświetlenie informacji tekstowej o połączeniu się nowego użytkownika
     * @param nickname to imię użytkownika
     * @return obiekt typu String
     */
    public static String userConnected(String nickname) {
        return String.format("%s " + userAdded, nickname);
    }

    /**
     * Metoda odpowiadająca za wyświetlenie informacji o opuszczeniu rozmowy przez użytkownika
     * @param nickname to imię użytkownika
     * @return obiekt typu String
     */
    public static String userDisconnected(String nickname) {
        return String.format("%s " + userRemoved, nickname);
    }
}

