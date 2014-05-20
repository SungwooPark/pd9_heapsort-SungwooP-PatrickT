//Patrick Tsai
//APCS 2 pd. 9
//HW 41
//2014-05-19

public class Heapsort {
	private ALHeap heap;
	
	public Heapsort() {
		heap = new ALHeap();
	}
	
	public Integer[] sort(Integer[] input) {
		Integer[] output = new Integer[input.length];
		//add values to heap
		for (int i = 0; i < input.length; i++) {
			heap.add(input[i]);
		}
		
		//now sort
		for (int i = 0; i < heap.getSize(); i++) {
			output[i] = heap.removeMin();
		}
		return output;
	}
}