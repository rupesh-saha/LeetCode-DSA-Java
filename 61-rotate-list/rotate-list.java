/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null){
            return head;
        }

        int size = getSize(head);

        for (int i=0; i < k%size; i++){
          head = rotateMethodRight(head,size);
        }

        return head;
        
    }

    public ListNode rotateMethodRight (ListNode head,int size) {
        
        ListNode newTail = getNode(head, size-2);
        ListNode oldTail = getNode(head, size-1);

        oldTail.next = head;
        newTail.next = null;
        head = oldTail;

        return head;
    }

    public int getSize(ListNode head) {
        ListNode temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    public ListNode getNode(ListNode head, int index) {
        ListNode temp = head;
        int count = 0;

        while (temp != null) {
            if (count == index){
                return temp;
            }

            count++;
            temp = temp.next;
        }

        return temp;
    }
}