// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.algorithm;

import java.util.Date;
import java.util.Calendar;
import java.util.TimerTask;
import java.util.Timer;

public class Listener
{
    private Timer timer;
    private TimerTask timerTask;
    
    public Listener() {
    }
    
    public Listener(final TimerTask timerTask) {
        this.timerTask = timerTask;
    }
    
    public void listen(final int startHour, final int startMinute, final int startSecond, final long period, final boolean isStartTomorrow) {
        this.timer = new Timer();
        final Calendar calendar = Calendar.getInstance();
        calendar.set(11, startHour);
        calendar.set(12, startMinute);
        calendar.set(13, startSecond);
        if (isStartTomorrow) {
            calendar.add(5, 1);
        }
        final Date date = calendar.getTime();
        this.timer.schedule(this.timerTask, date, period);
    }
}
