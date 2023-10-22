import java.util.List;
import java.util.Scanner;

public class LanguageSelector {
    private final List<Language> languages;

    public LanguageSelector(List<Language> languages) {
        this.languages = languages;
    }

    public void selectLanguage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select a language:");
        for (Language language : languages) {
            System.out.println(language.getLangName() + " - " + language.getCode());
        }

        String selectedLanguageCode;
        do {
            selectedLanguageCode = scanner.nextLine().toLowerCase();
        } while (!isValidLanguageCode(selectedLanguageCode));
        scanner.close();
    }

    public boolean isValidLanguageCode(String selectedLanguageCode) {
        for (Language language : languages) {
            if (language.getCode().equals(selectedLanguageCode)) {
                System.out.println(language.getGreeting());
                return true;
            }
        }
        System.out.println("Please select a valid language!");
        return false;
    }


}