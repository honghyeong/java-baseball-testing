package baseball;


import java.util.ArrayList;
import java.util.stream.Stream;

public class GuessResult {

    //    private int answer;
    private ArrayList<int[]> answerList = new ArrayList<int[]>();
    private ArrayList<int[]> inputList = new ArrayList<int[]>();
    private int ballCount;
    private int strikeCount;
    private int answer;
    private int input;

    public GuessResult(int answer) {
        int tempAnswer=answer;
        this.answer=answer;

        for(int i=0;i<3;i++){
            answerList.add(new int[]{tempAnswer%10,i}); // ex) 713 -> (key, value) = { 7:2, 1:1, 3:0 }
            tempAnswer/=10;
        }

        this.ballCount=0;
        this.strikeCount=0;
    }


    public void setInput(int input){

        int tempInput=input;
        this.input = input;
        for(int i=0;i<3;i++){
            inputList.add(new int[]{tempInput%10,i});
            tempInput/=10;
        }
    }

    public void getBallResult(){
        int result=0;
        for(int i=0;i<3;i++){
            int value=answerList.get(i)[0];
            int index=answerList.get(i)[1];
            Stream<int[]> stream = inputList.stream();
            result+=(int)stream.filter(e->e[0]==value).filter(e->e[1]!=index).count();
        }
        System.out.println("getBallResult" + result);
        this.ballCount=result;

    }
    public void getStrikeResult(){
        int result=0;
        for(int i=0;i<3;i++){
            if((answerList.get(i)[0]==inputList.get(i)[0]) && answerList.get(i)[1]==inputList.get(i)[1]){
                result+=1;
            }
        }
        System.out.println("getStrikeResult" + result);
        this.strikeCount=result;
    }

    public boolean getFinalResult(){
        if (strikeCount == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return true;
        } else if (ballCount + strikeCount == 0) {
            System.out.println("낫싱");
            return false;
        } else {
            String a = "";
            if (ballCount > 0) {
                a += String.format("%d볼 ", ballCount);
            }
            if (strikeCount > 0) {
                a += String.format("%d스트라이크", strikeCount);
            }
            System.out.println(a);
            return false;
        }
        System.out.println("정답:"+answer);
        System.out.println(String.format("%d볼 %d스트라이크\n",ballCount,strikeCount));
        return false;
    }

}
