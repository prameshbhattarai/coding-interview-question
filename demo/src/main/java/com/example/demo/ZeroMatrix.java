package com.example.demo;

/**
 * Given a boolean matrix, update it so that if any cell is true, all the cells in that
 * row and column are true.
 * <p>
 * Input
 * [
 * [true, false, false]
 * [false, false, false]
 * [false, false, false]
 * ]
 * <p>
 * Output
 * [
 * [true, true, true]
 * [true, false, false]
 * [true, false, false]
 * ]
 */
public class ZeroMatrix {

    /**
     * This process will take extra space n
     * @param arr
     * @return arr
     */
    public boolean[][] bruteForce(boolean[][] arr) {
        int startRow = 0;

        /*
        If we have a true in any cell
        then we must make all cells in that row to true
        rowToBeTrue will hold the index of all the rows to be true

        also, if we have a true in any cell
        then we must make all the cells in that column to true
        colToBeTrue will hold the index of all the columns to be true
         */
        boolean[] rowToBeTrue = new boolean[arr.length];
        boolean[] colToBeTrue = new boolean[arr[0].length];

        // look into each cell and find the cells that need to be true
        for (int i = 0; i < arr.length; i++) {
            for (int j = startRow; j < arr[0].length; j++) {
                if (arr[i][j]) {
                    rowToBeTrue[i] = true;
                    colToBeTrue[j] = true;
                }
            }
        }

        // make all the rows to true
        for (int i = 0; i < rowToBeTrue.length; i++) {
            if (rowToBeTrue[i]) {
                for (int j = startRow; j < arr[i].length; j++) {
                    arr[i][j] = true;
                }
            }
        }

        // make all the columns to true
        for (int i = 0; i < arr.length; i++) {
            for (int j = startRow; j < arr[0].length; j++) {
                if (colToBeTrue[j]) {
                    arr[i][j] = true;
                }
            }
        }

        return arr;
    }

    /**
     * This process will not take extra space
     * @param arr
     * @return arr
     */
    public boolean[][] optimizedWay(boolean[][] arr) {

        /*
        Instead of creating extra space
        we will use first row and first column as a lookup

        and to track the flag for first row and first column we will create a two variables
         */

        boolean firstRowAllTrue = false, firstColumnAllTrue = false;

        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

                // if the current cell value is true
                // then set the first row and first column of the cell to true
                if (arr[i][j]) {
                    // if it is from first row or first column
                    // then update the firstRowAllTrue and firstColumnAllTrue to true
                    if (i == 0) firstRowAllTrue = true;
                    if (j == 0) firstColumnAllTrue = true;

                    // first rpw to true
                    arr[i][0] = true;
                    // first column to true
                    arr[0][j] = true;
                }
            }
        }

        // now again iterate the array from first row and column
        for(int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                // if the first row and first column of the cell is true
                // then update all the values in that row or column to true
                if (arr[i][0] || arr[0][j]) {
                    arr[i][j] = true;
                }
            }
        }

        // update first column values, if firstRowAllTrue is true
        if (firstRowAllTrue) {
            for(int j = 0; j < arr[0].length; j++) {
                arr[0][j] = true;
            }
        }


        // update first row values, if firstColumnAllTrue is true
        if (firstColumnAllTrue) {
            for(int i = 0; i < arr.length; i++) {
                arr[i][0] = true;
            }
        }

        return arr;
    }

}
