package org.example;

public class MarsRover {

    char[] defaultInitialDirection = new char[3];

    public char[] move(char[] startingPoint, char[] moveCommand) {
        int rightCount = 0;
        int leftCount = 0;
        int forwardCount = 0;
        for (char c : moveCommand) {
            if (c == 'R') {
                rightCount++;
            } else if (c == 'L') {
                leftCount++;
            }else if(c == 'F'){
                forwardCount++;
            }
        }
        char finalDirection = rightCount - leftCount > 0 ?
                turnRight((rightCount - leftCount) % 4)
                : turnLeft((leftCount - rightCount) % 4);

        return forwardCount >0? ("1"+finalDirection).toCharArray():("0" + finalDirection).toCharArray();
    }

    private static char turnLeft(int numOfTurns) {
        char direction = 'N';
        switch (numOfTurns) {
            case 1:
                direction = 'W';
                break;
            case 2:
                direction = 'S';
                break;
            case 3:
                direction = 'E';
                break;
            default:

        }
        return direction;
    }

    private static char turnRight(int numOfTurns) {
        char direction = 'N';
        switch (numOfTurns) {
            case 1:
                direction = 'E';
                break;
            case 2:
                direction = 'S';
                break;
            case 3:
                direction = 'W';
                break;
            default:

        }
        return direction;
    }

    private static char moveForward(int numOfMoves) {
        return '1';
    }


}

