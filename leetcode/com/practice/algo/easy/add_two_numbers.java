/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result =null;
        ListNode current = null;
        int i=0;
        int carry =0 ;
        while(l1 != null &&  l2 != null  ) {
            int sumDigit = l1.val + l2.val + carry;
            if(sumDigit > 9){
                carry = sumDigit / 10;
                sumDigit %= 10;
            } else {
                carry = 0;                
            }
            if(result == null) {
                result = current = new ListNode(sumDigit);
            } else {
                current.next = new ListNode(sumDigit);  
                current =current.next;                  
            }
            l1 = l1.next;
            l2 = l2.next;
        }
            while(l1 != null) {
                int nextDigit = l1.val + carry;
                if(nextDigit > 9){
                    carry = nextDigit / 10;
                    nextDigit %= 10;
                } else {
                    carry = 0;                
                }
                if(result == null) {
                    result = current = new ListNode(nextDigit);
                } else {
                    current.next = new ListNode(nextDigit); 
                    current =current.next;                   
                }
                l1 = l1.next;
            }
        
        
       
            while(l2 != null) {
                int nextDigit = l2.val + carry;
                if(nextDigit > 9){
                    carry = nextDigit / 10;
                    nextDigit %= 10;
                } else {
                    carry = 0;                
                }
                if(result == null) {
                    result = current = new ListNode(nextDigit);
                } else {
                    current.next = new ListNode(nextDigit); 
                    current =current.next;
                }
                l2 = l2.next;
            }
        
        if(carry != 0) {
            current.next = new ListNode(carry);
        }
        
        return result;
        
    }
}
