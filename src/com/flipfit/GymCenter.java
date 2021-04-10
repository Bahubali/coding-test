package com.flipfit;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class GymCenter implements Center {

    private String address;
    private Map<Days, List<Slot>> dayWiseSlots;

    public GymCenter(String address) {
        this.address = address;
        this.dayWiseSlots = new HashMap<>();
    }
    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public List<Slot> getAllSlots() {
        return null;
    }

    @Override
    public List<Slot> getSlotsByDay(Days day) {
        if (!this.dayWiseSlots.containsKey(day)) {
            throw new RuntimeException("No slots present for "+day);
        }
        return this.dayWiseSlots.get(day);
    }

    @Override
    public void addSlot(Slot slot, Days day) {
        if (!dayWiseSlots.containsKey(day)) {
            List<Slot> slots = new ArrayList<>();
            slots.add(slot);
            dayWiseSlots.put(day, slots);
        } else {
            dayWiseSlots.get(day).add(slot);
        }
    }

    @Override
    public Slot bookSlot(Days day, Timing timing) {
        List<Slot> availableSlots = this.dayWiseSlots.get(day);
        Slot bookedSlot = null;
        if (!availableSlots.isEmpty()) {
            for (Slot slot: availableSlots) {
                if (slot.getTiming().compareTo(timing) && slot.getAvailableBookings() > 0){
                    bookedSlot = (slot.confirmSlot())? slot : null;
                }
            }
        }
        return bookedSlot;
    }
}
