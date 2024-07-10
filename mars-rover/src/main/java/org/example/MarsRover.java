package org.example;

public class MarsRover {

    private final Position initialPosition;
    private final Position currentPosition;
    private char direction;


    public MarsRover(int x, int y, char direction) {
        this.initialPosition = new Position(x, y);
        this.currentPosition = new Position(x, y);
        this.direction = direction;

    }

    public String move(char[] moveCommand) {
        for (char c : moveCommand) {
            if (c == 'R') {
                turnRight();
            } else if (c == 'L') {
                turnLeft();
            } else if (c == 'F') {
                moveForward();
            } else if (c == 'B') {
                moveBackward();
            }
        }

        String finalX = Integer.toString(this.currentPosition.x);
        String finalY = Integer.toString(this.currentPosition.y);
        return (finalX + finalY + this.direction);
    }

    private void moveBackward() {
        switch (direction) {
            case 'N':
                currentPosition.y--;
                break;
            case 'W':
                currentPosition.x++;
                break;
            case 'S':
                currentPosition.y++;
                break;
            case 'E':
                currentPosition.x--;
                break;
        }
    }

    private void moveForward() {
        switch (direction) {
            case 'N':
                currentPosition.y++;
                break;
            case 'W':
                currentPosition.x--;
                break;
            case 'S':
                currentPosition.y--;
                break;
            case 'E':
                currentPosition.x++;
                break;
        }
    }

    private void turnLeft() {
        switch (direction) {
            case 'N':
                this.direction = 'W';
                break;
            case 'W':
                this.direction = 'S';
                break;
            case 'S':
                this.direction = 'E';
                break;
            case 'E':
                this.direction = 'N';
                break;
        }
    }

    private void turnRight() {
        switch (direction) {
            case 'N':
                this.direction = 'E';
                break;
            case 'E':
                this.direction = 'S';
                break;
            case 'S':
                this.direction = 'W';
                break;
            case 'W':
                this.direction = 'N';
                break;
        }
    }
}

