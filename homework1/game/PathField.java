package ija.ija2022.homework1.game;

import ija.ija2022.homework1.common.Field;
import ija.ija2022.homework1.common.Maze;
import ija.ija2022.homework1.common.MazeObject;

public class PathField implements Field{

    public Field up_obj, right_obj, left_obj, down_obj;
    PacmanObject pacman;
    boolean empty;
    int row = 0;
    int col = 0;

    @Override
    public char getSymbol() {
        return '.';
    }

    @Override
    public void setMaze(Maze maze) {

    }

    public Field getUp_obj() {
        return up_obj;
    }

    public Field getRight_obj() {
        return right_obj;
    }

    public Field getLeft_obj() {
        return left_obj;
    }

    public Field getDown_obj() {
        return down_obj;
    }

    public void setUp_obj(Field up_obj) {
        this.up_obj = up_obj;
    }

    public void setRight_obj(Field right_obj) {
        this.right_obj = right_obj;
    }

    public void setLeft_obj(Field left_obj) {
        this.left_obj = left_obj;
    }

    public void setDown_obj(Field down_obj) {
        this.down_obj = down_obj;
    }

    @Override
    public Field nextField(Direction dirs)
    {
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
        if (pacman != null){
            return false;
        }
        else {
            this.pacman = (PacmanObject) object;
            return true;
        }
    }

    @Override
    public boolean remove(MazeObject object) {
        if (pacman != null){
            pacman = null;
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean isEmpty() {
        if (pacman != null){
            return false;
        }
        else {
            return true;
        }

    }

    @Override
    public MazeObject get() {
        return pacman;
    }

    @Override
    public boolean canMove() {
        return true;
    }

    public PathField(int row, int col){
        this.row = row;
        this.col = col;
        this.pacman = null;
    }
    public PathField(int row, int col, PacmanObject pacman,Field up_obj,Field right_obj,Field left_obj,Field down_obj){
        this.row = row;
        this.col = col;
        this.pacman = pacman;
        this.up_obj = up_obj;
        this.right_obj = right_obj;
        this.left_obj = left_obj;
        this.down_obj = down_obj;
    }
    public PathField(int row, int col, PacmanObject pacman){
        this.row = row;
        this.col = col;
        this.pacman = pacman;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof PathField){
            PathField temp = (PathField) obj;
            return temp.col==this.col && temp.row ==  this.row;
        }
        return false;
    }
}
