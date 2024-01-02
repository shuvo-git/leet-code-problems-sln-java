package main.zigzag;

public class Zigzag {
    public static void main(String[] args) {
        String s1 = "thisisazigzag";
        String s2 = "thisisazigzagandthisisalsoazigzag";
        String s = "0123456789ABC";

        printSpiral(s, 5);
        printSpiral(s1, 5);
        printSpiral(s2, 5);
    }

    public static void printSpiral(String str, int k) {
        System.out.println(str);
        int len = str.length();

        int nextFactor = (k - 1) * 2;


        for (int i = 0; i < len; i = i + nextFactor) {
            System.out.printf("%c", str.charAt(i));
            printSpace(nextFactor - 1, ' ');

        }
        System.out.println();

        for (int rowStart = 1; rowStart < k; ++rowStart) {
            for (int left = rowStart; left < len; left += nextFactor) {

                printSpace(rowStart, ' ');
                if (left >= nextFactor) printSpace(rowStart - 1, ' ');

                //int left = i;
                int right = left + nextFactor - rowStart * 2;

                //if (right < len) {
                if (left == right)
                    System.out.printf("%c", str.charAt(left));
                else {
                    System.out.printf("%c", str.charAt(left));
                    if (right < len) {
                        printSpace(right - left - 1, ' ');
                        System.out.printf("%c", str.charAt(right));
                    }
                }
                //}
            }
            System.out.println();
        }
    }

    public static void printSpace(int numOfSpace) {
        while (numOfSpace-- != 0) {
            System.out.printf("%c", ' ');
        }
    }

    public static void printSpace(int numOfSpace, char c) {
        while (numOfSpace-- != 0) {
            System.out.printf("%c", c);
        }
    }
}
