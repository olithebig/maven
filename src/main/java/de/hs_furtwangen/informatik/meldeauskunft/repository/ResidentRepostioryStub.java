package de.hs_furtwangen.informatik.meldeauskunft.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;

public class ResidentRepostioryStub implements ResidentRepository{

	public List<Resident> getResidents() {
		
List<Resident> speicher = new ArrayList<Resident>();
speicher.add(new Resident ("Harald","Schmickler","Strase1","Stadt1", new Date(22343)));
speicher.add(new Resident ("Harald","Schmickler","Strase1","Stadt1", new Date(22343)));
speicher.add(new Resident ("Urban","Priol","Strase2","Stadt2", new Date(22343)));
speicher.add(new Resident ("Markus","Lanz","Strase3","Stadt3", new Date(22343)));
return speicher;

	}

	
	
	
}
