class Twitter {

    private int time;

    // user -> followees
    private Map<Integer, Set<Integer>> followMap;

    // user -> list of tweets
    private Map<Integer, List<Tweet>> tweetMap;

    public Twitter() {

        time = 0;

        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    // Tweet structure
    class Tweet {

        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public void postTweet(int userId, int tweetId) {

        tweetMap.putIfAbsent(userId, new ArrayList<>());

        tweetMap.get(userId).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();

        // Max Heap based on tweet time
        PriorityQueue<Tweet> maxHeap =
            new PriorityQueue<>(
                (a, b) -> b.time - a.time
            );

        // User should follow themselves
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        // Add tweets of all followees
        for (int followee : followMap.get(userId)) {

            List<Tweet> tweets =
                tweetMap.getOrDefault(followee,
                                      new ArrayList<>());

            for (Tweet tweet : tweets) {
                maxHeap.offer(tweet);
            }
        }

        // Get 10 most recent tweets
        int count = 0;

        while (!maxHeap.isEmpty() && count < 10) {

            result.add(maxHeap.poll().id);
            count++;
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        followMap.putIfAbsent(followerId,
                              new HashSet<>());

        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (followMap.containsKey(followerId) &&
            followeeId != followerId) {

            followMap.get(followerId)
                     .remove(followeeId);
        }
    }
}