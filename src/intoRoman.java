import java.util.Scanner;

/**
 * Created by sw913 on 2017/6/20.
 * 数字转罗马数字，其规律可以总结为：
 * 同一个罗马数字的罗马数字写法只和这个数字对应的1、5、10、100被有关
 * 比如8 Viii 80 LXXX  8000 DCCC
 */
public class intoRoman {
    public static String inToToman(int num){
        String[][] dict = {{"","I","II","III","IV","V","VI","VII","VIII","IX"},
                        {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                        {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                        {"","M","MM","MMM","","","","","",""}};
        return dict[3][num/1000]+dict[2][(num%1000)/100]+dict[1][(num%100)/10] + dict[0][(num%10)];
    }

}
