package Xjw.DataStructure.Controller;


import java.util.Date;

class singlyLinkedCircularList{
    public int value;
    public singlyLinkedCircularList Next;

    public singlyLinkedCircularList(int val) {
        value = val;
    }
    //获取值
    public Integer getValue() {
        return this.value;
    }
    //更改值
    public void setValue(int data){
        this.value=data;
    }
    //更改指向
    public void setNext(singlyLinkedCircularList next){
        this.Next=next;
    }
    //获取指向
    public singlyLinkedCircularList getNext(){
        return this.Next;
    }
}

/**
 *方法1:将以单向循环链表解决
 */
public class JosePlusProblem {
    public singlyLinkedCircularList NodeHead;
    public singlyLinkedCircularList NodeTail;
    int size;
    public JosePlusProblem(){
        NodeHead=NodeTail=null;
        size=0;
    }

    /**
     * 在头部添加
     * @param data
     */
    public void addHead(int data){
        singlyLinkedCircularList singlyLinkedCircularList=new singlyLinkedCircularList(data);
        if(size==0){
            singlyLinkedCircularList.setNext(singlyLinkedCircularList);
            NodeHead=NodeTail=singlyLinkedCircularList;
            size++;
        }else{
            NodeTail.setNext(singlyLinkedCircularList);
            singlyLinkedCircularList.setNext(NodeHead);
            NodeHead=singlyLinkedCircularList;
            size++;
        }
    }

    /**
     * 尾部添加
     * @param data
     */
    public void addTail(int data){
        singlyLinkedCircularList singlyLinkedCircularList=new singlyLinkedCircularList(data);
        if(size==0){
            singlyLinkedCircularList.setNext(singlyLinkedCircularList);
            NodeHead=NodeTail=singlyLinkedCircularList;
            size++;
        }else{
            NodeTail.setNext(singlyLinkedCircularList);
            singlyLinkedCircularList.setNext(NodeHead);
            NodeTail=singlyLinkedCircularList;
            size++;
        }
    }

    /**
     * 根据值进行删除
     * @param data
     */
    public void deleteValue(int data){
        if(NodeHead==NodeTail){
            System.out.println("链表为空");
        }
        singlyLinkedCircularList singlyLinkedCircularList=NodeHead;
        int count=size;
        while (count!=0){
            if(NodeHead.getValue()==data){
                NodeTail.setNext(NodeHead.Next);
                NodeHead=NodeHead.Next;
                break;
            }
            if(singlyLinkedCircularList.Next.getValue()==data){
                singlyLinkedCircularList.setNext(singlyLinkedCircularList.Next.getNext());
                break;//break 控制当第一个匹配结果时结束遍历，只删除第一个匹配的元素
            }else{
                singlyLinkedCircularList=singlyLinkedCircularList.Next;
            }
            count--;
            if(count==0){
                System.out.println("链表中没有找到对应的值,无法删除");
            }
        }
    }

    /**
     * 根据索引删除值
     * @param index
     */
    public void deleteIndex(int index){
        if(index<0||index>size){
            System.out.println("索引的位置超出范围");
        }else{
            singlyLinkedCircularList singlyLinkedCircularLis=NodeHead;
            int count=1;
            while (count<size){
                if(index==1){
                    NodeTail.setNext(NodeHead.Next);
                    NodeHead=NodeHead.Next;
                    break;
                }
                if(count==index-1){
                    singlyLinkedCircularLis.setNext(singlyLinkedCircularLis.Next.getNext());
                    break;
                }
                singlyLinkedCircularLis=singlyLinkedCircularLis.Next;
                count++;
            }
        }
    }

    /**
     * 解决JosePlus问题
     * @param m
     * @param n
     */
    public static void JosePlus(int m, int n){

        JosePlusProblem josePlusProblem=new JosePlusProblem();
        for(int i=1;i<=m;i++){
            josePlusProblem.addTail(i);
        }

        while (true){
            if (josePlusProblem.NodeHead==josePlusProblem.NodeTail){
                break;
            }
            for (int i=0;i<n;i++){
                josePlusProblem.NodeHead=josePlusProblem.NodeHead.Next;
                josePlusProblem.NodeTail=josePlusProblem.NodeTail.Next;
            }
            System.out.println(josePlusProblem.NodeHead.getValue());
            josePlusProblem.NodeHead=josePlusProblem.NodeHead.Next;
            josePlusProblem.NodeTail.setNext(josePlusProblem.NodeHead);
        }
        System.out.println("最后的赢家是："+josePlusProblem.NodeHead.getValue());
    }

    public void throughList(){
        if(NodeHead==NodeTail){
            System.out.println("链表为空");
        }
        singlyLinkedCircularList singlyLinkedCircularList=NodeHead;
        while (singlyLinkedCircularList.Next!=NodeHead){
            if(singlyLinkedCircularList==NodeHead){
                System.out.println(singlyLinkedCircularList.getValue());
            }
            System.out.println(singlyLinkedCircularList.Next.getValue());
            singlyLinkedCircularList=singlyLinkedCircularList.Next;
        }
    }



    public static void main(String[] args) {
       JosePlus(5,1);
    }
}
