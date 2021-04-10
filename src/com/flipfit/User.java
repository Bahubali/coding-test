package com.flipfit;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class User {
    private int id;
    private String email;
    private String name;
    List<Slot> bookedSlots;
}
