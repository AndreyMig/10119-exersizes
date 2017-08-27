import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller implements ActionListener {

	public final static String OPTION_CHOSEN_EVENT = "VIEW_OPTION_CHOSEN_EVENT";

	public static final String ACTION_PERFORMED_EVENT = "ACTION_PERFORMED_EVENT";

	public static final String LOAD_STUDENTS_EVENT = "LOAD_STUDENTS_EVENT";

	public static final String NO_DUPS_BY_FIELD_EVENT = "NO_DUPS_BY_FIELD_EVENT";

	public static final String REVERSE_EVENT = "REVERSE_EVENT";

	public static final String COUNT_NO_DUPS_BY_FIELD_EVENT = "COUNT_NO_DUPS_BY_FIELD_EVENT";

	public static final String SORT_COUNT_NO_DUPS_BY_FIELD_EVENT = "SORT_COUNT_NO_DUPS_BY_FIELD_EVENT";

	public static final String SORT_NO_DUPS_BY_FIELD_EVENT = "SORT_NO_DUPS_BY_FIELD_EVENT";

	public static final String STRING_LEN_NO_DUPS_BY_FIELD_EVENT = "STRING_LEN_NO_DUPS_BY_FIELD_EVENT";

	public static final String COUNT_IDENTICAL_STUDENTS_EVENT = "COUNT_IDENTICAL_STUDENTS_EVENT";

	public static final String SORT_BY_COUNT_IDENTICAL_STUDENTS_EVENT = "SORT_BY_COUNT_IDENTICAL_STUDENTS_EVENT";

	public static final String END_EVENT = "END_EVENT";

	public static final String MODEL_UPDATED_EVENT = "MODEL_UPDATED_EVENT";

	private ArrayList<IView> views;
	private Model model;

	public Controller(Model model) {
		this.model = model;
		this.views = new ArrayList<IView>();
	}

	public void addView(IView view) {
		this.views.add(view);
		view.registerListener(this);
		view.init();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("controller actionPerformed: event = " + e.getActionCommand());

		switch (e.getActionCommand()) {
		case LOAD_STUDENTS_EVENT:
			loadStudentsEvent();
			break;
		case REVERSE_EVENT:
			reverseEvent((IView) e.getSource());
			break;
		case SORT_NO_DUPS_BY_FIELD_EVENT:
			sortNoDupsByFieldEvent((IView) e.getSource());
			break;
		case COUNT_NO_DUPS_BY_FIELD_EVENT:
			countNoDupsByFieldEvent((IView) e.getSource());
			break;

		case SORT_COUNT_NO_DUPS_BY_FIELD_EVENT:
			sortByCountNoDupsByFieldEvent((IView) e.getSource());
			break;

		case STRING_LEN_NO_DUPS_BY_FIELD_EVENT:
			sortByStringLengthNoDupsByFieldEvent((IView) e.getSource());
			break;

		case COUNT_IDENTICAL_STUDENTS_EVENT:
			countIdenticalStudentsEvent((IView) e.getSource());
			break;

		default:
			System.out.println(e.getActionCommand() + " NOT SUPPORTED");
			break;
		}
	}

	private void countIdenticalStudentsEvent(IView iView) {
		String[] args = iView.getArgs();
		this.model.printCountSameStudents();
	}

	private void sortByStringLengthNoDupsByFieldEvent(IView iView) {
		String[] args = iView.getArgs();
		this.model.printSortStringLengthCountNoDupsByField(args[0]);
	}

	private void sortByCountNoDupsByFieldEvent(IView iView) {
		String[] args = iView.getArgs();
		this.model.printSortCountNoDupsByField(args[0]);
	}

	private void countNoDupsByFieldEvent(IView iView) {
		String[] args = iView.getArgs();
		this.model.printCountNoDupsByField(args[0]);

	}

	private void sortNoDupsByFieldEvent(IView iView) {
		String[] args = iView.getArgs();
		this.model.printNoDupsByField(args[0]);

	}

	private void reverseEvent(IView iView) {
		String[] args = iView.getArgs();
		this.model.printReverse(args[0]);
	}

	private void loadStudentsEvent() {
		System.out.println("controller loadStudentsEvent: ");

		try {
			this.model.readStudents();
		} catch (FileNotFoundException e) {
			onErrorEvent(e);
		}

	}

	private void onErrorEvent(Exception e) {
		for (IView iView : views) {
			iView.onError(e);
		}
	}

}
