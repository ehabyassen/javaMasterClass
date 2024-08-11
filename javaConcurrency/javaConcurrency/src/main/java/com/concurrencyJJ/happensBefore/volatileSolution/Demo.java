package com.concurrencyJJ.happensBefore.volatileSolution;

public class Demo {

    public static void main(String[] args) {
        runExperiment();
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

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Frames Stored: " + frameExchanger.getFramesStoredCount());
        System.out.println("Frames Taken: " + frameExchanger.getFramesTakenCount());
        System.out.println("hasNewFrame: " + frameExchanger.isHasNewFrame());
        System.out.println("Last Produced Frame: " + frameExchanger.getFrame());
    }
}
