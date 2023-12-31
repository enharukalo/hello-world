import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

public class HelloWorldApp {
    public static void main(String[] args) {
        // Create a LanguageSelector object
        LanguageSelector languageSelector = new LanguageSelector();

        // Parse the command line arguments
        CommandLineArgs cmdLineArgs = new CommandLineArgs();
        JCommander cmd = JCommander.newBuilder()
                .addObject(cmdLineArgs)
                .programName("HelloWorldApp")
                .build();

        // Display the greeting message
        try {
            cmd.parse(args);
            if (cmdLineArgs.languageCode != null) {
                String greeting = languageSelector.selectLanguage(cmdLineArgs.languageCode);
                System.out.println(greeting);
            } else {
                cmd.usage();
            }
        } catch (ParameterException e) { // Invalid command line argument
            System.err.println(e.getMessage());
            cmd.usage();
        } catch (InvalidLanguageException e) { // Invalid language code
            System.err.println(e.getMessage());
        }
    }
}