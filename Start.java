public class Start {
    public static void start(Integer numPlayers, Integer numCardsPerPlayer) {
        Cards[] deck = new Cards[52]; // deck to store the cards
        int index = 0;
        for (int i = 2; i <= 14; i++) {
            for (int j = 1; j <= 4; j++) {
                deck[index] = new Cards(i, j); // generating deck cards
            }
        }
        
        
        Operations.shuffleDeck(deck); // shuffle the deck
        Cards[][] playerCards = Operations.distributeCards(deck, numPlayers, numCardsPerPlayer); // distribute cards to players
        System.out.println("Game started! Deck generated and cards distributed.");
        Game.game(deck, playerCards, numPlayers, numCardsPerPlayer); // start the game
    }
}
