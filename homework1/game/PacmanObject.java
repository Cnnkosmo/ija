package ija.ija2022.homework1.game;

import ija.ija2022.homework1.common.Field;
import ija.ija2022.homework1.common.Maze;
import ija.ija2022.homework1.common.MazeObject;

public class PacmanObject implements MazeObject{
    int row, col;
    Field placeholder;
    public PacmanObject(int row, int col){
        this.row = row;
        this.col = col;
    }

    public void setPlaceholder(Field placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    public boolean canMove(Field.Direction dir){
        if (placeholder.nextField(dir).canMove()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean move(Field.Direction dir) {
        if (canMove(dir)){
            placeholder.nextField(dir).put(this);
            placeholder.remove(this);
            return true;
        }
        else{
            return false;
        }
    }
}
