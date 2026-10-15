class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int res = 0, lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start < lastEnd) {
                res++;
                lastEnd = Math.min(lastEnd, end);
            } else {
                lastEnd = end;
            }
        }

        return res;
    }
}
