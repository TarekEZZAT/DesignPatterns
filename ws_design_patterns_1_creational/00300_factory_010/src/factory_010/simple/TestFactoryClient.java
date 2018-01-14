package factory_010.simple;
public class TestFactoryClient {
	public static void main(String[] args) {
		ProductFactory pf = new ProductFactory();
		Product productA;
		Product productB;
		productA = pf.createProduct("A");
		productA.writeName("John Doe");
		productB = pf.createProduct("B");
		productB.writeName("John Doe");
	}
}