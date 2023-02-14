package ispitni.final_stretch;

import ispitni.finkiHashingCodes.SLL;
import ispitni.finkiHashingCodes.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Card{
    int id;
    int rank;

    public Card(int id, int rank) {
        this.id = id;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return String.format("%d",id);
    }
}

public class Tarot {
    private static void printCards(SLL<Card> deck1, SLL<Card> deck2) {
        SLLNode<Card> firstDeck1 = deck1.getFirst();
        SLLNode<Card> firstDeck2 = deck2.getFirst();
        deck1.delete(firstDeck1);
        deck2.insertLast(firstDeck1.element);
        deck2.delete(firstDeck2);
        deck1.insertLast(firstDeck2.element);

        SLLNode<Card> tmp1 = deck1.getFirst();
        SLLNode<Card> tmp2 = deck2.getFirst();
        SLLNode<Card> secondFromLast = deck1.getFirst();

        while(tmp1.succ != null){
            secondFromLast = tmp1;
            tmp1 = tmp1.succ;
        }

        int counter = 0;
        while(counter != 2){
            tmp2 = tmp2.succ;
            counter++;
        }
        deck1.delete(secondFromLast);
        deck2.insertAfter(secondFromLast.element,tmp2);

        System.out.println(deck1);
        System.out.println(deck2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SLL<Card> deck1 = new SLL<Card>();
        SLL<Card> deck2 = new SLL<Card>();
        for(int i=0;i<6;i++){
            String[] parts = br.readLine().split("\\s+");
            Card card = new Card(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
            deck1.insertLast(card);
        }
        for(int i=0;i<6;i++){
            String[] parts = br.readLine().split("\\s+");
            Card card = new Card(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
            deck2.insertLast(card);
        }
        printCards(deck1,deck2);
    }
}
