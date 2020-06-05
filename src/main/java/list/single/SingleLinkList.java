package list.single;

/**
 * @author kingflag
 *         Created by kingflag on 2020/6/5.
 */
public class SingleLinkList<E> {
    /**
     * 头节点
     */
    private ListNode<E> head;


    private static class ListNode<E> {

        E value;

        ListNode<E> next;

        public ListNode(E value, ListNode<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    public SingleLinkList() {
        this.head = new ListNode<E>(null, null);
    }

    public SingleLinkList(ListNode<E> head) {
        this.head = head;
    }

    /**
     * 头部添加
     *
     * @param value
     */
    public void addHead(E value) {
        ListNode<E> newNode = new ListNode<E>(value, null);
        newNode.next = this.head.next;
        this.head.next = newNode;
    }

    /**
     * 尾部添加
     *
     * @param value
     */
    public void addTail(E value) {
        ListNode<E> newNode = new ListNode<E>(value, null);
        ListNode<E> node = this.head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
    }

    public static void main(String[] args) {
        SingleLinkList<Integer> singleLinkList = new SingleLinkList();
        for (int i = 0; i < 100; i++) {
            singleLinkList.addHead(i);
        }
        ListNode node = singleLinkList.head.next;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }

    }


}
