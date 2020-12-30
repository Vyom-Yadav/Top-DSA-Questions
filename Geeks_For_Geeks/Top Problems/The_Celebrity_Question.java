/*
A celebrity is a person who is known to all but does not know anyone at a party.
If you go to a party of N people, find if there is a celebrity in the party or not.
A square NxN matrix M[][] is used to represent people at the party such that if an element
of row i and column j  is set to 1 it means ith person knows jth person.
Here M[i][i] will always be 0.
Note: Follow 0 based indexing.


Example 1:

Input:
N = 3
M[][] = {{0 1 0},
         {0 0 0},
         {0 1 0}}
Output: 1
Explanation: 0th and 2nd person both
know 1. Therefore, 1 is the celebrity.

Example 2:

Input:
N = 2
M[][] = {{0 1},
         {1 0}}
Output: -1
Explanation: The two people at the party both
know each other. None of them is a celebrity
*/

//Solution
import java.io.*;
import java.util.*;

public class The_Celebrity_Question {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M, N));
            t--;

        }
    }


    static class Solution {
        int celebrity(int[][] M, int n) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                stack.push(i);
            }
            while (stack.size() >= 2) {
                int a = stack.pop();
                int b = stack.pop();
                if (M[a][b] == 1) {
                    stack.push(b);
                } else {
                    stack.push(a);
                }

            }
            int pot = stack.peek();
            for (int i = 0; i < n; i++) {
                if (i == pot) {
                    continue;
                }
                if (M[pot][i] == 0 && M[i][pot] == 1) {
                    continue;
                } else {
                    return -1;
                }
            }
            return pot;
        }

    }
}
