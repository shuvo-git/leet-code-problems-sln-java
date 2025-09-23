package main.leetcode;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 9/23/25 7:46 PM
 */

public class Hashmap {
    public static void main(String[] args) {

    }

    // 383. Ransom Note
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] noteFreq = new int[128];
        for (char c : ransomNote.toCharArray()) {
            ++noteFreq[c];
        }

        int[] magFreq = new int[128];
        for (char c : magazine.toCharArray()) {
            ++magFreq[c];
        }

        for (char c : ransomNote.toCharArray()) {
            if (magFreq[c] < noteFreq[c])
                return false;
        }
        return true;
    }

}
