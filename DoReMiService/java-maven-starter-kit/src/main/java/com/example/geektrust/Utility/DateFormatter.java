package com.example.geektrust.Utility;

import com.example.geektrust.Service.SubscriptionService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatter {

    private static SimpleDateFormat formatter = new SimpleDateFormat(Constants.SIMPLE_DATE_FORMAT);
    private static  Calendar calendar = Calendar.getInstance();
    private static DateFormatter dateFormatter ;

    public static DateFormatter getInstance() {
        if(dateFormatter == null){
            dateFormatter =  new DateFormatter();
        }
        return dateFormatter;
    }

    public static Date getDateFromString(String dateString) throws ParseException {
        Date date = null;
        formatter.setLenient(false);
        date = formatter.parse(dateString);
        return date;
    }

    public static String getStringFromDate(Date date){
        String resultDate = formatter.format(date);
        return resultDate;
    }

    public static Date getRenewalReminderDate(Integer month){
        Date date = SubscriptionService.getSubscriptionStartDate();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        calendar.add(Calendar.DAY_OF_MONTH, Constants.REMINDER_DAYS_BEFORE_RENEWAL);
        Date finalDate = calendar.getTime();
        return finalDate;
    }
}
