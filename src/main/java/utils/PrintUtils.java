package utils;

import java.util.Random;

public class PrintUtils {
    public PrintUtils() {
    }

    public static void printResult(int ballCount, int strikeCount){
        if (strikeCount == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");

        } else if (ballCount + strikeCount == 0) {
            System.out.println("낫싱");

        } else {
            String a = "";
            if (ballCount > 0) {
                a += String.format("%d볼 ", ballCount);
            }
            if (strikeCount > 0) {
                a += String.format("%d스트라이크", strikeCount);
            }
            System.out.println(a);
        }
    }
}
