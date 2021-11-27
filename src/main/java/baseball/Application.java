package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args){

        final Scanner scanner = new Scanner(System.in);

        System.out.println("게임 시작! 게임을 시작하려면 1, 종료하려면 2을 입력하세요.");
        int startStop= scanner.nextInt();

//
//        while(startStop==1){
//            BaseBallGame baseBallGame = new BaseBallGame();
//            startStop= baseBallGame.playGame();
//        }
        System.out.println("게임을 종료합니다.");
    }
}
