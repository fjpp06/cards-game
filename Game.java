import java.util.Scanner;

public class Game {
    public static void game(Cards[] deck, Cards[][] playerCards, int numPlayers, int cardsPerPlayer) {
        Cards[] temp = new Cards[numPlayers]; // array to store the selected cards
        Cards[] playerSelectedCards = new Cards[numPlayers]; // array to store the cards selected by players
        Scanner scan = new Scanner(System.in);
        String question = "Player %d, it's your turn. Insert the number of the card you want to play:";
        String replyString = "Player %d, you played: %s of %s";
        String replyInt = "Player %d, you played: %d of %s";
        for (int i = 1; i <= numPlayers; i++) {
            String ask = String.format(question, i);
            System.out.println(ask);
            int playerCard = scan.nextInt();
            playerSelectedCards[i - 1] = playerCards[i - 1][playerCard]; // store the selected card for the player
            temp[i - 1] = playerCards[i - 1][playerCard]; // store the selected card in a temporary array
            playerCards[i - 1][playerCard] = null; // remove the card from the player's hand
            Operations.compactDeck(playerCards[i - 1]); // compact the player's hand after selection
            if (playerSelectedCards[i - 1].cardValue >= 2 && playerSelectedCards[i - 1].cardValue <= 10) {
                String reply = String.format(replyInt, i, Cards.getValueName(playerSelectedCards[i - 1].cardValue), Cards.getSuitName(playerSelectedCards[i - 1].cardSuit));
                System.out.println(reply);
            } else {
                String reply = String.format(replyString, i, Cards.getValueName(playerSelectedCards[i - 1].cardValue), Cards.getSuitName(playerSelectedCards[i - 1].cardSuit));
                System.out.println(reply);
            }
        }

        Operations.sortDeck(playerSelectedCards); // sort the selected cards
        int winnerIndex = 0; // index of the winning card
        for (int i = 0; i < numPlayers; i++) {
            if (temp[i] == playerSelectedCards[numPlayers - 1]) {
                System.out.println("Player " + (i + 1) + " wins with card: " + Cards.getValueName(Temp[i].cardValue) + " of " + Cards.getSuitName(Temp[i].cardSuit));
                winnerIndex = i; // store the index of the winning player
            }
        }
        int emptyIndex = 0; // index of the empty card
        for (int i = 0; i < cardsPerPlayer; i++) {
            if (playerCards[winnerIndex][i] == null) {
                emptyIndex = i;
            } 
        }

        for (int i = 0; i < numPlayers; i++) {
            playerCards[winnerIndex][emptyIndex + i] = playerSelectedCards[i]; // add the selected cards to the winner's hand
            playerSelectedCards[i] = null; // remove the card from the player's hand
            temp[i] = null; // clear the temporary array
        }
        
        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < numPlayers; j++) {
                if (playerCards[i][j] == null) {
                    playerCards[i][j] = deck[i]; // add the card from the deck to the player's hand
                    deck[i] = null; // remove the card from the deck
                }
            }
        }

        Operations.compactDeck(deck); // compact the deck after adding the card
        playerSelectedCards = new Cards[numPlayers]; // reset the selected number array for the next round
        scan.close();



        
    }
}
