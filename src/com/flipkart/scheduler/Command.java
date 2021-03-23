package com.flipkart.scheduler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Command {

    enum ScheduleType {
        SJF,FCFS,FPS,EDF;
    }
    private int threadCount;
    private ScheduleType scheduleType;
}
