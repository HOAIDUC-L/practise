package Exercise1;

class MyTime {
    private int hour;
    private int minute;
    private int second;

    public MyTime(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }

    public void setTime(int hour, int minute, int second) {
        if (isValidTime(hour, minute, second)) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        } else {
            throw new IllegalArgumentException("Invalid hour, minute, or second!");
        }
    }

    public void setHour(int hour) {
        if (hour >= 0 && hour <= 23) {
            this.hour = hour;
        } else {
            throw new IllegalArgumentException("Invalid hour!");
        }
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute <= 59) {
            this.minute = minute;
        } else {
            throw new IllegalArgumentException("Invalid minute!");
        }
    }

    public void setSecond(int second) {
        if (second >= 0 && second <= 59) {
            this.second = second;
        } else {
            throw new IllegalArgumentException("Invalid second!");
        }
    }

    public int getHour() { return hour; }
    public int getMinute() { return minute; }
    public int getSecond() { return second; }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public MyTime nextSecond() {
        second++;
        if (second == 60) {
            second = 0;
            nextMinute();
        }
        return this;
    }

    public MyTime nextMinute() {
        minute++;
        if (minute == 60) {
            minute = 0;
            nextHour();
        }
        return this;
    }

    public MyTime nextHour() {
        hour = (hour + 1) % 24;
        return this;
    }

    public MyTime previousSecond() {
        if (second == 0) {
            second = 59;
            previousMinute();
        } else {
            second--;
        }
        return this;
    }

    public MyTime previousMinute() {
        if (minute == 0) {
            minute = 59;
            previousHour();
        } else {
            minute--;
        }
        return this;
    }

    public MyTime previousHour() {
        hour = (hour == 0) ? 23 : hour - 1;
        return this;
    }

    private boolean isValidTime(int hour, int minute, int second) {
        return (hour >= 0 && hour <= 23) && (minute >= 0 && minute <= 59) && (second >= 0 && second <= 59);
    }
}

public class B34 {
    public static void main(String[] args) {
        MyTime time = new MyTime(23, 59, 59);
        System.out.println("Initial time: " + time);

        time.nextSecond();
        System.out.println("After nextSecond: " + time);

        time.previousSecond();
        System.out.println("After previousSecond: " + time);

        time.nextMinute();
        System.out.println("After nextMinute: " + time);

        time.previousMinute();
        System.out.println("After previousMinute: " + time);

        time.nextHour();
        System.out.println("After nextHour: " + time);

        time.previousHour();
        System.out.println("After previousHour: " + time);
    }
}
