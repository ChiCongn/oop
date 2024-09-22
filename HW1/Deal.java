package HW1;

public class Deal {
    public static void main(String[] args) {
        final int CARDS_PER_PLAYER = 5;
        final int NUMBERS_OF_CARDS = 52;
        if (args.length < 1){
            throw new IllegalArgumentException("Please type numbers of players");
        }
        int players = Integer.parseInt(args[0]);
        if (players * CARDS_PER_PLAYER > NUMBERS_OF_CARDS){
            throw new IllegalArgumentException("Having too many player. Someone has to be get lost!");
        }
        // initial
        final String[] SUITS = {
                "Clubs, Diamonds, Hearts, Spades"
        };
        final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"
        };

        // initialize deck
        String[] deck = new String[NUMBERS_OF_CARDS];
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length * i + j] = RANKS[i] + " of " + SUITS[j];
            }
        }

        // shuffle
        for (int i = 0; i < NUMBERS_OF_CARDS; i++) {
            int r = i + (int) (Math.random() * (NUMBERS_OF_CARDS - i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }

        // print cards
        for (int i = 0; i < players * CARDS_PER_PLAYER; i++) {
            System.out.println(deck[i]);
            if (i % CARDS_PER_PLAYER == CARDS_PER_PLAYER - 1)
                System.out.println();
        }
    }
}
