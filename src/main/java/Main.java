import devices.*;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Ad Pop-up Thread
        // schedule은 일반적인 ExecutorService가 아닌 ScheduledExecutorService에 있다.
        ScheduledExecutorService adPopUp = Executors.newSingleThreadScheduledExecutor();
        adPopUp.scheduleAtFixedRate(new AdMessage(), 10, 15, TimeUnit.SECONDS);

        Scanner sc = new Scanner(System.in);

        // Greeting
        System.out.println("Welcome to Apple Store!");
        System.out.println("스토어. 좋아하는 Apple 제품을 구입하는 가장 좋은 방법.");
        System.out.println("iPhone의 새 시대를 여는 iPhone 17 Pro, iPhone 17 그리고 완전히 새로운 iPhone Air를 만날 시간.\n");
        System.out.println("구매하려는 제품을 선택하세요.");
        System.out.println("1. iPhone");
        System.out.println("2. Mac");

        int categoryChoice = sc.nextInt();
        sc.nextLine();

        AppleDevice myDevice = null;

        if (categoryChoice == 1){
            myDevice = new IPhone();
        } else if (categoryChoice == 2){
            System.out.println("\n===원하는 Mac 선택===");
            System.out.println("꿈꾸던 그 모든 것, Mac과 함께 현실로.");
            System.out.println("1. MacBook Air");
            System.out.println("2. MacBook Pro");
            System.out.println("3. iMac");
            int macModelChoice = sc.nextInt();
            sc.nextLine();
            if (macModelChoice == 1 || macModelChoice == 2){
                myDevice = new Macbook(macModelChoice);
            } else if (macModelChoice == 3) {
                myDevice = new IMac();
            }
        }

        if (myDevice != null){
            myDevice.startPurchaseProcess(sc);
        } else {
            System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
        }

        sc.close();
        adPopUp.shutdown();
    }
}
