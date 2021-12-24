package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MatrixProductTests {

    private static final int[][] matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    private static final int[][] matrix2 = new int[][]{{-1, 2, 3}, {4, 5, -6}, {7, 8, 9}};
    private static final MatrixProduct matrixProduct = new MatrixProduct();

    @Test
    void testMatrixProduct() {
        int product = matrixProduct.matrixProduct(matrix1);
        Assertions.assertEquals(2016, product);

        product = matrixProduct.matrixProduct(matrix2);
        Assertions.assertEquals(1080, product);
    }

}
