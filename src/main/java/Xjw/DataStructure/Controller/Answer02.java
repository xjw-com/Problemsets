package Xjw.DataStructure.Controller;

public class Answer02 {
    //    单链表节点
    class singleLinkNode<Integer> {
        private Integer value;
        private singleLinkNode next;

        public singleLinkNode(Integer V, singleLinkNode N) {
            value = V;
            next = N;
        }

        public Integer getValue() {
            return value;
        }
    }
}
