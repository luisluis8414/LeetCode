package LeetCode.Hard.findMedianSortedArray;
//Not the solution. Initial approach but Complexity is O(m+n) and not O(log(m+n))
class NotSolution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArr = merge(nums1, nums2);
        double median;
        if (mergedArr.length % 2 != 0) {//wenn ungerade
            int index = ((mergedArr.length / 2));
            median = (double) (mergedArr[index]);
        } else {//wenn gerade 
            int index1 = (mergedArr.length / 2)-1;
            int index2 = (mergedArr.length / 2);
            System.out.println(index1 +" "+ index2);
            System.out.println(mergedArr[index1] +" "+ mergedArr[index2]);
            median = (double) ((mergedArr[index1] + mergedArr[index2]));
            median/=2;
        };
        return median;
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] mergedArr = new int[m + n];

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                mergedArr[k++] = arr1[i++];
            } else {
                mergedArr[k++] = arr2[j++];
            }
        }
        while (i < m) {
            mergedArr[k++] = arr1[i++];
        }
        while (j < n) {
            mergedArr[k++] = arr2[j++];
        }

        return mergedArr;
        // int m = arr1.length;
        // int n = arr2.length;
        // int[] mergedArr = new int[m + n];
        // // int t =Math.min(m, n);
        // for (int i = 0; i < m; i++) {
        // int index = binarySearch(arr2, arr1[i]);
        // if(index<0){ //wenn Element arr1[i] nicht in arr2 exsistiert
        // System.out.println(index);
        // int index1=-index-1+i;
        // //System.out.println(-index-1+i); -index-1+i --> Stelle an der die Werte aus
        // arr1 muessn
        // mergedArr[index1]=arr1[i];
        // mergedArr[index1+1]=arr2[i];
        // }else { //wenn arr1[i] in arr2 exsistiert
        // System.out.println(index);
        // mergedArr[index+i]=arr1[i];
        // mergedArr[index+1+i]=arr2[i];
        // }
        // }
        // if(arr2.length>arr1.length){
        // int index=arr2.length-(arr2.length-arr1.length);
        // for(int i=arr1.length*2;i<mergedArr.length;i++){
        // mergedArr[i]=arr2[index];
        // index++;
        // }
        // }
        // return mergedArr;
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

    public static void main(String[] args) {
        int[] arr1 = { 1, 2};
        int[] arr2 = {3, 4};
        System.out.println(findMedianSortedArrays(arr1, arr2));;
    }
}
