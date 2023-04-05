package ija.ija2022.homework1.game;

import ija.ija2022.homework1.common.Field;
import ija.ija2022.homework1.common.Maze;
import ija.ija2022.homework1.common.MazeObject;

import java.util.Objects;

public class PacmanField implements Field{
    PacmanObject pacman;

    Field up_obj, right_obj, left_obj, down_obj;

    PacmanField(PacmanObject pacman){
        this.pacman = pacman;
    }

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

    }

    @Override
    public void setRight_obj(Field right_obj) {

    }

    @Override
    public void setLeft_obj(Field right_obj) {

    }

    @Override
    public void setDown_obj(Field right_obj) {

    }

    @Override
    public char getSymbol() {
        return 'S';
    }

    @Override
    public void setMaze(Maze maze) {

    }

    @Override
    public Field nextField(Direction dirs) {
        return null;
    }

    @Override
    public boolean put(MazeObject object) {
        return false;
    }

    @Override
    public boolean remove(MazeObject object) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public MazeObject get() {
        return null;
    }

    @Override
    public boolean canMove() {
        return false;
    }
}
