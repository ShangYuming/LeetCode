import java.util.Scanner;

/**
 * Created by sw913 on 2017/6/13.
 */
public class ReverseInteger {
    //max = 3147483647
    public static int reverse(int x){
        double result = 0;
        if(x == 0) return (int) result;
        else{
            String str = ""+x;
            if(str.charAt(0)=='-'){
                str = str.substring(1);
                str = new StringBuilder(str).reverse().toString();
                str = ""+"-"+str;
                result = Double.parseDouble(str);
            }else{
                str = new StringBuilder(str).reverse().toString();
                result = Double.parseDouble(str);
            }
        }
        if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE){
            result = 0;
        }
        return (int)result;
    }
}
