package ija.ija2022.homework1.game;

import ija.ija2022.homework1.common.Field;
import ija.ija2022.homework1.common.Maze;
import ija.ija2022.homework1.common.MazeObject;

public class PathField implements Field{
    PacmanObject pacman;
    boolean empty;
    boolean pacman_entry;
    int row = 0;
    int col = 0;
    MazeMap map;

    @Override
    public char getSymbol() {
        if(pacman == null){
            return '.';
        }
        else{
            return 'S';
        }
    }
    @Override
    public void setMaze(Maze maze) {

    }

    public void setMap(MazeMap map) {
        this.map = map;
    }

    @Override
    public boolean canMove() {
        return true;
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

    public PathField(int row, int col){
        this.row = row;
        this.col = col;
        this.pacman = null;
    }
    public PathField(PacmanObject pacman,int row,int col){
        this.row = row;
        this.col = col;
        this.pacman = pacman;
        this.pacman.setPlaceholder(this);
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
