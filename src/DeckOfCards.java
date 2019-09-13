import java.util.LinkedList;
import java.util.Random;

/**
 * Class
 * To get Deck of cards
 */
public class DeckOfCards {
    private Card[] cards; // Makes cards array from Card class
    private int size; // number of cards
    private int maxValue; // highest value of cards
    private int minValue; // lowest value of cards

    /**
     *  Constructor of this class
     *
     * @param numSuit  Suit of cards
     * @param maxRank  Rank of cards
     */
    public DeckOfCards(int numSuit, int maxRank){
        this.size = maxRank * numSuit;
        this.minValue = 1;
        this.maxValue = maxRank * numSuit;
        cards = new Card[size];
        int count = 0;
        for(int i = 1; i <= maxRank; i++){
            for(int j = 1; j <= numSuit; j++){
                cards[count++] = new Card(i, j);
            }
        }
    }

    /**
     * To shuffle for the deck
     * @param temp is needed to carry the whole cards temporarily to shuffle
     */
    public void shuffle(){
        LinkedList<Card> temp = new LinkedList<Card>(); // to use remove contents in the list

        for(int i = 0; i < size; i++){
            temp.add(cards[i]);
        }

        for(int j = 0; j < size; j++){
            Random r = new Random();
            cards[j] = temp.remove(r.nextInt(temp.size()));
        }
    }

    /**
     * To deal the card
     * @param numCard decide number of cards to get
     * @return deal the card
     */
    public Card[] deal(int numCard){
        Card[] temp = new Card[numCard];
        for(int i = 0; i < numCard; i++){
            temp[i] = cards[i];
        }
        return temp;
    }

    /**
     * To make histogram
     * @param numCard decide number of cards to get
     * @return the sum of the values of the cards dealt
     */
    public  int[] Histogram(int numCard){
        int[] histogram = new int[size * numCard];

        for (int i = 0; i < 1_00_000; i++) {
            Card[] temp = new Card[numCard];
            int sum = 0;
            for(int j = 0; j<numCard; j++){
                temp[j] = cards[j];
                sum += cards[j].getValue();

            }
            histogram[sum]++;
            shuffle();
        }

            return histogram;
    }

    /**
     * To decide minimum number
     * @param histogram
     * @return minimum number of histogram
     */
    public int minCase(int[] histogram){
        int x= 0;
        for(int i =0; i<histogram.length; i++){
            if (histogram[i] != 0){
                x = i;
                break;
            }

        }
        return x;
    }
    /**
     * To decide Maximum number
     * @param histogram
     * @return Maximum number of histogram
     */
    public int maxCase(int[] histogram){
        int x = 0;
        for(int i = histogram.length -1 ; i>=0 ; i--){
            if(histogram[i] != 0){
                x = i;
                break;
            }
        }
        return x;
    }

    /**
     * Return the current state of the deck
     * @return number of cards , low number, high number , top card.
     */
    public String toString(){
        return String.format("Deck of %d cards: low = 1 high = %d top = Card S%dR%d",
                size, maxValue, cards[0].getSuit(), cards[0].getRank());
    }
}
