class Solution {
    static class Visit {
        int timestamp;
        String website;

        Visit(int timestamp, String website) {
            this.timestamp = timestamp;
            this.website = website;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Visit>> userVisits = new HashMap<>();
        int n = username.length;
        for (int i = 0; i < n; i++) {
            userVisits.putIfAbsent(username[i], new ArrayList<>());
            userVisits.get(username[i]).add(new Visit(timestamp[i], website[i]));
        }
        Map<String, Integer> patternCounts = new HashMap<>();
        for (String user : userVisits.keySet()) {
            List<Visit> visits = userVisits.get(user);
            visits.sort((a, b) -> Integer.compare(a.timestamp, b.timestamp));

            int size = visits.size();
            Set<String> userPatterns = new HashSet<>();
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    for (int k = j + 1; k < size; k++) {
                        String pattern = visits.get(i).website + "," + 
                                         visits.get(j).website + "," + 
                                         visits.get(k).website;
                        userPatterns.add(pattern);
                    }
                }
            }
            for (String pattern : userPatterns) {
                patternCounts.put(pattern, patternCounts.getOrDefault(pattern, 0) + 1);
            }
        }

        String maxPattern = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : patternCounts.entrySet()) {
            String pattern = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount) {
                maxCount = count;
                maxPattern = pattern;
            } else if (count == maxCount) {
                if (maxPattern.isEmpty() || pattern.compareTo(maxPattern) < 0) {
                    maxPattern = pattern;
                }
            }
        }

        return Arrays.asList(maxPattern.split(","));
    }
}