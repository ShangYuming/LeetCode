import java.util.Scanner;

/**
 * Created by sw913 on 2017/6/18.
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        boolean result = true;
        if(x < 0){
            result = false;
        }else{
            //求整数是几位
            int num = 0;
            num = (int)Math.log10(x) + 1;
            int index = 0;
            while(num > 0){
                if(x/(int)(Math.pow(10,(num-1))) != x % 10){
                    result = false;
                    break;
                }else{
                    x = x%(int)(Math.pow(10,num-1));
                    x = x/10;
                    num-=2;
                }

            }

        }
        return result;
    }
}
