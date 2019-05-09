package com.stack.queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bahubali.n on 26/03/19.
 */
public class BuildingSunsetView {

    public static void main(String[] args) {
        Deque<Building> buildings = new LinkedList<>();
        buildings.addFirst(new Building(1, 1));
        buildings.addFirst(new Building(2, Math.max(buildings.peekFirst().maxHeightOfAdjacentBuilding, 2)));
        buildings.addFirst(new Building(3, Math.max(buildings.peekFirst().maxHeightOfAdjacentBuilding, 3)));
        buildings.addFirst(new Building(5, Math.max(buildings.peekFirst().maxHeightOfAdjacentBuilding, 5)));
        buildings.addFirst(new Building(4, Math.max(buildings.peekFirst().maxHeightOfAdjacentBuilding, 4)));
        buildingWithSunsetView(buildings);
    }

    public static void buildingWithSunsetView(Deque<Building> buildings) {
        List<Building> sunsetView = new ArrayList();
        while (!buildings.isEmpty()) {
            if (buildings.peekFirst().buildingHeight >= buildings.peekFirst().maxHeightOfAdjacentBuilding) {
                sunsetView.add(buildings.peekFirst());
            }
            buildings.removeFirst();
        }
    }
}

class Building {

    int buildingHeight;
    int maxHeightOfAdjacentBuilding;


    public Building(int buildingHeight, int adjacentHeight) {
        this.buildingHeight = buildingHeight;
        this.maxHeightOfAdjacentBuilding = adjacentHeight;
    }

}
