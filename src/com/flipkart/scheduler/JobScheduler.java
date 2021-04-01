package com.flipkart.scheduler;


import java.util.*;
import java.util.stream.Collectors;

public class JobScheduler implements Scheduler {

    private List<Job> jobList;
    private Queue<String> threads;
    private Map<String, List<Job>> assignedJobs;

    JobScheduler(int thread) {
        this.jobList = new ArrayList<>();
        this.threads = new LinkedList<>();
        this.assignedJobs = new HashMap<>();
        int i = 1;
        while (thread-- > 0) {
            this.threads.add("Thread"+i++);
        }
    }
    public void addJob(Job job) {
        if (this.jobList != null) {
            this.jobList.add(job);
        }
    }

    @Override
    public void execute(Command command) {
        switch (command.getScheduleType()) {
            case SJF:

                Collections.sort(this.jobList, new SJFComparator());
                for (Job job: this.jobList) {
                    String thread = this.threads.poll();
                    if (this.assignedJobs.get(thread) == null) {
                        List<Job> jobs = new ArrayList<>();
                        jobs.add(job);
                        this.assignedJobs.put(thread, jobs);
                    } else {
                        this.assignedJobs.get(thread).add(job);
                    }
                    this.threads.add(thread);
                }
                break;
            default:
        }
    }

    public Map<String, List<Job>> getAssignedJobs() {
        return this.assignedJobs;
    }

    public static void main(String[] args) {
        JobScheduler scheduler = new JobScheduler(2);
        scheduler.addJob(Job.builder()
                .name("J1").duration(10).priority(Job.Priority.P2).deadline(10).build());
        scheduler.addJob(Job.builder()
                .name("J2").duration(20).priority(Job.Priority.PO).deadline(40).build());
        scheduler.addJob(Job.builder()
                .name("J3").duration(15).priority(Job.Priority.P2).deadline(40).build());
        scheduler.addJob(Job.builder()
                .name("J4").duration(30).priority(Job.Priority.P1).deadline(40).build());
        scheduler.addJob(Job.builder()
                .name("J5").duration(10).priority(Job.Priority.PO).deadline(30).build());
        Command command = Command.builder().scheduleType(Command.ScheduleType.SJF).build();
        scheduler.execute(command);
        for (Map.Entry<String, List<Job>> jobEntry: scheduler.getAssignedJobs().entrySet()) {
            String jobNames = jobEntry.getValue().stream().map(Job::getName).collect(Collectors.joining(","));
            System.out.println(jobEntry.getKey() + " : "+jobNames);
        }
    }
}
