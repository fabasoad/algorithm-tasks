package com.fabasoad.custom;

class SquareRoot {

  public static double square(double number){
    double t;
    double squareroot = number / 2;
    do {
      t = squareroot;
      squareroot = (t + (number / t)) / 2;
    } while ((t - squareroot) != 0);
    return squareroot;
  }

  public static void main(String[] args) {
    System.out.println(square(2));
    System.out.println(square(4));
    System.out.println(square(8));
  }
}
