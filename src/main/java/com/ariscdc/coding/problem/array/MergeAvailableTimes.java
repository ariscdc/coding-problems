package com.ariscdc.coding.problem.array;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparingLong;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Merge Available Times
 *
 * Write a function that merges the following sets of available times.
 * The result should include all time where any employee is available without overlapping availability.
 * {
 *   "employee_one": [
 *     {
 *       "begin_at":"2016-02-23T18:00:00Z",
 *       "end_at":"2016-02-23T21:20:00Z"
 *     },
 *     {
 *       "begin_at":"2016-02-23T22:00:00Z",
 *       "end_at":"2016-02-23T23:20:00Z"
 *     },
 *   ],
 *   "employee_two": [
 *     {
 *       "begin_at":"2016-02-23T17:00:00Z",
 *       "end_at":"2016-02-23T21:00:00Z"
 *     },
 *     {
 *       "begin_at":"2016-02-23T22:30:00Z",
 *       "end_at":"2016-02-23T23:50:00Z"
 *     }
 *   ]
 * }
 *
 * This solution works on top of the previous solution from 20180829 interview. It is based on previous suggestion
 * that what if we sort the input. Here we sort by beginAt and iterates the sorted employee times once and check
 * for overlap. While overlap is found, then we continuously merge, otherwise we add the last merged value to list.
 *
 * For simplicity, dates are represented as 24-hour format numbers, but this solution also works when Dates are
 * converted to its long value (unix timestamp).
 *
 * Without factoring the sort function, the merge algorithm would run in O(n) time, as each individual Employee's
 * available time is visited once.
 *
 * 20180829 1930-1940 (10)
 * 20180829 1956-2004 (08)
 * 20180829 2006-2010 (04)
 * 20180829 2130-2159 (29)
 * -----------------------------
 * Duration:          (51 mins.)
 */
public class MergeAvailableTimes {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(
                "Employee 1",
                asList(
                        new AvailableTime(1800, 2120),
                        new AvailableTime(2200, 2320),
                        new AvailableTime(100, 200),
                        new AvailableTime(230, 1700)
                )));
        employees.add(new Employee(
                "Employee 2",
                asList(
                        new AvailableTime(100, 200),
                        new AvailableTime(1700, 2100),
                        new AvailableTime(2230, 2350)
                )));

        MergeAvailableTimes merger = new MergeAvailableTimes();
        List<AvailableTime> employeeTimes = new ArrayList<>();
        employees.forEach(employee -> employeeTimes.addAll(employee.getAvailableTimes()));

        System.out.println(employeeTimes);
        List<AvailableTime> mergedAvailableTimes = merger.mergeAvailableTimes(employeeTimes);
        System.out.println(mergedAvailableTimes);
    }

    private List<AvailableTime> mergeAvailableTimes(List<AvailableTime> individualTimes) {

        if (individualTimes == null || individualTimes.isEmpty()) {
            return new ArrayList<>();
        }
        if (individualTimes.size() == 1) {
            return individualTimes;
        }
        List<AvailableTime> sortedTimes = new ArrayList<>(individualTimes);
        sortedTimes.sort(comparingLong(AvailableTime::getBeginAt));

        List<AvailableTime> mergedTimes = new ArrayList<>();
        AvailableTime lastAvailableTime = sortedTimes.get(0);
        for (int i = 1; i < sortedTimes.size(); i++) {
            if (doesIntersect(lastAvailableTime, sortedTimes.get(i))) {
                lastAvailableTime = new AvailableTime(
                        Math.min(lastAvailableTime.getBeginAt(), sortedTimes.get(i).getBeginAt()),
                        Math.max(lastAvailableTime.getEndAt(), sortedTimes.get(i).getEndAt()));
            } else {
                mergedTimes.add(lastAvailableTime);
                lastAvailableTime = sortedTimes.get(i);
            }
        }
        mergedTimes.add(lastAvailableTime);
        return mergedTimes;
    }

    private boolean doesIntersect(AvailableTime time1, AvailableTime time2) {
        return time1 != null && time2 != null &&
                time2.getBeginAt() <= time1.getEndAt() &&
                time2.getEndAt() >= time1.getBeginAt();
    }

    private static class AvailableTime {

        private long beginAt;
        private long endAt;

        AvailableTime(long beginAt, long endAt) {
            this.beginAt = beginAt;
            this.endAt = endAt;
        }

        long getBeginAt() {
            return beginAt;
        }

        long getEndAt() {
            return endAt;
        }

        @Override
        public String toString() {
            return "AvailableTime{" +
                    "beginAt=" + beginAt +
                    ", endAt=" + endAt +
                    '}';
        }
    }

    private static class Employee {

        private String name;
        private List<AvailableTime> availableTimes;

        Employee(String name, List<AvailableTime> availableTimes) {
            this.name = name;
            this.availableTimes = availableTimes;
        }

        String getName() {
            return name;
        }

        List<AvailableTime> getAvailableTimes() {
            return availableTimes;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", availableTimes=" + availableTimes +
                    '}';
        }
    }
}
