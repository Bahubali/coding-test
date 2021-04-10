package com.flipfit;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Slot {

    private Timing timing;
    private Workout workout;
    private int totalBookings;
    private int availableBookings;

    public boolean confirmSlot() {
        if (this.availableBookings < this.totalBookings) {
            this.availableBookings -= 1;
        }
        return true;
    }
}
