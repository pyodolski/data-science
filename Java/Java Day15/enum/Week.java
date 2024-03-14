package ch16;
/*
class Week {
    public static final Week MONDAY = new Week("MONDAY")
    public static final Week TUESDAY = new Week("TUESDAY")

    String day;
    public Week(String day) {
        this.day = day;
    }

    public getDay() {
        return day;
    }
}
*/
enum Week {
    MONDAY,
    TUESDAY,
}

class DayT {
    public static void main(String[] args) {
        Week today = Week.TUESDAY;
        today = Week.MONDAY;
        System.out.println(today);
        Week sodlf = Week.TUESDAY;
        System.out.println(sodlf);
        var days = Week.values();
        System.out.println(days[0]);
        System.out.println(days[1]);
        // for (var w : days)
        //      sout(day);
        Week w = Week.TUESDAY;
        System.out.println(w.name());
        System.out.println(w);

        int weekNum = today.ordinal();
        System.out.println(weekNum);
        /////////////////    ///
               ///          ///
            ///  ///        ///
         ///        ///     ///

           ///        ///
           ///        ///
           //////////////
           ///        ///
           //////////////
    }
}
