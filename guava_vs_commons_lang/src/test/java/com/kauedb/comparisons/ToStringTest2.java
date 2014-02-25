package com.kauedb.comparisons;import com.google.common.base.Stopwatch;
import com.kauedb.comparisons.SimpleObject;
import org.testng.annotations.Test;
import org.testng.collections.Objects;

import java.lang.Double;import java.lang.InterruptedException;import java.lang.Math;import java.lang.Override;import java.lang.String;import java.lang.System;import java.lang.Thread;import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * User: kauedb
 * Date: 2/22/14
 * Time: 11:33 AM
 */
public class ToStringTest2 {

    @Test(invocationCount = 10)
    public void testToString(){
        final SimpleObject simpleObject = new SimpleObject(){
            @Override
            public String toString() {
                return super.toString();
            }
        };

        simpleObject.setI(Double.valueOf(Math.random()).intValue());
        simpleObject.setString(String.valueOf(Math.random()));

        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, Double.valueOf(Math.random()).intValue());

        simpleObject.setDate(calendar.getTime());

        final Stopwatch stopwatch = Stopwatch.createStarted();
        simpleObject.toString();
        stopwatch.stop();

        java.lang.System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
        System.out.println(stopwatch.elapsed(TimeUnit.NANOSECONDS));

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test(invocationCount = 10)
    public void testToStringGuava(){
        final SimpleObject simpleObject = new SimpleObject(){
            @Override
            public String toString() {
                return Objects.toStringHelper(getClass())
                        .omitNulls()
                        .add("i", this.getI())
                        .add("integer", this.getInteger())
                        .add("string", this.getString())
                        .add("date", this.getDate())
                        .toString();
            }
        };

        simpleObject.setI(Double.valueOf(Math.random()).intValue());
        simpleObject.setString(String.valueOf(Math.random()));

        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, Double.valueOf(Math.random()).intValue());

        simpleObject.setDate(calendar.getTime());

        final Stopwatch stopwatch = Stopwatch.createStarted();
        simpleObject.toString();
        stopwatch.stop();

        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
        System.out.println(stopwatch.elapsed(TimeUnit.NANOSECONDS));

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test(invocationCount = 10)
    public void testToStringApacheCommonsLang(){


        final SimpleObject simpleObject = new SimpleObject(){
            @Override
            public String toString() {
                return Objects.toStringHelper(getClass())
                        .add("i", this.getI())
                        .add("integer", this.getInteger())
                        .add("string", this.getString())
                        .add("date", this.getDate())
                        .toString();
            }
        };

        simpleObject.setI(Double.valueOf(Math.random()).intValue());
        simpleObject.setString(String.valueOf(Math.random()));

        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, Double.valueOf(Math.random()).intValue());

        simpleObject.setDate(calendar.getTime());

        final Stopwatch stopwatch = Stopwatch.createStarted();
        simpleObject.toString();
        stopwatch.stop();

        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
        System.out.println(stopwatch.elapsed(TimeUnit.NANOSECONDS));

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
