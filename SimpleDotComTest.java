public class SimpleDotComTest{
	public static void main(String [] args){
		SimpleDotCom s = new SimpleDotCom();
		int [] a = {2,3,4};
		s.setlocationCells(a);
		String userguess = "2";
		s.CheckYourself(userguess);
	}
}