package com.ariscdc.coding.problem.recursion;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Given a list of Tasks, execute all on the right order.
 * A Task can have dependency Tasks that must be executed first.
 *
 * Every Task is a Node in a Graph.
 * The Tasks and its dependencies form a Directed Acyclic Graph (DAG).
 * The Graph may not be fully connected (certain Tasks stand completely alone).
 *
 * This problem is an example of Topological Sort Algorithm.
 * It works on DAG and puts some order to which the nodes can be traversed.
 * Standard Data Structures which work with Topological Sort are Adjacency Matrix, Adjacency List.
 *
 * Time/Space Complexity: O(n), where n is the number of Tasks
 *
 * 20160220 1410-1440 (30 mins.)
 */
public class TasksWithDependencies {

    public static void execute(List<Task> tasks) {

        if (tasks == null) return;
        for (Task task: tasks) {
            task.execute();
        }
        System.out.println();
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {

        Task taskA = new Task("A");
        Task taskE = new Task("E");
        Task taskD = new Task("D", asList(taskE));

        Task taskB = new Task("B", asList(taskA));
        Task taskC = new Task("C", asList(taskA, taskB, taskD));
        Task taskF = new Task("F", asList(taskC));

        execute(asList(taskA, taskB, taskC, taskD, taskE, taskF));
    }

    private static class Task {

        private String id;
        private boolean executed;
        private List<Task> dependencies = new LinkedList<>();

        Task(String id) {
            this.id = id;
        }

        Task(String id, List<Task> dependencies) {
            this.id = id;
            this.dependencies = dependencies;
        }

        public boolean isExecuted() {
            return executed;
        }

        public List<Task> getDependencies() {
            return dependencies;
        }

        public void execute() {
            if (!executed) {
                for (Task dependency: dependencies) {
                    dependency.execute();
                }
                System.out.print(" -> " + id);
                executed = true;
            }
        }

        @Override
        public String toString() {
            return String.format("Task{id=%s, executed=%s}", id, executed);
        }
    }
}
