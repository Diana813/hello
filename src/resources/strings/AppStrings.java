package resources.strings;

public class AppStrings {

    public static String appTitle = "Hello";
    public static String enterYourNickname = "Podaj swoje imię: ";

    public static String send = "Wyślij";

    public static String usersList = "Użytkownicy:";

    public static String userConnected(String nickname){
        return String.format("%s dołączył/a do rozmowy!", nickname);
    }

    public static String userDisconnected(String nickname){
        return String.format("%s opuścił/a rozmowę!", nickname);
    }
}

