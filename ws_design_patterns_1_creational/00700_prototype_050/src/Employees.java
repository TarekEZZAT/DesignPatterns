

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable{

	private List<String> employeesList;
	
	public Employees(){
		employeesList = new ArrayList<String>();
	}
	
	public Employees(List<String> list){
		this.employeesList=list;
	}
	public void loadData(){
		//read all employees from database and put into the list
		employeesList.add("Herbert");
		employeesList.add("Mary");
		employeesList.add("David");
		employeesList.add("Lisa");
	}
	
	public List<String> getEmployeesList() {
		return employeesList;
	}

	// The clone method is overridden to provide a deep copy of the employees list.
	@Override
	public Object clone() throws CloneNotSupportedException{
			List<String> employeeList = new ArrayList<String>();
			for(String s : this.getEmployeesList()){
				employeeList.add(s);
			}
			return new Employees(employeeList);
	}
	
}