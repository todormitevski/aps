//package ispitni.lists_WO_methods;
//
//import ispitni.finkiHashingCodes.SLL;
//import ispitni.finkiHashingCodes.SLLNode;
//
//import java.util.Scanner;
//
//class Hero{
//    //yeah
//}
//
//public class Heroes {
//    public static void startHeroesGame(SLL<Hero> playerOne, SLL<Hero> playerTwo) {
//        //Find the strongest card from p1, remove, add to middle od p2
//        SLLNode<Hero> tmp = playerOne.getFirst();
//        SLLNode<Hero> toRemove = tmp;
//        int max = tmp.element.getStrength();
//        tmp = tmp.succ;
//
//        //Find max
//        while (tmp != null) {
//            if (tmp.element.getStrength() > max) {
//                max = tmp.element.getStrength();
//                toRemove = tmp;
//            }
//            tmp = tmp.succ;
//        }
//
//        //Delete
//        tmp = playerOne.getFirst();
//        if (toRemove.equals(playerOne.first)) {
//            playerOne.first = playerOne.first.succ;
//        } else {
//            while (tmp.succ != toRemove && tmp.succ.succ != null) {
//                tmp = tmp.succ;
//            }
//            if (tmp.succ == toRemove) tmp.succ = tmp.succ.succ;
//        }
//
//        //Find middle of playerTwo
//        SLLNode<Hero> fast = playerTwo.getFirst();
//        SLLNode<Hero> middle = playerTwo.getFirst();
//        while (fast.succ != null && fast.succ.succ != null) {
//            fast = fast.succ.succ;
//            middle = middle.succ;
//        }
//
//        //Insert in middle
//        tmp = playerTwo.getFirst();
//        while (tmp != null) {
//            if (tmp.equals(middle)) {
//                SLLNode<Hero> extra = tmp.succ;
//                tmp.succ = toRemove;
//                toRemove.succ = extra;
//            }
//            tmp = tmp.succ;
//        }
//    }
//
//    public static void main(String[] args) {
//        //yeah
//    }
//}
