//Sungwoo Park
//2014-05-21
//HW#42
//APCS2/Pd9

//First, I heapified the array by increasing partition by one at a time and swapping values to conserve heap property.
//Then, I created another variable that represents partition, but this one starts from the end of the array.
//I moved the first value of array (which is min value of heapifized region) to the position of the sorted region.
//After that step, I moved up the last value of heapifized region to the front and swapped elements again to preserved heap property.
//I repeated this step until my array is sorted in descending order.
import java.util.ArrayList;

public class Heapsort{
    ALHeap a = new ALHeap();

    
    //Constant memory consumption sort
    Integer[] sort(Integer[] data){
        for (int i=1;i<data.length;i++){
            int pos = i;
            while (pos != 0){    
                if (data[pos] < data[(pos-1)/2]){
                    swap(data,(pos-1)/2,pos);
                }
                pos = (pos-1)/2;
            }
        }
        
        //put sorted elements at back
        int partition = data.length-1;
        for(int i=0;i<data.length-1;i++){
            int temp = data[0];
            data[0] = data[partition];
            
            //Put number in front in right place
            int tempPos = 0;
            while (tempPos < partition){
                if (tempPos*2+1 >= data.length){
                    break;
                }
                //Check if you are about to swap element at partition
                //Also, one tree situation
                if (tempPos*2+1 >= partition){
                    break;
                }else if(tempPos*2+2 >= partition){
                    //Swap with left tree if greater
                    if (data[tempPos] > data[tempPos*2+1]){
                        swap(data,tempPos,tempPos*2+1);
                        tempPos = tempPos*2+1;
                     }
                     break;
                }
                if (tempPos*2+2 >= data.length){
                }   
                if (data[tempPos] > Math.min(tempPos*2+1,tempPos*2+2)){
                    if (data[tempPos*2+1] < data[tempPos*2+2]){
                        //swap parent with left subtree
                        swap(data,tempPos,tempPos*2+1);
                        tempPos = tempPos*2+1;
                    }else{
                        //swap parent with right subtree
                        swap(data,tempPos,tempPos*2+2);
                        tempPos = tempPos*2+2;
                    }
                }else{
                    break;
                }
            }
            data[partition] = temp;
            partition = partition - 1;
        }

        return data;
    }

    public void swap(Integer[] data, int pos1, int pos2){
        int temp = data[pos1];
        data[pos1] = data[pos2];
        data[pos2] = temp;
    }

    public static void main(String[] args){
        Heapsort a  = new Heapsort();
        Integer[] test = {7,197,5,1231,13,99,200,42,2,16,3,1,123};
        Integer[] sorted = a.sort(test);
        for (int i:sorted){
            System.out.println(i);
        }
    }
}
