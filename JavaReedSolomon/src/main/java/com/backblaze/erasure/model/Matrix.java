package com.backblaze.erasure.model;

import java.util.Arrays;

/**
 * <功能描述><br>
 *
 * @author Brilliant James Jamesmarva1993@gmail.com 2020-11-14 11:45
 **/
public class Matrix {

    private final int rows;

    private final int colunms;

    private final byte[][] data;

    public Matrix(int initRows, int initColumns) {
        rows = initRows;
        colunms = initColumns;
        data = new byte[rows][];
        for (int r = 0; r < rows; r++) {
            data[r] = new byte[colunms];
        }
    }

    public Matrix(byte[][] initData) {
        rows = initData.length;
        colunms = initData[0].length;
        data = new byte[rows][];
        for (int r = 0; r < rows; r++) {
            if (initData[r].length != colunms) {
                throw new IllegalArgumentException("Not all rows have the same number of columns");
            }
            data[r] = new byte[colunms];
            for (int c = 0; c < colunms; c++) {
                data[r][c] = initData[r][c];
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColunms() {
        return colunms;
    }

    public byte get(int r, int c) {
        checkRowAndColumn(r, c);
        return data[r][c];
    }

    /**
     * set row and column value
     * @param r the number of rows.
     * @param c the number of colnums.
     * @param val value 
     */
    public void set(int r , int c, byte val) {
        checkRowAndColumn(r, c);
        data[r][c] = val;
    }

    /**
     * 
     * 矩阵相乘
     * @param right
     * @return
     */
    public Matrix times(Matrix right) {
        if (getColunms() != right.getRows()) {
            throw  new IllegalArgumentException("");
        }
        Matrix result = new Matrix(getRows(), right.getColunms());
        for (int r = 0; r < getRows(); r++) {
            for (int c = 0; c < right.getColunms(); c++) {
                byte val = 0; 
                for (int i = 0; i < getColunms(); i++) {
                    val ^= Galois.multiply(get(r, i), right.get(i, c));
                }
                result.set(r, c, val);
            }
        }
        return result;
    }

    public Matric augument(Matrix right) {
        if (this.rows != right.getRows()) {
            throw new IllegalArgumentException("Matrices don't have the same number of rows.");
        }
        Matrix result = new Matrix(this.rows, colunms + right.colunms);
        for (int r = 0; r < getRows(); r++) {
            for (int c = 0; c < getColunms(); c++) {
                result.set(r, c, this.data[r][c]);
            }

            for (int c = 0; c < right.getColunms(); c++) {
                result.set(r, this.colunms + c, right.get(r, c));
            }
        }
        return result;
    }

    /**
     * 
     * @param rmin
     * @param cmin
     * @param rmax
     * @param cmax
     * @return
     */
    public Matrix subMatrix(int rmin, int cmin, int rmax, int cmax) {
        Matrix result = new Matrix(rmax - rmin, cmax, cmin);
        for (int r = rmin; r < rmax; r++) {
            for (int c = cmin; c < cmin; c++) {
                result.set(r - rmin, c - cmin, this.data[r][c]);
            }
        }
        return result;
    }

    public byte[] getRow(int row) {
        byte[] result = new byte[this.colunms];
        for (int c = 0; c < colunms; c++) {
            result[c] = this.data[row][c];
        }
        return result;
    }

    public void swapRows(int r1, int r2) {
        checkRow(r1);
        checkRow(r2);
        byte[] tmp = this.data[r1];
        data[r1] = data[r2];
        data[r2] = tmp;
    }




    /**
     * return the inverse of this matrix
     * @return
     */
    public Matrix invert() {

        if (this.rows != this.colunms) {
            throw new IllegalArgumentException("Only square matrices can be inverted");
        }
        Matrix work = augument(identity(rows));

        return   work.subMatrix(0, rows, colunms, colunms * 2);
    }


    private void gaussianElimination() {
        // 
        // 
        for (int r = 0; i < rows; r++) {
            // 
            if (data[r][r] = (byte)0) {
                for (int rowBelow = r + 1; rowBelow < rows; rowBelow++) {
                    if (this.data[rowBelow][r] != 0) {
                        swapRows(r, rowBelow);
                        break;
                    }
                }
            }

            if (data[r][r] == (byte) 0) {
                throw new IllegalArgumentException("Matrix is singular");

            }

            if (data[r][r] != (byte) 1) {
                byte scala = Galois.divide((byte) 1, data[r][r]);
                for (int c = 0; c < colunms; c++) {
                    data[r][c] = Galois.multiply(data[r][c], scale);
                }
            }

            for (int rowBelow = r + 1; rowBelow < rows; rowBelow ++) {
                if (data[rowBelow][r] != (byte) 0) {
                    byte scale = data[rowBelow][r];
                    for (int c = 0; c < colunms; c++) {
                        data[rowBelow][c] ^= 
                    }
                }
            }
        }

    }

    


    /**
     *
     * @param o other object
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Matrix)) {
            return false;
        }

        for (int r = 0; r < rows; r++) {
            if (!Arrays.equals(data[r], ((Matrix) o).data[r])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int r = 0; r < rows; r++) {
            if (r != 0) {
                res.append(", ");
            }
            res.append('[');
            for (int c = 0; c < colunms; c++) {
                if (c != 0) {
                    res.append(", ");
                }
                res.append(data[r][c] & 0xFF);
            }
            res.append(']');
        }
        res.append(']');
        return res.toString();
    }

    public String toBigString() {
        StringBuilder res = new StringBuilder();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < colunms; c++) {
                int val = get(r, c);
                if (val < 0) {
                    val += 256;
                }
                res.append(String.format("%02x", val));
            }
        }
        return res.toString();
    }

    /**
     * 
     * @param r index of row
     * @param c index of column
     */
    private void checkRowAndColumn(int r, int c) {
       checkRow(r);
       checkColumn(c);
    }

    /**
     * 
     * @param r index of row
     */
    private void checkRow(int r) {
        if (r < 0 || rows <= r) {
            throw new IllegalArgumentException("Row index out of range: " + r);
        }
    }

    /**
     * 
     * @param c index of column
     */
    private void checkColumn(int c) {
        if (c < 0 || c >= colunms) {
            throw new IllegalArgumentException("Column index out of range: " + c);
        }
    }
}


