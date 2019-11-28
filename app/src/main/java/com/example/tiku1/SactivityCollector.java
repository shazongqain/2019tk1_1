package com.example.tiku1;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class SactivityCollector {
    private static List<Activity> activities  =new ArrayList<>();
    public static  void addActivity(Activity activity)
    {
        activities.add(activity);
    }
    public static  void finishAll()
    {
        for (Activity activity:activities)
        {
            if (!activity.isFinishing())
            {
                activity.finish();
            }
        }
    }
}