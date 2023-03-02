package LeetCode.Medium.AddTwoNumbers;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {    
        ListNode dummy=new ListNode(0);
        ListNode l3=dummy;

        int carry=0;
        while(l1!=null||l2!=null){
            int firstVal=(l1!=null)?l1.val:0;
            int secondVal=(l2!=null)?l2.val:0;

            int sum=firstVal+secondVal;
            if(carry!=0){
            sum++;
            carry=0;
            }
            if(sum>9){
                carry++;
                sum-=10;
            }
            ListNode value = new ListNode(sum);
            l3.next=value;
            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;
            l3=l3.next;
        }    
        if(carry!=0){
            ListNode value= new ListNode(carry);
            l3.next=value;
        }
        return dummy.next;
}
}
