package org.example;

public class MarsRover {
    public String move(String s) {
        for(char c: s.toCharArray()) {
            if (c == 'R') {
                return "00E";
            } else if (c == 'L'){
                return "00W";
            }
        }
        return null;
    }
}
