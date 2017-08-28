import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

public class Controller implements ActionListener {

	public final static String LOAD_STUDENTS_EVENT = "1";

	public static final String MODEL_LOADED_STUDENTS_EVENT = "llllll";
	
	private ArrayList<IView> views = new ArrayList<IView>();
	private AlgorithemHandler model;

	public Controller(AlgorithemHandler model) {
		this.model = model;
		model.registerListener(this);
	}
	
	
	public void addView(IView view) {
		this.views.add(view);
		view.registerListener(this);
		view.init();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case LOAD_STUDENTS_EVENT:
			
			try {
				this.model.readStudents();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			break;
			
	case MODEL_LOADED_STUDENTS_EVENT:
			Collection c = this.model.getCurrentCollection();
			for (IView iView : views) {
				iView.showCollection(c);
			}
			
			break;
			
			
			default: 
				System.out.println(e.getActionCommand() + " NOT SUPPORTED ");
				break;
			
		}

	}

}
