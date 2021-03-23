package com.flipkart.scheduler;

import java.util.Comparator;

public class SJFComparator implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        if (o1.getDuration() > o2.getDuration()) {
            return 1;
        } else if (o1.getDuration() == o2.getDuration()) {
            return (o1.getPriority().getVal() > o2.getPriority().getVal())? 1 : -1;
        } else {
            return -1;
        }
    }
}
