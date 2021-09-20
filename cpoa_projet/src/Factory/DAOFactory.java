package Factory;

import DAO.ClientDAO;
import DAO.PeriodiciteDAO;

public abstract class DAOFactory {
	public static DAOFactory getDAOFacotry(Persistance cible) {
		DAOFactory daoF = null;
		
		switch(cible) {
		case MYSQL:
			daoF = new MYSQLDAOFactory();
			break;
		
		case ListeMemoire:
			daoF = new ListeMemoireDAOFactory();
		break;	
	}
		return daoF;

	}
	public abstract PeriodiciteDAO getPeriodciteDAO();
	public abstract ClientDAO getClientDAO();
}
