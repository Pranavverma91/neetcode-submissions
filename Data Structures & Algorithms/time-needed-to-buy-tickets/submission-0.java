public class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int totalTime = 0;
        int kTickets = tickets[k];
        
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                totalTime += Math.min(tickets[i], kTickets);
            } else {
                totalTime += Math.min(tickets[i], kTickets - 1);
            }
        }
        
        return totalTime;
    }
}