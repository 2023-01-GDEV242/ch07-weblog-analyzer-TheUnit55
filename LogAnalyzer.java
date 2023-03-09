//Juan Jimenez
//19
/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
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
        // Create the array object to hold the hourly
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
            if(hourCounts[hour] > hourCounts[quietestHour]) 
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
     
    //
    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    public void analyzeDailyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int day = entry.getDay();
            dayCounts[day]++;
        }
    }
    
    public void analyzeMonthlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int month = entry.getMonth();
            monthCounts[month]++;
        }
    }
    
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
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
