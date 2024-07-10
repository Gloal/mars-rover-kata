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
            "00LLLLLLL, 00E"
    })
    void turnsLeftOrRight_WhenGivenDirections(String directions, String expectedPosition){
        String actualPosition = rover.move(directions);
        assertEquals(expectedPosition, actualPosition);
    }




}
