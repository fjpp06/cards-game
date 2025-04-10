import java.util.Scanner;

public class Game {
    public static void game(Cards[][] playerCards, int numPlayers, int cardsPerPlayer) {
        int[] playerSelectedNumber = new int[numPlayers]; // array to store the number of the card selected by each player
        Cards[] playerSelectedCards = new Cards[numPlayers]; // array to store the cards selected by players
        Scanner scan = new Scanner(System.in);
        String question = "Player %d, it's your turn. Insert the number of the card you want to play:";
        String replyString = "Player %d, you played: %s of %s";
        String replyInt = "Player %d, you played: %d of %s";
        for (int i = 1; i <= numPlayers; i++) {
            String ask = String.format(question, i);
            System.out.println(ask);
            int playerCard = scan.nextInt();
            playerSelectedNumber[i - 1] = playerCard; // store the selected card number for the player
            playerSelectedCards[i - 1] = playerCards[i - 1][playerCard]; // store the selected card for the player
            if (playerSelectedCards[i - 1].cardValue >= 2 && playerSelectedCards[i - 1].cardValue <= 10) {
                String reply = String.format(replyInt, i, Cards.getValueName(playerSelectedCards[i - 1].cardValue), Cards.getSuitName(playerSelectedCards[i - 1].cardSuit));
                System.out.println(reply);
            } else {
                String reply = String.format(replyString, i, Cards.getValueName(playerSelectedCards[i - 1].cardValue), Cards.getSuitName(playerSelectedCards[i - 1].cardSuit));
                System.out.println(reply);
            }
        }
        scan.close();

        
    }
}
