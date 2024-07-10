package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class MarsRoverTest {
    private  MarsRover rover;
    @BeforeEach
    void SetUp(){
        rover = new MarsRover();
    }
    @ParameterizedTest
    @CsvSource({
            "00L, 00W",
            "00R, 00E",
            "00LL, 00S",
            "00LLLLLLL, 00E",
            "00LLLLLLLL, 00N",
            "00RRRR, 00N",
            "00RR, 00S",
            "00RRR, 00W",
            "00RRRRRRR, 00W",
            "00RLRLRLRLR, 00E",
            "00RLRLRLRLRLLLL, 00E",
            "00RLRLRLRL, 00N"

    })
    void returnsFinalPosition_WhenGivenLeftOrRIghtDirections(String directions, String expectedPosition){
        String actualPosition = rover.move(directions);
        assertEquals(expectedPosition, actualPosition);
    }




}
