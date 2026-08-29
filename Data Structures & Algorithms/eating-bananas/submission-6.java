class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int smallestSpeed = right;

        while (left <= right) {
            int midSpeed = (left + right) / 2;
            // we need to compare in terms of time taken to eat, not speed

            int timeToEat = 0;

            for (int p: piles) {
                timeToEat += Math.ceil((double) p / midSpeed);
            }

            if (timeToEat <= h) {
                smallestSpeed = midSpeed;
                right = midSpeed - 1;
            } else {
                left = midSpeed + 1;
            }
        }
        return smallestSpeed;
    }
}
