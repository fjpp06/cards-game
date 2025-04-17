public class Cards {
    int cardValue;
    int cardSuit;

    
    public Cards(int value, int suit) {
        this.cardValue = value;
        this.cardSuit = suit;
    }

    public static String getSuitName(int suit) {
        switch (suit) {
            case 1: return "Spades";
            case 2: return "Clubs";
            case 3: return "Hearts";
            case 4: return "Diamonds";
            default: return "Unknown Suit";
        }
    }

    public static String getValueName(int value) {
        if (value >= 2 && value <= 10) {
            return String.valueOf(value);
        }
        switch (value) {
            case 11: return "Jack";
            case 12: return "Queen";
            case 13: return "King";
            case 14: return "Ace";
            default: return "Unknown Value";
        }
    }
}

