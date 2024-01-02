package main.zigzag;

public class Zigzag {
    public static void main(String[] args) {
        String s = "thisisazigzag";
        printSpiral(s, 4);
    }

    public static void printSpiral(String s, int k) {
        //System.out.printf("%c %c %c", s.charAt(0), s.charAt(6), s.charAt(12));


        int len = s.length();

        for (int i = 0, p = k; i < k; ++i, p = p - 2) {

            // print space before every line
            for (int sp = 0; sp < i; ++sp) {
                System.out.printf("%c", ' ');
            }

            for (int j = i; j < len; j = j + p + 2) {
                // print each character
                System.out.print(s.charAt(i));

                // Print space between character
                int spaceCount = p+1;
                while (spaceCount != 0) {
                    System.out.printf("%c", ' ');
                    --spaceCount;
                }
            }
            System.out.println();
        }
    }
}
