import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* You may add any imports here, if you wish, but only from the 
   standard library */
//3,6,36,32,32,121,66,24,26,371,661,6,4,8,0,-1
//3,6,36,32,32,121,66,24,26,371,661,6,4,8,-1
//3,6,36, and 32,32,121, and 24,26,371,661, and 4,8


public class Main {
    public static int processArray(ArrayList<Integer> array) {
      
      List<List<Integer>> dereivedList =new ArrayList<>();
      Integer prev=-1;
      List<Integer> subList=null;
     
      ArrayList<Integer> connectArray=getCorrectArray(array);
      int size=connectArray.size();
      int counter =0;
      int last=-1;
      for(Integer record : connectArray) {
    	  ++counter;
    	 
    	  if(record>=prev) {
    		  if(subList==null) {
    		  subList=new ArrayList();
    		  		if(prev!=-1 && prev<=last&& record>=prev) {
	    			  subList.add(prev);
	    			  }
    		  }
    		  subList.add(record);
    		  prev=record;
    		
    	  }else {
    		  if(null!=subList) {
    			  last=subList.get(subList.size()-1);
    		  dereivedList.add(subList);
    		  }
    		  subList=null;
    		  prev=record;
    	  }
    	  
    	  if(size==counter && subList!=null ) {
    		  dereivedList.add(subList);
    	  }
      }
      //System.out.println(dereivedList);
      ArrayList<Integer> profitList=new ArrayList<Integer>();
      for(List<Integer> list:dereivedList) {
       Integer profit=getProfitList(list);
      profitList.add(profit);
      }
      int finalResult=profitList.stream().max((x,y)->x-y).get();
        return finalResult;
    }
   
	private static Integer getProfitList(List<Integer> list) {
		Integer result=0;
		if(list.size()>0)
			result=list.get(list.size()-1)-list.get(0);
		return result;
	}

	/**
	 * @param array
	 * @param connectArray
	 */
	private static  ArrayList<Integer> getCorrectArray(ArrayList<Integer> array) {
		 ArrayList<Integer> connectArray=new ArrayList<Integer>();
		array.stream().forEachOrdered(e->{
			if(e==-1)
				return;
			connectArray.add(e);
			});
		return connectArray;
	}

    public static void main (String[] args) {
    	System.out.println("dsfdsfdsfds");
    	if(true)
    		return;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
       
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int num = in.nextInt();
            if (num < 0) 
                break;
            arrayList.add(new Integer(num));
        }
        
      
        //Arrays.asList(arr).stream().forEachOrdered(e->arrayList.add(e));
        
        int result = processArray(arrayList);
        System.out.println(result);
    }
}