// Problem: Implement Max Heap
// URL: https://takeuforward.org/plus/dsa/problems/implement-max-heap?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-22

import java.util.ArrayList;

class Solution {
    private ArrayList<Integer> heap;

    public void initializeHeap() {
        heap = new ArrayList<>();
    }

    public void insert(int key) {
        heap.add(key);
        int i = heap.size() - 1;

        // Heapify up
        while (i > 0) {
            int parent = (i - 1) / 2;

            if (heap.get(parent) >= heap.get(i))
                break;

            swap(parent, i);
            i = parent;
        }
    }

    public void changeKey(int index, int newVal) {
        if (index < 0 || index >= heap.size())
            return;

        int oldVal = heap.get(index);
        heap.set(index, newVal);

        if (newVal > oldVal) {
            // Heapify up
            while (index > 0) {
                int parent = (index - 1) / 2;

                if (heap.get(parent) >= heap.get(index))
                    break;

                swap(parent, index);
                index = parent;
            }
        } else {
            // Heapify down
            heapify(index);
        }
    }

    public void extractMax() {
        if (heap.isEmpty())
            return;

        int last = heap.size() - 1;
        heap.set(0, heap.get(last));
        heap.remove(last);

        if (!heap.isEmpty()) {
            heapify(0);
        }
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int getMax() {
        if (heap.isEmpty())
            return -1;
        return heap.get(0);
    }

    public int heapSize() {
        return heap.size();
    }

    private void heapify(int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heap.size() && heap.get(left) > heap.get(largest))
            largest = left;

        if (right < heap.size() && heap.get(right) > heap.get(largest))
            largest = right;

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}

// We choose to implement the Max Heap using an ArrayList for dynamic resizing.
// The insert and changeKey methods maintain the heap property by performing
// heapify up or down as necessary. The extractMax method removes the maximum
// element (the root) and maintains the heap property by replacing it with the
// last element and heapifying down. The getMax method returns the maximum
// element without modifying the heap, and isEmpty and heapSize provide utility
// functions to check if the heap is empty and to get its size, respectively.