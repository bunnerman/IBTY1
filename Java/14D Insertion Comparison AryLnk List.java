import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.time.*;

class Maine
{
    public static void main(String[] args)
    {
        int maxNum = 500000;

        List<Integer> ary = new ArrayList<>();
        List<Integer> lnk = new LinkedList<>();

        Instant aryS = Instant.now();
        for (int i = 0; i < maxNum; i++)
            ary.addFirst(i);
        Instant aryE = Instant.now();
        long aryT = Duration.between(aryS, aryE).toNanos();

        Instant lnkS = Instant.now();
        for (int i = 0; i < maxNum; i++)
            lnk.addFirst(i);
        Instant lnkE = Instant.now();
        long lnkT = Duration.between(lnkS, lnkE).toNanos();

		System.out.println("FRONT INSERT");
        System.out.println("ArrayList:  " + aryT + " nS");
        System.out.println("LinkedList: " + lnkT + " nS");

		ary.clear(); lnk.clear();

		aryS = Instant.now();
        for (int i = 0; i < maxNum; i++)
            ary.addLast(i);
        aryE = Instant.now();
        aryT = Duration.between(aryS, aryE).toNanos();

        lnkS = Instant.now();
        for (int i = 0; i < maxNum; i++)
            lnk.addLast(i);
        lnkE = Instant.now();
        lnkT = Duration.between(lnkS, lnkE).toNanos();

		System.out.println("REAR INSERT");
        System.out.println("ArrayList:  " + aryT + " nS");
        System.out.println("LinkedList: " + lnkT + " nS");
    }
}
