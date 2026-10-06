import java.util.LinkedList;

class Maine
{
    public static void main(String[] args)
    {
        LinkedList<Integer> numbers = new LinkedList<>();

        // Insertion
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(1, 15); // Inserts 15 at index 1

        // Deletion
        numbers.remove(0);                   // Removes element at index 0 (10)
        numbers.remove(Integer.valueOf(30)); // Removes by value (30)

        // Traversal
        for (int num : numbers)
            System.out.print(num + " ");
    }
}
