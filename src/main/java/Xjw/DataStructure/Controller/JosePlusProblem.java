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
            if(singlyLinkedCircularList.getValue()==data){
                singlyLinkedCircularList.setNext(singlyLinkedCircularList.Next.Next.getNext());
                return;
            }
            singlyLinkedCircularList=singlyLinkedCircularList.Next;
            count--;

        }
    }

    public void throughList(){
        if(NodeHead==NodeTail){
            System.out.println("链表为空");
        }
        singlyLinkedCircularList singlyLinkedCircularList=NodeHead;
        while (singlyLinkedCircularList.Next!=NodeTail){
            System.out.println(singlyLinkedCircularList.getValue());
            singlyLinkedCircularList=singlyLinkedCircularList.Next;
        }
    }



    public static void main(String[] args) {
        JosePlusProblem josePlusProblem=new JosePlusProblem();
        josePlusProblem.addTail(1);
        josePlusProblem.addHead(2);
        josePlusProblem.addHead(3);
        josePlusProblem.addHead(4);
        josePlusProblem.addHead(5);
        josePlusProblem.throughList();
    }
}
