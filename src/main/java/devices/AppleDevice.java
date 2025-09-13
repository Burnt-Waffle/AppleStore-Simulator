package devices;

import java.util.Scanner;

public class AppleDevice {
    public String name;
    public int price;
    public String color;
    public String storage;

    // 구매 프로세스 - 1. 옵션을 선택, 2. 최종 결정 확인
    public void startPurchaseProcess(Scanner sc) {
        selectOptions(sc);
        confirmPurchase(sc);
    }

    // 각 제품의 모델마다 다른 옵션 선택지에 맞게 오버라이딩으로 구현해야 한다.
    // (추상화는 쓰지 말라고 하셨지만...)
    public void selectOptions(Scanner sc) {
        System.out.println("아직 옵션을 선택하지 않았습니다.");
    }

    // 현재까지 선택된 옵션 출력
    public void showInfo() {
        System.out.println("\n[최종 선택된 제품 정보]");
        System.out.println("제품명: " + name);
        System.out.println("색상: " + color);
        System.out.println("저장용량: " + storage);
        System.out.println("총 가격: " + String.format("%,d",price) + "원");
    }

    // 최종 결재 확인
    public void confirmPurchase(Scanner sc) {
        showInfo();
        System.out.println("주문을 확정하시겠습니까? [y/n] ");
        String purchaseChoice = sc.nextLine();
        if (purchaseChoice.equalsIgnoreCase("y")){
            System.out.println("\n구매가 완료되었습니다!");
            System.out.println("주문하신 " + name + "이(가) 곧 배송될 예정입니다.\n");
        } else {
            System.out.println("\n구매가 취소되었습니다.\n");
        }
    }

}
