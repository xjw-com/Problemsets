package Xjw.DataStructure.Controller;

public class Answer02 {
    //    单链表节点
    class singleLinkNode<Integer> {
        private Integer value;
        private singleLinkNode next;

        public singleLinkNode(Integer V) {
            value = V;
            next=null;
        }
    }
    public class singleList{
        private   singleLinkNode singleLinkNodeHead;

        //得到单链表的长度
        private int size(){
            singleLinkNode singleLinkNodeLen=singleLinkNodeHead;
            int size=0;
            while (singleLinkNodeLen!=null){
                size++;
                singleLinkNodeLen=singleLinkNodeLen.next;
            }
            return size;
        }
        //根据索引找到节点的位置
        private singleLinkNode getNodeIndex(int index){
            if(index<0||index>size()){
                System.out.println("索引index的位置不合法");
            }
            singleLinkNode node=singleLinkNodeHead;
            while (index-1!=0){
                //节点向后遍历一位，索引减一。当索引等于一时找到节点
                node=node.next;
                index--;
            }
            return node;
        }

        //在头部插入数据
        private void addHeadData(int data){
            singleLinkNode singleLinkNodeAddHead=new singleLinkNode(data);
            if(singleLinkNodeHead==null){
                singleLinkNodeHead=singleLinkNodeAddHead;
                return;
            }
            singleLinkNodeAddHead.next=singleLinkNodeHead;
            singleLinkNodeHead=singleLinkNodeAddHead;
        }
        // 在尾部进行插入
        private void addTailData(int data){
            singleLinkNode singleLinkNodeAddTail=new singleLinkNode(data);
            if(singleLinkNodeHead==null){
                singleLinkNodeHead=singleLinkNodeAddTail;
                return;
            }
            singleLinkNode curNode=singleLinkNodeHead;
            while (curNode.next!=null){
                curNode=curNode.next;
            }
            curNode.next=singleLinkNodeAddTail;
        }
        //按索引进行插入
        private void addIndex(int index,int data){
            singleLinkNode singleLikNodeAdd=new singleLinkNode(data);
            if(index==0){
                addHeadData(data);
            }
            if(index==size()){
                addTailData(data);
            }
            singleLinkNode addNode=getNodeIndex(index);
            //顺序不能反。
            singleLikNodeAdd.next=addNode.next;
            addNode.next=singleLikNodeAdd;
        }

        //交换两相邻的元素--指定元素和它后一个节点交换。如果为最后一个节点则和它前一个节点交换(通过调整链而不是调整数据)
        private void changeNode(int index){
            if(index<0||index>size()){
                System.out.println("索引index的位置不合法");
            }
            if(index==size()){
                singleLinkNode Node=getNodeIndex(index);
                singleLinkNode preNode=getNodeIndex(index-1);
                singleLinkNode prepreNode=getNodeIndex(index-2);
                preNode.next=Node.next;
                Node.next=preNode;
                prepreNode.next=Node;
            }else{
                singleLinkNode Node=getNodeIndex(index);
                singleLinkNode preNode=getNodeIndex(index-1);
                singleLinkNode NodeNext=getNodeIndex(index+1);
                Node.next=NodeNext.next;
                NodeNext.next=Node;
                preNode.next=NodeNext;
            }
        }
    }


    //多链表
    class DoubleLinkList{
        private int value;
        private DoubleLinkList NodePre;
        private DoubleLinkList NodeNext;
        public DoubleLinkList(int val){
            value=val;
        }
    }

    public class DoubleList{
        private DoubleLinkList NodeHead;
        private DoubleLinkList NodeTail;
        // 获取size
        public int size(){
            int count=0;
            DoubleLinkList curNode=NodeHead;
            while (curNode!=null){
                count++;
                curNode=curNode.NodeNext;
            }
            return count;
        }

        private DoubleLinkList getNodeIndex(int index){
            if(index<0||index>size()){
                System.out.println("索引index的位置不合法");
            }
            DoubleLinkList curNode=NodeHead;
            while (index-1!=0){
                index--;
                curNode=curNode.NodeNext;
            }
            return curNode;
        }

        //头部插入数据
        private void addHead(int data){
            DoubleLinkList addNode=new DoubleLinkList(data);
            if(NodeHead==null){

            }
        }
    }


}
