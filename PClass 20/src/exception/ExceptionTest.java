package exception;

public class ExceptionTest {

	public static void main(String[] args) throws MyException{
//		try {
//			execute();
//		} catch (Exception e1){
//			e1.printStackTrace();
//		}
		execute("true");
	}
	
	public static void execute() throws Exception{
		System.out.println("Execute...");
		throw new Exception();
	}
	
	public static void execute(String a) throws MyException{
		System.out.println("execute...");
		if ("true".equals(a)){
			throw new MyException("it can be true");
		}
	}
}
