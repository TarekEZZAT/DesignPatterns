public class TestCalcChain {
	
	public static void main(String[] args){
		
		// Here I define all of the objects in the chain
		
		Chain chainCalc1 = new AddNumbers();
		Chain chainCalc2 = new SubtractNumbers();
		Chain chainCalc3 = new MultNumbers();
		Chain chainCalc4 = new DivideNumbers();
		
		// Here I tell each object where to forward the
		// data if it can't process the request
		
		chainCalc1.setNextChain(chainCalc2);
		chainCalc2.setNextChain(chainCalc3);
		chainCalc3.setNextChain(chainCalc4);
		
		// Define the data in the Numbers Object
		// and send it to the first Object in the chain
		
		Numbers request1 = new Numbers(4,2,"add");
		Numbers request2 = new Numbers(4,2,"sub");
		Numbers request3 = new Numbers(4,2,"mult");
		Numbers request4 = new Numbers(4,2,"div");
		Numbers request5 = new Numbers(4,2,"pow");

		chainCalc1.calculate(request1);
		System.out.println("\n");
		chainCalc1.calculate(request2);
		System.out.println("\n");
		chainCalc1.calculate(request3);
		System.out.println("\n");
		chainCalc1.calculate(request4);
		System.out.println("\n");
		chainCalc1.calculate(request5);
		System.out.println("\n");

	}

}