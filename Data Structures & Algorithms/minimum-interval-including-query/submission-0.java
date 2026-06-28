class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int n = queries.length;
        int[][] sortedQueries = new int[n][2];

        for (int i = 0; i < n; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] ans = new int[n];
        int i = 0;

        for (int[] q : sortedQueries) {

            int query = q[0];
            int index = q[1];
            while (i < intervals.length && intervals[i][0] <= query) {
                int length = intervals[i][1] - intervals[i][0] + 1;
                pq.offer(new int[]{length, intervals[i][1]});
                i++;
            }
            while (!pq.isEmpty() && pq.peek()[1] < query) {
                pq.poll();
            }

            ans[index] = pq.isEmpty() ? -1 : pq.peek()[0];
        }

        return ans;
    }
}