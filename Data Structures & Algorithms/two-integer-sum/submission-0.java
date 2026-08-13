class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> elementToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];

            // check if the difference is in the HashMap. If not, add the current element to it
            if (elementToIndex.containsKey(difference))
                return i < elementToIndex.get(difference) ? new int[] {i, elementToIndex.get(difference)}: new int[] {elementToIndex.get(difference), i};

            elementToIndex.put(nums[i], i);
        }

        return null;
    }
}
