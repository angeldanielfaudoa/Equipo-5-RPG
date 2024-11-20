package rpg.utils.cache;

public interface Randomized {

    static int getRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }
}