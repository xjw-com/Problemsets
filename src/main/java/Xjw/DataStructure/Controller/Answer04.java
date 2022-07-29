package Xjw.DataStructure.Controller;

import java.util.*;

public class Answer04 {
    /**
     *  java中compareTo的用法
     * 1.返回参与比较的前后两个字符串的ASCII码的差值，如果两个字符串首字母不同，则该方法返回首字母的ASCII码的差值。
     * String a1 = "a";
     * String a2 = "c";
     * System.out.println(a1.compareTo(a2));//结果为-2
     * 2.参与比较的两个字符串如果首字符相同，则比较下一个字符，直到有不同的为止，返回该不同的字符的asc码差值。
     * String a1 = "aa";
     * String a2 = "ad";
     * System.out.println(a1.compareTo(a2));//结果为-3
     * 3.如果两个字符串不一样长，可以参与比较的字符又完全一样，则返回两个字符串的长度差值。
     * String a1 = "aa";
     * String a2 = "aa12345678";
     * System.out.println(a1.compareTo(a2));//结果为-8
     * 4.返回为正数表示a1>a2, 返回为负数表示a1<a2, 返回为0表示a1==a2。
     * 5.int型可以直接比较，所以没有用到compareTo比较，如果声明的是Date、String、Integer、或者其他的，可以直接使用compareTo比较。
     * Integer n1 = 5;
     * Integer n2 = 6;
     * System.out.println(n1.compareTo(n2));//-1
     *
     * 使用listIterator不使用Iterator的原因：
     * ListIterator 继承自 Iterator 接口，在 Iterator 的基础上增加了 6 个方法：
     * void hasPrevious()                        判断游标前面是否有元素;
     * Object previous()                          返回游标前面的元素，同时游标前移一位。游标前没有元素就报 java.util.NoSuchElementException 的错，所以使用前最好判断一下;
     * int nextIndex()                               返回游标后边元素的索引位置，初始为 0 ；遍历 N 个元素结束时为 N;
     * int previousIndex()                        返回游标前面元素的位置，初始时为 -1，同时报java.util.NoSu chElementException 错;
     * void add(E)                                   在游标 前面 插入一个元素。注意，是前面
     * void set(E)                                    更新迭代器最后一次操作的元素为 E，也就是更新最后一次调用 next() 或者 previous() 返回的元素。
     * 注意，当没有迭代，也就是没有调用 next() 或者 previous() 直接调用 set 时会报java.lang. IllegalStateException 错;
     * void remove()                               删除迭代器最后一次操作的元素，注意事项和 set 一样。
     * ListIterator 有两种获取方式
     * List.listIterator()
     * List.listIterator(int location)
     * 区别在于第二种可以指定 游标的所在位置。
     * ————————————————
     */

    public static List<Integer> intersection(List<Integer> L1, List<Integer> L2, List<Integer> Intersect){
        ListIterator<Integer> listIterator1=L1.listIterator();
        ListIterator<Integer> listIterator2=L2.listIterator();
        Integer integer1=null, integer2=null;
        if(listIterator1.hasNext()&&listIterator2.hasNext()){
            integer1=listIterator1.next();
            integer2=listIterator2.next();
        }
        while (integer1!=null&&integer2!=null){
            int compareResult=integer1.compareTo(integer2);
            if(compareResult==0){
                Intersect.add(integer1);
                integer1=listIterator1.hasNext()?listIterator1.next():null;
                integer2=listIterator2.hasNext()?listIterator2.next():null;
            }else if(compareResult<0){
                integer1=listIterator1.hasNext()?listIterator1.next():null;
            }else{
                integer2=listIterator2.hasNext()?listIterator2.next():null;
            }
        }
        return Intersect;
    }

    public static List<Integer>  intersection2(List<Integer> L1, List<Integer> L2, List<Integer> Intersect){
        ListIterator<Integer> listIterator1=L1.listIterator();
        ListIterator<Integer> listIterator2=L2.listIterator();
        Integer integer1=null, integer2=null;
        if(listIterator1.hasNext()&&listIterator2.hasNext()){
            integer1=listIterator1.next();
            integer2=listIterator2.next();
        }
        while (integer1!=null&&integer2!=null){
          //两表都为升序
            int compareResult=integer1.compareTo(integer2);
            //两表都为降序
            //int compareResult=integer2.compareTo(integer1);
            //TODO 一升一降 待完善
            if(compareResult==0){
                Intersect.add(integer1);
                integer1=listIterator1.hasNext()?listIterator1.next():null;
                integer2=listIterator2.hasNext()?listIterator2.next():null;
            }else if(compareResult<0){
                Intersect.add(integer1);
                integer1=listIterator1.hasNext()?listIterator1.next():null;

            }else{
                Intersect.add(integer2);
                integer2=listIterator2.hasNext()?listIterator2.next():null;
            }
        }
       if(integer1==null){
           while (integer2!=null){
               Intersect.add(integer2);
               integer2=listIterator2.hasNext()?listIterator2.next():null;
           }
       }
        if(integer2==null){
            while (integer1!=null){
                Intersect.add(integer1);
                integer1=listIterator1.hasNext()?listIterator1.next():null;
            }
        }
        return Intersect;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);
//        list1.add(4);
//        list1.add(5);
//        list2.add(4);
//        list2.add(5);
//        list2.add(6);
//        list2.add(7);
//        list2.add(8);
        list1.add(9);
        list1.add(8);
        list1.add(7);
        list1.add(6);
        list2.add(4);
        list2.add(3);
        list2.add(2);
        List<Integer> listResult=new ArrayList<Integer>();
        //intersection(list1,list2,listResult);
        intersection2(list1,list2,listResult);
        for (int i:listResult){
            System.out.println(i);
        }
    }
}
