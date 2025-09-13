package devices;

import java.util.Scanner;

public class Mac extends AppleDevice {
    public String processor;
    public int ramSize;

    @Override
    public void showInfo() {
        System.out.println("\n[최종 선택된 제품 정보]");
        System.out.println("제품명: " + name);
        System.out.println("프로세서: " + processor);
        System.out.println("램 용량: " + ramSize + "GB");
        System.out.println("색상: " + color);
        System.out.println("저장용량: " + storage);
        System.out.println("총 가격: " + String.format("%,d",price) + "원");
    }
}
