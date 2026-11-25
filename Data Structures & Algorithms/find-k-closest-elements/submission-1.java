class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int l = 0;
        int r = arr.length - 1;

        while (r - l + 1 > k) {
            int lAbs = Math.abs(arr[l] - x);
            int rAbs = Math.abs(arr[r] - x);

            if (lAbs <= rAbs) {
                r--;
            } else {
                l++;
            }
        }

        for (int i = l; i <= r; i++) {
            res.add(arr[i]);
        }

        return res;
    }
}