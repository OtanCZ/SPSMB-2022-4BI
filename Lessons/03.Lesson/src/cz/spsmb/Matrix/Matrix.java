package cz.spsmb.Matrix;

import java.util.List;

public class Matrix {
    private List validTypes = List.of(2, 3, 4, 5, 6);
    private int matrix[][];
    private int determinant;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public boolean checkValidity(int[][] matrix){
        if(!validTypes.contains(matrix.length)) return false;

        for (int i = 0; i < matrix.length; i++) {
            if(!validTypes.contains(matrix[i].length) || matrix[i].length != matrix.length) return false;
        }

        return true;
    }
}
