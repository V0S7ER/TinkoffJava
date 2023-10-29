package edu.hw2;

public class Task1 {
    public sealed interface Expr {
        double evaluate();

        record Constant(double value) implements Expr {
            @Override
            public double evaluate() {
                return value;
            }
        }

        record Negate(Expr e) implements Expr {
            @Override
            public double evaluate() {
                return -e.evaluate();
            }
        }

        record Exponent(Expr base, Expr power) implements Expr {
            @Override
            public double evaluate() {
                return Math.pow(base.evaluate(), power.evaluate());
            }
        }

        record Addition(Expr left, Expr right) implements Expr {
            @Override
            public double evaluate() {
                return left.evaluate() + right.evaluate();
            }
        }

        record Multiplication(Expr left, Expr right) implements Expr {

            @Override
            public double evaluate() {
                return left.evaluate() * right.evaluate();
            }
        }
    }
}
