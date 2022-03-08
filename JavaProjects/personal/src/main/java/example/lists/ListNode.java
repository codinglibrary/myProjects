package example.lists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author David
 */
public class ListNode<E> extends Object {
    E val;
    public ListNode next;
    public ListNode(){}
    public ListNode(E val){
        this.val=  val;
    }
    public ListNode(E val,ListNode next){
        this.val=val;
        this.next=next;
    }
}
