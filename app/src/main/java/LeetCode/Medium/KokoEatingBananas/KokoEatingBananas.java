package LeetCode.Medium.KokoEatingBananas;

public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int k = 0;
        int l = 1;
        int r = 0;
        for (int i : piles) {
            r = Integer.max(r, i);
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            if (canEat(piles, mid, h)) {
                k = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return k;
    }

    public static boolean canEat(int[] piles, int runner, int h) {
        int val = 0;
        for (int i : piles) {
            if (i % runner != 0)
                val++;
            int holder = i / runner;
            val += holder;
        }
        if (val <= h)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 30, 11, 23, 4, 20 };
        System.out.println(minEatingSpeed(arr, 5));
    }
}
