package com.wei.example.common.util;

import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {

    /**
     * get the shift days Date from the given baseDate
     *
     * @param baseDate  the base date to shift
     * @param shiftDays the offset
     * @return shifted date
     */
    public static Date getShiftDate(Date baseDate, int shiftDays) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(baseDate);
        cal.add(Calendar.DATE, shiftDays); //minus number decrement the days
        return cal.getTime();
    }
}
