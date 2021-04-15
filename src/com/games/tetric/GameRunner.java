package com.games.tetric;

import java.util.Arrays;

public class GameRunner {
    public static void main(String[] args) {
        Board terix = new TetrixBoard(7, 6);
//        Shape shape1 = new Shape(2, 2);
//        shape1.grid = new int[][]{
//                {1, 1},
//                {1, 1}};
//        Coordinate co1 = Coordinate.builder().x(0).y(1).build();
//        terix.move(co1, shape1);
//        System.out.println("*****************************************");
//        terix.print();
//        Shape shape2 = new Shape(4, 1);
//        shape2.grid = new int[][]{
//                {1}, {1}, {1}, {1}};
//
//        Coordinate co2 = Coordinate.builder().x(0).y(3).build();
//        terix.move(co2, shape2);
//        System.out.println("*****************************************");
//        terix.print();
//        Shape shape3 = new Shape(3, 2);
//        shape3.grid = new int[][]{
//                {1, 1}, {1, 0}, {1, 0}};
//
//        terix.print();
//        Coordinate co3 = Coordinate.builder().x(0).y(0).build();
//        terix.move(co3, shape3);
//        System.out.println("*****************************************");
//        terix.print();
//        System.out.println("*****************************************");
//        terix.clear();
//        terix.clear();
//        terix.print();
//
//        Shape shape4 = new Shape(3, 2);
//        shape4.grid = new int[][]{
//                {1, 1}, {0, 1},{0,1}};
//
//        terix.print();
//        Coordinate co4 = Coordinate.builder().x(0).y(1).build();
//        terix.move(co4, shape4);
//        System.out.println("*****************************************");
//        terix.print();

        terix.print();
        IShape jShape1 = new JShape(3, 2, JShape.JShapeType.TYPE_1);
        Coordinate co = Coordinate.builder().x(0).y(0).build();
        terix.move(co, jShape1);
        terix.print();
        IShape jShape2 = new JShape(3, 2, JShape.JShapeType.TYPE_1);
        Coordinate co2 = Coordinate.builder().x(0).y(0).build();
        terix.move(co2, jShape2);
        terix.print();
        IShape jShape3 = new JShape(3, 2, JShape.JShapeType.TYPE_1);
        Coordinate co3 = Coordinate.builder().x(0).y(0).build();
        terix.move(co3, jShape3);
        terix.print();
//        terix.clear();
//        terix.print();
    }
}
