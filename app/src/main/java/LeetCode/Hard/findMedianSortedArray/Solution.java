package LeetCode.Hard.findMedianSortedArray;
//still not O(log(m+n))
public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l1=nums1.length;//2
        int l2=nums2.length;//2
        int[] mergedArr=new int[l1+l2];//4

        int i=0;
        int j=0;
        int t=0;

        while(i<l1&&j<l2)
        {
            if(nums1[i]<nums2[j]){
                mergedArr[t]=nums1[i];
                i++;
            }else{
                mergedArr[t]=nums2[j];
                j++;
            }
            t++;
        }
        while(i<l1||j<l2){
            if(i<l1){
                mergedArr[t]=nums1[i];
                i++;
                t++;
            }
            if(j<l2){
                mergedArr[t]=nums2[j];
                j++;
                t++;
            }
        }
        

        if(mergedArr.length%2!=0){
           return (double)mergedArr[mergedArr.length/2];
        }else{
            double index1=(double)mergedArr[(mergedArr.length/2)-1];
            double index2=(double)mergedArr[mergedArr.length/2];
            return (index1+index2)/2;
        }
    }
}
