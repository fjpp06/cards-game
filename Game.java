public class Game {
    public static void game(Cards[] deck, Cards[][] playerCards, int numPlayers, int cardsPerPlayer) {
        GameLogic.gameLogic(deck, playerCards, numPlayers, cardsPerPlayer);
        // The game logic is handled and implemented in the GameLogic class
        // The game continues until the deck is empty or a player wins
        
        
    }
}
