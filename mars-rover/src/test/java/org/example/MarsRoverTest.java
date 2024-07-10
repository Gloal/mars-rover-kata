package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class MarsRoverTest {
    private MarsRover rover;
    private char[] initialPosition;


    @BeforeEach
    void SetUp() {
        rover = new MarsRover();
        initialPosition = new char[]{0,0,'N'};


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
    void returnsFinalPosition_WhenGivenLeftOrRightDirections(String directions, String expectedPosition) {
        char[] actualPosition = rover.move(initialPosition, directions.toCharArray());
        assertArrayEquals(expectedPosition.toCharArray(), actualPosition);
    }

    @Test
    void movesOnePositionForward_WhenGivenXDirections(){
        assertArrayEquals("1N".toCharArray(), rover.move(initialPosition,new char[]{'F','N'}));
    }


}
