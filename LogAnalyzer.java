//Juan Jimenez
//jj
/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly, daily and monthly access counts.
    private int[] hourCounts;
    private int[] dayCounts;
    private int[] monthCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;
    

    //7.12 Modified LogAnalzer so it can takes strings name of the log. public 
    // LogAnalyzer(String LogName), reader = new LogfileReader(LogName)
    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String LogName)
    { 
        // Create the array object to hold the hourly. daily and monthly
        // access counts.
        hourCounts = new int[24];
        dayCounts = new int[28];
        monthCounts = new int[12];
        // Create the reader to obtain the data.
        reader = new LogfileReader(LogName);
    }
    
    //7.14 add method numberOfAccesses 
    //Method public int numberOfAccesses()
    //int total = 0 to intialize total of type int as zero for ForEach loop
    //ForEach adds the value of hourcounts to total in total = total+hourCount
    //after returns the new value of total. 
    public int numberOfAccesses()
    {
        int total = 0;
        
        for(int hourCount : hourCounts) 
        {
            total = total + hourCount;    

        }
        
        return total;
    }

    //7.15 Method public int busiestHour() for the busiest hour of the day
    //int busiestHour = 0 to intialize it as zero
    //for loop that intiallizes hour as 1 with a type int, hour < hourCounts.
    //length for when hour is less it will loop until it is the same value of
    //hourCounts.length and has an increment of the value of hour with ++
    //if statement that changes buisestHour into hour when HourCount[hour] is
    //greater that [busiestHour] and then returns the new value of busiestHour
    //method shows that hour 22 is the busiest
        public int busiestHour()
    {
        int busiestHour = 0;
        
        for(int hour = 1; hour < hourCounts.length; hour++) 
        {
            if(hourCounts[hour] > hourCounts[busiestHour]) 
            {
                busiestHour = hour;
            }
        }
        
        return busiestHour;
    }
    
    //revisted quietestHour, before did not display the quietest hour becuase I had the less-than in the if 
    //statement in the wrong way but it now displays quietestHour correctly.
    //7.16 add public int quietestHour() method
    //intitalize quietestHour as zero
    //forloop that intitalizes hour as 1 and will loop until hour is greater 
    //then hourCounts length and has a increment of hour
    //if statement that when hour is less than quietesthour then it becomes
    // the new value of hour and then returns quietestHour with the new value
    //log 1 said 2 is the quietest and log 2 said 9
    public int quietestHour()
    {
        int quietestHour = 0;
        
        for(int hour = 1; hour < hourCounts.length; hour++) 
        {
            if(hourCounts[hour] < hourCounts[quietestHour]) 
            {
                quietestHour = hour;
            }
        }
        
        return quietestHour;
    }
    
    //7.18 add public int busiestTwoHourPeriod() method
    //intialize busiestPeriod and busiestPeriodCount as zero
    //for loop that intialize hour as zero and will loop until hour is greater
    //than hourCounts.length-1 with an increment of hour
    //intialize periodCount as type int of hourCounts [hour] and adds [hour+1]
    //if statement of if periodCount is greater thab busiestPeriodCount then
    //busiestPeriod is the current hour and BusiestPeriodCount is now period
    //count and returns busiestPeriod with the new value
    //log 1 said hour zero was busiesttwoHour and log 2 said 7
    public int busiestTwoHourPeriod()
    {
        int busiestPeriod = 0;
        int busiestPeriodCount = 0;
        
        for(int hour = 0; hour < hourCounts.length - 1; hour++) 
        {
            int periodCount = hourCounts[hour] + hourCounts[hour+1];
            if(periodCount > busiestPeriodCount) 
            {
                busiestPeriod = hour;
                busiestPeriodCount = periodCount;
            }
        }
        
        return busiestPeriod;
    }
    
    //7.19 quietestDay, busiestDay, TotalAccessesPerMonth, QuietestMonth,
    //busiestMonth, averageAccessesPerMonth
    
    //revisted 
    //intitalize quietestDay as zero
    //forloop that intitalizes day as 1 and will loop until day is greater 
    //then dayCounts length and has a increment of day
    //if statement that when day is less than quietestDay then it becomes
    // the new value of day and then returns quietestDay with the new value
    public int quietestDay()
    {
        int quietestDay = 0;
        
        for(int day = 1; day < dayCounts.length; day++) 
        {
            if(dayCounts[day] < dayCounts[quietestDay]) 
            {
                quietestDay = day;
            }
        }
        
        return quietestDay;
    }
    
    //int busiestDay = 0 to intialize it as zero
    //for loop that intiallizes day as 1 with a type int, day < dayCounts.
    //length for when day is less it will loop until it is the same value of
    //dayCounts.length and has an increment of the value of day with ++
    //if statement that changes buisestDay into Day when HourDay[Day] is
    //greater that [busiestDay] and then returns the new value of busiestDay
        public int busiestDay()
    {
        int busiestDay = 0;
        
        for(int day = 1; day < dayCounts.length; day++) 
        {
            if(dayCounts[day] > dayCounts[busiestDay]) 
            {
                busiestDay = day;
            }
        }
        
        return busiestDay;
    }
    
    //intitalize quietestMonth as zero
    //forloop that intitalizes Month as 1 and will loop until month is greater 
    //then monthCounts length and has a increment of month 
    //if statement that when month is less than quietestMonth then it becomes
    // the new value of month and then returns quietestMonth with the new value
    public int quietestMonth()
    {
        int quietestMonth = 0;
        
        for(int Month = 1; Month < monthCounts.length; Month++) 
        {
            if(monthCounts[Month] < monthCounts[quietestMonth]) 
            {
                quietestMonth = Month;
            }
        }
        
        return quietestMonth;
    }
    
    //int busiestMonth = 0 to intialize it as zero
    //for loop that intiallizes month as 1 with a type int, month < monthCounts.
    //length for when Month is less it will loop until it is the same value of
    //monthCounts.length and has an increment of the value of month with ++
    //if statement that changes buisestMonth into month when monthCount[Month] 
    //is greater that [busiestHour] and then returns the new value of busiestHour
        public int busiestMonth()
    {
        int busiestMonth = 0;
        
        for(int Month = 1; Month < monthCounts.length; Month++) 
        {
            if(monthCounts[Month] > monthCounts[busiestMonth]) 
            {
                busiestMonth = Month;
            }
        }
        
        return busiestMonth;
    }
    public int totalAccessesPerMonth()
    {
        int total = 0;
        
        for(int monthCount : monthCounts) 
        {
            total = total + monthCount;    
            
        }
        
        return total;
    }
    
    //for method that shows average acceses per month
    //intialized totalAPM and total to zero
    //gets the number of accesses with totalAPM and to get the average total
    //divides totalAPM by the length of all months which is 12 and then 
    //prints out the average which is held in total
    public int averageAccessesPerMonth()
    {
        int totalAPM = 0;
        int total = 0;
        
        for(int monthCount : monthCounts) 
        {
            totalAPM = totalAPM + monthCount;    
            
            total = totalAPM / monthCounts.length;
        }
        System.out.println("Average accesses per month: " + total );
        return total;
    }
    
    //revision of analyzeHourlyData()
    //for each Log entry returned by the reader the code is in a loop to continue as long as the log has more 
    //entries to process, it then checks if the entry is not null and then gets the hour entry from getHour method.
    //and then it increments the counter in the hourCounts array.
    //analyzes data for hourly
    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
    while (reader.hasNext()) 
    {
    LogEntry entry = reader.next();
    if (entry != null) 
    {
        int hour = entry.getHour();
        hourCounts[hour]++;
    }
    }}

    //revision of analyzeDailyData()
    //for each Log entry returned by the reader the code is in a loop to continue as long as the log has more 
    //entries to process, it then checks if the entry is not null and then gets the day entry form getDay method.
    //and it increments the counter for the dayCounts array.
    //for a data analyzer for daily data for busiest day and quietestday
    //analyzes data for daily 
    public void analyzeDailyData()
    {
        while (reader.hasNext()) 
        {
    LogEntry entry = reader.next();
    if (entry != null) 
    {
        int day = entry.getDay();
        dayCounts[day]++;
    }
    }}
    
    //revision of analyzeMonthlyData()
    //for each Log entry returned by the reader the code is in a loop to continue as long as the log has more 
    //entries to process, it then checks if the entry is not null and then gets the month entry form getMonth method.
    //and it increments the counter for the monthCounts array.
    //created a data analyzer for monthly data for busiest month and quietest
    //analyzes data for monthly
    public void analyzeMonthlyData()
    {
        while (reader.hasNext()) 
        {
    LogEntry entry = reader.next();
    if (entry != null) 
    {
        int month = entry.getMonth();
        monthCounts[month]++;
    }
    }}
    
    //printHourlyCounts that prints a header of HR: Count with the System.out.println
    //the for loop will print out the hour and will loop until the length of hoursCount is complete which is 24
    //in the end it should display all the hours and their data
    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    //added a method that displays all the days and data
    //printDailyCounts that prints a header of Day: Count with the System.out.println
    //the for loop will print out the day and will loop until the length of dayCount is complete which is 28
    //in the end it should display all the days and their data
    public void printDailyCounts()
    {
        System.out.println("Day: Count");
        for(int day = 0; day < dayCounts.length; day++) {
            System.out.println(day + ": " + dayCounts[day]);
        }
    }
    
    //added a method that displays all the months and data
    //printMonthlyCounts that prints a header of Month: Count with the System.out.println
    //the for loop will print out the month and will loop until the length of monthCount is complete which is 12
    //in the end it should display all the months and their data
    public void printMonthlyCounts()
    {
        System.out.println("Month: Count");
        for(int month = 0; month < monthCounts.length; month++) {
            System.out.println(month + ": " + monthCounts[month]);
        }
    } 
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
