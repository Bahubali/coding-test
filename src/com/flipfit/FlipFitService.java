package com.flipfit;

import lombok.Getter;
import lombok.Setter;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Singleton
public class FlipFitService {

    private Map<String, User> userRegistry;
    private Map<String, List<Center>> areaWiseCenters;

    FlipFitService() {
        this.userRegistry = new HashMap<>();
        this.areaWiseCenters = new HashMap<>();
    }
    public void registerUser(User user) {
        if (this.userRegistry.containsKey(user.getEmail())) {
            throw new RuntimeException("User already exists");
        }
        this.userRegistry.put(user.getEmail(), user);
    }

    public void addGymCenter(Center center, String area) {
        if (this.areaWiseCenters.containsKey(area)) {
            if (this.areaWiseCenters.get(area) == null) {
                List<Center> centers = new ArrayList<>();
                centers.add(center);
                this.areaWiseCenters.put(area, centers);
            }
        } else {
            List<Center> centers = new ArrayList<>();
            centers.add(center);
            this.areaWiseCenters.put(area, centers);
        }
    }

    public Slot buildSlot(WorkoutType type, String timing, int maxUsers) {
        String[] timings = timing.split("-");
        Timing time = Timing.builder().from(timings[0]).to(timings[1]).build();
        switch (type) {
            case CARDIO:
                Workout cardio = new Cardio();
                Slot slot = Slot.builder().timing(time)
                        .workout(cardio).availableBookings(maxUsers).build();
                return slot;
            case WEIGHTS:
                Workout weights = new Weights();
                Slot weight = Slot.builder().timing(time)
                        .workout(weights).availableBookings(maxUsers).build();
                return weight;
            default:
                return null;
        }
    }

    public void bookSlot(User user, String area, Days day, String timing) {
        List<Center> centers = this.areaWiseCenters.get(area);
        for (Center center: centers) {
            String[] timings = timing.split("-");
            Slot slot = center.bookSlot(day, Timing.builder().from(timings[0]).to(timings[1]).build());
            if (slot == null) {
                throw new RuntimeException("Unable to book slot");
            }
            if (user.getBookedSlots() == null) {
                List<Slot> slots = new ArrayList<>();
                slots.add(slot);
                user.setBookedSlots(slots);
            } else {
                user.getBookedSlots().add(slot);
            }
        }
    }

    public User getUser(String mail){
        return this.userRegistry.get(mail);
    }

    public static void main(String[] args) {
        FlipFitService fitService = new FlipFitService();
        fitService.registerUser(User.builder().email("bahubali@gmail.com").name("Bahu").build());
        fitService.registerUser(User.builder().email("smita@gmail.com").name("Smita").build());
        Center center = new GymCenter("16th Cross - 560102");
        Slot slot1 = fitService.buildSlot(WorkoutType.CARDIO, "7AM-8AM", 10);
        Slot slot2 = fitService.buildSlot(WorkoutType.WEIGHTS, "8AM-9AM", 10);
        center.addSlot(slot1, Days.MONDAY);
        center.addSlot(slot2, Days.MONDAY);
        fitService.addGymCenter(center, "KORAMANGALA");
        fitService.bookSlot(fitService.getUser("bahubali@gmail.com"),
                "KORAMANGALA", Days.MONDAY, "7AM-8AM");

    }
}
