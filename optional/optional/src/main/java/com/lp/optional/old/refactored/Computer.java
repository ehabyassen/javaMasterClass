package com.lp.optional.old.refactored;

import java.util.Optional;

public class Computer {

    private Optional<SoundCard> soundCard;

    public Optional<SoundCard> getSoundCard() {
        return soundCard;
    }

    public void setSoundCard(SoundCard soundCard) {
        this.soundCard = Optional.of(soundCard);
    }
}
