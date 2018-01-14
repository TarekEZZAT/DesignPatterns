
public class LinuxFactory implements IGUIFactory {
	@Override
	public IButton createButton() {
		return new LinuxButton();
	}
}
