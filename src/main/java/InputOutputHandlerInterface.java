public interface InputOutputHandlerInterface {
    boolean checkIfListOkay(String[] list);

    void printOutput(String string);

    String getUserInput();

    String[] stringToStringList(String string);
}