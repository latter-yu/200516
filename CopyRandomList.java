package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyRandomList {
    public Node copyRandomList(Node head) {
        //复制带随机指针(random)的链表
        //给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点
        //要求返回这个链表的 深拷贝:

        //1.使用 Map 建立 新链表(value) 与 原链表的每个节点val(key) 的键值对
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            //cur 表示旧链表节点
            map.put(cur, new Node(cur.val));
        }
        //2.深拷贝 next 和 random
        for (Node cur = head; cur != null; cur = cur.next) {
            //cur 表示旧链表节点, newCur 表示新链表节点
            Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);
        }
        return map.get(head);
    }
}

class Test {
    //拷贝示例
    public ArrayList<Integer> data;

    public Test() {
        data = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Test{" +
                "data=" + data +
                '}';
    }

    private static Test copy(Test t) {
        //浅拷贝
        Test t2 = new Test();
        t2.data = t.data;
        return t2;
    }
    private static Test deepCopy(Test t) {
        //深拷贝
        Test t1 = new Test();
        t1.data.addAll(t.data);
        return t1;
    }
    public static void main(String[] args) {
        Test t = new Test();
        t.data.add(1);
        t.data.add(2);
        t.data.add(3);

        Test t1 = deepCopy(t);
        //深拷贝：修改拷贝后的参数不影响拷贝前的参数
        t.data.add(4);
        System.out.println(t);
        System.out.println(t1);
        //Test{data=[1, 2, 3, 4]}
        //Test{data=[1, 2, 3]}

        Test t2 = copy(t);
        //浅拷贝：修改拷贝后的参数可能会影响拷贝前的参数
        t.data.add(4);
        System.out.println(t);
        System.out.println(t2);
        //Test{data=[1, 2, 3, 4, 4]}
        //Test{data=[1, 2, 3, 4, 4]}
    }
}