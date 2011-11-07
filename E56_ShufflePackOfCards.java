import java.util.Random;

public class E56_ShufflePackOfCards {
    /**
     * lets card be an integer
     */
    public static void shuffleCards(int[] cards) {
        Random random = new Random();
        for (int i = cards.length - 1; i != -1; i--) {
            int rand = random.nextInt(i + 1);
            exchange(cards, i, rand);
        }
    }

    private static void exchange(int[] cards, int index1, int index2) {
        if (index1 != index2) {
            cards[index1] += cards[index2];
            cards[index2] = cards[index1] - cards[index2];
            cards[index1] -= cards[index2];
        }
    }

    public static void main(String[] args) {
        int[] cards = new int[52];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = i;
        }

        shuffleCards(cards);
        System.out.print("Shuffled: [" + cards[0]);
        for (int i = 1; i < cards.length; i++) {
            System.out.print("," + cards[i]);
        }
        System.out.println("]");
    }
}
