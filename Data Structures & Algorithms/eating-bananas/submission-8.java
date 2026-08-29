class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int minEatingSpeed = r;

        while (l <= r) {
            int midEatingSpeed = (l + r) / 2;
            int timeTakenToEat = 0;

            for (int p : piles) {
                timeTakenToEat += Math.ceil((double) p / midEatingSpeed);
            }

            if (timeTakenToEat <= h) {
                minEatingSpeed = midEatingSpeed;
                r = midEatingSpeed - 1;
            } else {
                l = midEatingSpeed + 1;
            }
        }

        return minEatingSpeed;
    }
}
