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

    // @Override
    // public boolean convertStringListToIntList(String[] list) {
    //     int[] integerList = new int[list.length];
    //     int newInt;
    //     for (int i = 0; i<=list.length; i++){
    //         try {
    //             newInt = Integer.parseInt(list[i]);
    //         } catch (NumberFormatException e) {
    //            //return ;
    //         }
    //         integerList[i] = newInt;
    //     }
    //     return true;
    // }
}
