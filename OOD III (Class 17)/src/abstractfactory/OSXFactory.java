package abstractfactory;

public class OSXFactory implements GUIFactory {
	public Button createButton(){
		return new Button();
	}
}
