import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] commands = input.split(" ");

        if (commands.length == 3 && commands[0].equals("start")) {
            Integer numPlayers = Integer.parseInt(commands[1]);
            Integer numCardsPerPlayer = Integer.parseInt(commands[2]);
            if (numPlayers < 2 || numPlayers > 4) {
                System.out.println("Invalid number of players. Please enter a number between 2 and 4.");
            } else if (numCardsPerPlayer < 5 || numCardsPerPlayer > 9) {
                System.out.println("Invalid number of cards per player. Please enter a number between 5 and 9.");
            } else {
                Start.start(numPlayers, numCardsPerPlayer); // start the game with the given number of players and cards per player
            }
        } else if (commands.length == 1 && commands[0].equals("exit")) {
            System.out.println("Exiting the game.");
            scan.close();
            return;
        } 

        scan.close();
    }
}
