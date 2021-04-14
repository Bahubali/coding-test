package com.flipkart.scheduler;

import java.util.Comparator;

public class FPSComparator implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        if (o1.getPriority().getVal() == o2.getPriority().getVal()) {
            //return o1.getPriority()
        }
        return 1;
    }
}
