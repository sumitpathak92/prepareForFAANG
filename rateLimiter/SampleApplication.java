package rateLimiter;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SampleApplication {

    public static void main(String[] args) {
        String uId = String.valueOf(UUID.randomUUID());
        UserBucketCreator userBucketCreator = new UserBucketCreator(uId);
        ExecutorService executorService = Executors.newFixedThreadPool(12);
        for(int i = 0; i<12; i++) {
            executorService.execute(()->userBucketCreator.accessApplication(uId));
        }
        executorService.shutdown();
    }
}
