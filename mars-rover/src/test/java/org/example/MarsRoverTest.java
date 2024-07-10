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
            "0L, 0W",
            "0R, 0E",
            "0LL, 0S",
            "0LLLLLLL, 0E",
            "0LLLLLLLL, 0N",
            "0RRRR, 0N",
            "0RR, 0S",
            "0RRR, 0W",
            "0RRRRRRR, 0W",
            "0RLRLRLRLR, 0E",
            "0RLRLRLRLRLLLL, 0E",
            "0RLRLRLRL, 0N"

    })
    void move_LeftOrRightFromNorth_ShouldReturnCorrectFinalDirection(String directions, String expectedPosition) {
        char[] actualPosition = rover.move(directions.toCharArray());
        assertArrayEquals(expectedPosition.toCharArray(), actualPosition);
    }

    @ParameterizedTest
    @CsvSource({
            "0L, 0N",
            "0R, 0S",
            "0LL, 0W",

    })
    void move_LeftAndRightFromEast_ShouldReturnCorrectFinalDirection(String directions, String expectedPosition) {
        rover = new MarsRover(0, 0, 'E');
        char[] actualPosition = rover.move(directions.toCharArray());
        assertArrayEquals(expectedPosition.toCharArray(), actualPosition);
    }

    @Test
    void move_ForwardOrBackward_ShouldReturnCorrectFinalDirection() {
        assertArrayEquals("1N".toCharArray(), rover.move(new char[]{'F', 'N'}));
        assertArrayEquals("-1N".toCharArray(), rover.move(new char[]{'B', 'N'}));
    }

    @ParameterizedTest
    @CsvSource({
            "B,-1N",
            "LBBBBB, -5W",
            "R, 0E",
            "FLL, 1S",
            "FFLLLLLLFL, 3E",
            "BLLLLBFBLLLL, -2N",
            "BRRRR, -1N",
            "RRFFFFFFFBBB, 4S",
            "BRRR, -1W",
            "BBRRRRRRRFF, 0W",
            "FRLRLRLRLR, 1E",

    })
    void move_LeftOrRightAndForwardOrBackward_shouldReturnCorrectDirection(String directions, String expectedPosition) {
        char[] actualPosition = rover.move(directions.toCharArray());
        assertArrayEquals(expectedPosition.toCharArray(), actualPosition);
    }

    void move_LeftOrRightAndForwardOrBackward_shouldReturnCorrectPosition(String directions, String expectedPosition) {
    }


}
