package br.gumn.application.control;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.gumn.application.bean.University;
import br.gumn.application.persistence.UniversityDAO;

/**
 * @author gert.muller
 *
 */
@ManagedBean
@SessionScoped
public class UniversityController {
	private University university;
	
	public DataModel<University> listUniversities() {
		return new ListDataModel<University>(new UniversityDAO().list());
	}
}
