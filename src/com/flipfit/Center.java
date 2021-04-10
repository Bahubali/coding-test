package com.flipfit;

import java.util.List;

public interface Center {

    public String getAddress();

    public List<Slot> getAllSlots();

    public List<Slot> getSlotsByDay(Days day);

    public void addSlot(Slot slot, Days day);

    public Slot bookSlot(Days day, Timing timing);
}
