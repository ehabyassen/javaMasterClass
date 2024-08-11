package com.concurrencyJJ.happensBefore.issue;

public class FrameExchanger {

    private long framesStoredCount;
    private long framesTakenCount;
    private boolean hasNewFrame;
    private Frame frame;

    public void storeFrame(Frame frame) {
        this.frame = frame;
        framesStoredCount++;
        hasNewFrame = true;
    }

    public Frame takeFrame() {
        while (!hasNewFrame) {
            //busy waiting
        }
        Frame newFrame = frame;
        framesTakenCount++;
        hasNewFrame = false;
        return newFrame;
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
