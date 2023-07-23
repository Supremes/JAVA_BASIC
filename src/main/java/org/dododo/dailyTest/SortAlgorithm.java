package org.dododo.dailyTest;

import java.util.Arrays;

public class SortAlgorithm {
    public static void run () {
        int[] nums = {3, 1, 2 ,4, 6,5};
        for (int num: nums) {
            System.out.printf(num + " ");
        }
        System.out.println();

        SortAlgorithm.quickSort(nums, 0, nums.length - 1);
        for (int num: nums) {
            System.out.printf(num + " ");
        }
        int[] arr = {2, 3, 1, 4, 10, 8 ,7};
        for (int num: arr) {
            System.out.printf(num + " ");
        }
        System.out.println();
//        swapSort(arr);
//        for (int num: arr) {
//            System.out.printf(num + " ");
//        }
//        System.out.println();
//        paopaoSort(arr);
//        for (int num: arr) {
//            System.out.printf(num + " ");
//        }
        heapSort(arr);
        for (int num: arr) {
            System.out.printf(num + " ");
        }
    }
    
    // 快速排序
    public static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int index = partition(nums, start, end);
            quickSort(nums, start , index - 1);
            quickSort(nums, index + 1, end);
        }
    }

    private static int partition(int []nums, int left , int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] < pivot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    // 冒泡： 相邻两两比较

    public static int[] paopaoSort(int []arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return  arr;
    }
    // 选择排序: 从第一个开始比较, 一遍得到最小值
    public static int[] swapSort(int []arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len;j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
    // 插入排序

    public static int[] insertSort(int []arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }

    // 归并排序
    public static int[] mergeSort(int []arr) {
        int len = arr.length;
        if (len < 2)    return arr;
        int mIdx = len / 2;
        return merge(mergeSort(Arrays.copyOfRange(arr, 0, mIdx)), mergeSort(Arrays.copyOfRange(arr, mIdx, len)));
    }

    public static int [] merge(int []arr1, int []arr2) {
        int leftLen = arr1.length;
        int rightLen = arr2.length;
        int[] result = new int[leftLen + rightLen];
        int leftIdx = 0, rightIdx = 0;
        int idx = 0;
        while (leftIdx < leftLen && rightIdx < rightLen) {
            if (arr1[leftIdx] > arr2[rightIdx]) {
                result[idx++] = arr2[rightIdx++];
            } else {
                result[idx++] = arr1[leftIdx++];
            }
        }
        while (leftIdx < leftLen) {
            result[idx++] = arr1[leftIdx++];
        }
        while (rightIdx < rightLen) {
            result[idx++] = arr2[rightIdx++];
        }
        return result;
    }

    private static int heapLen;
    // 堆排序
    public static void heapSort(int[] arr) {
        heapLen = arr.length;

        for (int i = heapLen - 1; i >= 0; i--) {
            heapify(arr, i);
        }

        for (int i = heapLen - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            heapLen--;
            heapify(arr, 0);
        }
    }

    public static void heapify(int[] arr, int idx) {
        int leftIdx = idx * 2 + 1, rightIdx = idx * 2 + 2;
        int largest = idx;
        if (leftIdx < heapLen && arr[leftIdx] > arr[largest]) {
            largest = leftIdx;
        }
        if (rightIdx < heapLen && arr[rightIdx] > arr[largest]) {
            largest = rightIdx;
        }
        if (largest != idx) {
            int tmp = arr[largest];
            arr[largest] = arr[idx];
            arr[idx] = tmp;
            heapify(arr, largest);
        }
    }
}
