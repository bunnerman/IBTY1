import java.util.LinkedList;

class Maine
{
    public static void main(String[] args)
    {
        LinkedList<Integer> obj = new LinkedList<>();

        obj.addFirst(1);
        obj.addLast(2);
        obj.add(1, 3);
		obj.addLast(4);
		obj.addLast(5);
		obj.addFirst(6);

    
        obj.remove();
		obj.removeFirst();
		obj.removeLast();
        obj.remove(Integer.valueOf(3));

        for (int i : obj)
            System.out.print(i + " ");
    }
}
