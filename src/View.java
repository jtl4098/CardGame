import java.util.Scanner;

/**
 * <pre>
 *     Program : View
 * @author : TK KIL
 * Date : 20/June/2019
 *
 * Purpose : Makes deck of cards
 * </pre>
 */
public class View {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in); // To get users input
        System.out.print("How many suits? ");
        int sc = input.nextInt();


        System.out.print("How many ranks? "); // To get users input
        int ra = input.nextInt();

        /**
         * Make new constructor to make deck
         */
        DeckOfCards deck = new DeckOfCards(sc, ra);

        System.out.println(deck.toString());
        System.out.println("1 = shuffle, 2=deal 1 hand, 3=deal 100000 times, 4=quit: "); // making option
        int choice;

        /**
         * if user wants to quit, the input should be "4"
         *
         */
        do {
            choice = input.nextInt();
            switch (choice){
                case 1 : // shuffle case
                    deck.shuffle();

                    System.out.println(deck.toString());
                    System.out.println("1 = shuffle, 2=deal 1 hand, 3=deal 100000 times, 4=quit: ");
                    break;

                case 2 : // deal case
                    System.out.print("How many cards ? ");
                    int mc = input.nextInt();

                    Card[] cd = deck.deal(mc);
                    for(int i = 0; i < cd.length ; i++){
                        System.out.printf("Card S%dR%d  ",cd[i].getSuit(), cd[i].getRank());
                    }
                    System.out.println("");
                    System.out.println(deck.toString());
                    System.out.println("1 = shuffle, 2=deal 1 hand, 3=deal 100000 times, 4=quit: ");
                    break;
                case 3 : // deal and shuffle 100000 times case
                    System.out.print("How many cards ? ");
                    int cc = input.nextInt();

                    int [] result = deck.Histogram(cc); // make new array to deal and shuffle 1000 times

                    /**
                     * To express Histogram.
                     */
                    for (int i = deck.minCase(result); i <= deck.maxCase(result); i++) {
                        if (i < 10)
                            System.out.print(" ");
                        System.out.println(i + ": " + result[i]);
                    }
                    System.out.println(deck.toString());
                    System.out.println("1 = shuffle, 2=deal 1 hand, 3=deal 100000 times, 4=quit: ");
                    break;
            }

        }while (choice != 4); // quit

        System.out.println("BYE !");



    }
}
