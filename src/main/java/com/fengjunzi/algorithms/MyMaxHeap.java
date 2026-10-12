package com.fengjunzi.algorithms;

import java.util.Arrays;

public class MyMaxHeap {
    private int[] elements;
    private int heapSize;
    private int maxSize;

    public MyMaxHeap(int[] elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
        this.heapSize = elements.length;
        this.maxSize = elements.length;
        buildMaxHeap();
    }

    public MyMaxHeap() {
        this.maxSize = 16;
        this.heapSize = 0;
        this.elements = new int[maxSize];
    }

    private void buildMaxHeap(){
        for(int i = heapSize / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public void push(int value){
        if(maxSize == heapSize){
            maxSize = heapSize * 2;
            this.elements = Arrays.copyOf(this.elements, maxSize);
        }
        // 修正：新元素放末尾，执行“上浮”
        elements[heapSize] = value;
        siftUp(heapSize);
        heapSize++;
    }

    // 新增：上浮逻辑
    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) >> 1;
            if (elements[index] > elements[parent]) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    public int pop(){
        if(heapSize == 0) return -1;

        int ans = elements[0];
        // 修正：先减 size，再拿末尾元素换到堆顶
        heapSize--;
        if (heapSize > 0) {
            elements[0] = elements[heapSize];
            maxHeapify(0);
        }
        return ans;
    }

    private void maxHeapify(int i) {
        while (true) {
            int left = (i << 1) + 1;
            int right = (i << 1) + 2;
            int largest = i;

            if (left < heapSize && elements[left] > elements[largest]) {
                largest = left;
            }
            if (right < heapSize && elements[right] > elements[largest]) {
                largest = right;
            }

            if (largest != i) {
                swap(i, largest);
                i = largest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
}