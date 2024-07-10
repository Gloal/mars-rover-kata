package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MarsRoverTest {

    @Test
    void turnsRight_whenGivenDirections(){
        MarsRover rover = new MarsRover();
        assertEquals("00E", rover.move("00R"));
    }

    @Test
    void turnsLeft_whenGivenDiretions(){
        MarsRover rover = new MarsRover();
        assertEquals("00W", rover.move("00L"));
    }
}
