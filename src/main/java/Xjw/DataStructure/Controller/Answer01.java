package Xjw.DataStructure.Controller;

import java.util.Iterator;
import java.util.List;

/**
 * @Author xjw
 * @Date 2022/7/3 15:16
 * @Version 1.0
 */
public class Answer01 {
    public void printLots(List<Integer> L,List<Integer> P){
        Iterator<Integer> iteratorL=L.iterator();
        Iterator<Integer> iteratorP=P.iterator();
        Integer itemL=null;
        Integer itemP;
        int itemStart=0;
        while (iteratorL.hasNext()&&iteratorP.hasNext()){
            itemP=iteratorP.next();
            while (itemStart<itemP&&iteratorL.hasNext()){
                itemStart++;
                itemL=iteratorL.next();
            }
        }
        System.out.print(itemL+"");
        // 时间复杂度为O(N^2)|O(n*m) n,m 为L,P的长度。
    }

}
