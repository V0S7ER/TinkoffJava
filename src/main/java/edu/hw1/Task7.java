package edu.hw1;

public class Task7 {
    private Task7() {
    }

    public static int rotateLeft(int number, int shift) {
        String binaryString = Integer.toString(number, 2);
        int n = binaryString.length();

        int beginPos = shift % n;

        String rotatedBinaryString = binaryString.substring(beginPos, n) + binaryString.substring(0, beginPos);
        return Integer.parseInt(rotatedBinaryString, 2);

    }

    public static int rotateRight(int number, int shift) {
        String binaryString = Integer.toString(number, 2);
        int n = binaryString.length();
        return rotateLeft(number, n - shift % n);
    }
}
