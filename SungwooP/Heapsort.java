//Sungwoo Park
//2014-05-19
//HW#41
//APCS2/Pd9

//Best case of sorting: When the inputing data is sorted from least to greatest order.
//-adding element to heap has constant, O(1) runtime
//-removing element from heap has constant runtime
//Therefore, the run time is linearly proporational to the size of the data. 
//O(n) Runtime

//Worse case of sorting: When the inputing data is sorted from greatest to least order. 
//Then everytime when you add an element to a heap, you have to swap elements.
//-adding element to heap has O(logn) runtime
//-removing element has constant runtime
//O(nlogn) Runtime

//I think memory consumption will be same in both best and worst situation because they both have same size of heap and arraylist.

import java.util.ArrayList;

public class Heapsort{
    ALHeap a = new ALHeap();

    Integer[] sort( Integer[] data){
        for (int i: data){
            a.add(i);            
        }
        Integer[] toReturn = new Integer[data.length];
        for (int i=0;i<data.length;i++){
            toReturn[i] = a.removeMin();
        }

        return toReturn;
    }
    
    //Constant memory consumption sort
    Integer[] cSort(Integer[] data){
        for (int i=0;i<data.length;i++){
            helper(data,i);
        }
    }

    public void helper(Integer[]] data,int pos){
        for (int i=0;i <= pos;i++){
            if ((pos-1)/2 >= 0){
                if (data[pos] < data[(pos-1)/2]){
                    int temp = data[pos];
                    data[pos] = data[(pos-1)/2];
                    data[(pos-1)/2] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args){
        Heapsort test = new Heapsort();
        Integer[] data = {3,123,153,332,54342,12};
        Integer[] sorted = test.sort(data);
        for (int i: sorted){
            System.out.println(i);
        }
    }
}
