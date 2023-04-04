package ija.ija2022.homework1.game;

import ija.ija2022.homework1.common.Field;
import ija.ija2022.homework1.common.Maze;

public class MazeConfigure {
    int actual_row;
    public int rows, cols;
    private boolean error_occured;
    private MazeMap maze;
    private boolean check_start;
    Field[][] field;
    public MazeConfigure() {
        this.maze = null;
        error_occured = false;
        actual_row = 0;
        check_start = false;
    }

    public void startReading(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.field = new Field[rows][cols];
    }

    public boolean processLine(String line) {
        cols = 0;
        for (Character a : line.toCharArray()) {
            if(a == 'X'){
                field[actual_row][cols] = new WallField(actual_row,cols);
            }
            else if(a == '.'){
                field[actual_row][cols] = new PathField(actual_row,cols);
            }
            else if(a == 'S'){
                if (check_start) error_occured = true;
                field[actual_row][cols] = new PacmanField(new PacmanObject(actual_row,cols));
                check_start = true;
            }
            else {
                error_occured = true;
                return false;
            }
            cols++;
        }
        actual_row++;
        return true;
    }

    private MazeMap CreateWallFrame(MazeMap map){
        int row=0;
        int col=0;
        for (int r = 0; r < map.rows; r++){
            for (int c = 0; c < map.field[0].length; c++){
                if (r == 0){
                    map.field[r][c] = new WallField(r,c);
                }
                else if (r == map.field.length-1){
                    map.field[r][c] = new WallField(r,c);
                }
                else if (c == 0){
                    map.field[r][c] = new WallField(r,c);
                }
                else if(c == map.field[0].length-1){
                    map.field[r][c] = new WallField(r,c);
                }
                else{
                    Field temp = null;
                    if(field[r-1][c-1].getSymbol()=='X'){
                        temp = new WallField(r,c);
                    } else if (field[r-1][c-1].getSymbol()=='.') {
                        temp = new PathField(r,c);
                    } else if (field[r-1][c-1].getSymbol()=='S') {
                        temp = new PathField(r,c,new PacmanObject(r,c));

                    }
                    map.field[r][c]  = temp;
                }

            }
        }

        return map;
    }
    private Maze setLinks(MazeMap map){
        for(int r = 0; r < map.rows; r++){
            for (int c = 0; c < map.field[0].length; c++){
                if (r==0) {
                    map.field[r][c].setDown_obj(map.field[r + 1][c]);
                    if (c - 1 >= 0) {
                        map.field[r][c].setLeft_obj(map.field[r][c - 1]);
                    }
                    if (c + 1 < map.field[0].length) {
                        map.field[r][c].setRight_obj(map.field[r][c + 1]);
                    }
                }
                else if (r == map.field.length-1) {
                    map.field[r][c].setUp_obj(map.field[r - 1][c]);
                    if (c - 1 >= 0) {
                        map.field[r][c].setLeft_obj(map.field[r][c - 1]);
                    }
                    if (c + 1 < map.field[0].length) {
                        map.field[r][c].setRight_obj(map.field[r][c + 1]);
                    }
                }
                else if (c == 0){
                        map.field[r][c].setRight_obj(map.field[r][c+1]);
                    if (r-1 > 0){
                        map.field[r][c].setUp_obj(map.field[r-1][c]);
                        }
                    if (r+1 < map.field.length){
                        map.field[r][c].setDown_obj((map.field[r+1][c]));
                    }
                }
                else if (c == map.field[0].length-1){
                        map.field[r][c].setLeft_obj(map.field[r][c-1]);
                    if (r-1 < 0){
                        map.field[r][c].setUp_obj(map.field[r-1][c]);
                    }
                    if (r+1 < map.field.length){
                        map.field[r][c].setDown_obj(map.field[r+1][c]);
                    }
                    }
                else {
                        map.field[r][c].setDown_obj(map.field[r+1][c]);
                        map.field[r][c].setUp_obj(map.field[r-1][c]);
                        map.field[r][c].setLeft_obj(map.field[r][c-1]);
                        map.field[r][c].setRight_obj(map.field[r][c+1]);
                    }
            }
        }
        return map;
    }

    public boolean stopReading() {
        return true;

    }

    public Maze createMaze() {
        if (error_occured) {
            return null;
        } else {
            return setLinks(CreateWallFrame(new MazeMap(rows+2,cols+2)));
        }
    }
}
