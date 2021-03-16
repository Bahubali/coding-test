package com.coding;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tile {

    private int value;
    private Position position;
}
