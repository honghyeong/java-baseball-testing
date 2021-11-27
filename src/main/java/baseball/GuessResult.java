package baseball;
import utils.PrintUtils;

import java.util.ArrayList;
import java.util.stream.Stream;

public class GuessResult {


    private ArrayList<int[]> answerList = new ArrayList<int[]>();


    public GuessResult(int answer) {
        int tempAnswer=answer;

        for(int i=0;i<(int)(Math.log10(answer)+1);i++){
            answerList.add(new int[]{tempAnswer%10,i}); // ex) 713 -> (key, value) = { 7:2, 1:1, 3:0 }
            tempAnswer/=10;
        }

    }

    public int getBallResult(ArrayList<int[]> inputList){
        int result=0;
        for(int i=0;i<answerList.size();i++){
            int value=answerList.get(i)[0];
            int index=answerList.get(i)[1];
            result+=inputList.stream().filter(e->e[0]==value).filter(e->e[1]!=index).count();
        }
        return result;
    }

    public int getStrikeResult(ArrayList<int[]> inputList){
        int result=0;
        for(int i=0;i<answerList.size();i++){
            if((answerList.get(i)[0]==inputList.get(i)[0]) && answerList.get(i)[1]==inputList.get(i)[1]){
                result+=1;
            }
        }
        return result;
    }

    public boolean getFinalResult(ArrayList<int[]> inputList){

        int ballCount=getBallResult(inputList);
        int strikeCount=getStrikeResult(inputList);
        PrintUtils.printResult(ballCount,strikeCount);

        if(strikeCount==3 && ballCount==0){
            return true;
        }
        else{
            return false;
        }
    }


}
