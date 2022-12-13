class Twitter {
    private HashMap<Integer,HashSet<Integer>> followList;
    private HashMap<Integer,HashSet<Twitee>> postedTweet;
    private int timestamp;
    public Twitter() {
        followList = new HashMap<>();
        postedTweet = new HashMap<>();
        timestamp = 0;
    }
    
    public class Twitee{
        public int id;
        public int time;

        public Twitee(int i, int t){
            this.id = i;
            this.time = t;
        }
    }

    public void postTweet(int userId, int tweetId) {
        timestamp++;
        if(postedTweet.containsKey(userId)){
            HashSet<Twitee> set = postedTweet.get(userId);
            set.add(new Twitee(tweetId,timestamp));
            postedTweet.put(userId,set);
        }else{
            HashSet<Twitee> set = new HashSet<>();
            set.add(new Twitee(tweetId,timestamp));
            postedTweet.put(userId,set);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Twitee> pq = new PriorityQueue<>(new Comparator<Twitee>(){
            public int compare(Twitee a, Twitee b){
                return b.time-a.time;
            }
        });

        HashSet<Twitee> temp = postedTweet.get(userId);
        if(temp != null){
            for(Twitee element : temp){
                pq.add(element);
            }
        }

        HashSet<Integer> list = followList.get(userId);
        if(list != null){
            for(Integer user : list){
                if(postedTweet.get(user) != null){
                    HashSet<Twitee> eachPosted = postedTweet.get(user);
                    if(eachPosted != null){
                        for(Twitee ele : eachPosted){
                            pq.add(ele);
                        }
                    }
                }
            }
        }

        int count = 10;
        List<Integer> res = new ArrayList<>();
        while(count > 0 && !pq.isEmpty()){
            res.add(pq.poll().id);
            count--;
        }
        return res;

    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        if(followList.containsKey(followerId)){
            HashSet<Integer> set = followList.get(followerId);
            set.add(followeeId);
            followList.put(followerId,set);
        }else{
            HashSet<Integer> set = new HashSet<>();
            set.add(followeeId);
            followList.put(followerId,set);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!followList.containsKey(followerId)){
            return;
        }else{
            HashSet<Integer> set = followList.get(followerId);
            set.remove(followeeId);
            followList.put(followerId,set);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
