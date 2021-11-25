package com.example.demo;

public class MedianOfArray {

    public double bruteForceApproach(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];

        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        int arrLength = arr.length;

        int i = 0, j = 0, k = 0;
        while (i < arr1Length && j < arr2Length) {
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1Length) {
            arr[k++] = arr1[i++];
        }

        while (j < arr2Length) {
            arr[k++] = arr2[j++];
        }

        boolean isEven = arrLength % 2 == 0;
        if (isEven) {
            return (double) (arr[arrLength / 2] + arr[arrLength / 2 - 1]) / 2;
        }
        return (double) arr[arrLength / 2] / 2;
    }

}
