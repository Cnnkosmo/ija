package ija.ija2022.homework1.game;

import ija.ija2022.homework1.common.Field;
import ija.ija2022.homework1.common.Maze;
import ija.ija2022.homework1.common.MazeObject;

public class WallField implements Field {

    Field up_obj, right_obj, left_obj, down_obj;
    int row = 0;
    int col = 0;

    @Override
    public Field getUp_obj() {
        return up_obj;
    }

    @Override
    public Field getRight_obj() {
        return right_obj;
    }

    @Override
    public Field getLeft_obj() {
        return left_obj;
    }

    @Override
    public Field getDown_obj() {
        return down_obj;
    }

    @Override
    public void setUp_obj(Field up_obj) {
        this.up_obj = up_obj;
    }

    @Override
    public void setRight_obj(Field right_obj) {
        this.right_obj = right_obj;
    }

    @Override
    public void setLeft_obj(Field left_obj) {
        this.left_obj = left_obj;
    }

    @Override
    public void setDown_obj(Field down_obj) {
        this.down_obj = down_obj;
    }

    @Override
    public char getSymbol() {
        return 'X';
    }

    @Override
    public void setMaze(Maze maze) {

    }

    @Override
    public Field nextField(Direction dirs) {
        switch (dirs){
            case D -> {
                if (down_obj != null){
                    return down_obj;
                }
                else {
                    throw new UnsupportedOperationException();
                }
            }
            case R -> {
                if (right_obj != null){
                    return right_obj;
                }
                else {
                    throw new UnsupportedOperationException();
                }
            }
            case L -> {
                if (left_obj != null){
                    return left_obj;
                }
                else {
                    throw new UnsupportedOperationException();
                }
            }
            case U -> {
                if (up_obj != null){
                    return up_obj;
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

    @Override
    public boolean canMove() {
        return false;
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
