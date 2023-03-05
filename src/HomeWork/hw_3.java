package HomeWork;


public class hw_3 {

    public static void main(String args[]) {
        NodeList list = new NodeList();
        for (int i = 0; i < 15; i++) {
            int num = (int)(Math.random() * 100);
            Node node = new Node(num);
            if (i == 0) {
                list.head = node;
            } else {
                list.head.append(node);
            }
            list.tail = node;
        }
        System.out.println(list);
        System.out.println(list.revert());

    }

    public static class NodeList {

        Node head;
        Node tail;


        public String toString() {
            Node curr = head;
            StringBuilder sBuilder = new StringBuilder();
            while (curr != null) {
                sBuilder.append(curr.getData()).append(curr.hasNext() ? " >> " : "");
                curr = curr.getNext();
            }
            return sBuilder.toString();
        }


        public String revert() {
            Node curr = head;
            Node newHead = null;
            Node newLast = null;
            while (curr != null) {
                Node pre = curr.getPrevious();
                Node next = curr.getNext();
                if (pre == null) newLast = curr;
                if (next == null) newHead = curr;
                curr.setNext (pre);
                curr.setPrevious(next);
                curr = curr.getPrevious ();
            }
            head = newHead;
            tail = newLast;
            return this.toString();
        }
    }


    public static class Node {
        private Node previous;
        private Node next;
        private int data;

        public Node(int data) {
            this.data = data;
        }
        public void append(Node node) {
            if (this.next == null) {
                this.next = node;
                node.previous = this;
            } else {
                this.next.append(node);
            }
        }

        public Node getPrevious() {
            return previous;
        }
        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public int getData() {
            return data;
        }
    }
}
