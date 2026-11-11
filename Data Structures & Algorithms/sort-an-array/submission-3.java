class Solution {
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];

        mergeSort(0, nums.length - 1, temp, nums);
        return nums;
    }

    private void mergeSort(int left, int right, int[] temp, int[] nums) {
        // divide
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(left, mid, temp, nums);
        mergeSort(mid + 1, right, temp, nums);

        merge(left, mid, right, temp, nums);
    }

    private void merge(int left, int mid, int right, int[] temp, int[] nums) {
        // conquer
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                nums[k++] = temp[i++];
            } else {
                nums[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            nums[k++] = temp[i++];
        }
    }
}