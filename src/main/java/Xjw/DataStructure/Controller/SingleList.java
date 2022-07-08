package Xjw.DataStructure.Controller;


    class singleLinkNode{
        public Integer value;
        public singleLinkNode next;

        public singleLinkNode(Integer V) {
            value = V;
            next = null;
        }
    }


/**
 * @author xjw
 */
public  class SingleList {
        public singleLinkNode singleLinkNodeHead;



    /**
     * 得到单链表的长度
     * @return
     */
        public int size() {
            singleLinkNode singleLinkNodeLen = singleLinkNodeHead;
            int size = 0;
            while (singleLinkNodeLen != null) {
                size++;
                singleLinkNodeLen = singleLinkNodeLen.next;
            }
            return size;
        }

        // 根据索引找到节点的位置
        public singleLinkNode getNodeIndex(int index) {
            if (index < 0 || index > size()) {
                System.out.println("索引index的位置不合法");
            }
            singleLinkNode node = singleLinkNodeHead;
            while (index - 1 != 0) {
                //节点向后遍历一位，索引减一。当索引等于一时找到节点
                node = node.next;
                index--;
            }
            return node;
        }

        // 在头部插入数据
        public void addHeadData(int data) {
            singleLinkNode singleLinkNodeAddHead = new singleLinkNode(data);
            if (singleLinkNodeHead == null) {
                singleLinkNodeHead = singleLinkNodeAddHead;
                return;
            }
            singleLinkNodeAddHead.next = singleLinkNodeHead;
            singleLinkNodeHead = singleLinkNodeAddHead;
        }

        // 在尾部进行插入
        public void addTailData(int data) {
            singleLinkNode singleLinkNodeAddTail = new singleLinkNode(data);
            if (singleLinkNodeHead == null) {
                singleLinkNodeHead = singleLinkNodeAddTail;
                return;
            }
            singleLinkNode curNode = singleLinkNodeHead;
            while (curNode.next != null) {
                curNode = curNode.next;
            }
            curNode.next = singleLinkNodeAddTail;
        }

        //按索引进行插入
        public void addIndex(int index, int data) {
            singleLinkNode singleLikNodeAdd = new singleLinkNode(data);
            if (index == 0) {
                addHeadData(data);
            }
            if (index == size()) {
                addTailData(data);
            }
            singleLinkNode addNode = getNodeIndex(index);
            //顺序不能反。
            singleLikNodeAdd.next = addNode.next;
            addNode.next = singleLikNodeAdd;
        }

        //交换两相邻的元素--指定元素和它后一个节点交换。如果为最后一个节点则和它前一个节点交换(通过调整链而不是调整数据)
        public void changeNode(int index) {
            if (index < 0 || index > size()) {
                System.out.println("索引index的位置不合法");
            }
            if (index == size()) {
                singleLinkNode Node = getNodeIndex(index);
                singleLinkNode preNode = getNodeIndex(index - 1);
                singleLinkNode prepreNode = getNodeIndex(index - 2);
                preNode.next = Node.next;
                Node.next = preNode;
                prepreNode.next = Node;
            } else {
                singleLinkNode Node = getNodeIndex(index);
                singleLinkNode preNode = getNodeIndex(index - 1);
                singleLinkNode NodeNext = getNodeIndex(index + 1);
                Node.next = NodeNext.next;
                NodeNext.next = Node;
                preNode.next = NodeNext;
            }
        }
        public static void main(String[] args) {
           
        }
    }


