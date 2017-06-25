import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sw913 on 2017/6/5.
 */
public class ZigzagConversion {
    public static String convert(String s,int numRows){
        int len = s.length();
        if (len == 0 || numRows <= 1) return s;

        String[] ans = new String[numRows];
        Arrays.fill(ans, "");
        int row = 0, delta = 1;
        for (int i = 0; i < len; i++) {
            ans[row] += s.charAt(i);
            row += delta;
            if (row >= numRows) {
                row = numRows-2;
                delta = -1;
            }
            if (row < 0) {
                row = 1;
                delta = 1;
            }
        }

        String ret = "";
        for (int i = 0; i < numRows; i++) {
            ret += ans[i];
        }
        return ret;
    }

}
