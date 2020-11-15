
public class BalloonGame implements BalloonGameInterface {

    private static final String INFLATE = "INFLATE";
    private static final String BANK = "BANK";
    private static final String BURST = "BURST";
    private static final String SCORE = "SCORE: ";

    private final InputOutputHandlerInterface inputOutputHandler;

    public BalloonGame(InputOutputHandlerInterface inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void playGame() {
        String input = inputOutputHandler.getUserInput();
        String[] balloonList = inputOutputHandler.stringToStringList(input);

        if (inputOutputHandler.checkIfListOkay(balloonList)) {
            calculateTotalPoints(balloonList);
        } else {
            playGame();
        }
    }

    private void calculateTotalPoints(String[] listOfBalloons) {
        int totalNumberOfPoints = 0;

        for (String i : listOfBalloons) {
            int balloonStrength = Integer.parseInt(i);
            totalNumberOfPoints = totalNumberOfPoints + calculateBalloonPoints(balloonStrength);
        }
        inputOutputHandler.printOutput(SCORE + totalNumberOfPoints);
    }

    private int calculateBalloonPoints(int balloonStrength) {
        int localPoints = 0;
        while (balloonStrength >= 0) {
            String input = inputOutputHandler.getUserInput();

            if (BANK.equalsIgnoreCase(input)) {
                return localPoints;
            } else if (INFLATE.equalsIgnoreCase(input)) {
                balloonStrength--;
                localPoints++;
            }
        }
        inputOutputHandler.printOutput(BURST);
        return 0;
    }
}