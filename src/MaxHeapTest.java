import org.junit.Test;

import static org.junit.Assert.*;

// got help from other students and peers

public class MaxHeapTest {
    // homework
    @Test
    public void testMaxHeapN(){
        MaxHeap maxHeap = new MaxHeap(10);
        Integer[] testHeap = {};
        maxHeap.MaxHeapN(testHeap);
        assertTrue(maxHeap.equals(testHeap));

        MaxHeap maxHeapOne = new MaxHeap(10);
        Integer[] testHeapOne = {1, 4, 2, 7, 3};
        Integer[] outputOne = {7, 4, 2, 1, 3};
        maxHeapOne.MaxHeapN(testHeapOne);
        assertTrue(maxHeapOne.equals(outputOne));

        MaxHeap maxHeapTwo = new MaxHeap(10);
        Integer[] testHeapTwo = {0, 0, 0, 0, 0, 0, 0};
        Integer[] outputTwo = {0, 0, 0, 0, 0, 0, 0};
        maxHeapTwo.MaxHeapN(testHeapTwo);
        assertTrue(maxHeapTwo.equals(outputTwo));
    }

    @Test
    public void testMaxHeapNLogN(){
        MaxHeap maxHeap = new MaxHeap(10);
        Integer[] testHeap = {};
        maxHeap.MaxHeapNLogN(testHeap);
        assertTrue(maxHeap.equals(testHeap));

        MaxHeap maxHeapOne = new MaxHeap(10);
        Integer[] testHeapOne = {1, 4, 2, 7, 3};
        Integer[] outputOne = {7, 4, 2, 1, 3};
        maxHeapOne.MaxHeapNLogN(testHeapOne);
        assertTrue(maxHeapOne.equals(outputOne));

        MaxHeap maxHeapTwo = new MaxHeap(10);
        Integer[] testHeapTwo = {0, 0, 0, 0, 0, 0, 0};
        Integer[] outputTwo = {0, 0, 0, 0, 0, 0, 0};
        maxHeapTwo.MaxHeapNLogN(testHeapTwo);
        assertTrue(maxHeapTwo.equals(outputTwo));
    }

    @Test
    public void testAdd(){
        MaxHeap maxHeap = new MaxHeap (5);
        Integer[] empty = {};
        assertEquals(0, maxHeap.size);
        assertTrue(maxHeap.equals(empty));

        assertTrue(maxHeap.add(1));
        Integer[] testOne = {1};
        assertEquals(1, maxHeap.size);
        assertTrue(maxHeap.equals(testOne));

        assertTrue(maxHeap.add(4));
        Integer[] testTwo = {4, 1};
        assertEquals(2, maxHeap.size);
        assertTrue(maxHeap.equals(testTwo));

        assertTrue(maxHeap.add(2));
        Integer[] testThree = {4, 1, 2};
        assertEquals(3, maxHeap.size);
        assertTrue(maxHeap.equals(testThree));

        assertTrue(maxHeap.add(7));
        Integer[] testFour = {7, 4, 2, 1};
        assertEquals(4, maxHeap.size);
        assertTrue(maxHeap.equals(testFour));

        assertTrue(maxHeap.add(3));
        Integer[] testFive = {7, 4, 2, 1, 3};
        assertEquals(5, maxHeap.size);
        assertTrue(maxHeap.equals(testFive));

        assertFalse(maxHeap.add(23));
    }

    @Test
    public void testGet(){
        MaxHeap myHeap = new MaxHeap(10);
        assertEquals(null, myHeap.get());
        myHeap.add(1);
        myHeap.add(2);
        myHeap.add(4);
        assertEquals((Integer) 4, myHeap.get());
        myHeap.add(3);
        assertEquals((Integer) 4, myHeap.get());
        myHeap.add(122);
        assertEquals((Integer) 122, myHeap.get());
        myHeap.add(-1223);
        assertEquals((Integer) 122, myHeap.get());
    }

    @Test
    public void testPop(){
        MaxHeap maxHeap = new MaxHeap (10);
        maxHeap.add(1);
        assertEquals((Integer) 1, maxHeap.pop());
        assertEquals(null, maxHeap.pop());

        maxHeap.add(4);
        maxHeap.add(2);
        assertEquals((Integer) 4, maxHeap.pop());
        assertEquals((Integer) 2, maxHeap.pop());

        maxHeap.add(7);
        maxHeap.add(3);
        maxHeap.add(23);
        maxHeap.add(234);
        assertEquals((Integer) 234, maxHeap.pop());
        maxHeap.pop();
        assertEquals((Integer) 7, maxHeap.pop());
    }
}

