package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RoverPositionTest {

    @Test
    void constructor_GivenValidDirection_ReturnsSetDirection() {
        RoverPosition roverPosition = new RoverPosition(1, 2, 'S');
        assertEquals(roverPosition.toString(), "1,2,S");
    }

    @Test
    void constructor_GivenInvalidDirection_ReturnsException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new RoverPosition(1, 2, 'b'));
        assertEquals("Invalid direction character; please enter a valid direction", ex.getMessage());
    }

    @Test
    void setDirection_GivenInvalidDirection_ReturnsException() {
        RoverPosition roverPosition = new RoverPosition(1, 2, 'S');
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> roverPosition.setDirection('x'));
        assertEquals("Invalid direction character; please enter a valid direction", ex.getMessage());
    }

    @Test
    void constructor_GivenInvalidXCoordinate_ReturnsIllegalArgumentException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new RoverPosition(111, 2, 'N'));
        assertEquals("Invalid coordinates", ex.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "1,-111,N",
            "90, 111, W",
    })
    void setXCoordinate_shouldReturnIllegalArgumentException(int initialXCoordinate, int initialYCoordinate, char initialDirection) {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new MarsRover(initialXCoordinate, initialYCoordinate, initialDirection));
        assertEquals("Invalid coordinates", ex.getMessage());
    }
}