package com.flipkart.scheduler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Job {

    enum Priority {
        PO(0), P1(1), P2(2);
        private int val;
        Priority(int val) {
            this.val = val;
        }
        public int getVal() {
            return this.val;
        }
    }
    enum UserType {
        ADMIN,ROOT,USER;
    }
    private String name;
    private int duration;
    private Priority priority;
    private int deadline;
    private UserType userType;

}
