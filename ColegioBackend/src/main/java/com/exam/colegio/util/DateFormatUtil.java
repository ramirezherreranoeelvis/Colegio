package com.exam.colegio.util;

import java.text.SimpleDateFormat;
import java.util.Date;
public class DateFormat {

        static String ymd(Date date) {
                var formatter = new SimpleDateFormat("yyyy-MM-dd");
                return formatter.format(date);
        }

}
