public class Operations {
    public static void shuffleDeck(Cards[] deck) {
        for (int i = 0; i < deck.length; i++) {
            int randomIndex = (int) (Math.random() * deck.length);
            Cards temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }

    public static Cards[][] distributeCards(Cards[] deck, int numPlayers, int cardsPerPlayer) {
        Cards[][] playerCards = new Cards[numPlayers][cardsPerPlayer]; // array to store players cards
        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                playerCards[i][j] = deck[i * cardsPerPlayer + j]; // distributing cards to players
            }
        }
        return playerCards; // return the array of distributed cards
    }
    
    public static int compareCards(Cards card1, Cards card2) {
        if (card1.cardValue > card2.cardValue) {
            return 1;
        } else if (card1.cardValue < card2.cardValue) {
            return -1;
        } else {
            return 0;
        }
    }
}
