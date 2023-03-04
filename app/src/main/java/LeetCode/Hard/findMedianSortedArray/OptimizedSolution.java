package LeetCode.Hard.findMedianSortedArray;
//still not O(log(m+n))
public class OptimizedSolution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l1=nums1.length;
        int l2=nums2.length;
        int l3=l1+l2;
        int[] mergedArr=new int[l3];//4

        int i=0;
        int j=0;
        int t=0;

        while (i < l1 || j < l2) {
            if (i < l1 && j < l2) {
                mergedArr[t++] = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
            } else if (i < l1) {
                mergedArr[t++] = nums1[i++];
            } else {
                mergedArr[t++] = nums2[j++];
            }
        }

        if(l3%2!=0){
           return (double)mergedArr[l3/2];
        }else{
            return (((double)mergedArr[(l3/2)-1])+((double)mergedArr[l3/2]))/2;
        }
    }
}
