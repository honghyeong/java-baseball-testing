package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GuessResultTest {



    @Test
    @DisplayName("Test getBallResult")
    void getBallResult(){
        GuessResult guessResult =new GuessResult(713);

        ArrayList<int[]> inputList=new ArrayList<int[]>();

        // test input, output 설정
        int tempAnswer=123;
        int expectedOutput=1;

        for(int i=0;i<3;i++){
            inputList.add(new int[]{tempAnswer%10,i}); // ex) 713 -> (key, value) = { 7:2, 1:1, 3:0 }
            tempAnswer/=10;
        }

        Assertions.assertEquals(expectedOutput,guessResult.getBallResult(inputList)); // expected output

    }

    @Test
    @DisplayName("Test getStrikeResult")
    void getStrikeResult(){
        GuessResult guessResult =new GuessResult(713);

        ArrayList<int[]> inputList=new ArrayList<int[]>();

        // test input, output 설정
        int tempAnswer=123;
        int expectedOutput=1;

        for(int i=0;i<3;i++){
            inputList.add(new int[]{tempAnswer%10,i}); // ex) 713 -> (key, value) = { 7:2, 1:1, 3:0 }
            tempAnswer/=10;
        }

        Assertions.assertEquals(expectedOutput,guessResult.getStrikeResult(inputList));

    }


    @Test
    @DisplayName("Test getFinalResult")
    void getFinalResult(){
        GuessResult guessResult =new GuessResult(713);

        ArrayList<int[]> inputList=new ArrayList<int[]>();

        // test input, output 설정
        int tempAnswer=713;
        boolean expectedOutput=true;

        for(int i=0;i<3;i++){
            inputList.add(new int[]{tempAnswer%10,i}); // ex) 713 -> (key, value) = { 7:2, 1:1, 3:0 }
            tempAnswer/=10;
        }

        Assertions.assertEquals(expectedOutput,guessResult.getFinalResult(inputList));

    }

}