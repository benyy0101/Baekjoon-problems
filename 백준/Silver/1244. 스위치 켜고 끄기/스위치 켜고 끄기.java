import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numLights = sc.nextInt();
		
		int[] lights = new int[numLights+1];
		lights[0] = 0;
		
		for(int i=1; i<= numLights;i++) {
			lights[i] = sc.nextInt();
		}
		//System.out.println("0"+Arrays.toString(lights));	
		int numStudents = sc.nextInt();
		int[][] students = new int[numStudents][2];
		
		for(int i = 0; i<numStudents;i++) {
			students[i][0] = sc.nextInt();
			students[i][1] = sc.nextInt();
		}
		
		for(int[] student: students) {
			
			//meaning male
			if(student[0] == 1) {
				//System.out.println("im");
				int coeff = student[1];
				for(int i = coeff; i <= numLights; i += coeff) {
					
					lights[i] = lights[i] == 0? 1:0;
				}
			}
			//meaning female
			else {
				int idx = student[1];
				int offset = 1;
				lights[idx] = lights[idx] == 0?1:0;
				for(int i = 1; i<numLights/2;i++) {
					if(idx - i <= 0 || idx + i >numLights) break;
					
					if(lights[idx-i] == lights[idx+i]) {
						lights[idx-i] = lights[idx-i] == 0? 1:0;
						lights[idx+i] = lights[idx+i] == 0? 1:0;
					}
					else break;
				}
			}
			//System.out.println(student[0]+Arrays.toString(lights));	
		}
		StringBuilder sb = new StringBuilder();
		for(int i =1; i<=numLights;i++) {
			sb.append(lights[i]);
			if(i % 20 != 0) {
				sb.append(" ");
			}
			else {
				sb.append("\n");
			}
			
		}
		System.out.println(sb.toString());
	}
}
