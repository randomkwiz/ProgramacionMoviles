package es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel;

import androidx.room.TypeConverter;


import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Converters {
    @TypeConverter
    public static GregorianCalendar fromLong(Long value){
        if(value == null){
            throw new NullPointerException("must not be null 1");
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(value);
        return cal;
    }

    @TypeConverter
    public static Long toLong(GregorianCalendar calendar){
        if(calendar == null){
            throw new NullPointerException("must not be null 2");
        }

        return calendar.getTimeInMillis();
    }
}
