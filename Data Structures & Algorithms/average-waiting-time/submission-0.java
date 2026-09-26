public class Solution {
    public double averageWaitingTime(int[][] customers) {
        long currentTime = 0;
        long totalWaitTime = 0;

        for (int[] customer : customers) {
            int arrival = customer[0];
            int time = customer[1];
            currentTime = Math.max(currentTime, arrival) + time;
            totalWaitTime += (currentTime - arrival);
        }

        return (double) totalWaitTime / customers.length;
    }
}