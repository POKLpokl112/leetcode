package code.one;

public class AddTwoNumbers {

	class ListNode {
		int val;

		public ListNode(int val) {
			this.val = val;
		}

		ListNode next;
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        
	    	ListNode l4  = new ListNode(0);
	        ListNode l3 = l4;
	    	int num = 0;
	       
	        l3.val = l1.val+l2.val+num;
	    		
	    		if(l3.val>9){
	        		l3.val = l3.val%10;
	        		num = 1;
	        	}else{
	        		num=0;
	        	}
	        
	        l1 = l1.next;
	    	l2 = l2.next;
	       
	    	
	    	while(l1!=null||l2!=null){
	            l1 = l1==null?new ListNode(0):l1;
	            l2 = l2==null?new ListNode(0):l2;
	    		
	                l3.next = new ListNode(0);
	    		    l3=l3.next;
	            
	             l3.val = l1.val+l2.val+num;
	    		
	    		if(l3.val>9){
	        		l3.val = l3.val%10;
	        		num = 1;
	        	}else{
	        		num=0;
	        	}
	            l1 = l1.next;
	    	    l2 = l2.next;
	    		
	    	}
	        
	        if(num==1){
	             l3.next = new ListNode(1);
	        }
	    	return l4;
	}
}
