package ink.lucien.java.util.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutionException;

import static java.lang.Thread.sleep;

/**
 * Created by Lucien Shui on 2019/9/4.
 */
public class UtilConcurrentMain {

    private ExecutorService aPool = new ThreadPoolExecutor(50, 50,
            50L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(500));

    private ExecutorService bPool = new ThreadPoolExecutor(50, 50,
            50L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(500));

    private ExecutorService cPool = new ThreadPoolExecutor(1, 1,
            50L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(8000 * 5));

    private int gao() throws ExecutionException, InterruptedException {
        List<Future<Integer>> aList = new ArrayList<>();
        List<Future<Integer>> bList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerList.add(i);
        }
        for (int i = 0; i < integerList.size(); i++) {
            int index = i;
            Future<Integer> future = aPool.submit(() -> {
                integerList.set(index, index << 1);
                System.out.println("a: " + index);
                return index;
            });
            aList.add(future);
        }

        List<Integer> aRet = new ArrayList<>();

        for (Future<Integer> each : aList) {
            aRet.add(each.get());
        }

        for (Integer each : aRet) {
            System.out.print(each + " ");
        }
        System.out.println();

        aPool.shutdown();

        for (Integer each : integerList) {
            System.out.println(each);
        }

        for (int i = 0; i < integerList.size(); i++) {
            int index = i;
            Future<Integer> future = bPool.submit(() -> {
                System.out.println("b: " + (integerList.get(index) << 1));
                return integerList.get(index) << 1;
            });
            bList.add(future);
        }

        List<Integer> bRet = new ArrayList<>();

        for (Future<Integer> each : bList) {
            bRet.add(each.get());
        }

        for (Integer each : bRet) {
            System.out.print(each + " ");
        }
        System.out.println();

        bPool.shutdownNow();

        List<Future> cList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int cur = i;
            Future future = cPool.submit(() -> {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(cur + " ");
            });
            cList.add(future);
        }

        for (Future each : cList) {
            each.get();
        }

        System.out.println("\nAll done");

        return 0;
    }

    public static void main(String[] args) {
        UtilConcurrentMain utilConcurrentMain = new UtilConcurrentMain();
        try {
            System.out.println(utilConcurrentMain.gao());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
