// Link to problem - https://leetcode.com/problems/merge-two-sorted-lists/

/**
 * Intuition - Iterative approach
 * Scan through the lists and compare their values. A `curr` pointer will point to the
 * last sorted element.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode curr = null;
        
        if(list1 == null) {
            return list2;
        }
        else if(list2 == null) {
            return list1;
        }
        
        if(list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        }
        else {
            head = list2;
            list2 = list2.next;
        }
        curr = head;
        
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            }
            else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        
        while(list1 != null) {
            curr.next = list1;
            list1 = list1.next;
            curr = curr.next;
        }
        
        while(list2 != null) {
            curr.next = list2;
            list2 = list2.next;
            curr = curr.next;
        }
        
        return head;
    }
}
