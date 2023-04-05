package ija.ija2022.homework1.common;

import ija.ija2022.homework1.game.MazeMap;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public interface Field {


    void setMap(MazeMap map);

    boolean canMove();

    static enum Direction{
        D,L,R,U;
        public int deltaRow(){
            return 0;
        }
        public int deltaCol(){
            return 0;
        }


    }

    int symbol = '0';
    int row = 0;
    int col = 0;
    char getSymbol();
    void setMaze(Maze maze);
    Field nextField(Field.Direction dirs);
    boolean put(MazeObject object);
    boolean remove(MazeObject object);
    boolean isEmpty();

    MazeObject get();


}
