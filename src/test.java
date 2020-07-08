import java.util.Iterator;

public class test {

    public static void main(String [] args ){
        LinkList<Integer> linkList = new LinkList<>();
        linkList.add(31);
        linkList.add(21);
        linkList.add(5);
        linkList.add(2);
        linkList.add(3);
        linkList.add(43);
        linkList.add(18);
        System.out.println("迭代器使用方法");
        Iterator<Integer> itreator = linkList.iterator();
        while (itreator.hasNext()) {
            int a = 2*itreator.next();
            System.out.println(a+" ");
        }
        System.out.println("整体排序，迭代器使用方法二");
        linkList.sort();
        for (Integer i :linkList) {
            System.out.println(i+" ");
        }
    }
}
