package org.example;

public class MarsRover {

    char initialDirection = 'N';
    public String move(String s) {
        int right_count = 0;
        int left_count = 0;
        for(char c: s.toCharArray()) {
            if (c == 'R') {
                right_count++;
            } else if (c == 'L'){
                left_count++;
            }
        }
        char finalDirection = right_count - left_count > 0? turnRight((right_count-left_count)%4) : turnLeft((left_count-right_count)%4);

        return "00"+finalDirection;
    }

    private static char turnLeft(int numOfTurns) {
        char direction = 'N';
        switch( numOfTurns){
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
        switch( numOfTurns){
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


}

