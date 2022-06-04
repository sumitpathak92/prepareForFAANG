package rateLimiter;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {

    private String userid;

    // for each user we need a bucket
    Map<String, LeakyBucket> bucketMap;

    public UserBucketCreator(String userid) {
        this.userid = userid;
        this.bucketMap = new HashMap<>();
        this.bucketMap.put(userid, new LeakyBucket(10));
    }

    public void accessApplication(String userId) {
        if(bucketMap.get(userId).grantAccessToUser()) {
            System.out.println(Thread.currentThread().getName() + " -> " +"::::  application accessible ::::: ");
        } else {
            System.out.println(":::: many requests in , please try again ::::: ");
        }
    }
}
