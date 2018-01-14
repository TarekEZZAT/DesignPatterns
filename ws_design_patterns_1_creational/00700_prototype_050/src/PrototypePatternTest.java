import java.util.List;


public class PrototypePatternTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Employees employees = new Employees();
		employees.loadData();
		
		//Use the clone method to get the Employee object
		Employees employees1 = (Employees) employees.clone();
		Employees employees2 = (Employees) employees.clone();
		List<String> employeesList1 = employees1.getEmployeesList();
		employeesList1.add("John");
		List<String> employeesList2 = employees2.getEmployeesList();
		employeesList2.remove("Mary");
		
		System.out.println("employeesList (Original) List: "+employees.getEmployeesList());
		System.out.println("employeesList1           List: "+employeesList1);
		System.out.println("employeesList2           List: "+employeesList2);
	}

}