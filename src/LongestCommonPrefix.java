import java.util.*;

/**
 * Created by sw913 on 2017/6/23.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        else if(strs.){
            return "";
        }
        else{
            int min = 9999;
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() < min) {
                    min = strs[i].length();
                }
            }
            int k = 0;
            boolean flag = true;
            Set<Character> bijiao= new HashSet<Character>();
            while(flag){
                for(int j = 0;j<strs.length;j++){
                    bijiao.add(strs[j].charAt(k));
                }
                if(bijiao.size() == 1){
                    flag = true;
                }else{
                    flag = false;
                }
                bijiao.clear();
                k++;
            }
            String result = "";
            for(int l = 0;l<=k;l++){
                result += strs[0].charAt(l);
            }
            return result;
        }
    }
}
