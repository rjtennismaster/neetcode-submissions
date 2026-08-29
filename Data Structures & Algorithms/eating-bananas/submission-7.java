class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int smallestSpeed = r;

        while (l <= r) {
            int midSpeed = (l + r) / 2;
            int timeTakenToEat = 0;

            for (int p: piles) {
                timeTakenToEat += Math.ceil((double) p / midSpeed);
            }

            if (timeTakenToEat <= h) {
                smallestSpeed = midSpeed;
                r = midSpeed - 1;
            } else {
                l = midSpeed + 1;
            }
        }
        return smallestSpeed;
    }
}
