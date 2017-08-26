import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		
		Model model = new Model();
		IView view = new ConsoleView();
		Controller controller = new Controller();
		
		
		ArrayList<Student> list = readStudents();

		for (Student student : list) {
			System.out.println(student);
		}

		// 1 print strings no dups by string
		System.out.println("___Q1___ print string without dups:");
		printNoDupsByField(list, "name");
		System.out.println("----------------------");

		// 2 print sorted strings no dups by string
		System.out
				.println("___Q2___ print string without dups: sort by string");
		printSortedNoDupsByField(list, "name");
		System.out.println("----------------------");

		// 3 reverse
		System.out.println("___Q3___ reversed array:");
		printReverse(list, "name");
		System.out.println("----------------------");
		// 4 print count by string
		System.out.println("___Q4___ count of identical strings:");
		printCountNoDupsByField(list, "name");
		System.out.println("----------------------");

		// 5 print sort count by string
		System.out
				.println("___Q5___ count of identical strings sorted by counted string:");
		printSortCountNoDupsByField(list, "name");
		System.out.println("----------------------");

		// 6 print sort string length count by string
		System.out
				.println("___Q6___ count of identical strings sorted by counted string length:");
		printSortStringLengthCountNoDupsByField(list, "name");
		System.out.println("----------------------");

		System.out
				.println("___Q7___ count by occurences and sort by count no dups with order on a field");
		printCountOccurencesSortByCount(list, "name", -1);
		System.out.println("----------------------");

		System.out.println("___Q8___ count of identical students:");
		Map<Student, Integer> map = printCountSameStudents(list);
		System.out.println("----------------------");

		System.out.println("___Q9___ sort by count of identical students: ");
		printSortCountSameStudents(map);
		System.out.println("----------------------");

	}

	
}
