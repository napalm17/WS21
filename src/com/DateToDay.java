package com;

public class DateToDay {

    int day;
    int month;
    int year;

    DateToDay(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    int beginDay = 1;
    int beginMonth = 3;
    int beginYear = 1900;

    String getDifference(){
        String[] daysWeek = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int dayDifference =  365 * (this.year - beginYear) +  Math.round(this.year - beginYear / 4) + 30 * (this.month - beginMonth) + (this.day - beginDay);
        return daysWeek[dayDifference % 7];
    }

}
