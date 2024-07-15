package main.solution;

public class ConcatenateArray {
    public static void main(String[] args) {
        ConcatenateArray ca = new ConcatenateArray();
        ca.getConcatenation(new int[]{1,2,3});
    }
    // Solved
    public int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int[] resultArray = new int[length+length];
        System.arraycopy(nums, 0, resultArray, 0, length);
        System.arraycopy(nums, 0, resultArray, length, length);
        return resultArray;
    }
}
