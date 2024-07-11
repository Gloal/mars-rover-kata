package org.example;

public class MarsRover {

    private final RoverPosition initialPosition;
    private final RoverPosition currentPosition;

    public MarsRover(int x, int y, char direction) {
        this.initialPosition = new RoverPosition(x, y, direction);
        this.currentPosition = new RoverPosition(x, y, direction);

    }

    public RoverPosition move(char[] moveCommand) {
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

        return currentPosition;
    }

    private void moveBackward() {
        switch (currentPosition.getDirection()) {
            case 'N':
                currentPosition.setY(currentPosition.getY() - 1);
                break;
            case 'W':
                currentPosition.setX(currentPosition.getX() + 1);
                break;
            case 'S':
                currentPosition.setY(currentPosition.getY() + 1);
                break;
            case 'E':
                currentPosition.setX(currentPosition.getX() - 1);
                break;
        }
    }

    private void moveForward() {
        switch (currentPosition.getDirection()) {
            case 'N':
                currentPosition.setY(currentPosition.getY() + 1);
                break;
            case 'W':
                currentPosition.setX(currentPosition.getX() - 1);
                break;
            case 'S':
                currentPosition.setY(currentPosition.getY() - 1);
                break;
            case 'E':
                currentPosition.setX(currentPosition.getX() + 1);
                break;
        }
    }

    private void turnLeft() {

        switch (currentPosition.getDirection()) {
            case 'N':
                currentPosition.setDirection('W');
                break;
            case 'W':
                currentPosition.setDirection('S');
                break;
            case 'S':
                currentPosition.setDirection('E');
                break;
            case 'E':
                currentPosition.setDirection('N');
                break;
        }
    }

    private void turnRight() {
        switch (currentPosition.getDirection()) {
            case 'N':
                currentPosition.setDirection('E');
                break;
            case 'W':
                currentPosition.setDirection('N');
                break;
            case 'S':
                currentPosition.setDirection('W');
                break;
            case 'E':
                currentPosition.setDirection('S');
                break;
        }
    }

}
