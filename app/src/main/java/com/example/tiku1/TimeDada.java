package com.example.tiku1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDada {
    public static String setTime(String type, Date data)
    {
        SimpleDateFormat format  =new SimpleDateFormat(type);
        return format.format(data);
    }
}
