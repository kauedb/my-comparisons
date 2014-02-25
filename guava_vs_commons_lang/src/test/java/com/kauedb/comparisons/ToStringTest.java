package com.kauedb.comparisons;import com.google.common.base.Objects;
import com.google.common.base.Stopwatch;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.testng.annotations.Test;

import java.lang.InterruptedException;import java.lang.Object;import java.lang.Override;import java.lang.String;import java.lang.StringBuilder;import java.lang.System;import java.lang.Thread;import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * User: kauedb
 * Date: 2/20/14
 * Time: 9:42 PM
 */
public class ToStringTest {

    @Test(invocationCount = 10)
    public void test() throws InterruptedException {
        A a = new A();
        a.setB(new B());

        Stopwatch stopwatch = Stopwatch.createStarted();
        System.out.println(new F());
        stopwatch.stop();

        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
        System.out.println(stopwatch.elapsed(TimeUnit.NANOSECONDS));

        Thread.sleep(3000L);
    }

    @Test
    public void test1() {
    }

    static class C {

        private String s = "s";

        String getS() {
            return s;
        }

        void setS(String s) {
            this.s = s;
        }

        public Objects.ToStringHelper toStringHelper() {
            return Objects.toStringHelper(this)
                    .add("s", s);
        }

        @java.lang.Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("s", s)
                    .toString();
        }
    }

    static class A extends C {
        private B b;
        private int i;
        private String s;

        B getB() {
            return b;
        }

        void setB(B b) {
            this.b = b;
        }

        int getI() {
            return i;
        }

        void setI(int i) {
            this.i = i;
        }

        String getS() {
            return s;
        }

        void setS(String s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return super.toStringHelper().omitNullValues()
                    .add("b", b)
                    .add("i", i)
                    .add("s", s)
                    .toString();
        }
    }

    static class B {

        private Date date = new Date();

        Date getDate() {
            return date;
        }

        void setDate(Date date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this).omitNullValues()
                    .add("date", ToStringUtil.withQuotationMarks(date))
                    .toString();
        }
    }

    static class ToStringUtil {

        public static String withQuotationMarks(Object o) {
            return new StringBuilder().append("\"").append(o).append("\"").toString();
        }

    }

    static class E {

        private int i;

        int getI() {
            return i;
        }

        void setI(int i) {
            this.i = i;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("i", i)
                    .toString();
        }
    }

    static class D extends E {
        private String s;

        String getS() {
            return s;
        }

        void setS(String s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    //.appendSuper(super.toString())
                    .append("s", s)
                    .append(new A())
                    .appendAsObjectToString(new A())
                    .toString();
        }
    }

    static class F {

        private int i;

        int getI() {
            return i;
        }

        void setI(int i) {
            this.i = i;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }

}
