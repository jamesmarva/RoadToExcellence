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
     * @param r row
     * @param c colnum
     * @param val value
     */
    public void set(int r , int c, byte val) {
        checkRowAndColumn(r, c);
        data[r][c] = val;
    }

    private void checkRowAndColumn(int r, int c) {
        if (r < 0 || rows <= r) {
            throw new IllegalArgumentException("Row index out of range: " + r);
        }

        if (c < 0 || c >= colunms) {
            throw new IllegalArgumentException("Column index out of range: " + c);
        }
    }



    public Matrix times(Matrix right) {
        if (getColunms() != right.getRows()) {
            throw  new IllegalArgumentException("");
        }

        return null;
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




}
