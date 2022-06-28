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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next == null)
            return true;
        //find mid;
        ListNode slow= head; 
        ListNode fast= head;
        while(fast.next!=null &&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //reverse the list
        slow.next=reverseList(slow.next);
        //move slow to next
        slow= slow.next;
        //compare
            while(slow!=null){
                if(head.val!=slow.val)
                    return false;
                head=head.next;
                slow= slow.next;
                
            }
        return true;
    }
        
        
        
        ListNode reverseList(ListNode head){
            ListNode prev=null;
            ListNode next=null;
            while(head !=null){
                next=head.next;
                head.next=prev;
                prev= head;
                head=next;
            }
            return prev;
        }
        
    
}
