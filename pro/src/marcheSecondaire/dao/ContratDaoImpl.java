package marcheSecondaire.dao;

import java.util.List;

import marcheSecondaire.beans.Contrat;

public class ContratDaoImpl implements ContratDao {

private DaoFactory daoFactory;
	
	public ContratDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<Contrat> lister() {
		// TODO Auto-generated method stub
		return null;
	}
}