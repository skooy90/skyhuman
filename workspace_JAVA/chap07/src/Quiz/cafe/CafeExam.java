package Quiz.cafe;

public class CafeExam {

	public static void main(String[] args) {

		Back back = new Back();
		Alba alba = new Alba();
		Alba sbukAlba = new Alba(new Sbuk());
		Alba BackAlba = new Alba(new Back());
		back.jumun("아아", 2);
		System.out.println(back.total);
		back.sel(10000);

		Cafe c1 = (Cafe) back;
		Cafe c2 = (Cafe) new Sbuk();
		alba.coffee(c1, "아아", 2, 10000);
		alba.coffee(c2, "아아", 2, 10000);

		c1.seemenu();
		sbukAlba.coffee("뜨아", 3, 20000);
		BackAlba.coffee("뜨아", 3, 20000);

	}

}
