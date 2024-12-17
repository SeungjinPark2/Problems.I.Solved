package book.divide.and.conquer.mergesort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
class SolutionTest {
    Solution s = new Solution();

    @Test
    void mergeSortTest() {
        int[] arr = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] answer = s.mergeSort(arr.length, arr);
        System.out.println(Arrays.toString(answer));
        Arrays.sort(arr);

        assertArrayEquals(arr, answer);
    }
}