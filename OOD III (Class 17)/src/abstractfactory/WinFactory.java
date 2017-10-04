package abstractfactory;

public class WinFactory implements GUIFactory {
	public Button createButton(){
		return new Button(); // suppose WindowsButton is a derived class of Button
	}
}
