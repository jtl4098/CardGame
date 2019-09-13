public class Card {
    private int rank; // rank value
    private int suit; // suit value
    private int value; // the value of card

    /**
     * Constructor
     * @param suit
     * @param rank
     */
    public Card(int suit, int rank){
        this.rank = rank;
        this.suit = suit;
        this.value = rank * suit; //calculate value of the card
    }

    public String toString(){
        return "";
    }

    /**
     * To get rank value
     * @return rank value
     */
    public int getRank(){
        return rank;
    }

    /**
     * To get suit value
     * @return suit value
     */
    public int getSuit(){
        return suit;
    }

    /**
     * To get value of the cards
     * @return value of the cards
     */
    public int getValue(){
        return value;
    }
}
