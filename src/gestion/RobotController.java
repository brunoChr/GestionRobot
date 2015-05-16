package gestion;
/**
 * 
 */


/**
 * @author b.christol
 *
 */
public class RobotController {

	private RobotView _robotView;
	private RobotModel _robotModel;


	/**
	 * 
	 */
	public RobotController() {
		
		_robotModel = new RobotModel();
		_robotView = new RobotView(this);
	}

	
   public void start()
    {
	   _robotView.afficher(true);
    }
   
   public void quitter()
   {
	   _robotModel.fermerConnexion();
		System.exit(1);
   }
   
	
	public RobotView get_robotView() {
		return _robotView;
	}


}
