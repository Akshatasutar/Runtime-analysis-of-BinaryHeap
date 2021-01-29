package com.task1a;

import java.util.ArrayList;
import java.util.Arrays;

public class TraverseAlgo {
    private static void shiftLeft(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
    }

    public static void levelOrderTraverse(int[] binHeap) {
        shiftLeft(binHeap);
        System.out.println("Level order: " + Arrays.toString(binHeap));
    }

    public static void inOrderTraverse(int[] binHeap, ArrayList<Integer> arrInOrder, int i) {
        if(2*i > binHeap.length - 2) {
            arrInOrder.add(binHeap[i]);
        }
        else {
            inOrderTraverse(binHeap, arrInOrder, 2*i);
            arrInOrder.add(binHeap[i]);
            inOrderTraverse(binHeap, arrInOrder, 2*i + 1);
        }
    }

    public static void preOrderTraverse(int[] binHeap, ArrayList<Integer> arrInOrder, int i) {
        if(2*i > binHeap.length - 2) {
            arrInOrder.add(binHeap[i]);
        }
        else {
            arrInOrder.add(binHeap[i]);
            preOrderTraverse(binHeap, arrInOrder, 2*i);
            preOrderTraverse(binHeap, arrInOrder, 2*i + 1);
        }
    }

    public static void postOrderTraverse(int[] binHeap, ArrayList<Integer> arrInOrder, int i) {
        if(2*i > binHeap.length - 2) {
            arrInOrder.add(binHeap[i]);
        }
        else {
            postOrderTraverse(binHeap, arrInOrder, 2*i);
            postOrderTraverse(binHeap, arrInOrder, 2*i + 1);
            arrInOrder.add(binHeap[i]);
        }
    }
}
