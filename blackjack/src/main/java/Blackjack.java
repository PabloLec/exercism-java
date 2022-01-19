import java.util.*;

public class Blackjack {

    public HashMap<String, Integer> cardValues = new HashMap<String, Integer>();

    public Blackjack() {
        cardValues.put("ace", 11);
        cardValues.put("two", 2);
        cardValues.put("three", 3);
        cardValues.put("four", 4);
        cardValues.put("five", 5);
        cardValues.put("six", 6);
        cardValues.put("seven", 7);
        cardValues.put("eight", 8);
        cardValues.put("nine", 9);
        cardValues.put("ten", 10);
        cardValues.put("jack", 10);
        cardValues.put("queen", 10);
        cardValues.put("king", 10);
        cardValues.put("other", 0);
    }

    public int parseCard(String card) {
        return cardValues.get(card);
    }

    public boolean isBlackjack(String card1, String card2) {
        if (parseCard(card1) + parseCard(card2) == 21) {
            return true;
        }
        return false;
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        if (!isBlackjack) {
            return "P";
        }
        else if (isBlackjack && dealerScore > 10) {
            return "W";
        }
        return "S";
    }

    public String smallHand(int handScore, int dealerScore) {
        if (handScore >= 17) {
            return "S";
        }
        else if (handScore <= 11) {
            return "H";
        }
        else if (dealerScore >= 7) {
            return "H";
        }
        return "S";

    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
