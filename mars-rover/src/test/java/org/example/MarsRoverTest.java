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
            "0L, 00W",
            "0R, 00E",
            "0LL, 00S",
            "0LLLLLLL, 00E",
            "0LLLLLLLL, 00N",
            "0RRRR, 00N",
            "0RR, 00S",
            "0RRR, 00W",
            "0RRRRRRR, 00W",
            "0RLRLRLRLR, 00E",
            "0RLRLRLRLRLLLL, 00E",
            "0RLRLRLRL, 00N"
    })
    void move_LeftOrRightFromNorth_ShouldReturnCorrectFinalDirection(String directions, String expectedPosition) {
        String actualPosition = rover.move(directions.toCharArray());
        assertEquals(expectedPosition, actualPosition);
    }

    @ParameterizedTest
    @CsvSource({
            "0L, 00N",
            "0R, 00S",
            "0LL, 00W",

    })
    void move_LeftAndRightFromEast_ShouldReturnCorrectFinalDirection(String directions, String expectedPosition) {
        rover = new MarsRover(0, 0, 'E');
        String actualPosition = rover.move(directions.toCharArray());
        assertEquals(expectedPosition, actualPosition);
    }

    @Test
    void move_ConsecutiveForwardOrBackward_ShouldReturnCorrectFinalDirection() {
        assertEquals("02N", rover.move(new char[]{'F', 'F'}));
        assertEquals("02N", rover.move(new char[]{'B', 'F'}));
    }

    @ParameterizedTest
    @CsvSource({
            "B,0-1N",
            "LBBBBB, 50W",
            "R, 00E",
            "FLL, 01S",
            "FFLLLLLLFL, 01E",
            "BLLLLBFBLLLL, 0-2N",
            "BRRRR, 0-1N",
            "RFFFFFFFBBB, 40E",
            "BRRR, 0-1W",
            "BBRRRRRRRFF, -2-2W",
            "RFLRLRLRLR, 10E",
    })
    void move_LeftOrRightAndForwardOrBackward_shouldReturnCorrectPositionAndDirection(String directions, String expectedPosition) {
        String actualPosition = rover.move(directions.toCharArray());
        assertEquals(expectedPosition, actualPosition);
    }

    @Test
    void move_ConsecutiveLeftOrRightAndForwardOrBackward_shouldReturnCorrectPosition() {
        assertEquals("02S", rover.move(new char[]{'F', 'F','L','L'}));
        assertEquals("02S", rover.move(new char[]{'B', 'F', 'R', 'L'}));
    }

}
