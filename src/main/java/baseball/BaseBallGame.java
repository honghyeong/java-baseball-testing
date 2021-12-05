package baseball;
import java.util.Scanner;
import utils.RandomUtils;

public class BaseBallGame {

    Scanner scanner = new Scanner(System.in);
    GuessInput guessInput=new GuessInput();
    GuessResult guessResult = new GuessResult(713); // get random answer
//    GuessResult guessResult = new GuessResult(RandomUtils.nextInt(100, 1000)); // get random answer

    BaseBallGame() {
    }

    public int playGame(){
        int ballCount=0;
        int strikeCount=0;
        boolean flag=false;


        while(!flag) {
            System.out.print("숫자를 입력해주세요 : ");
            int input=scanner.nextInt();

            try {
                guessInput.setInput(input);
            } catch (Exception e) {
                System.out.print("잘못된 입력입니다. 100~999의 정수 숫자를 입력해주세요 : ");
                input = scanner.nextInt();
            }
            guessResult.setInput(guessInput.getInput());
            guessResult.getBallResult();
            guessResult.getBallResult();

            flag = guessResult.getFinalResult();

        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextInt();
    }


}
