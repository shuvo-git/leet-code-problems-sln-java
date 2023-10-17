package main.solution;

/***************************
 * @Author: Jobayed Ullah
 * @email: shuvo.pma@gmail.com
 * @date: 10/17/2023
 * @time: 5:26 PM
 */

public class ValidateBinaryTreeNode {
    public static void main(String[] args) {
        System.out.println(
                ValidateBinaryTreeNode.validateBinaryTreeNodes(
                        6,
                        new int[]{1,-1,-1,4,-1,-1},
                        new int[]{2,-1,-1,5,-1,-1}
                ));
        System.out.println(
                ValidateBinaryTreeNode.validateBinaryTreeNodes(
                        4,
                        new int[]{1, -1, 3, -1},
                        new int[]{2, -1, -1, -1}
                ));
        System.out.println(
                ValidateBinaryTreeNode.validateBinaryTreeNodes(
                        4,
                        new int[]{3, -1, 1, -1},
                        new int[]{-1, -1, 0, -1}
                ));
    }

    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        int[] freq = new int[n];
        int[] edge = new int[n];

        for (int i = 0; i < leftChild.length; ++i) {
            int left = leftChild[i];

            if (left > -1) {
                ++edge[left];
                ++edge[i];

                ++freq[left];
                if (freq[left] > 1)
                    return false;
            }
        }

        for (int i = 0; i < rightChild.length; ++i) {
            int right = rightChild[i];

            if (right > -1) {
                ++edge[right];
                ++edge[i];

                ++freq[right];
                if (freq[right] > 1)
                    return false;
            }
        }

        for (int i = 0; i < n; ++i) {
            if (edge[i] == 0)
                return false;
        }

        return true;
    }
}
