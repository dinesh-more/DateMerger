package com.maxxton;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DateMarger {

	private Date startDate;
	private Date endDate;
	private long diff;
	private List<DateRange> dateRanges1=new ArrayList<DateRange>();
	
	public List<DateRange>  mergeDates(List<DateRange> dateRanges){
		for(int i1=0;i1<dateRanges.size();i1=i1+2) {
			DateRange dateRange = new DateRange();
			for(int j1=i1;j1<=i1;) {
				// calculating difference between dates;
				long diffInMillies = Math.abs(dateRanges.get(j1+1).getStartDate().getTime() - dateRanges.get(i1).getStartDate().getTime());
				diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
				
				// for getting start date
				if(diff==1) {
					break;
				}else if(dateRanges.get(i1).getStartDate().equals(dateRanges.get(j1+1).getStartDate())) {
					startDate=dateRanges.get(i1).getStartDate();
				}else if(dateRanges.get(i1).getStartDate().before(dateRanges.get(j1+1).getStartDate())) {
					startDate=dateRanges.get(i1).getStartDate();
				}else {
					startDate=dateRanges.get(j1+1).getStartDate();
				}
				
				// for getting end date
				if(diff==1) {
					break;
				}else if(dateRanges.get(i1).getEndDate().equals(dateRanges.get(j1+1).getStartDate())) {
					endDate=dateRanges.get(j1+1).getEndDate();
				}
				if(dateRanges.get(i1).getEndDate().equals(dateRanges.get(j1+1).getEndDate())) {
					endDate=dateRanges.get(i1).getStartDate();
				}else if(dateRanges.get(i1).getEndDate().after(dateRanges.get(j1+1).getEndDate())) {
					endDate=dateRanges.get(i1).getEndDate();
				}else {
					endDate=dateRanges.get(j1+1).getEndDate();
				}
				break;
			}
			if(diff==1) {
				dateRange.setStartDate(dateRanges.get(i1).getStartDate());
				dateRange.setEndDate(dateRanges.get(i1).getEndDate());
				dateRanges1.add(dateRange);
				
				DateRange dateRange2=new DateRange();
				dateRange2.setStartDate(dateRanges.get(i1+1).getStartDate());
				dateRange2.setEndDate(dateRanges.get(i1+1).getEndDate());
				dateRanges1.add(dateRange2);
			}else {
				dateRange.setEndDate(endDate);
				dateRange.setStartDate(startDate);
				dateRanges1.add(dateRange);
			}
		}
		return dateRanges1;
	}
}
