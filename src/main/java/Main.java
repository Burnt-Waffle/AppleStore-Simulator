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

        int categoryChoice;
        // 잘못된 입력이 주어졌을 때 예외처리
        while(true){
            System.out.println("구매하려는 제품을 선택하세요.");
            System.out.println("1. iPhone");
            System.out.println("2. Mac");
            try{
                categoryChoice = Integer.parseInt(sc.nextLine());
                if (categoryChoice==1 || categoryChoice==2){
                    break;
                } else {
                    System.out.println("\n잘못된 입력입니다. 1 또는 2 중에서 선택해주세요.");
                }
            } catch(NumberFormatException e){
                System.out.println("\n잘못된 입력입니다. 숫자로 입력해주세요.");
            }
        }

        AppleDevice myDevice = null;

        if (categoryChoice == 1){
            myDevice = new IPhone();
        } else {
            System.out.println("\n=== 원하는 Mac 선택 ===");
            System.out.println("꿈꾸던 그 모든 것, Mac과 함께 현실로.");
            while(true){
                try{
                    System.out.println("1. MacBook Air");
                    System.out.println("2. MacBook Pro");
                    System.out.println("3. iMac");
                    categoryChoice = Integer.parseInt(sc.nextLine());
                    if (categoryChoice==1 || categoryChoice==2 || categoryChoice==3){
                        break;
                    } else {
                        System.out.println("\n잘못된 입력입니다. 1, 2, 3 중에서 선택해주세요.");
                    }
                } catch(NumberFormatException e){
                    System.out.println("\n잘못된 입력입니다. 숫자로 입력해주세요.");
                }
            }
            if (categoryChoice == 1 || categoryChoice == 2){
                myDevice = new Macbook(categoryChoice);
            } else {
                myDevice = new IMac();
            }
        }

        myDevice.startPurchaseProcess(sc);

        sc.close();
        adPopUp.shutdown();
    }
}
