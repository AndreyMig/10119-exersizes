import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ConsoleView implements IView {

	private ArrayList<ActionListener> listeners = new ArrayList<ActionListener>();
	private String[] args;

	@Override
	public void init() {
		welcomeMessage();
		String option = getOption();
		Scanner s = new Scanner(System.in);
		while (option.compareToIgnoreCase(Controller.END_EVENT)) {
			String[] args = option.split(" ");
			proccessEvent(this, args);
		}
		s.close();
	}

	private void proccessEvent(String[] args) {
		this.args = new String[args.length - 1];
		for (int i = 1; i < args.length; i++) {
			this.args[i - 1] = args[i];
		}

		for (ActionListener listener : listeners) {
			listener.actionPerformed(new ActionEvent(this, -1, args[0]));
		}
	}

	private void welcomeMessage() {
		System.out.println("Hello, Please choose an option:");
		System.out.println("1. load students - "
				+ Controller.LOAD_STUDENTS_EVENT);
		System.out.println("2. print no duplicates by field"
				+ Controller.NO_DUPS_BY_FIELD_EVENT);
		System.out.println("3. print sorted no duplicates by field"
				+ Controller.SORT_NO_DUPS_BY_FIELD_EVENT);
		System.out.println("4. print reverse" + Controller.REVERSE_EVENT);
		System.out.println("5. print count no duplicates by field"
				+ Controller.COUNT_NO_DUPS_BY_FIELD_EVENT);
		System.out.println("6. print sorted count no duplicates by field"
				+ Controller.SORT_COUNT_NO_DUPS_BY_FIELD_EVENT);
		System.out
				.println("7. print sort string length count no duplicates by field"
						+ Controller.STRING_LEN_NO_DUPS_BY_FIELD_EVENT);
		System.out
				.println("8. count by occurences and sort by count no dups with order on a field"
						+ Controller.SORT_NO_DUPS_BY_FIELD_EVENT);
		System.out.println("9. print count of identical students"
				+ Controller.COUNT_IDENTICAL_STUDENTS_EVENT);
		System.out.println("10. print sort by count of identical students"
				+ Controller.SORT_BY_COUNT_IDENTICAL_STUDENTS_EVENT);

	}

	@Override
	public void registerListener(ActionListener listener) {
		this.listeners.add(listener);

	}

	@Override
	public void selectionMade(String option) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showData() {
		// TODO Auto-generated method stub

	}

}
