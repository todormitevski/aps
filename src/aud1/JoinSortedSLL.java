//package aud1;
//
//public class JoinSortedSLL<E extends Comparable<E>> {
//
//    public AudSLL<E> joinSortedLists(AudSLL<E> firstList, AudSLL<E> secondList){
//
//        AudSLL<E> result = new AudSLL<E>();
//        AudSLLNode<E> tmpFirst = firstList.getFirst();
//        AudSLLNode<E> tmpSecond = secondList.getFirst();
//
//        while(tmpFirst != null && tmpSecond != null){
//            if(tmpFirst.element.equals(tmpSecond.element)){
//                result.insertLast(tmpFirst.element);
//                tmpFirst = tmpFirst.succ;
//            } else{
//                result.insertLast(tmpSecond.element);
//                tmpSecond = tmpSecond.succ;
//            }
//        }
//
//        while(tmpFirst != null){
//            result.insertLast(tmpFirst.element);
//            tmpFirst = tmpFirst.succ;
//        }
//
//        while(tmpSecond != null){
//            result.insertLast(tmpSecond.element);
//            tmpSecond = tmpSecond.succ;
//        }
//
//        return null;
//    }
//}
