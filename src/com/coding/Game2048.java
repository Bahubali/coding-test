package com.coding;

import com.datastructure.DoublyLinkedList;
import com.datastructure.Node;
import com.games.chess.Queen;
import com.games.game2048.Panel;
import sun.misc.Queue;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.*;
import java.util.Stack;
import java.util.concurrent.DelayQueue;

public class Game2048 extends Board {

    private Map<Integer, DoublyLinkedList<Tile>> rowsMap;
    private Map<Integer, DoublyLinkedList<Tile>> columnsMap;

    public Game2048(int rows, int columns) {
        super(rows, columns);
        this.rowsMap = new HashMap<>();
        this.columnsMap = new HashMap<>();
        initializeBoard();
    }

    @Override
    protected void initializeBoard() {
        for (int i = 0; i < this.getRows(); i++) {
            DoublyLinkedList<Tile> rowMap = new DoublyLinkedList<>();
            for (int j = 0; j < this.getColumns(); j++) {
                Position position = Position.builder().row(i).column(j).build();
                Tile tile = Tile.builder()
                        .position(position)
                        .value(0).build();
                this.tiles[position.getRow()][position.getColumn()] = tile;
                DoublyLinkedList<Tile> columnMap = this.columnsMap.get(j);
                if (columnMap == null) {
                    columnMap = new DoublyLinkedList<>();
                    columnMap.add(tile);
                    this.columnsMap.put(j, columnMap);
                } else {
                    columnMap.add(tile);
                }
                rowMap.add(tile);
            }
            rowsMap.put(i, rowMap);
        }
    }

    public void addEntry(int num, Position position) throws Exception {
        Tile panel = this.tiles[position.getRow()][position.getColumn()];
        if (panel != null && panel.getValue() == 0) {
            panel.setValue(num);
//            System.out.println("Entry Added:");
//            print();
        } else {
            throw new Exception("Invalid entry");
        }
    }
    
    public void makeMove(Direction direction) throws InterruptedException {
        switch (direction) {
            case LEFT: swipeAndMerge(true, false);
                break;
            case RIGHT: swipeAndMergeReverse(true, false);
                break;
            case UP: swipeAndMerge(false, true);
                break;
            case DOWN: swipeAndMergeReverse(false, true);;
                break;
        }
        print();
    }

    private void swipeAndMerge(boolean isRow, boolean isColumn) {
        for (int i = 0; i < this.getRows(); i++) {
            
            Node<Tile> tiles = (isRow)? this.rowsMap.get(i).getHead(): this.columnsMap.get(i).getHead();
            Deque<Integer> tileQueue = new LinkedList<>();
            Node<Tile> current = tiles;
            int score = 0, zerosCount = 0;
            while (current != null) {
                if (current.getKey().getValue() > 0) {
                    tileQueue.add(current.getKey().getValue());
                    score += current.getKey().getValue();
                } else {
                    zerosCount++;
                }
                current = current.getNext();
            }
            if (score > 0) {
                while (zerosCount > 0) {
                    tileQueue.add(0);
                    zerosCount--;
                }
                tileQueue = addMerge(tileQueue);
                current = tiles;
                while (!tileQueue.isEmpty()) {
                    current.getKey().setValue(tileQueue.poll());
                    current = current.getNext();
                }
            }
        }
    }

    private void swipeAndMergeReverse(boolean isRow, boolean isColumn) {
        for (int i = 0; i < this.getRows(); i++) {
            Deque<Integer> tileQueue = new LinkedList<>();
            Node<Tile> current = (isRow)? this.rowsMap.get(i).getTail(): this.columnsMap.get(i).getTail();
            int score = 0, zerosCount = 0;
            while (current != null) {
                if (current.getKey().getValue() > 0) {
                    tileQueue.add(current.getKey().getValue());
                    score += current.getKey().getValue();
                } else {
                    zerosCount++;
                }
                current = current.getPrev();
            }
            if (score > 0) {
                while (zerosCount > 0) {
                    tileQueue.add(0);
                    zerosCount--;
                }
                tileQueue = addMerge(tileQueue);
                current = (isRow) ? this.rowsMap.get(i).getTail() : this.columnsMap.get(i).getTail();
                while (!tileQueue.isEmpty()) {
                    current.getKey().setValue(tileQueue.poll());
                    current = current.getPrev();
                }
            }
        }
    }

    private Deque<Integer> addMerge(Deque<Integer> tileDeque) {

        Deque<Integer> result = new LinkedList<>();
        int i = 0, size = 4;
        while (i < this.getSize()) {
            Integer first = tileDeque.poll();
            if (first == 0) {
                tileDeque.add(first);
            } else {
                if (first > 0 && first == tileDeque.peek()) {
                    Integer second = tileDeque.poll();
                    int newVal = first + second;
                    second = 0;
                    result.add(newVal);
                    tileDeque.add(second);
                } else {
                    result.add(first);
                }
            }
            i++;
        }
        while (!tileDeque.isEmpty()) {
            result.add(tileDeque.poll());
        }
        return result;
    }

    public void print() {
        for (int row = 0; row < this.tiles[0].length; row++) {
            for (int column = 0; column < this.tiles.length; column++) {
                System.out.print(this.tiles[row][column].getValue()+"  ");
            }
            System.out.println();
        }
        System.out.println("**** X ****");
        System.out.println();
    }
}
