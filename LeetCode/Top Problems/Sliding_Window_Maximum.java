/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.



Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
Example 3:

Input: nums = [1,-1], k = 1
Output: [1,-1]
 */
/*
PLEASE BEFORE SEEING THE SOLUTION TRY YOURSELF ON https://leetcode.com/problems/sliding-window-maximum/
 */
//Solution
import java.util.*; // No need to write this line on leetcode.
public class Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k){
        int n = nums.length;
        int i =0;
        Deque<Integer> store = new LinkedList<>();
        int[] ans = new int[n-k+1];
        for(;i<n;i++){
            if(i<k) {
                while (!store.isEmpty() && nums[store.peekLast()] <= nums[i]) {
                    store.removeLast();
                }
                store.addLast(i);
            }
            else{
                ans[i-k] = nums[store.peekFirst()];
                while(!store.isEmpty() && store.peekFirst() <= i-k){
                    store.removeFirst();
                }
                while (!store.isEmpty() && nums[store.peekLast()] <= nums[i]) {
                    store.removeLast();
                }
                store.addLast(i);
            }
        }
        ans[i-k] = nums[store.peekFirst()];
        return ans;
    }
}
