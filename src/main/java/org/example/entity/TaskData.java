package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String employee) {
        switch (employee.toLowerCase()) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                Set<Task> allTasks = new HashSet<>();
                allTasks.addAll(annsTasks);
                allTasks.addAll(bobsTasks);
                allTasks.addAll(carolsTasks);
                return allTasks;
            default:
                throw new IllegalArgumentException("Invalid employee: " + employee);
        }
    }

    public Set<Task> getUnion(Set<Task> taskSet, Set<Task> taskSet2) {
        Set<Task> union = new HashSet<>(taskSet);
        union.addAll(taskSet2);
        return union;
    }

    public Set<Task> getIntersection(Set<Task> taskSet, Set<Task> taskSet2) {
        Set<Task> intersection = new HashSet<>(taskSet);
        intersection.retainAll(taskSet2);
        return intersection;
    }

    public Set<Task> getDifferences(Set<Task> taskSet, Set<Task> taskSet2) {
        Set<Task> difference = new HashSet<>(taskSet);
        difference.removeAll(taskSet2);
        return difference;
    }
}
