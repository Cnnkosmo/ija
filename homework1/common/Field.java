package ija.ija2022.homework1.common;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public interface Field {
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
    public Field getUp_obj();
    public Field getRight_obj();
    public Field getLeft_obj();
    public Field getDown_obj();
    void setUp_obj(Field up_obj);
    void setRight_obj(Field right_obj);
    void setLeft_obj(Field right_obj);
    void setDown_obj(Field right_obj);
    char getSymbol();
    void setMaze(Maze maze);
    Field nextField(Field.Direction dirs);
    boolean put(MazeObject object);
    boolean remove(MazeObject object);
    boolean isEmpty();

    MazeObject get();
    boolean canMove();


}
