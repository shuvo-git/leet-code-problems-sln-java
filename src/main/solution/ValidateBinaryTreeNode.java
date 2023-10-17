package main.solution;

import java.util.Arrays;

/***************************
 * @Author: Jobayed Ullah
 * @email: shuvo.pma@gmail.com
 * @date: 10/17/2023
 * @time: 5:26 PM
 */
// 1361
public class ValidateBinaryTreeNode {
    public static void main(String[] args) {
        System.out.println(
                ValidateBinaryTreeNode.validateBinaryTreeNodes(
                        6,
                        new int[]{1, -1, -1, 4, -1, -1},
                        new int[]{2, -1, -1, 5, -1, -1}
                )); // False
        System.out.println(
                ValidateBinaryTreeNode.validateBinaryTreeNodes(
                        4,
                        new int[]{1, -1, 3, -1},
                        new int[]{2, -1, -1, -1}
                )); // true
        System.out.println(
                ValidateBinaryTreeNode.validateBinaryTreeNodes(
                        4,
                        new int[]{3, -1, 1, -1},
                        new int[]{-1, -1, 0, -1}
                )); //True

        System.out.println(
                ValidateBinaryTreeNode.validateBinaryTreeNodes(
                        4,
                        new int[]{1, -1, 3, -1},
                        new int[]{2, 3, -1, -1}
                )); //False
        System.out.println(
                ValidateBinaryTreeNode.validateBinaryTreeNodes(
                        4,
                        new int[]{1, 0, 3, -1},
                        new int[]{-1, -1, -1, -1}
                )); //False
    }

    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        int[] parent = new int[n];
        Arrays.fill(parent, -1);


        for (int i = 0; i < leftChild.length; ++i) {
            int left = leftChild[i];
            int right = rightChild[i];

            if (left != -1) {
                if (parent[left] != -1) {
                    if (parent[left] != i) {
                        return false;
                    }

                } else
                    parent[left] = i;
            }

            if (right != -1) {
                if (parent[right] != -1) {
                    if (parent[right] != i) {
                        return false;
                    }

                } else
                    parent[right] = i;
            }
        }

        int rootCnt = 0;
        for (int i = 0; i < n; ++i) {
            if (parent[i] == -1) ++rootCnt;
        }

        if (rootCnt != 1) return false;

        int[] visited = new int[n];

        return !dfs(visited, n, leftChild, rightChild, 0);

    }

    private static boolean dfs(int[] visited, int n, int[] leftChild, int[] rightChild, int s) {
        //if (visited[s] == 2) return true;
        visited[s] = 1;

        int left = leftChild[s];
        if (left != -1) {
            if (visited[left] == 0) {
                return dfs(visited, n, leftChild, rightChild, left);
            } else if (visited[left] == 1) return true;
        }

        int right = rightChild[s];
        if (right != -1) {
            if (visited[right] == 0) {
                return dfs(visited, n, leftChild, rightChild, right);
            } else if (visited[right] == 1) return true;
        }


        //visited[s] = 2;
        return false;

    }
}
