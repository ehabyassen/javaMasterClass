package com.concurrencyJJ.happensBefore.issue;

public class Demo {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            runExperiment();
            System.out.println("+".repeat(50));
        }
    }

    private static void runExperiment() {
        FrameExchanger frameExchanger = new FrameExchanger();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                Frame frame = new Frame("Frame-" + i);
                frameExchanger.storeFrame(frame);
            }
        }, "Producer Thread");

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                Frame frame = frameExchanger.takeFrame();
                System.out.println(frame);
            }
        }, "Consumer Thread");

        producer.setDaemon(true);
        consumer.setDaemon(true);
        producer.start();
        consumer.start();

        try {
            Thread.sleep(1000);
            producer.interrupt();
            consumer.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Frames Stored: " + frameExchanger.getFramesStoredCount());
        System.out.println("Frames Taken: " + frameExchanger.getFramesTakenCount());
        System.out.println("hasNewFrame: " + frameExchanger.isHasNewFrame());
        System.out.println("Last Produced Frame: " + frameExchanger.getFrame());
    }
}
