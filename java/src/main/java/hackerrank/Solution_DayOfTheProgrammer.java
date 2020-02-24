package hackerrank;

public class Solution_DayOfTheProgrammer {

    public static void main(String[] args) {
        assert "13.09.2017".equals(dayOfProgrammer(2017));
        assert "12.09.2016".equals(dayOfProgrammer(2016));
        assert "12.09.1800".equals(dayOfProgrammer(1800));
        assert "13.09.1917".equals(dayOfProgrammer(1917));
        assert "26.09.1918".equals(dayOfProgrammer(1918));
    }

    static String dayOfProgrammer(int year) {
        boolean cond = year % 4 == 0;
        if (year >= 1918) {
            cond = year % 400 == 0 || (cond && year % 100 != 0);
        }
        int febDays = (cond ? 29 : 28) - (year == 1918 ? 13 : 0);
        return String.format("%s.09.%s", 256 - (5 * 31 + 2 * 30 + febDays), year);
    }
}
