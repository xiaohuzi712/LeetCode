package LeetCode;
/**
 * Created by huchao on 2017/4/7.
 * 输入两个存储非负整数的链表，然后将其对应位置元素相加，结果逆序输出
 * eg:
 *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
 */
public class Code2 {
    ListNode head;
     //定义单链表
     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             this.next = null;
             this.val = x;
         }
     }
    public Code2(){
        head = null;
    }
    //构建单链表
    public ListNode buildList(int [] data) {
        ListNode current=null;
        for (int i = 0; i < data.length; i++) {
            if (head == null) {
                head = new ListNode(data[i]);
                current = head;
            } else {
                    while(current.next!=null){
                        current = head.next;
                    }
                   ListNode node = new ListNode(data[i]);
                  current.next = node;
                }
            }
        return head;
    }
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode c1 = l1;
       ListNode c2 = l2;
       int dump = 0;
       //定义输出单链表头部指针
       ListNode node = null;
       //定义待插入链表元素的移动指针
       ListNode current=null;
       while(l1!=null||l2!=null){
           dump=dump/10;
           if(l1!=null){
               dump+=l1.val;
               l1= l1.next;
           }
           if(l2!=null){
               dump+=l2.val;
               l2= l2.next;
           }
           //判断头指针是否为空，如果为空，则创建头指针
           if(node==null){
               node = new ListNode(dump%10);
               current = node;
           }else{
               current.next= new ListNode(dump%10);
                current =current.next;
           }
       }
       if(dump/10==1){
           current.next  = new ListNode(1);
           current =current.next;
       }
       return node;
    }
    public static void main(String[] args) {
        int[] list1 = {1,6,6,9};
        int[] list2 = {8,2,5,2};
        Code2 node1 = new Code2();
        Code2 node2 = new Code2();
        //创建单链表1
        ListNode singleList1 =  node1.buildList(list1);
        //定义单链表2
        ListNode singleList2 =  node2.buildList(list2);
        ListNode reusult = node2.addTwoNumbers(singleList1, singleList2);
        //打印输出链表
        while (reusult!=null){
            System.out.print(reusult.val+"->");
            reusult = reusult.next;
        }
    }
}
