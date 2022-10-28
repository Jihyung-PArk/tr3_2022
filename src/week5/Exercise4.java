package week5;

import textio.TextIO;

public class Exercise4 {

    public static void main(String[] args) {

        Deck deck = new Deck();
        boolean replay;



        do{
            deck.shuffle();
            BlackjackHand blackjackHand = new BlackjackHand();
            int cards = 2 + (int)(Math.random()*5);
            System.out.print("On hand : ");
            for(int num = 0; num < cards; num++){
                Card card = deck.dealCard();
                System.out.print(" " + card);
                System.out.println();
            }

            System.out.println("Value computed for the hand is " + blackjackHand.getBlackjackValue());
            System.out.println("Do you want replay again?");
             replay = TextIO.getlnBoolean();
        }while (replay);
    }
}
