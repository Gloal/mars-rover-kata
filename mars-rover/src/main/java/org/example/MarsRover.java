package org.example;

public class MarsRover {

    private final RoverPosition initialPosition;
    private final RoverPosition currentPosition;

    public MarsRover(int x, int y, char direction) {
        if(!isValidDirection(direction)){
            throw new IllegalArgumentException("Invalid direction");
        }

        if(x > MarsTerrain.MAX_X || x < -MarsTerrain.MAX_X || y > MarsTerrain.MAX_Y || y < -MarsTerrain.MAX_Y){
            throw new IllegalArgumentException("Invalid coordinates");
        }

        this.initialPosition = new RoverPosition(x, y, direction);
        this.currentPosition = new RoverPosition(x, y, direction);

    }

    private boolean isValidDirection(char direction) {
        return direction == 'N' || direction == 'E' || direction == 'S' || direction == 'W';
    }

    public RoverPosition move(String moveCommand) {
        if(moveCommand == null){
            throw new NullPointerException("Move command cannot be null; please enter valid command");
        }
        for (char c : moveCommand.toCharArray()) {
            if (c == 'R') {
                turnRight();
            } else if (c == 'L') {
                turnLeft();
            } else if (c == 'F') {
                moveForward();
            } else if (c == 'B') {
                moveBackward();
            }else{
                throw new IllegalArgumentException("Invalid move command: "+c);
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
