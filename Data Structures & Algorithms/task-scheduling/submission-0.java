class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];

        for (int task : tasks) {
            freqs[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // add the freqs into the heap
        for (int freq : freqs) {
            if (freq > 0) {
                maxHeap.offer(freq);
            }
        }

        Queue<int[]> q = new LinkedList<>();

        int time = 0;
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            // heap is empty or not
            if (maxHeap.isEmpty()) {
                time = q.peek()[1];
            } else {
                // pluck an element, add it to q if its freq isn't 0
                int freq = maxHeap.poll() - 1;

                if (freq > 0) {
                    q.offer(new int[] {freq, time + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.offer(q.poll()[0]);
            }
        }

        return time;
    }
}
