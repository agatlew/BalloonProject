import java.util.Scanner;

public class InputOutputHandler implements InputOutputHandlerInterface {

    private final Scanner scanner;

    public InputOutputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean checkIfListOkay(String[] list) {
        for (String i : list) {
            try {
                Integer.parseInt(i);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getUserInput() {
        return scanner.nextLine();
    }

    @Override
    public void printOutput(String string) {
        System.out.println(string);
    }

    @Override
    public String[] stringToStringList(String string){
        return string.split(" ");
    }
}
