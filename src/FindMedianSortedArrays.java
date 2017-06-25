/**
 * Created by sw913 on 2017/6/1.
 */

import java.util.Arrays;

public class FindMedianSortedArrays {
    public int findMinK(int[] A,int[] B,int a1,int a2,int b1,int b2,int k){
        int m = a2 - a1 + 1;//m是A数组的长度
        int n = b2 - b1 + 1;//n是B数组的长度
        //保证m是哪个比较小的数组
        if(m > n){
            return findMinK(B,A,b1,b2,a1,a2,k);
        }
        if(m == 0){
            return B[b1 + k -1];
        }
        if(k == 1){
            return Math.min(A[a1],B[b1]);
        }
        int posA = Math.min(k/2,m);
        int posB = k-posA;
        if(A[a1+posA-1] == B[b1+posB - 1]){
            return A[a1 + posA - 1];
        }else if(A[a1+posA-1] < B[b1+posB - 1]){
            return findMinK(A,B,a1+posA,a2,b1,b1 + posB -1,k-posA);
        }else{
            return findMinK(A,B,a1,a1+posA-1,b1+posB,b2,k-posB);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1.length + nums2.length) % 2 == 0){
            return (findMinK(nums1,nums2,0,nums1.length-1,0,nums2.length-1,(nums1.length+nums2.length)/2)+findMinK(nums1,nums2,0,nums1.length-1,0,nums2.length-1,(nums1.length+nums2.length)/2+1))/2.0;
        }else{
            return findMinK(nums1,nums2,0,nums1.length-1,0,nums2.length-1,(nums1.length+nums2.length)/2 + 1);
        }
    }
}
