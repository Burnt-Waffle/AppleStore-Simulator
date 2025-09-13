
public class AdMessage implements Runnable{
    private final String[] ads = {
            "고민은 배송만 늦출뿐",
            "애플병을 치료하는 방법은 구매뿐",
    };

    private int adIndex = 0;

    @Override
    public void run() {
        String showAD =
                "********************************************************\n" +
                "*                                                      *\n" +
                "*                APPLE         AD                      *\n" +
                "*                                                      *\n" +
                "********************************************************";
        System.out.println(showAD);
        System.out.println(ads[adIndex]);

        adIndex = (adIndex + 1) % 2;
    }
}
