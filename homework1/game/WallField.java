package ija.ija2022.homework1.game;

import ija.ija2022.homework1.common.Field;
import ija.ija2022.homework1.common.Maze;
import ija.ija2022.homework1.common.MazeObject;

public class WallField implements Field {

    MazeMap map;
    Field up_obj, right_obj, left_obj, down_obj;
    int row = 0;
    int col = 0;

    @Override
    public void setMap(MazeMap map) {
        this.map = map;
    }

    @Override
    public boolean canMove() {
        return false;
    }


    @Override
    public char getSymbol() {
        return 'X';
    }

    @Override
    public void setMaze(Maze maze) {

    }

    @Override
    public Field nextField(Direction dirs)
    {
        switch (dirs){
            case D -> {
                if (map.field[row+1][col] != null){
                    return map.field[row-1][col];
                }
                else {
                    throw new UnsupportedOperationException();
                }
            }
            case R -> {
                if (map.field[row][col+1] != null){
                    return map.field[row][col+1];
                }
                else {
                    throw new UnsupportedOperationException();
                }
            }
            case L -> {
                if (map.field[row][col-1] != null){
                    return map.field[row][col-1];
                }
                else {
                    throw new UnsupportedOperationException();
                }
            }
            case U -> {
                if (map.field[row-1][col] != null){
                    return map.field[row-1][col];
                }
                else {
                    throw new UnsupportedOperationException();
                }
            }
        }
        return null;
    }


    @Override
    public boolean put(MazeObject object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(MazeObject object) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public MazeObject get() {
        return null;
    }

    public WallField(int row, int col){
        this.row = row;
        this.col = col;
    }
    public WallField(int row, int col, Field up_obj,Field right_obj,Field left_obj,Field down_obj){
        this.row = row;
        this.col = col;
        this.up_obj = up_obj;
        this.right_obj = right_obj;
        this.left_obj = left_obj;
        this.down_obj = down_obj;


    }


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof WallField){
            WallField temp = (WallField) obj;
            return temp.col==this.col && temp.row ==  this.row;
        }
        return false;
    }


}
