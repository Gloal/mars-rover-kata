package org.example;

public class MarsRover {

    private final int[] initialPosition;
    private int[] currentPosition;

    private int currentYposition;
    private int currentXPosition;
    private char direction;



    MarsRover(int x, int y, char direction){
        this.initialPosition = new int[]{x,y};
        this.currentPosition = new int[2];
        this.direction = direction;

    }


    public char[] move(char[] moveCommand) {
        int rightCount = 0, leftCount = 0, forwardCount = 0;
        for (char c : moveCommand) {
            if (c == 'R') {
                turnRight(direction);
            } else if (c == 'L') {
                turnLeft(direction);
            } else if (c == 'F') {
                moveForward();
            } else if (c == 'B') {
                moveBackward();
            }
        }

        String finalX = Integer.toString(this.currentPosition[0]);
        String finalY = Integer.toString(this.currentPosition[1]);
        return (finalX + finalY + this.direction).toCharArray();
    }

    private void moveBackward() {
        switch (direction) {
            case 'N':
                currentPosition[1]--;
                break;
            case 'W':
                currentPosition[0]++;
                break;
            case 'S':
                currentPosition[1]++;
                break;
            case 'E':
                currentPosition[0]--;
                break;
        }
    }

    private void moveForward() {
        switch (direction) {
            case 'N':
                currentPosition[1]++;
                break;
            case 'W':
                currentPosition[0]--;
                break;
            case 'S':
                currentPosition[1]--;
                break;
            case 'E':
                currentPosition[0]++;
                break;
        }
    }

    private void turnLeft(char initialDirection) {
        switch (initialDirection) {
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

    private void turnRight(char initialDirection) {
        switch (initialDirection) {
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

