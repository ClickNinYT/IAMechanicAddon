package dev.clicknin.iamechanic;

public class Smelt {
    private final int burnTime;
    private final String replacementItem;

    public Smelt(int burnTime, String replacementItem) {
        this.burnTime = burnTime;
        this.replacementItem = replacementItem;
    }

    public int getBurnTime() {
        return this.burnTime * 20;
    }

    public String getReplacementItem() {
        return this.replacementItem;
    }
}
