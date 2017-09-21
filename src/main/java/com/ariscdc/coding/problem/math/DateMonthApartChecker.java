package com.ariscdc.coding.problem.math;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Given two dates, determine if the two is less than, more than, or exactly a month apart.
 *     1. 2017-09-21, 2017-10-21 = Exactly
 *     2. 2017-10-01, 2017-10-05 = Less than
 *     3. 2017-01-20, 2017-05-02 = More than
 *
 * 20170921 1930-2028 (58 mins.) (Algorithm, Test Cases)
 * 20170921 2032-2053 (21 mins.) (Implementation)
 * 20170921 2055-2059 (4 mins.) (Test)
 * 20170921 2100-2113 (13 mins.) (Error handling)
 *                    (96 mins.)
 */
public class DateMonthApartChecker {

    private static final int LESS_THAN_A_MONTH = -1;
    private static final int EXACTLY_A_MONTH = 0;
    private static final int MORE_THAN_A_MONTH = 1;

    private static final int JANUARY = 1;
    private static final int DECEMBER = 12;

    private static int compareDay(int fromDay, int toDay) {

        if (toDay == fromDay) {
            return EXACTLY_A_MONTH;
        } else if (toDay > fromDay) {
            return MORE_THAN_A_MONTH;
        } else {
            return LESS_THAN_A_MONTH;
        }
    }

    private static int extractDay(String date, String paramName) {

        int day = Integer.parseInt(date.substring(6));
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException(paramName + " Day is invalid.");
        }
        // TODO Validate Days of Month
        return day;
    }

    private static int extractMonth(String date, String paramName) {

        int month = Integer.parseInt(date.substring(4, 6));
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException(paramName + " Month is invalid.");
        }
        return month;
    }

    private static int extractYear(String date) {
        return Integer.parseInt(date.substring(0, 4));
    }

    private static int getMonthApart(String fromDate, String toDate) {

        validateDate(fromDate, "Start Date");
        validateDate(toDate, "End Date");

        return getMonthApart(
                extractYear(fromDate), extractMonth(fromDate, "Start"), extractDay(fromDate, "Start"),
                extractYear(toDate), extractMonth(toDate, "End"), extractDay(toDate, "End"));
    }

    /**
     * ==================================================
     *  Algorithm:
     * ==================================================
     *   toYear == fromYear
     *     toMonth == fromMonth
     *       toDay >= fromDay -- less A
     *       else -- invalid A
     *     toMonth > fromMonth + 1  -- more A
     *     toMonth < fromMonth + 1  -- invalid B
     *     toMonth == fromMonth + 1
     *       toDay == fromDay  -- exact A
     *       toDay > fromDay -- more B
     *       else -- less B
     *
     *   toYear > fromYear
     *     fromMonth != 12 -- more C
     *     else
     *       toMonth == 01
     *         toDay == fromDay -- exact B
     *         toDay > fromDay -- more D
     *         else -- less C
     *       else -- more E
     *
     *   toYear < fromYear -- invalid C
     *
     * ==================================================
     *  Test Cases:
     * ==================================================
     *  1. 20180101 20170101 -- invalid C -- 2017 < 2018
     *  2. 20170201 20170101 -- invalid B -- 2017 == 2017, 01 < 03
     *  3. 20170130 20170120 -- invalid A -- 2017 == 2017, 01 == 01, 20 < 30
     *  4. 20170101 20170101 -- less A -- 2017 == 2017, 01 == 01, 01 >= 01
     *  5. 20170101 20180101 -- more C -- 2018 > 2017, 01 != 12
     *  6. 20170201 20170301 -- exact A -- 2017 == 2017, 03 == 02 + 1, 01 == 01
     *  7. 20170201 20170215 -- less A -- 2017 == 2017, 02 == 02, 15 > 01
     *  8. 20170512 20171012 -- more A -- 2017 == 2017, 10 > 05 + 1
     *  9. 20170512 20170615 -- more B -- 2017 == 2017, 06 == 05 + 1, 15 > 12
     *  10. 20170512 20170611 -- less B -- 2017 == 2017, 06 == 05 + 1, 11 < 12
     *  11. 20171203 20180103 -- exact B -- 2018 > 2017, 12 == 12, 01 == 01, 03 == 03
     *  12. 20171203 20180106 -- more D -- 2018 > 2017, 12 == 12, 01 == 01, 06 > 03
     *  13. 20171203 20180102 -- less C -- 2018 > 2017, 12 == 12, 01 == 01, 02 < 03
     *  14. 20171203 20180202 -- more E -- 2018 > 2017, 12 == 12, 01 != 01
     */
    private static int getMonthApart(int fromYear, int fromMonth, int fromDay,
                                     int toYear, int toMonth, int toDay) {
        if (toYear == fromYear) {
            if (toMonth == fromMonth) {
                if (toDay >= fromDay) {
                    return LESS_THAN_A_MONTH;
                } else {
                    throw new IllegalArgumentException("End Day is less than Start Day.");
                }
            } else if (toMonth > fromMonth + 1) {
                return MORE_THAN_A_MONTH;
            } else if (toMonth == fromMonth + 1) {
                return compareDay(fromDay, toDay);
            } else {
                throw new IllegalArgumentException("End Month is less than Start Month.");
            }
        } else if (toYear > fromYear) {
            if (fromMonth != DECEMBER) {
                return MORE_THAN_A_MONTH;
            } else {
                if (toMonth == JANUARY) {
                    return compareDay(fromDay, toDay);
                } else {
                    return MORE_THAN_A_MONTH;
                }
            }
        }
        throw new IllegalArgumentException("End Year is less than Start Year.");
    }

    private static void validateDate(String date, String paramName) {
        if (date == null || date.length() != 8) {
            throw new IllegalArgumentException(paramName + " is invalid.");
        }
    }

    public static void main(String[] args) {

        String[] testCases = {
                "20180101-20170101",
                "20170201-20170101",
                "20170130-20170120",
                "20170101-20170101",
                "20170101-20180101",
                "20170201-20170301",
                "20170201-20170215",
                "20170512-20171012",
                "20170512-20170615",
                "20170512-20170611",
                "20171203-20180103",
                "20171203-20180106",
                "20171203-20180102",
                "20171203-20180202"
        };
        int i = 0;
        for (String testCase : testCases) {
            String[] fromToDates = testCase.split("-");
            try {
                System.out.print(++i + ". " + fromToDates[0] + "-" + fromToDates[1] + ": ");
                System.out.print(getMonthApart(fromToDates[0], fromToDates[1]));
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
