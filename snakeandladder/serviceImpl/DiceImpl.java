package snakeandladder.serviceImpl;

import snakeandladder.service.Dice;

import java.util.Random;

public class DiceImpl implements Dice {
    private int DICE_MIN = 1;
    private int DICE_MAX = 6;
    private Random random = new Random();

    @Override
    public int roll() {
        return this.random.nextInt(this.DICE_MAX - this.DICE_MIN + 1) + this.DICE_MIN;
    }
}
