package de.hs_furtwangen.informatik.meldeauskunft.service;

import java.util.List;

import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;
import de.hs_furtwangen.informatik.meldeauskunft.repository.ResidentRepository;
import de.hs_furtwangen.informatik.meldeauskunft.repository.ResidentRepostioryStub;

public class ResidentServiceStub implements ResidentService{

	public Resident getUniqueResident(Resident filterResident) throws ResidentServiceException {
		ResidentRepository reside = new ResidentRepostioryStub();
		List<Resident> list = reside.getResidents();
		if(list.contains(filterResident))
			return filterResident;
		else 
			throw new ResidentServiceException("nicht gefunden");
		
	}

	public List<Resident> getFilteredResidentsList(Resident filterResident) {
		// TODO Auto-generated method stub
		return null;
	}

}
