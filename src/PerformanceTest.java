import java.time.Duration;
import java.time.Instant;

/*
got help for execution time from:
https://howtodoinjava.com/java/date-time/execution-elapsed-time/
https://howtodoinjava.com/java/date-time/execution-elapsed-time/
 */

public class PerformanceTest {
    public static void main (String[] args){
        int num = 20;
        testMaxHeapNLogN(num);
        testMaxHeapN(num);
    }
    public static void testMaxHeapNLogN(int factor){
        //Performance test
        int size = 170000 * factor;
        MaxHeap maxHeap = new MaxHeap(size);
        Integer[] data = new Integer[size];
        for(int i = 0; i < size; i++){
            data[i] = i;
        }
        Instant start = Instant.now();
        maxHeap.MaxHeapNLogN(data);
        Instant end = Instant.now();
        long duration = Duration.between(start,end).toMillis();
        System.out.println("LogN maxHeap : " + duration);
    }

    public static void testMaxHeapN(int factor){
        //Performance test
        int size = 170000 * factor;
        MaxHeap heap = new MaxHeap(size);
        Integer[] data = new Integer[size];
        for(int i = 0; i < size; i++){
            data[i] = i;
        }
        Instant start = Instant.now();
        heap.MaxHeapN(data);
        Instant end = Instant.now();
        long duration = Duration.between(start,end).toMillis();
        System.out.println("N maxHeap : " + duration);
    }
}

