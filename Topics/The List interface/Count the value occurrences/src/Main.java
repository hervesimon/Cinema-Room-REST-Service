import java.util.List;

class Counter {
    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        long countForList1 = list1.stream().filter(item -> item.equals(elem)).count();
        long countForList2 = list2.stream().filter(item -> item.equals(elem)).count();
        return countForList1 == countForList2;
    }
}