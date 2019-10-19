package org.academiadecodigo.splicegirls.characters;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.splicegirls.position.Position;

public class Scary {

        private Picture picture;
        private Direction direction;
        private int distance = 1;
        private int health = 100;
        private int col;
        private int row;
        private boolean isAlive = true;
        private int cellSize = 80;
        private final int PADDING = 10;
        private int startingPointCol = 80;
        private int startingPointRow = 400;
        private int damage = 25;

    public Scary(int col, int row) {

        this.col = col;
        this.row = row;

        picture = new Picture(startingPointCol + (col * cellSize + PADDING),startingPointRow + (row * cellSize + PADDING), "scary/idle right scary.png");
        picture.draw();
    }

    public void moveUp() {
        row = row - distance;

    }

    public void moveDown() {
        row = row + distance;

    }

    public void moveLeft() {
        col = col - distance;

    }

    public void moveRight() {
        col = col + distance;

    }

    public void attack(Enemy enemy){

        if(enemy.getHealth() > 0) {
            if (enemy.getCol() == col +1 && enemy.getRow() == row){
                enemy.hit(50);
                System.out.println("outch");
            }
            if (enemy.getCol() == col -1 && enemy.getRow() == row){
                enemy.hit(50);
                System.out.println("outch2");
            }
        } else {
            enemy.killEnemy();
        }

    }
    public void hit(int damage){
        this.health = health - damage;
        System.out.println("Scary health: " + health);
    }

    public void killScary(){
        isAlive = false;
        this.picture.delete();
    }

    public int getCol(){
        return col;
    }

    public int getRow(){
        return row;
    }

    public Direction getDirection(){
        return direction;
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

    public Picture getPicture(){
        return picture;
    }

    public void setPicture(Picture picture){
        this.picture = picture;
    }

    public int getCellSize(){
        return cellSize;
    }

    public int getStartingPointCol(){
        return startingPointCol;
    }

    public int getStartingPointRow(){
        return startingPointRow;
    }

    public int getHealth(){
        return health;
    }



}

