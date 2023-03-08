//juan jimenez
//16,18,19
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
    
    
    //7.16
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
    
    //7.18
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
