/******************************************************************************
 * Compilation: javac Clock.java Execution: java Clock
 *
 * A data type Clock.java that represents time on a 24-hour clock, such as
 * 00:00, 13:30, or 23:59. Time is measured in hours (00–23) and minutes (00–59)
 *
 * %java Clock Is 00:59 earlier than 23:49? true a tic: 01:00 b toc + 61 mins:
 * 00:50
 * 
 ******************************************************************************/

public class Clock {
    private int hr, min;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h > 23 || m < 0 || m > 59)
            throw new IllegalArgumentException("Illegal Argument provided!");
        this.hr = h;
        this.min = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format
    // HH:MM.
    public Clock(String s) {
        if (!s.contains(":")) {
            throw new IllegalArgumentException();
        }
        String[] time = s.split(":");
        if (time[0].length() != 2 || time[1].length() != 2)
            throw new IllegalArgumentException("Illegal Arguments provided!");
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);
        if (h < 0 || h > 23 || m < 0 || m > 59)
            throw new IllegalArgumentException("Illegal Argument provided!");
        this.hr = h;
        this.min = m;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String h = "";
        String m = "";
        if (this.hr < 10)
            h = "0" + this.hr;
        else
            h += this.hr;
        if (this.min < 10)
            m = "0" + this.min;
        else
            m += this.min;
        return h + ":" + m;

    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.hr < that.hr)
            return true;
        if (this.hr > that.hr)
            return false;
        return (this.min < that.min);
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (this.hr <= 23 && this.min < 59){
            this.min++;
            return;
        }            
        if (this.hr < 23 && this.min == 59) {
            this.hr++;
            this.min = 0;
            return;
        }
        if (this.hr == 23 && this.min == 59) {
            this.hr = 0;
            this.min = 0;
            return;
        }

    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0)
            throw new IllegalArgumentException(" Delta time cannot be negative!");
        if (this.min + delta >= 60) {
            int incM = (this.min + delta) % 60;
            int incH = (this.min + delta) / 60;
            if (this.hr + incH < 23) {
                this.hr += incH;
                this.min = incM;
            } else {
                this.hr = (this.hr + incH) % 24;
                this.min = incM;
            }
        } else
            this.min = this.min + delta;
    }

    // Test client (see below).
    public static void main(String[] args) {
        // Checking the constructor behaviour
        Clock a = new Clock(7,58);
        Clock b = new Clock("02:52");
        // Ordering is 00:00 to 23:59
        StdOut.println("Is " + a + " earlier than " + b + "? " + a.isEarlierThan(b));

        // Adding 1 minute
        a.tic();
        StdOut.println("a tic: " + a);

        // Adding a delta
        int delta = 61;
        b.toc(delta);
        StdOut.println("b toc + " + delta + " mins: " + b);

    }
}