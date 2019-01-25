package com.company;

import java.io.CharArrayReader;
import java.util.Arrays;

public class Robot {

    public static void main(String[] args) {
	// write your code here

        //TODO load and create level
        //Textdatei in Array speichern
        String[] loadedLevel = SimpleIO.readTextFile("C:\\Users\\Fabi\\IdeaProjects\\Robot\\src\\com\\company\\level.txt");

        //Methode aufrufen mit loadedLevel Array und in 2D Array speichern
          int[][] level = createLevel(loadedLevel);



        //TODO Random Array als Level erstellen


        Draw.init(800,600);
        Draw.enableDoubleBuffering(true);
        Draw.setFps(1000);
        Draw.setBackgroundColor(128,128,128);

        int x_posi = 0;
        int y_posi = 0;



//        int direction_x = randomVelocity();
//        int dírection_y = randomVelocity();


        while (true) {

            Draw.clearScreen();
            //TODO draw level and animate robot
            drawLevel(level,x_posi,y_posi);

//            if( isDirectionValid(direction_x,dírection_y) == true){
//                x_posi = y_posi+direction_x;
//                y_posi = y_posi+dírection_y;
//            }else {
//                System.out.println("test");
//            }

            Draw.syncToFrameRate();


        }

    }


    public static int[][] createLevel(String[] lines){

        int [][] zweidArray = new int [40][40] ;



        for(int i=0; i<lines.length; i++){
            for(int j=0; j<40; j++) {

                if(lines[i].charAt(j) == '.'){
                zweidArray[i][j] = 0;
                }
                else {
                    zweidArray[i][j] = -1;
                }
            }
        }

       return zweidArray;

    }


    public static void drawLevel(int[][] level, int robot_x, int robot_y){

        for(int i=0; i<26; i++){
            for(int j=0; j<40; j++){

                if(level[i][j]!=1){
                    if(level[i][j]<0){
                        Draw.setColor(255,255,255);
                        Draw.filledRect(j*20,i*20,20,20);
                    }else if(level[i][j]>0){
                        Draw.setColor(255,0,0);
                        Draw.filledRect(j*20,i*20,20,20);
                    }
                }

            }
        }

        Draw.setColor(0,255,0);
        Draw.filledRect(robot_x*20,robot_y*20,20,20);

    }

//    public static boolean isPositionValid( int[][] level, int x, int y){
//
//        boolean position = true;
//
//        if (level[x][y]>0 || level[x][y]==0) {
//            position = true;
//        }else if(x<0 || x>39){
//            position = false;
//        }else if(y<0 || y>25){
//            return false;
//        }
//
//        return position;
//    }


//    public static int randomVelocity(){
//        int randomNumber = (int)(Math.random()*((1-(-1))+1))+(-1);
//
//        return randomNumber;
//    }
//
//    public static boolean isDirectionValid(int direction_x, int direction_y){
//
//        if(direction_x != 0 || direction_y!=0){
//            return true;
//        }
//
//        return false;
//    }

}
