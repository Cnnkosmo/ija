package ija.ija2022.homework1.game;

import ija.ija2022.homework1.common.Field;
import ija.ija2022.homework1.common.Maze;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        MazeConfigure cfg = new MazeConfigure();
        cfg.startReading(4, 3);
//        System.out.println(cfg.field.length);
        cfg.processLine("...");
        cfg.processLine(".X.");
        cfg.processLine(".X.");
        cfg.processLine(".S.");
        cfg.stopReading();
        Maze map = cfg.createMaze();
        for(int r = 0; r < map.field.length; r++){

            for (int c = 0; c < map.field[0].length; c++){
                    if(map.field[r][c] == null){
                    }else{
                        System.out.print(map.field[r][c].getSymbol());
                    }
            }
            System.out.println();
        }
        System.out.println(map.field[2][2].getDown_obj());

        List<Field> field = new ArrayList<>();
//        System.out.println(maze.numCols());
//        System.out.println(maze.numRows());
    }
}
