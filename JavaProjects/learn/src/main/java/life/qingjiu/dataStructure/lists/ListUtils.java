package main.java.life.qingjiu.dataStructure.lists;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.List;


/**
 * @author David
 */
public class ListUtils<E> {
    public static ListNode listNodeTransToLinkedList(LinkedList linkedList){
        if(linkedList.isEmpty()){
            return new ListNode();
        }
        ListNode head = new ListNode(linkedList.getFirst(),null);
        return head;
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
    public static ListNode checkLoop(){

    }

}

