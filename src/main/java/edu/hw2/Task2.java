package edu.hw2;

public class Task2 {
    public static class Rectangle { // класс - иммутабельный, проблемы решены
        private final int height;
        private final int width;

        public Rectangle(int height, int width) {
            this.height = height;
            this.width = width;
        }

        public int area() {
            return height * width;
        }

        public Rectangle setHeight(int height) {
            return new Rectangle(height, width);
        }

        public Rectangle setWidth(int width) {
            return new Rectangle(height, width);
        }
    }

    public static class Square extends Rectangle {

        public Square(int side) {
            super(side, side);
        }

        @Override public Square setHeight(int side) {
            return new Square(side);
        }

        @Override public Square setWidth(int side) {
            return new Square(side);
        }

        @Override public int area() {
            return super.area();
        }
    }
}
