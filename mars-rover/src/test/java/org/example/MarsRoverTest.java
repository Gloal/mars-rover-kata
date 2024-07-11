package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class MarsRoverTest {
    private MarsRover rover;

    @BeforeEach
    void SetUp() {
        rover = new MarsRover(0, 0, 'N');
    }

    @ParameterizedTest
    @CsvSource({
            "0L, 0,0,W",
            "0R, 0,0,E",
            "0LL, 0,0,S",
            "0LLLLLLL, 0,0,E",
            "0LLLLLLLL, 0,0,N",
            "0RRRR, 0,0,N",
            "0RR, 0,0,S",
            "0RRR, 0,0,W",
            "0RRRRRRR, 0,0,W",
            "0RLRLRLRLR, 0,0,E",
            "0RLRLRLRLRLLLL, 0,0,E",
            "0RLRLRLRL, 0,0,N"
    })
    void move_LeftOrRightFromNorth_ShouldReturnCorrectFinalDirection(String directions, int expectedXLocation, int expectedYLocation, char expectedDirection) {
        RoverPosition actualPosition = rover.move(directions.toCharArray());
        assertEquals(new RoverPosition(expectedXLocation,expectedYLocation,expectedDirection).toString(), actualPosition.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "0L, 0,0,N",
            "0R, 0,0,S",
            "0LL, 0,0,W",

    })
    void move_LeftAndRightFromEast_ShouldReturnCorrectFinalDirection(String directions, int expectedXLocation, int expectedYLocation, char expectedDirection) {
        rover = new MarsRover(0, 0, 'E');
        RoverPosition actualPosition = rover.move(directions.toCharArray());
        assertEquals(new RoverPosition(expectedXLocation,expectedYLocation,expectedDirection).toString(), actualPosition.toString());
    }

    @Test
    void move_ConsecutiveForwardOrBackward_ShouldReturnCorrectFinalDirection() {
        assertEquals(new RoverPosition(0,2,'N').toString(), rover.move(new char[]{'F', 'F'}).toString());
        assertEquals(new RoverPosition(0,2,'N').toString(), rover.move(new char[]{'B', 'F'}).toString());
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
        RoverPosition actualPosition = rover.move(directions.toCharArray());
        assertEquals(new RoverPosition(expectedXLocation,expectedYLocation,expectedDirection).toString(), actualPosition.toString());
    }

    @Test
    void move_ConsecutiveMoveDirections_shouldReturnCorrectPosition() {
        assertEquals(new RoverPosition(0,2,'S').toString(), rover.move(new char[]{'F', 'F','L','L'}).toString());
        assertEquals(new RoverPosition(0,2,'S').toString(), rover.move(new char[]{'B', 'F', 'R', 'L'}).toString());
    }

}
