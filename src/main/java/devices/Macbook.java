package devices;

import java.util.Scanner;

public class Macbook extends Mac implements ColorSelectable, StorageSelectable, RamSelectable, DisplaySizeSelectable, ProcessorSelectable {
    public boolean isPro;

    public Macbook (int num){
        if (num == 1){
            name = "MacBook Air";
            isPro = false;
        } else if (num == 2){
            name = "MacBook Pro";
            isPro = true;
        }
    }

    @Override
    public void selectOptions(Scanner sc) {
        selectDisplay(sc);
        selectColor(sc);
        selectProcessor(sc);
        selectRam(sc);
        selectStorage(sc);
    }

    @Override
    public void selectDisplay(Scanner sc){
        System.out.println("\n" + "=== 화면 크기 선택 ===");
        System.out.println(name + "의 화면 크기를 선택하세요.");

        int choice;
        while(true){
            if (!isPro){
                System.out.println("1. 13inch (1,590,000원)");
                System.out.println("2. 15inch (1,890,000원)");
            } else {
                System.out.println("1. 14inch (2,390,000원)");
                System.out.println("2. 16inch (3,690,000원)");
            }
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

        if (!isPro) {
            if (choice == 1) {
                name += " 13";
                price = 1590000;
            } else {
                name += " 15";
                price = 1890000;
            }
        } else{
            if (choice == 1){
                name += " 14";
                price = 2390000;
            } else {
                name += " 16";
                price = 3690000;
            }
        }
        System.out.println("\n선택한 모델: " + name);
        System.out.println("현재 가격: " + String.format("%,d",price) + "원");
    }

    @Override
    public void selectColor(Scanner sc) {
        int choice;
        while(true){
            System.out.println("=== 색상 선택 ===");
            System.out.println("색상. 맘에 드는 색상을 선택하세요.");
            // 색상 옵션 출력
            if (!isPro) {
                System.out.println("1. Sky Blue");
                System.out.println("2. Silver");
                System.out.println("3. Starlight");
                System.out.println("4. Midnight");
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    if (choice >= 1 && choice <= 4) {
                        break;
                    } else {
                        System.out.println("\n잘못된 입력입니다. 범위 안에서 선택해주세요.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\n잘못된 입력입니다. 숫자로 입력해주세요.");
                }
            } else {
                // 색상 옵션 출력
                System.out.println("1. Space Black");
                System.out.println("2. Silver");
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
        }

        if(!isPro){
            switch (choice) {
                case 1:
                    color = "Sky Blue";
                    break;
                case 2:
                    color = "Silver";
                    break;
                case 3:
                    color = "Starlight";
                    break;
                case 4:
                    color = "Midnight";
                    break;
            }
        } else {
            switch (choice) {
                case 1:
                    color = "Space Black";
                    break;
                case 2:
                    color = "Silver";
                    break;
            }
        }

        System.out.println("\n선택한 색상: " + color);
        System.out.println("현재 가격: " + String.format("%,d",price) + "원");
    }

    @Override
    public void selectProcessor(Scanner sc){
        if (isPro){
            int choice;
            while(true){
                System.out.println("=== 프로세서를 선택하세요. ===");
                System.out.println("1. M4 Pro");
                System.out.println("2. M4 Max (+600,000원)");
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
            if (choice == 1){
                processor = "M4 Pro";
            } else {
                processor = "M4 Max";
                price += 600000;
            }
            System.out.println("\n선택한 프로세서: " + processor);
            System.out.println("현재 가격: " + String.format("%,d",price) + "원");

        } else {
            processor = "M4"; // Pro가 아니라면 M4로 고정
        }
    }

    @Override
    public void selectRam(Scanner sc) {
        int choice;
        while(true){
            System.out.println("=== 램 용량 선택 ===");
            System.out.println("용량을 선택하세요");
            System.out.println("1. 24GB");
            System.out.println("2. 36GB (+300000원)");
            System.out.println("3. 48GB (+600000원)");
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
        switch(choice){
            case 1:
                ramSize = 24; break;
            case 2:
                ramSize = 36;
                price += 300000;
                break;
            case 3:
                ramSize = 48;
                price += 600000;
                break;
        }
        System.out.println("\n선택된 램 용량: " + ramSize + "GB");
        System.out.println("현재 가격: " + String.format("%,d",price) + "원");
    }

    @Override
    public void selectStorage(Scanner sc){
        int choice;
        while(true){
            System.out.println("=== 저장 용량 선택 ===");
            System.out.println("저장 용량. 당신에게 알맞은 저장 용량은?");
            System.out.println("1. 512GB");
            System.out.println("2. 1TB (+600,000원)");
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

        switch(choice) {
            case 1:
                storage = "512GB";
                break;
            case 2:
                storage = "1TB";
                price += 600000;
                break;
        }
        System.out.println("\n선택한 용량: " + storage);
        System.out.println("현재 가격: " + String.format("%,d",price) + "원");
    }
}
