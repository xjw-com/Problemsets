package Xjw.DataStructure.Controller;

/**
 * @Author xjw
 * @Date 2022/7/8 16:40
 * @Version 1.0
 */
/**
 * 多链表
 */
class DoubleLinkList {
    public int value;
    public DoubleLinkList NodePre;
    public DoubleLinkList NodeNext;

    public DoubleLinkList(int val) {
        value = val;
    }
    public Integer getValue() {
        return this.value;
    }
}

/**
 * @author xjw
 */
public class DoubleList {
    public DoubleLinkList NodeHead;
    public DoubleLinkList NodeTail;

    /**
     * 获取size
     * @return
     */
    public int size() {
        int count = 0;
        DoubleLinkList curNode = NodeHead;
        while (curNode != null) {
            count++;
            curNode = curNode.NodeNext;
        }
        return count;
    }

    /**
     * 根据索引获取节点
     * @param index
     * @return
     */
    public DoubleLinkList getNodeIndex(int index) {
        if (index < 0 || index > size()) {
            System.out.println("索引index的位置不合法");
        }
        DoubleLinkList curNode = NodeHead;
        while (index - 1 != 0) {
            index--;
            curNode = curNode.NodeNext;
        }
        return curNode;
    }

    /**
     * 遍历双向链表
     */
    public void list(){
        DoubleLinkList doubleLinkList=NodeHead;
        while (doubleLinkList!=null){
            System.out.println(doubleLinkList.getValue());
            doubleLinkList=doubleLinkList.NodeNext;
        }
    }



    /**
     *  头部插入数据
     *  如果链表为空
     *  头结点 = 插入的节点 = 尾结点
     *  不为空则:
     *  1、将插入节点的next指向头结点
     *  2、调整头结点的前驱为新节点
     *  3、将新节点设置为头结点
     * @param data
     */

    public void addHead(int data) {
        DoubleLinkList addNode = new DoubleLinkList(data);
        if (NodeHead == null) {
            NodeHead = addNode;
            NodeTail = addNode;
            return;
        }
        addNode.NodeNext = NodeHead;
        NodeHead.NodePre = addNode;
        NodeHead = addNode;

    }

    /**
     *  尾部插入
     *  为空时：
     *  等价于头部插入
     *  不为空：
     *  1、调整尾结点的后继next指向新节点
     *  2、调整新节点的前驱pri指向尾结点
     *  3、更新尾结点为新的节点
     * @param data
     */
    public void addTail(int data) {
        DoubleLinkList addNode = new DoubleLinkList(data);
        if (NodeHead == null) {
            NodeHead = addNode;
            NodeTail = addNode;
            return;
        }
        NodeTail.NodeNext = addNode;
        addNode.NodePre = NodeTail;
        NodeTail = addNode;
    }

    /**
     * 根据索引插入
     * @param index
     * @param data
     */
    public void addIndex(int index,int data){
        if(NodeHead==null||index<=0){
            addHead(data);
            return;
        }
        if(index>=size()){
            addTail(data);
            return;
        }
        DoubleLinkList indexNode=getNodeIndex(index);
        DoubleLinkList addNode=new DoubleLinkList(data);
        addNode.NodeNext=indexNode.NodeNext;
        indexNode.NodeNext=addNode;
        addNode.NodePre=indexNode;
        indexNode.NodeNext.NodePre=addNode;
    }
    /**
     * 交换两相邻的元素--指定元素和它后一个节点交换。如果为最后一个节点则和它前一个节点交换(通过调整链而不是调整数据)
     * @param index
     */
    public void changeNode(int index){
        if(index<0||index>size()){
            System.out.println("索引index的位置不合法");
            return;
        }
        if(2>size()){
            System.out.println("链表太短");
            return;
        }
        int nowIndex=1;
        DoubleLinkList tempList=NodeHead;
        DoubleLinkList linkList1=null;
        DoubleLinkList linkList2=null;
        while (NodeHead.NodeNext!=NodeTail){
            if(nowIndex==index){
                linkList1=tempList;
            }
            if(nowIndex==index+1){
                linkList2=tempList;
                linkList1.NodePre.NodeNext=linkList2;
                linkList1.NodeNext=linkList2.NodeNext;
                linkList2.NodeNext=linkList1;
                linkList2.NodeNext.NodePre=linkList1;
                linkList2.NodePre=linkList1.NodePre;
                linkList1.NodePre=linkList2;
                break;
            }
            tempList=tempList.NodeNext;
            nowIndex++;
        }
    }

    public static void main(String[] args) {
      DoubleList doubleList=new DoubleList();
      doubleList.addHead(1);
      doubleList.addTail(2);
      doubleList.addTail(3);
      doubleList.addTail(4);
      doubleList.addHead(5);
      doubleList.addIndex(5,6);
      doubleList.list();
      doubleList.changeNode(2);
      System.out.println("--------------");
      doubleList.list();
    }

}