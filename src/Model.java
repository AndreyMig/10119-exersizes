import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

public class Model {

	private ArrayList<Student> list;
	private ArrayList<ActionListener> listeners = new ArrayList<ActionListener>();
	private CollectionHolder collectionsHolder = new CollectionHolder();

	public Model() {
		list = new ArrayList<Student>();
	}

	public Map<Student, Integer> printCountSameStudents() {
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

	
	public Set getCountSameStudentsSet() {
		return collectionsHolder.sameStudentsSet;
	}
	
	public void sortCountSameStudents(Map<Student, Integer> map) {
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
			// System.out.println(studentDecorator);
			collectionsHolder.sameStudentsSet
					.add(studentDecorator.getStudent());
		}
		//
	}
	public Map<String, Integer> getSortedByStringLengthMap() {
		return collectionsHolder.stringLengthCountMap;
	}
	public void printSortStringLengthCountNoDupsByField(String field) {

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
			// System.out.println(entry.getKey() + " : " + entry.getValue());
			collectionsHolder.stringLengthCountMap.put(entry.getKey(),
					entry.getValue());
		}

	}
	public Map<String, Integer> getCountedByOccurencesMap() {
		return collectionsHolder.countOccurencesByOrderAndFieldMap;
	}
	public void printCountOccurencesSortByCount(ArrayList<Student> list,
			String field, int order) {

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
			// System.out.println(entry.getKey() + " : " + entry.getValue());
			collectionsHolder.countOccurencesByOrderAndFieldMap.put(
					entry.getKey(), entry.getValue());
		}

	}
	public List<Student> getReveresedList() {
		return collectionsHolder.reversedList;
	}
	public void printReverse(String field) {

		Stack<Student> stack = new Stack<Student>();

		for (Student student : list) {
			stack.push(student);
		}
		while (!stack.empty()) {
			// System.out.println(stack.pop());
			collectionsHolder.reversedList.add(stack.pop());
		}

	}

	public List<Student> getCountedByFieldNoDupsSet() {
		return collectionsHolder.reversedList;
	}
	public void createCountedNoDupsByField(String field) {
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
			// System.out.println(entry.getKey() + " : " + entry.getValue());
			collectionsHolder.noDupsByFieldCountMap.put(entry.getKey(),
					entry.getValue());
		}

	}
	public Map<String, Integer> getSortedByCountByFieldNoDupsSet() {
		return collectionsHolder.sortedNoDupsByFieldCountMap;
	}
	public void printSortCountNoDupsByField(String field) {
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
		collectionsHolder.sortedNoDupsByFieldCountMap = map;
//		for (Entry<String, Integer> entry : map.entrySet()) {
			// System.out.println(entry.getKey() + " : " + entry.getValue());
//			collectionsHolder.sortedNoDupsByFieldCountMap.put(entry.getKey(),
//					entry.getValue());
//		}

	}

	public void printNoDupsByField(String field) {
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
			// System.out.println(string);
			collectionsHolder.noDupsByFieldSet.add(string);
		}

	}

	public void printSortedNoDupsByField(ArrayList<Student> list, String field) {
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
		collectionsHolder.sortedNoDupsByFieldSet = set;
		proccessEvent(Controller.MODEL_UPDATED_EVENT);

	}

	public void readStudents() throws FileNotFoundException {
		Scanner s = null;

		s = new Scanner(new File("students.txt"));

		ArrayList<Student> list = new ArrayList<Student>();
		this.list = list;
		while (s.hasNext()) {
			String line = s.nextLine();

			list.add(new Student(line));

		}

		if (s != null) {
			s.close();
		}

		collectionsHolder.mainList = list;
		
		proccessEvent(Controller.MODEL_UPDATED_EVENT);
	}

	private void proccessEvent(String event) {
		System.out.println("model proccessEvent: ");

		for (ActionListener listener : listeners) {
			listener.actionPerformed(new ActionEvent(this, -1, event));
		}
	}

	public void registerListener(ActionListener listener) {
		this.listeners.add(listener);

	}

	class CollectionHolder {
		public Map<String, Integer> countOccurencesByOrderAndFieldMap = new HashMap<String, Integer>();
		public Map<String, Integer> stringLengthCountMap = new HashMap<String, Integer>();
		public Map<String, Integer> noDupsByFieldCountMap = new HashMap<String, Integer>();
		public Map<String, Integer> sortedNoDupsByFieldCountMap = new HashMap<String, Integer>();
		public ArrayList<Student> mainList = new ArrayList<Student>();
		public Set<Student> sameStudentsSet = new HashSet<Student>();
		public Set<String> sortedNoDupsByFieldSet = new HashSet<String>();
		public Set<String> noDupsByFieldSet = new HashSet<String>();
		public ArrayList<Student> reversedList = new ArrayList<Student>();
	
		
		
		

	}

}
