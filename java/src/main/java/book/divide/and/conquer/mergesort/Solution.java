package book.divide.and.conquer.mergesort;

import java.util.Arrays;

public class Solution {
    public int[] mergeSort(int n, int[] arrayToBeSorted) {
        if (n > 1) {
            int h = n / 2;

            // divide: 하나의 array 를 절반으로 쪼갬
            int[] leftArray = Arrays.copyOfRange(arrayToBeSorted, 0, h);
            int[] rightArray = Arrays.copyOfRange(arrayToBeSorted, h, n);

            int [] _lArr = mergeSort(h, leftArray);
            int [] _rArr = mergeSort(rightArray.length, rightArray);

            return merge(_lArr, _rArr);
        } else {
            return arrayToBeSorted;
        }
    }

    private int[] merge(int[] leftArray, int[] rightArray) {
        int lLength = leftArray.length, rLength = rightArray.length;
        int i = 0, j = 0, k = 0;
        int[] mergedArray = new int[leftArray.length + rightArray.length];

        // 실질적으로 합치는 과정
        while (k < lLength + rLength) {
            if (i >= lLength) {
                mergedArray[k] = rightArray[j++];
            } else if (j >= rLength) {
                mergedArray[k] = leftArray[i++];
            } else {
                if (leftArray[i] < rightArray[j]) {
                    mergedArray[k] = leftArray[i++];
                } else if (rightArray[j] < leftArray[i]) {
                    mergedArray[k] = rightArray[j++];
                } else {
                    assert true;
                }
            }
            k++;
        }

        return mergedArray;
    }
}
