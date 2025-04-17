import java.util.Arrays;

public class Operations {
    public static void shuffleDeck(Cards[] deck) {
        for (int i = 0; i < deck.length; i++) {
            int randomIndex = (int) (Math.random() * deck.length);
            Cards temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }

    
    public static void compactDeck(Cards[] deck) {
        int index = 0; // Pointer for the next position to place a non-null card
        for (int i = 0; i < deck.length; i++) {
            if (deck[i] != null) {
                deck[index] = deck[i]; // Move non-null card to the current index
                if (index != i) {
                    deck[i] = null; // Clear the old position
                }
                index++;
            }
        }
    }

    public static Cards[][] distributeCards(Cards[] deck, int numPlayers, int cardsPerPlayer) {
        Cards[][] playerCards = new Cards[numPlayers][52]; // array to store players cards
        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                playerCards[i][j] = deck[i * cardsPerPlayer + j]; // distributing cards to players
                deck[i * cardsPerPlayer + j] = null; // removing the card from the deck after distribution
            }
        }
        compactDeck(deck); // compact the deck after distribution
        return playerCards; // return the array of distributed cards
    }
    
    public static void sortDeck(Cards[] deck) {
        // Sort the deck based on card values and suits
        Arrays.sort(deck, (card1, card2) -> {
            if (card1.cardValue != card2.cardValue) {
                return Integer.compare(card1.cardValue, card2.cardValue);
            } else {
                return Integer.compare(card1.cardSuit, card2.cardSuit);
            }
        });
    }
}
