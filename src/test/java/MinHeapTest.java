import alg.MinHeap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinHeapTest {

    @Test
    public void testInsert() {
        MinHeap minHeap = new MinHeap(5);
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(6);
        minHeap.insert(1);
        int[] expected = {1, 3, 5, 10, 6};
        assertEquals(minHeap.getLength(), 5);
        assertEquals(minHeap.getData()[0], expected[0]);
        assertEquals(minHeap.getData()[1], expected[1]);
        assertEquals(minHeap.getData()[2], expected[2]);
        assertEquals(minHeap.getData()[3], expected[3]);
        assertEquals(minHeap.getData()[4], expected[4]);
    }

    @Test
    public void testDelete() {
        MinHeap minHeap = new MinHeap(5);
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(6);
        minHeap.insert(1);
        int[] expected = {3, 6, 5, 10};
        assertEquals(minHeap.delete(), 1);
        assertEquals(minHeap.getLength(), 4);
        assertEquals(minHeap.getData()[0], expected[0]);
        assertEquals(minHeap.getData()[1], expected[1]);
        assertEquals(minHeap.getData()[2], expected[2]);
        assertEquals(minHeap.getData()[3], expected[3]);
    }

    @Test
    public void testDeleteEmptyHeap() {
        MinHeap minHeap = new MinHeap(5);
        try {
            minHeap.delete();
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "Heap is empty!");
        }
    }

    @Test
    public void testInsertFullHeap() {
        MinHeap minHeap = new MinHeap(5);
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(6);
        minHeap.insert(1);
        try {
            minHeap.insert(1);
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "Heap is full!");
        }
    }

    @Test
    public void testDeleteMultipleElements() {
        MinHeap minHeap = new MinHeap(5);
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(6);
        minHeap.insert(1);
        assertEquals(minHeap.delete(), 1);
        assertEquals(minHeap.delete(), 3);
        assertEquals(minHeap.delete(), 5);
        assertEquals(minHeap.delete(), 6);
        assertEquals(minHeap.delete(), 10);
    }

    @Test
    public void testDeleteLastElement() {
        MinHeap minHeap = new MinHeap(5);
        minHeap.insert(10);
        assertEquals(minHeap.delete(), 10);
        assertEquals(minHeap.getLength(), 0);
    }
}
