package ija.ija2022.homework1.game;

import ija.ija2022.homework1.common.Field;
import ija.ija2022.homework1.common.Maze;
import ija.ija2022.homework1.common.MazeObject;

public class PacmanObject implements MazeObject{
    static int row, col;

    public PacmanObject(int row, int col){
        this.row = row;
        this.col = col;
    }
    @Override
    public boolean canMove(Field.Direction dir) {
        return true;
    }

    @Override
    public boolean move(Field.Direction dir) {
        return true;
    }
}
