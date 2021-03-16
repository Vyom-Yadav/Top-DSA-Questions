/*
Given a linked list, swap every two adjacent nodes and return its head.

 

Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
 

Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
*/
// Before watching solution try on https://leetcode.com/problems/swap-nodes-in-pairs/
// Solution
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        int abc;
        while(temp.next!= null) {
            abc = temp.next.val;
            temp.next.val = temp.val;
            temp.val = abc;
            if(temp.next.next!= null){
                temp = temp.next.next;
            }
            else{
                break;
            }
        }
        return head;
    }
}
