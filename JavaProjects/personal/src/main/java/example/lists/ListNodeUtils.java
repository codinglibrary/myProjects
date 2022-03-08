package example.lists;

import java.util.*;


/**
 * @author David
 */
public class ListNodeUtils<E> {
    public static ListNode likedListTransToListNode(LinkedList linkedList){
        if(linkedList.isEmpty()){
            return new ListNode();
        }
        ListNode head = new ListNode();
        Iterator iterator = linkedList.iterator();
        head.val = iterator.next();
        ListNode pre = head ,t ;
        while(iterator.hasNext()){
            t = new ListNode();
            t.val = iterator.next();
            pre.next = t;
            pre = t ;
        }
        return head;
    }
    public static LinkedList listNodeTransToLikedList(ListNode head) {
        LinkedList linkedList = new LinkedList();
        if(head == null ){
            return null;
        }
        ListNode p = head;
        while(p!=null){
            linkedList.add(p.val);
            p = p.next;
        }
        return linkedList;
    }
    public static String listToString(ListNode head){
        String result = "[";
        ListNode p=head;
        while(p!=null){
            result = result + p.val.toString();
            p = p.next;
            if(p!=null){
                result += ", ";
            }
        }
        result = result + "]";
        return result;
    }
    public static ListNode reverseListNode(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null ){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static ListNode detectLoop(){

        return null;
    }
}

