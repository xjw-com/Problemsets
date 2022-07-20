package Xjw.DataStructure.Controller;



class SingleLinkNode {
    public Integer value;
    public SingleLinkNode next;

    public SingleLinkNode(Integer V) {
        this.value = V;
    }

    public Integer getValue() {
        return this.value;
    }
}


/**
 * @author xjw
 */
public class SingleList {
    public SingleLinkNode singleLinkNodeHead;

    /**
     * 得到单链表的长度
     *
     * @return
     */
    public int size() {
        SingleLinkNode singleLinkNodeLen = singleLinkNodeHead;
        int size = 0;
        while (singleLinkNodeLen != null) {
            size++;
            singleLinkNodeLen = singleLinkNodeLen.next;
        }
        return size;
    }

    /**
     * 根据索引找到节点的位置
     *
     * @param index
     * @return
     */
    public SingleLinkNode getNodeIndex(int index) {
        if (index <= 0) {
            index = 1;
        }
        if (index >= size()) {
            index = size();
        }
        SingleLinkNode node = singleLinkNodeHead;
        while (index - 1 != 0) {
            //节点向后遍历一位，索引减一。当索引等于一时找到节点
            node = node.next;
            index--;
        }
        return node;
    }

    /**
     * 在头部插入数据
     *
     * @param data
     */
    public void addHeadData(int data) {
        SingleLinkNode singleLinkNodeAddHead = new SingleLinkNode(data);
        if (singleLinkNodeHead == null) {
            singleLinkNodeHead = singleLinkNodeAddHead;
            return;
        }
        singleLinkNodeAddHead.next = singleLinkNodeHead;
        singleLinkNodeHead = singleLinkNodeAddHead;
    }


    /**
     * 在尾部进行插入
     *
     * @param data
     */
    public void addTailData(int data) {
        SingleLinkNode singleLinkNodeAddTail = new SingleLinkNode(data);
        if (singleLinkNodeHead == null) {
            singleLinkNodeHead = singleLinkNodeAddTail;
            return;
        }
        SingleLinkNode curNode = singleLinkNodeHead;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = singleLinkNodeAddTail;
    }


    /**
     * 按索引进行插入
     *
     * @param index
     * @param data
     */
    public void addIndex(int index, int data) {
        SingleLinkNode singleLikNodeAdd = new SingleLinkNode(data);
        if (index <= 0) {
            addHeadData(data);
            return;
        }
        if (index >= size()) {
            addTailData(data);
            return;
        }
        SingleLinkNode addNode = getNodeIndex(index);
        //顺序不能反。
        singleLikNodeAdd.next = addNode.next;
        addNode.next = singleLikNodeAdd;
    }


    /**
     * 遍历链表
     */
    public void list() {
        if (singleLinkNodeHead.next == null) {
            System.out.println("空链表");
            return;
        }
        SingleLinkNode temp = singleLinkNodeHead;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.getValue());
            temp = temp.next;
        }
    }

    /**
     * 交换两相邻的元素--指定元素和它后一个节点交换。如果为最后一个节点则和它前一个节点交换(通过调整链而不是调整数据)
     *
     * @param index
     */
    public void changeNode(int index) {
        SingleLinkNode preNode=null,Node=null,nextNode=null;
        SingleLinkNode temp= singleLinkNodeHead;
        int nowIndex=1;
        while (temp.next!=null){
            if(nowIndex==index-1){
                preNode=temp;
            }
            if(nowIndex==index){
                Node=temp;
            }
            if(nowIndex==index+1){
                nextNode=temp;
                Node.next=nextNode.next;
                nextNode.next=Node;
                preNode.next=nextNode;
                break;
            }
            nowIndex++;
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.addTailData(1);
        singleList.addTailData(2);
        singleList.addTailData(3);
        singleList.addTailData(4);
        singleList.addTailData(5);
        singleList.addIndex(1,5);
//        singleList.addIndex(7,6);
//        System.out.println(singleList.getNodeIndex(3).getValue());
        singleList.list();
        System.out.println("--------------------");
        singleList.changeNode(3);
        singleList.list();
    }
}


