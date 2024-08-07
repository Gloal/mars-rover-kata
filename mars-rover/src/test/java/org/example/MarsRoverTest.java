package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class MarsRoverTest {
    private MarsRover rover;

    @BeforeEach
    void SetUp() {
        rover = new MarsRover(0, 0, 'N');
    }

    @ParameterizedTest
    @CsvSource({
            "L, 0,0,W",
            "R, 0,0,E",
            "LL, 0,0,S",
            "LLLLLLL, 0,0,E",
            "LLLLLLLL, 0,0,N",
            "RRRR, 0,0,N",
            "RR, 0,0,S",
            "RRR, 0,0,W",
            "RRRRRRR, 0,0,W",
            "RLRLRLRLR, 0,0,E",
            "RLRLRLRLRLLLL, 0,0,E",
            "RLRLRLRL, 0,0,N"
    })
    void move_LeftOrRightFromNorth_ShouldReturnCorrectFinalDirection(String directions, int expectedXLocation, int expectedYLocation, char expectedDirection) {
        RoverPosition actualPosition = rover.move(directions);
        assertEquals(new RoverPosition(expectedXLocation,expectedYLocation,expectedDirection).toString(), actualPosition.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "L, 0,0,N",
            "R, 0,0,S",
            "LL, 0,0,W",
    })
    void move_LeftAndRightFromEast_ShouldReturnCorrectFinalDirection(String directions, int expectedXLocation, int expectedYLocation, char expectedDirection) {
        rover = new MarsRover(0, 0, 'E');
        RoverPosition actualPosition = rover.move(directions);
        assertEquals(new RoverPosition(expectedXLocation,expectedYLocation,expectedDirection).toString(), actualPosition.toString());
    }

    @Test
    void move_ConsecutiveForwardOrBackward_ShouldReturnCorrectFinalDirection() {
        assertEquals(new RoverPosition(0,2,'N').toString(), rover.move("FF").toString());
        assertEquals(new RoverPosition(0,2,'N').toString(), rover.move("BF").toString());
    }

    @ParameterizedTest
    @CsvSource({
            "B,0,-1,N",
            "LBBBBB, 5,0,W",
            "R, 0,0,E",
            "FLL, 0,1,S",
            "FFLLLLLLFL, 0,1,E",
            "BLLLLBFBLLLL, 0,-2,N",
            "BRRRR, 0,-1,N",
            "RFFFFFFFBBB, 4,0,E",
            "BRRR, 0,-1,W",
            "BBRRRRRRRFF, -2,-2,W",
            "RFLRLRLRLR, 1,0,E",
    })
    void move_LeftOrRightAndForwardOrBackward_shouldReturnCorrectPositionAndDirection(String directions, int expectedXLocation, int expectedYLocation, char expectedDirection) {
        RoverPosition actualPosition = rover.move(directions);
        assertEquals(new RoverPosition(expectedXLocation,expectedYLocation,expectedDirection).toString(), actualPosition.toString());
    }

    @Test
    void move_ConsecutiveMoveDirections_shouldReturnCorrectPosition() {
        assertEquals(new RoverPosition(0,2,'S').toString(), rover.move("FFLL").toString());
        assertEquals(new RoverPosition(0,2,'S').toString(), rover.move("BFRL").toString());
    }

    @ParameterizedTest
    @CsvSource({
            " ,0,-1,N",
            ", 5,0,W"
    })
    void move_NullMoveCommand_shouldReturnNullPointerException(String directions, int expectedXLocation, int expectedYLocation, char expectedDirection) {
        NullPointerException ex = assertThrows(NullPointerException.class, () -> rover.move(directions));
        assertEquals("Move command cannot be null; please enter valid command", ex.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "FFJFF ,0,-1,N",
            "7, 5,0,W",
            "L- , 0,0,N"
    })
    void move_InvalidMoveCommand_shouldReturnIllegalArgumentException(String directions, int expectedXLocation, int expectedYLocation, char expectedDirection) {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> rover.move(directions));
        assertThat (ex.getMessage(), containsString("Invalid move command: "));
    }

    @Test
    void throwsException_WhenGivenInvalidInitialDirection() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new MarsRover(0, 0, 'X'));
        assertEquals("Invalid direction", ex.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "-111,1,N",
            "111,0,W",
    })
    void move_InvalidXCoordinates_shouldReturnIllegalArgumentException(int initialXCoordinate, int initialYCoordinate, char initialDirection) {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new MarsRover(initialXCoordinate, initialYCoordinate, initialDirection));
        assertEquals("Invalid coordinates", ex.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "1,-111,N",
            "90, 111, W",
    })
    void move_InvalidYCoordinates_shouldReturnIllegalArgumentException(int initialXCoordinate, int initialYCoordinate, char initialDirection) {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new MarsRover(initialXCoordinate, initialYCoordinate, initialDirection));
        assertEquals("Invalid coordinates", ex.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "FF,-100,0,E",
            "LLBBBBB, -97,0,W",
    })
    void move_WrapXCoordinates_shouldReturnWrappedPosition(String directions, int expectedXLocation, int expectedYLocation, char expectedDirection) {
        rover = new MarsRover(99, 0, 'E');
        RoverPosition actualPosition = rover.move(directions);
        assertEquals(new RoverPosition(expectedXLocation,expectedYLocation,expectedDirection).toString(), actualPosition.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "FF,0,-100,N",
            "LLBBBBB, 0,-97,S",
    })
    void move_WrapYCoordinates_shouldReturnWrappedPosition(String directions, int expectedXLocation, int expectedYLocation, char expectedDirection) {
        rover = new MarsRover(0, 99, 'N');
        RoverPosition actualPosition = rover.move(directions);
        assertEquals(new RoverPosition(expectedXLocation,expectedYLocation,expectedDirection).toString(), actualPosition.toString());
    }
}
