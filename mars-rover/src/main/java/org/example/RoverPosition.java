package org.example;

public class RoverPosition {
    private int x;
    private int y;
    private char direction;

    public RoverPosition(int x, int y, char direction) {
        if (!isValidDirection(direction)) {
            throw new IllegalArgumentException("Invalid direction character; please enter a valid direction");
        }
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getDirection() {
        return direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(char direction) {
        if (!isValidDirection(direction)) {
            throw new IllegalArgumentException("Invalid direction character; please enter a valid direction");
        }
        this.direction = direction;
    }

    private boolean isValidDirection(char direction) {
        return direction == 'N' || direction == 'E' || direction == 'S' || direction == 'W';
    }

    @Override
    public String toString() {
        return x + "," + y +","+ direction;
    }
}

