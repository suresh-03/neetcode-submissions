class Twitter {
    int time;
    Map<Integer, PriorityQueue<Tweet>> userTweets;
    Map<Integer, List<Integer>> userFollowees;

    public Twitter() {
        this.time = 1;
        this.userTweets = new HashMap<>();
        this.userFollowees = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (userTweets.containsKey(userId)) {
            userTweets.get(userId).add(new Tweet(tweetId, time++));
        } else {
            PriorityQueue<Tweet> tweets = new PriorityQueue<>((t1, t2) -> t2.time - t1.time);
            tweets.add(new Tweet(tweetId, time++));
            userTweets.put(userId, tweets);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> recent10Feeds = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((t1, t2) -> t2.time - t1.time);
        Queue<Tweet> temp = new LinkedList<>();

        if (userFollowees.containsKey(userId)) {
            List<Integer> f = userFollowees.get(userId);

            for (int i = 0; i < f.size(); i++) {
                int uid = f.get(i);
                if (userTweets.containsKey(uid)) {
                    PriorityQueue<Tweet> t = userTweets.get(uid);

                    while (!t.isEmpty()) {
                        Tweet tweet = t.poll();
                        pq.add(tweet);
                        temp.offer(tweet);
                    }

                    while (!temp.isEmpty()) {
                        t.offer(temp.poll());
                    }
                }
            }
        }
        if (userTweets.containsKey(userId)) {
            PriorityQueue<Tweet> t = userTweets.get(userId);

            while (!t.isEmpty()) {
                Tweet tweet = t.poll();
                pq.add(tweet);
                temp.offer(tweet);
            }

            while (!temp.isEmpty()) {
                t.offer(temp.poll());
            }
        }

        int i = 1;
        while(!pq.isEmpty() && i <= 10){
            recent10Feeds.add(pq.poll().tweetId);
            i++;
        }

        return recent10Feeds;
    }

    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        if (userFollowees.containsKey(followerId)) {
            if(!userFollowees.get(followerId).contains(followeeId)){
            userFollowees.get(followerId).add(followeeId);
            }
        } else {
            List<Integer> followees = new ArrayList<>();
            followees.add(followeeId);
            userFollowees.put(followerId, followees);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (userFollowees.containsKey(followerId)) {
            List<Integer> followees = userFollowees.get(followerId);
            for (int i = 0; i < followees.size(); i++) {
                if (followees.get(i) == followeeId) {
                    followees.remove(i);
                    // System.out.println(followees);
                    return;
                }
            }
        }
    }
}

class Tweet {
    int tweetId;
    int time;

    public Tweet(int tweetId, int time) {
        this.tweetId = tweetId;
        this.time = time;
    }
}
