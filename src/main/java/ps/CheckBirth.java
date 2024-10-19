package ps;

import java.util.regex.Pattern;

public class CheckBirth {

    public static void main(String[] args) {
        String[] arr = {
                "1899-13-31", "19001231", "2001-09-04", "1900-02-29", "2021-5-31", "1950-11-30", "1996-02-29", "1999-11-31", "2000-02-29"
        };

        System.out.println(solution(arr));
    }

    public static int solution(String[] birth) {
        int result = 0;
        String normalPattern = "^(19\\d\\d|200\\d|201\\d|202[01])-(0[1-9]|1[0-2])-\\d{2}$";
        String toDate31Pattern = "\\d{4}-((01|03|05|07|08|10|12)-(0[1-9]|1[0-9]|2[0-9]|3[0-1]))$";
        String toDate30Pattern = "\\d{4}-((04|06|09|11)-(0[1-9]|1[0-9]|2[0-9]|3[0-1]))$";
        String toDate29Pattern = "\\d{4}-((02)-(0[1-9]|1[0-9]|2[0-9]))$";
        String toDate28Pattern = "\\d{4}-((02)-(0[1-9]|1[0-9]|2[0-8]))$";

        for (String date : birth) {
            if (!validateDate(date, normalPattern)) continue;

            if (validateDate(date, toDate31Pattern)) result++;
            else if (validateDate(date, toDate30Pattern)) result++;
            else {
                int year = Integer.parseInt(date.split("-")[0]);
                if (validateLeapYear(year) && validateDate(date, toDate29Pattern)) result++;
                else if ((!validateLeapYear(year)) && validateDate(date, toDate28Pattern)){
                    result++;
                }
            }
        }

        return result;
    }

    public static Boolean validateDate(String date, String pattern) {
        Pattern p = Pattern.compile(pattern);
        return p.matcher(date).matches();
    }

    public static Boolean validateLeapYear(int year) {
        return (year %400 == 0) || (year %4 == 0 && year %100 != 0);
    }

}
