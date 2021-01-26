package com.maxxton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws ParseException {
		
		 List<DateRange> dateRanges=new ArrayList<DateRange>();
		 String startDate;
		 String endDate;
		 SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		 Scanner scanner=new Scanner(System.in);		 
		 for(int i=0;i<2;i++) {
			 System.out.println("Date Range"+(i+1));
			 System.out.println("Enter The Start Date(dd/MM/yyyy)=");
			 startDate=scanner.nextLine();
			 
			 System.out.println("Enter The End Date(dd/MM/yyyy)=");
			 endDate=scanner.nextLine();
			 
			 DateRange daterange1=new DateRange();
			 daterange1.setStartDate(dateFormat.parse(startDate));
			 daterange1.setEndDate(dateFormat.parse(endDate));
			 dateRanges.add(daterange1);
		 }		 
		 SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMM yyyy");  
		 DateMarger dateMarger=new DateMarger();
		 System.out.println("\n\tMarged Date");
		 for(DateRange range:dateMarger.mergeDates(dateRanges)){
			 System.out.println(dateFormatter.format(range.getStartDate())+" - "+dateFormatter.format(range.getEndDate()));
		 }
	}
}
