//package ispitni.lists_WO_methods;
//
//import ispitni.finkiHashingCodes.SLL;
//import ispitni.finkiHashingCodes.SLLNode;
//
//public class Cakes {
//    //Izbrisi jazli cii vrednosti se javuvaat paren broj pati
//    //Dozvoleno e samo edna lista
//    public static void deleteEven(SLL<Integer> list) {
//        SLLNode<Integer> tmp = list.getFirst();
//        SLLNode<Integer> current;
//        int counter;
//        while (tmp != null) {
//            counter = 0;
//            current = list.getFirst();
//
//            //Count occurences
//            while (current != null) {
//                if (current.element.equals(tmp.element))
//                    ++counter;
//                current = current.succ;
//            }
//
//            if (counter % 2 == 0) {
//                SLLNode<Integer> toDelete = tmp;
//                while (toDelete != null) {
//                    if (toDelete.element == tmp.element)
//                        list.delete(toDelete);
//                    toDelete = toDelete.succ;
//                }
//            }
//
//            tmp = tmp.succ;
//        }
//    }
//}
