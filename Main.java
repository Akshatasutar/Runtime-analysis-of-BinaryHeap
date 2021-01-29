package com.task1a;

import java.util.ArrayList;
import java.util.Arrays;

import static com.task1a.TraverseAlgo.*;

public class Main {
    public static void main(String[] args) {
        ApiFileManager manager = new ApiFileManager();

        //Runtime analysis:
        long start;
        long estimTime;
        int n = 100;
        int[] binHeap = new int[n];
        int[] inputNums;

        for (int a = 0; a < 4; a++) {
            inputNums = new int[n];
            manager.readIntFile("Seminar 1 - File with random numbers.txt",inputNums);

            binHeap = new int[n + 1];
            binHeap[1] = inputNums[0];
            start = System.nanoTime();
            insertEach(binHeap, inputNums, n);
            estimTime = System.nanoTime() - start;
            System.out.println("n = " + n);
            System.out.println(estimTime);
            System.out.println("----------------------------------");
            n = n*10;
        }

        ArrayList<Integer> arrInOrder = new ArrayList<>(binHeap.length - 1);
        inOrderTraverse(binHeap, arrInOrder, 1);
        //System.out.println("In order: " + arrInOrder.toString());

        ArrayList<Integer> arrPreOrder = new ArrayList<>(binHeap.length - 1);
        preOrderTraverse(binHeap, arrPreOrder, 1);
        //System.out.println("Pre order: " + arrPreOrder.toString());

        ArrayList<Integer> arrPostOrder = new ArrayList<>(binHeap.length - 1);
        postOrderTraverse(binHeap, arrPostOrder, 1);
        //System.out.println("Post order: " + arrPostOrder.toString());

        //levelOrderTraverse(binHeap);
    }

    private static void swapPos(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static void insertEach(int[] binHeap, int[] inputNums, int n) {
        for (int i = 2; i < n + 1; i++){
            binHeap[i] = inputNums[i - 1];
            //child = binHeap[i]; parent = binHeap[i/2];
            int j = i;
            while(binHeap[j/2] > binHeap[j] && j >= 2) {
                swapPos(binHeap, j/2, j);
                j = j/2;
            }
        }
    }
}
