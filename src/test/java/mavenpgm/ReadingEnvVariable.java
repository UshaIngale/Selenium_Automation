package mavenpgm;

public class ReadingEnvVariable {

	public static void main(String[] args) {
		String rootFolder=System.getProperty("user.dir");
		System.out.println(rootFolder);
	}

}
