public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private NumberDisplay seconds;   // tambah detik
    private String displayString;
    
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        updateDisplay();
    }
    
    public ClockDisplay(int hour, int minute, int second)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        setTime(hour, minute, second);
    }
    
    public void timeTick()
    {
        seconds.increment();
        if (seconds.getValue() == 0) {
            minutes.increment();
            if (minutes.getValue() == 0) {
                hours.increment();
            }
        }
        updateDisplay();
    }
    
    public void setTime(int hour, int minute, int second)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        seconds.setValue(second);
        updateDisplay();
    }
    
    public String getTime()
    {
        return displayString;
    }
    
    private void updateDisplay()
    {
        java.time.LocalTime now = java.time.LocalTime.now();
        java.time.format.DateTimeFormatter fmt =
            java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss");
        displayString = now.format(fmt);
    }

    
    // Tambahan untuk tanggal
    public String getDate()
    {
        java.time.LocalDate today = java.time.LocalDate.now();
        java.time.format.DateTimeFormatter fmt =
            java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return today.format(fmt);
    }
    
    // Tambahan untuk suhu (dummy)
    public String getTemperature()
    {
        int suhu = 20 + (int)(Math.random() * 15); // 20–34 °C
        return suhu + "°C";
    }
}
