package devices;

import java.util.Scanner;

public class IPhone extends AppleDevice implements ColorSelectable, StorageSelectable{

    // 모델마다 선택할 수 있는 옵션이 다르기 떄문에 선택지들을 먼저 정리해야 됨
    // 이름이 너무 길어서 모델별 식별자로 구분
    private final int IPHONE_17 = 1;
    private final int IPHONE_AIR = 2;
    private final int IPHONE_PRO = 3;
    private final int IPHONE_PRO_MAX = 4;

    // 배열로 각 모델별 옵션 저장
    private final String[] MODEL_NAMES = {"iPhone 17", "iPhone Air", "iPhone 17 Pro", "iPhone 17 Pro Max"};
    private final int[] MODEL_PRICES = {1290000, 1590000, 1790000, 1990000};

    private final String[] IPHONE17_COLORS = {"Lavender", "Sage", "Mist Blue", "White", "Black"};
    private final String[] IPHONE_AIR_COLORS = {"Sky Blue", "Light Gold", "Cloud White", "Space Black"};
    private final String[] IPHONE_PRO_COLORS = {"Silver", "Cosmic Orange", "Deep Blue"};

    private final String[] IPHONE17_STORAGE = {"256GB", "512GB"};
    private final String[] IPHONE_AIR_STORAGE = {"256GB", "512GB", "1TB"};
    private final String[] IPHONE_PRO_STORAGE = {"256GB", "512GB", "1TB", "2TB"};
    private final int[] IPHONE17_STORAGE_PRICE = {0, 300000};
    private final int[] IPHONE_AIR_STORAGE_PRICE = {0, 300000, 600000};
    private final int[] IPHONE_PRO_STORAGE_PRICE = {0, 300000, 600000, 1200000};

    private int modelType; // 선택된 모델 식별자를 저장

    // 아이폰에서 선택할 수 있는 옵션들
    @Override
    public void selectOptions(Scanner sc){
        selectModel(sc);
        selectColor(sc);
        selectStorage(sc);
    }

    // 아이폰 모델 선택
    public void selectModel(Scanner sc){
        int choice;
        while(true){
            System.out.println("\n=== iPhone 모델 선택 ===");
            System.out.println("모델. 당신에게 딱 맞는 모델은?");
            // 모델 옵션 출력
            for (int i = 0; i < MODEL_NAMES.length; i++){
                System.out.printf("%d. %s (%,d원)\n", i + 1, MODEL_NAMES[i], MODEL_PRICES[i]);
            }
            try{
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= MODEL_NAMES.length){
                    break;
                } else {
                    System.out.println("\n잘못된 입력입니다. 범위 안에서 선택해주세요.");
                }
            } catch(NumberFormatException e){
                System.out.println("\n잘못된 입력입니다. 숫자로 입력해주세요.");
            }
        }
        this.modelType = choice;
        this.name = MODEL_NAMES[modelType-1];
        this.price = MODEL_PRICES[modelType-1];

        System.out.println("\n선택된 모델: " + name);
        System.out.println("현재 가격: " + String.format("%,d",price) + "원");
    }

    @Override
    public void selectColor(Scanner sc) {
        // 모델에 맞게 색상 옵션 로드
        String[] colorOptions;
        switch (this.modelType){
            case IPHONE_17:
                colorOptions = IPHONE17_COLORS;
                break;
            case IPHONE_AIR:
                colorOptions = IPHONE_AIR_COLORS;
                break;
            default:
                colorOptions = IPHONE_PRO_COLORS;
        }

        int choice;
        while(true){
            System.out.println("=== 색상 선택 ===");
            System.out.println("색상. 맘에 드는 색상을 선택하세요.");
            // 모델별 색상 옵션 출력
            for (int i = 0; i < colorOptions.length; i++){
                System.out.printf("%d. %s\n", i+1, colorOptions[i]);
            }
            try{
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= colorOptions.length){
                    break;
                } else {
                    System.out.println("\n잘못된 입력입니다. 범위 안에서 선택해주세요.");
                }
            } catch(NumberFormatException e){
                System.out.println("\n잘못된 입력입니다. 숫자로 입력해주세요.");
            }
        }

        this.color = colorOptions[choice-1];

        System.out.println("\n선택한 색상: " + color);
        System.out.println("현재 가격: " + String.format("%,d",price) + "원");
    }


    @Override
    public void selectStorage(Scanner sc) {
        // 모델에 맞게 용량과 가격 옵션 로드
        String[] storageOptions;
        int[] storagePrice;
        switch (this.modelType){
            case IPHONE_17:
                storageOptions = IPHONE17_STORAGE;
                storagePrice = IPHONE17_STORAGE_PRICE;
                break;
            case IPHONE_AIR:
            case IPHONE_PRO:
                storageOptions = IPHONE_AIR_STORAGE;
                storagePrice = IPHONE_AIR_STORAGE_PRICE;
                break;
            case IPHONE_PRO_MAX:
                storageOptions = IPHONE_PRO_STORAGE;
                storagePrice = IPHONE_PRO_STORAGE_PRICE;
                break;
            default:
                System.out.println("오류: 잘못된 모델입니다.");
                return;
        }

        int choice;
        while(true){
            System.out.println("=== 저장 용량 선택 ===");
            System.out.println("저장 용량. 당신에게 알맞은 저장 용량은?");
            // iPhone 별 저장 용량 옵션 출력
            for (int i = 0; i < storageOptions.length; i++){
                System.out.printf("%d. %s (+%,d원)\n", i+1, storageOptions[i], storagePrice[i]);
            }
            try{
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= storageOptions.length){
                    break;
                } else {
                    System.out.println("\n잘못된 입력입니다. 범위 안에서 선택해주세요.");
                }
            } catch(NumberFormatException e){
                System.out.println("\n잘못된 입력입니다. 숫자로 입력해주세요.");
            }
        }

        this.storage = storageOptions[choice-1];
        this.price += storagePrice[choice-1];

        System.out.println("\n선택한 용량: " + storage);
        System.out.println("현재 가격: " + String.format("%,d",price) + "원");
    }
}
