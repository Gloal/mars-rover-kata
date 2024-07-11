package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class RoverPositionTest {

    @Test
    void setDirection_GivenValidDirection_ReturnsSetDirection() {
        RoverPosition roverPosition = new RoverPosition(1,2,'S');
        assertEquals(roverPosition.toString(), "1,2,S");
    }

    @Test
    void setDirection_GivenInvalidDirection_ReturnsException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new RoverPosition(1,2,'b'));
        assertEquals("Invalid direction character; please enter a valid direction", ex.getMessage());
    }

}