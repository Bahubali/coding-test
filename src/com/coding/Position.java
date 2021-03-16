package com.coding;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Position {
    private int row;
    private int column;
}
