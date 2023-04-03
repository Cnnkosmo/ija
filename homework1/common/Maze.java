package ija.ija2022.homework1.common;

import java.util.ArrayList;
import java.util.List;

public class Maze {


   public  int cols ;
    public int rows;
    public Field[][] field ;
    public Maze(int rows, int cols){
        this.rows= rows;
        this.cols = cols;
        field = new Field[rows][cols];
    }
    public Field getField(int row, int col) {
        if (row < 0 || col < 0){
            return null;
        }
        else {
            return field[row][col];
        }
    }

    public int numRows() {
        return rows;
    }
    public int numCols() {
        return cols;
    }
}
