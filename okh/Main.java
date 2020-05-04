package okh;
import java.util.Scanner;
public class Main {
	
	static final String DIREKTORI = "D:/Kuliah/Semester 6/OKH A/Toronto/";
	
	public static void main(String[] args) {
		String dir_crs = "";
		String dir_stu = "";
		
		String dir_carf92_stu = DIREKTORI+"car-f-92.stu";
		String dir_carf92_crs = DIREKTORI+"car-f-92.crs";
		
		String dir_cars91_stu = DIREKTORI+"car-s-91.stu";
		String dir_cars91_crs = DIREKTORI+"car-s-91.crs";
		
		String dir_earf83_stu = DIREKTORI+"ear-f-83.stu";
		String dir_earf83_crs = DIREKTORI+"ear-f-83.crs";
		
		String dir_hecs92_stu = DIREKTORI+"hec-s-92.stu";
		String dir_hecs92_crs = DIREKTORI+"hec-s-92.crs";
		
		String dir_kfus93_stu = DIREKTORI+"kfu-s-93.stu";
		String dir_kfus93_crs = DIREKTORI+"kfu-s-93.crs";
		
		String dir_lsef91_stu = DIREKTORI+"lse-f-91.stu";
		String dir_lsef91_crs = DIREKTORI+"lse-f-91.crs";
		
		String dir_purs93_stu = DIREKTORI+"pur-s-93.stu";
		String dir_purs93_crs = DIREKTORI+"pur-s-93.crs";
		
		String dir_ryes93_stu = DIREKTORI+"rye-s-93.stu";
		String dir_ryes93_crs = DIREKTORI+"rye-s-93.crs";
		
		String dir_staf83_stu = DIREKTORI+"sta-f-83.stu";
		String dir_staf83_crs = DIREKTORI+"sta-f-83.crs";
		
		String dir_tres92_stu = DIREKTORI+"tre-s-92.stu";
		String dir_tres92_crs = DIREKTORI+"tre-s-92.crs";
		
		String dir_utas92_stu = DIREKTORI+"uta-s-92.stu";
		String dir_utas92_crs = DIREKTORI+"uta-s-92.crs";
		
		String dir_utes92_stu = DIREKTORI+"ute-s-92.stu";
		String dir_utes92_crs = DIREKTORI+"ute-s-92.crs";
		
		String dir_yorf83_stu = DIREKTORI+"yor-f-83.stu";
		String dir_yorf83_crs = DIREKTORI+"yor-f-83.crs";
		
		System.out.println("1. Car-f-92");
		System.out.println("2. Car-s-91");
		System.out.println("3. Ear-f-83");
		System.out.println("4. Hec-s-92");
		System.out.println("5. Kfu-s-93");
		System.out.println("6. Lse-f-91");
		System.out.println("7. Pur-s-93");
		System.out.println("8. Rye-s-93");
		System.out.println("9. Sta-f-83");
		System.out.println("10. Tre-s-92");
		System.out.println("11. Uta-s-92");
		System.out.println("12. Ute-s-92");
		System.out.println("13. yor-f-83");
		System.out.println("00. Keluar");
		System.out.print("Pilih dataset : \n");
		
		Scanner input = new Scanner(System.in);
		int toronto = input.nextInt();
		
		switch(toronto) {
			case 1:
				dir_stu = dir_carf92_stu;
				dir_crs = dir_carf92_crs;
				break;
			case 2:
				dir_stu = dir_cars91_stu;
				dir_crs = dir_cars91_crs;
				break;
			case 3:
				dir_stu = dir_earf83_stu;
				dir_crs = dir_earf83_crs;
				break;
			case 4:
				dir_stu = dir_hecs92_stu;
				dir_crs = dir_hecs92_crs;
				break;
			case 5:
				dir_stu = dir_kfus93_stu;
				dir_crs = dir_kfus93_crs;
				break;
			case 6:
				dir_stu = dir_lsef91_stu;
				dir_crs = dir_lsef91_crs;
				break;
			case 7:
				dir_stu = dir_purs93_stu;
				dir_crs = dir_purs93_crs;
				break;
			case 8:
				dir_stu = dir_ryes93_stu;
				dir_crs = dir_ryes93_crs;
				break;
			case 9:
				dir_stu = dir_staf83_stu;
				dir_crs = dir_staf83_crs;
				break;
			case 10:
				dir_stu = dir_tres92_stu;
				dir_crs = dir_tres92_crs;
				break;
			case 11:
				dir_stu = dir_utas92_stu;
				dir_crs = dir_utas92_crs;
				break;
			case 12:
				dir_stu = dir_utes92_stu;
				dir_crs = dir_utes92_crs;
				break;
			case 13:
				dir_stu = dir_yorf83_stu;
				dir_crs = dir_yorf83_crs;
				break;
			case 00:
				System.exit(0);
		}
		
		System.out.println("1. Constructive Heuristics");
	
		int heuristics = input.nextInt();
		
		switch(heuristics) {
		case 1 :
			CourseSet cs = new CourseSet(dir_crs);
			ConflictMatrix cm = new ConflictMatrix(dir_stu, cs.getSize());
			int [][] confMat = cm.getConflictMatrix();
			int jumlahSiswa = cm.getJumlahStudent();
			int[][] solution = Scheduler.getSaturationSchedule(cs.getSize(), cm.getDegree(), confMat);
			Solution bestSolution = new Solution(solution);
			System.out.println("Jumlah Timeslot : " + bestSolution.getJumlahTimeslot());
			System.out.println("Penalty : " + Utils.getPenalty(confMat, solution, jumlahSiswa));
			break;
		}
		
		input.close();

	}
}
