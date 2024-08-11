package com.concurrencyJJ.happensBefore.volatileSolution;

public class FrameExchanger {

    private long framesStoredCount;
    private long framesTakenCount;
    private volatile boolean hasNewFrame;
    private Frame frame;

    public void storeFrame(Frame frame) {
        this.frame = frame;
        framesStoredCount++;
        hasNewFrame = true;
        sleep(1);
    }

    public Frame takeFrame() {
        sleep(1);
        while (!hasNewFrame) {
            Thread.onSpinWait();
        }
        Frame newFrame = frame;
        framesTakenCount++;
        hasNewFrame = false;
        return newFrame;
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public long getFramesStoredCount() {
        return framesStoredCount;
    }

    public long getFramesTakenCount() {
        return framesTakenCount;
    }

    public boolean isHasNewFrame() {
        return hasNewFrame;
    }

    public Frame getFrame() {
        return frame;
    }
}
