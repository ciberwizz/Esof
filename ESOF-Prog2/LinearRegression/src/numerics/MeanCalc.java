package numerics;

import Auxiliar.LinkedList;

public class MeanCalc {
	private LinkedList<Double> number_list;
	
	public MeanCalc(LinkedList<Double> number_list_) {
		setNewList(number_list_);
	}
	
	public void setNewList(LinkedList<Double> number_list_) {
		number_list = number_list_;
	}
	/**
	 * Calculates Mean of list.
	 * @return the mean of the list of numbers or NaN if there isn't a number on the list
	 */
	public Double[] calculate() {
		Double resultx = 0.0, resulty = 0.0;
		Double result[] = new Double[2];
		if(number_list.size() == 0){
			return result;
		}
		
		number_list.reset(); // Reset internal pointer for security
		for(int i = 0; i < number_list.size(); i++){
			resultx += number_list.getNodeValue1();
			resulty += number_list.getNodeValue2();
			number_list.nextNode();
		}
		
		result[0] = resultx / number_list.size();
		result[1] = resulty / number_list.size();
		return result;
	}
}
