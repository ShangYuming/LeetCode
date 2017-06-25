/**
 * Created by sw913 on 2017/6/20.
 */
public class ContainerWithMostWaters {

    public static int V(int ax,int ay, int bx,int by){
        if(ay == 0 || by == 0)
            return 0;
        else
            return (Math.min(ay,by))*Math.abs((bx - ax));
    }
    public static int maxArea(int[] height){
        int len = height.length;
        if(height.length < 2)
            return 0;
        int max = 0;
        int temp = 0;
        int i = 0,j = len-1;
        while(i < j){
            temp = V(i,height[i],j,height[j]);
            max = temp > max ? temp:max;
            if(height[i] < height[j]){
                i++;
            } else{
                j--;
            }
        }
        return max;
    }
}
