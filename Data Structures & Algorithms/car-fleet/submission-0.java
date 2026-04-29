class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Pair position and time
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        // Sort by position descending
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double prevTime = 0;

        for (int i = 0; i < n; i++) {
            double currTime = cars[i][1];

            // New fleet if current time is greater
            if (currTime > prevTime) {
                fleets++;
                prevTime = currTime;
            }
        }

        return fleets;
    }
}