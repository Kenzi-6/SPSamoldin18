package com.company;

import java.lang.Math;


class Num {
    int X;
    int Y;

    public Num(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public int umnozhenie(int x, int y) {
        if (x == 0 || y == 0) {
            return 0;
        } else if (x == 1) {
            return y;
        } else if (y == 1) {
            return x;
        } else {
            return (int) Math.pow(10, (Math.log10(x) + Math.log10(y)));
        }
    }
}
