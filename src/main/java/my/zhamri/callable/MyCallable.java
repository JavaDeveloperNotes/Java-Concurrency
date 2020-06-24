package my.zhamri.callable;

import java.util.concurrent.*;

public class MyCallable implements Callable<Integer> {

    public static void main(String[] args) {
        Callable<Integer> myCallable = new MyCallable();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(myCallable);
        try {
            Integer total = future.get();
            System.out.println("Total: " + total);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Failed");
        }
        executorService.shutdown();
    }

    @Override
    public Integer call() {
        int x = 0;
        int number = ThreadLocalRandom.current().nextInt(10);
        System.out.println("Number: " + number);
        for (int i = 0; i < number; i++) {
            System.out.println("Running: " + i);
            x = x + i;
        }
        return x;
    }
}
