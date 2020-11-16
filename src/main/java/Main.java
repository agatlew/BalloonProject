import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BalloonGameInterface balloonGame =
                new BalloonGame(new InputOutputHandler(scanner));
        balloonGame.playGame();
    }
}
