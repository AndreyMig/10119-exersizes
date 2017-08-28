import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;


public class AlgorithemHandler {

	
//	private ArrayList<Student> list;
	
	private Collection<Student> currentCollection;
	private ArrayList<ActionListener> listeners = new ArrayList<ActionListener>();

	public AlgorithemHandler() {
//		list  =new ArrayList<Student>();
	}
	
	public void readStudents()
			throws FileNotFoundException {
		Scanner s = new Scanner(new File("students.txt"));

		ArrayList<Student> list = new ArrayList<Student>();

		while (s.hasNext()) {
			String line = s.nextLine();

			list.add(new Student(line));

		}
		s.close();
		currentCollection = list;
		proccessEvent(Controller.MODEL_LOADED_STUDENTS_EVENT);
		
//		return list;
	}
	
	private void proccessEvent(String command) {

		for (ActionListener actionListener : listeners) {
			actionListener.actionPerformed(new ActionEvent(this, -1, command));
		}

	}
	
	public void registerListener(ActionListener listener) {
		this.listeners.add(listener);

	}

	public Collection<Student> getCurrentCollection() {
		// TODO Auto-generated method stub
		return currentCollection;
	}

}
