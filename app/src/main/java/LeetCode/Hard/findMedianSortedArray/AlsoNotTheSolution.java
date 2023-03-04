package LeetCode.Hard.findMedianSortedArray;

public class AlsoNotTheSolution {
    // check if arr.length>0 yes --> go on, no --> skip this arr
    // if arr odd length/2 otherwise length/2 %% length/2 + 1
    // calculate median of each arr
    // merge both median into new arr, mergedarr.length==2
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        double median1 = 0;
        double median2 = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        double[] medianArr = new double[2];
        if (length2 == 0 && length1 == 0)
            return 0;
        if (length1 == 0) {
            return findMedian(nums2);
        }
        if (length2 == 0) {
            return findMedian(nums1);
        }
        if (length2 == 1 && length1 == 1){
            return ((double) (nums1[0] + nums2[0])) / 2;
        }
        if (length1 == 1){
            return medianOneElementArr(nums1, nums2);
        }
        if (length2 == 1){
            return medianOneElementArr(nums2, nums1);
        }

        median1 = findMedian(nums1);
        median2 = findMedian(nums2);

        if (median2 > median1) {
            medianArr[0] = median1;
            medianArr[1] = median2;
        } else {
            medianArr[0] = median2;
            medianArr[1] = median1;
        }

        median = (medianArr[0] + medianArr[1]) / 2;

        return median;
    }

    public static double medianOneElementArr(int[] oneElemenrArr, int[] nums) {
        double median = 0;
        int[] mergedArr = new int[nums.length + 1];
        int index = binarySearch(nums, oneElemenrArr[0]);
        System.out.println(index);
        if (index >= 0){
            mergedArr[index] = oneElemenrArr[0];
        }
        else{
            mergedArr[(-index) - 1] = oneElemenrArr[0];
        }
        
        for (int i = 0; i < nums.length; i++) {
          
            int index2 = binarySearch(mergedArr, nums[i]);
            System.out.println("i: "+ nums[i]);
            System.out.println("index2: "+ index2);
            // if (index2 >= 0){
            //     mergedArr[index2] = nums[i];
            // }
            // else{
            //     mergedArr[(-index2) - 1] = nums[i];
            // }
        }
        median = findMedian(mergedArr);
        return median;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -(left + 1);
    }

    public static double findMedian(int[] nums1) {
        double median = 0;
        int length = nums1.length;
        if (length % 2 != 0)
            median = (double) (nums1[(length - 1) / 2]);
        else
            median = (((double) nums1[length / 2]) + ((double) (nums1[length / 2] - 1))) / 2;
        return median;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1 };
        int[] arr2 = { 3, 4 };
        System.out.println(findMedianSortedArrays(arr1, arr2));

    }
}
