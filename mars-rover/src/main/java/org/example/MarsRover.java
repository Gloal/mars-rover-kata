package org.example;

public class MarsRover {

    private final int[] initialPosition;
    private char direction;

    MarsRover(int x, int y, char direction){
        this.initialPosition = new int[]{x,y};
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
                forwardCount++;
                moveForward();
            } else if (c == 'B') {
                forwardCount--;
                moveBackward();
            }
        }

        return (Integer.toString(forwardCount) + this.direction).toCharArray();
    }

    private void moveBackward() {
    }

    private void moveForward() {
    }

    private char turnLeft(char initialDirection) {
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
            default:
                this.direction = 'N';
        }
        return this.direction;
    }

    private char turnRight(char initialDirection) {
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
            default:
                this.direction = 'N';
        }
        return this.direction;
    }
}

