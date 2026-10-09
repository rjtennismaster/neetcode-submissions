class Solution {
    public int rob(int[] nums) {
        int oneAgo = 0, twoAgo = 0;
        
        for (int num : nums) {
            int robDecision = Math.max(oneAgo, num + twoAgo);
            twoAgo = oneAgo;
            oneAgo = robDecision;
        }
        
        return oneAgo;
    }
}
