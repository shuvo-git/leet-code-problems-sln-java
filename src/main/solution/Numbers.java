package main.solution;

import java.util.HashMap;
import java.util.Map;

/***************************
 * {@link Name: } Jobayed Ullah
 */

public class Numbers {

    // 13. Roman to Integer
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int len = s.length();
        int result = 0;

        for (int i = 0; i < len; ++i) {
            Character c = s.charAt(i);
            result += map.get(c);

            if (i > 0) {
                Character cMinusOne = s.charAt(i - 1);
                switch (c) {
                    case 'V':
                        if (cMinusOne == 'I')
                            result -= 2;
                        break;
                    case 'X':
                        if (cMinusOne == 'I')
                            result -= 2;
                        break;
                    case 'L':
                        if (cMinusOne == 'X')
                            result -= 20;
                        break;
                    case 'C':
                        if (cMinusOne == 'X')
                            result -= 20;
                        break;
                    case 'D':
                        if (cMinusOne == 'C')
                            result -= 200;
                        break;
                    case 'M':
                        if (cMinusOne == 'C')
                            result -= 200;
                        break;
                    default:
                        break;
                }
            }


        }
        return result;
    }
}
