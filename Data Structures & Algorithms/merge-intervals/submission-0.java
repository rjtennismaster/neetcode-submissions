class Solution {
    public int[][] merge(int[][] intervals) {
        // sort
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // init res
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        // merge if needed, add if not
        for (int[] arr : intervals) {
            int start = arr[0];
            int end = arr[1];
            int lastEnd = res.getLast()[1];

            if (start <= lastEnd) {
                res.getLast()[1] = Math.max(end, lastEnd);
            } else {
                res.add(new int[] {start, end});
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
