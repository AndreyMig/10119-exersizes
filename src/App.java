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

	private static Map<Student, Integer> printCountSameStudents(
			ArrayList<Student> list) {
		Map<Student, Integer> map = new HashMap<Student, Integer>();

		for (Student student : list) {

			Integer count = map.get(student);

			if (count == null) {
				map.put(student, 1);
			} else {
				map.put(student, count + 1);

			}
		}

		for (Entry<Student, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		return map;
	}

	private static void printSortCountSameStudents(Map<Student, Integer> map) {
		//
		Comparator<StudentDecorator> comparator = new Comparator<StudentDecorator>() {
			@Override
			public int compare(StudentDecorator o1, StudentDecorator o2) {
				return o1.getCount() - o2.getCount() >= 0 ? 1 : -1;
			}
		};

		Set<StudentDecorator> set = new TreeSet<StudentDecorator>(comparator);

		System.out.println(map.size());
		for (Entry<Student, Integer> e : map.entrySet()) {
			set.add(new StudentDecorator(e.getKey(), e.getValue()));
		}

		for (StudentDecorator studentDecorator : set) {
			System.out.println(studentDecorator);
		}
		//
	}

	private static void printSortStringLengthCountNoDupsByField(
			ArrayList<Student> list, String field) {

		Comparator<String> comparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int lengthDiff = o1.length() - o2.length();
				int compareStringRes = o1.compareTo(o2);
				if (lengthDiff == 0) {
					return compareStringRes;
				}
				return lengthDiff;
			}
		};

		Map<String, Integer> map = new TreeMap<String, Integer>(comparator);

		for (Student student : list) {

			String string = "";

			switch (field) {
			case "name":
				string = student.getName();
				break;

			case "grade":
				string = "" + student.getGrade();
				break;
			}

			Integer count = map.get(string);
			if (count == null) {
				map.put(string, 1);
			} else {
				map.put(string, count + 1);
			}
		}

		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}

	private static void printCountOccurencesSortByCount(
			ArrayList<Student> list, String field, int order) {

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (Student student : list) {

			String string = "";

			switch (field) {
			case "name":
				string = student.getName();
				break;

			case "grade":
				string = "" + student.getGrade();
				break;
			}

			Integer count = map.get(string);
			if (count == null) {
				map.put(string, 1);
			} else {
				map.put(string, count + 1);
			}
		}

		Comparator<Entry<String, Integer>> comp = new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				return (o1.getValue() - o2.getValue()) * order;
			}
		};

		Set<Entry<String, Integer>> ts = new TreeSet<Entry<String, Integer>>(
				comp);

		for (Entry<String, Integer> entry : map.entrySet()) {
			ts.add(entry);
			// System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		for (Entry<String, Integer> entry : ts) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}

	private static void printReverse(ArrayList<Student> list, String field) {

		Stack<Student> stack = new Stack<Student>();

		for (Student student : list) {
			stack.push(student);
		}
		while (!stack.empty()) {
			System.out.println(stack.pop());
		}

	}

	private static void printCountNoDupsByField(ArrayList<Student> list,
			String field) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (Student student : list) {

			String string = "";

			switch (field) {
			case "name":
				string = student.getName();
				break;

			case "grade":
				string = "" + student.getGrade();
				break;
			}

			Integer count = map.get(string);
			if (count == null) {
				map.put(string, 1);
			} else {
				map.put(string, count + 1);
			}
		}

		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}

	private static void printSortCountNoDupsByField(ArrayList<Student> list,
			String field) {
		Map<String, Integer> map = new TreeMap<String, Integer>();

		for (Student student : list) {

			String string = "";

			switch (field) {
			case "name":
				string = student.getName();
				break;

			case "grade":
				string = "" + student.getGrade();
				break;
			}

			Integer count = map.get(string);
			if (count == null) {
				map.put(string, 1);
			} else {
				map.put(string, count + 1);
			}
		}

		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}

	private static void printNoDupsByField(ArrayList<Student> list, String field) {
		Set<String> set = new HashSet<String>();

		for (Student student : list) {

			switch (field) {
			case "name":
				set.add(student.getName());
				break;

			case "grade":
				set.add("" + student.getGrade());
				break;
			}

		}

		for (String string : set) {
			System.out.println(string);
		}

	}

	private static void printSortedNoDupsByField(ArrayList<Student> list,
			String field) {
		Set<String> set = new TreeSet<String>();

		for (Student student : list) {

			switch (field) {
			case "name":
				set.add(student.getName());
				break;

			case "grade":
				set.add("" + student.getGrade());
				break;
			}

		}
		for (String string : set) {
			System.out.println(string);
		}
	}

	public static ArrayList<Student> readStudents()
			throws FileNotFoundException {
		Scanner s = new Scanner(new File("students.txt"));

		ArrayList<Student> list = new ArrayList<Student>();

		while (s.hasNext()) {
			String line = s.nextLine();

			list.add(new Student(line));

		}
		s.close();
		return list;
	}

}
