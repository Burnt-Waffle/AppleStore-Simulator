package devices;

import java.util.Scanner;

public class IMac extends Mac implements ColorSelectable, StorageSelectable, RamSelectable {
    public IMac() {
        //iMac은 이름과 프로세서는 고정, 가격은 기본값으로 초기화
        this.name = "iMac";
        this.price = 2290000;
        this.processor = "M4";
    }

    @Override
    public void selectOptions(Scanner sc) {
        System.out.println();
        System.out.println("선택된 모델: " + this.name);
        System.out.println("현재 가격: " + String.format("%,d", this.price) + "원");
        selectColor(sc);
        selectRam(sc);
        selectStorage(sc);
    }

    @Override
    public void selectColor(Scanner sc) {
        int choice;
        while (true) {
            // iMac 색상 옵션 출력
            System.out.println("=== 색상 선택 ===");
            System.out.println("색상. 맘에 드는 색상을 선택하세요.");
            System.out.println("1. Blue");
            System.out.println("2. Purple");
            System.out.println("3. Pink");
            System.out.println("4. Orange");
            System.out.println("5. Yellow");
            System.out.println("6. Green");
            System.out.println("7. Silver");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= 7) {
                    break;
                } else {
                    System.out.println("\n잘못된 입력입니다. 범위 안에서 선택해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n잘못된 입력입니다. 숫자로 입력해주세요.");
            }
        }

        switch (choice) {
            case 1:
                color = "Blue";
                break;
            case 2:
                color = "Purple";
                break;
            case 3:
                color = "Pink";
                break;
            case 4:
                color = "Orange";
                break;
            case 5:
                color = "Yellow";
                break;
            case 6:
                color = "Green";
                break;
            case 7:
                color = "Silver";
                break;
        }
        System.out.println("\n선택한 색상: " + color);
        System.out.println("현재 가격: " + String.format("%,d", price) + "원");
    }

    // 램 용량 선택
    @Override
    public void selectRam(Scanner sc) {
        int choice;
        while (true) {
            System.out.println("=== 램 용량 선택 ===");
            System.out.println("용량을 선택하세요");
            System.out.println("1. 16GB");
            System.out.println("2. 24GB (+300000원)");
            System.out.println("3. 32GB (+600000원)");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= 3) {
                    break;
                } else {
                    System.out.println("\n잘못된 입력입니다. 범위 안에서 선택해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n잘못된 입력입니다. 숫자로 입력해주세요.");
            }
        }

        switch (choice) {
            case 1:
                ramSize = 16;
                break;
            case 2:
                ramSize = 24;
                price += 300000;
                break;
            case 3:
                ramSize = 32;
                price += 600000;
                break;
        }
        System.out.println("\n선택된 램 용량: " + ramSize + "GB");
        System.out.println("현재 가격: " + String.format("%,d", price) + "원");
    }

    @Override
    public void selectStorage(Scanner sc) {
        int choice;
        while (true) {
            System.out.println("=== 저장 용량 선택 ===");
            System.out.println("저장 용량. 당신에게 알맞은 저장 용량은?");
            System.out.println("1. 256GB");
            System.out.println("2. 512GB (+300,000원)");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= 2) {
                    break;
                } else {
                    System.out.println("\n잘못된 입력입니다. 범위 안에서 선택해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n잘못된 입력입니다. 숫자로 입력해주세요.");
            }
        }

        switch (choice) {
            case 1:
                storage = "256GB";
                break;
            case 2:
                storage = "512GB";
                price += 300000;
                break;
        }
        System.out.println("\n선택한 용량: " + storage);
        System.out.println("현재 가격: " + String.format("%,d", price) + "원");
    }
}
