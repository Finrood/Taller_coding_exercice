import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class Main {

    /**
     * longest palindromic substring: Given a string, find the longest substring which is palindrome.
     *
     * Input: abac
     * output: aba
     *
     * Input: tacag
     * output:  aca
     *
     * Input: wegeeksskeegyuweppppppppppppppppp,
     *
     * we
     *
     * Output: "geeksskeeg"
     *
     * Input: abacd
     */

    public static void main(String[] args) {
        //System.out.println(findLongestPalindrome("abac"));
        //System.out.println(findLongestPalindrome("tacag"));
        System.out.println(findLongestPalindrome("wegeeksskeegyuwe"));
        //System.out.println(findLongestPalindrome("abac"));

    }

    public static String findLongestPalindrome(String s) {
        // have a Stringbuilder result variable
        // Iterate from 0 - middle
        // iterate from end to middle
        // compare chars and check if they match
        // if match, increment start1 and decrement start2. write in result in start1 index, chars at start1, and same for start2
        // if don't match : increment start1 go thought the entire string

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int sameCharLastIndex = i;
            for (int j = i+1; j < s.length(); j++) {
                if (c == s.charAt(j)) {
                    sameCharLastIndex = j;
                }
            }
            if (sameCharLastIndex == i) continue;

            int potentialIndex1 = i;
            int potentialIndex2 = sameCharLastIndex;

            String potentialPalindrome = s.substring(i, sameCharLastIndex+1);
            int middleIndex = potentialPalindrome.length()/2;
            boolean isResult = true;

            for (potentialIndex1=i; (potentialIndex1!=potentialIndex2); potentialIndex1++) {
                char a = s.charAt(potentialIndex1);
                char b = s.charAt(potentialIndex2);

                if (a != b) {
                    isResult = false;
                    continue;
                }
                potentialIndex2--;
            }
            if (isResult) {
                return potentialPalindrome;
            }
            break;
        }
        return null;
    }

}