import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;
import org.easymock.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;
import de.hs_furtwangen.informatik.meldeauskunft.repository.ResidentRepository;
import de.hs_furtwangen.informatik.meldeauskunft.repository.ResidentRepostioryStub;
import de.hs_furtwangen.informatik.meldeauskunft.service.BaseResidentService;
import de.hs_furtwangen.informatik.meldeauskunft.service.ResidentServiceException;
public class ResidentTest {
	
	
	@Test(expected = ResidentServiceException.class)
	public void uniqueTest() throws ResidentServiceException
	{
		
		BaseResidentService base = new BaseResidentService();
		base.setResidentRepository(new ResidentRepostioryStub());
		
		Resident res = new Resident ("Harald","Schmickler","Strase1","Stadt1", new Date());
		
		base.getUniqueResident(res);
		
		
	}
	
	@Test
	public void uniqueTest2() throws ResidentServiceException
	{
		
		
		BaseResidentService base = new BaseResidentService();

		base.setResidentRepository(new ResidentRepostioryStub());
		
		Resident res = new Resident ("Urban","Priol","Strase2","Stadt2", new Date(22343));
		
			
			Resident erg = base.getUniqueResident(res);
		
		assertTrue(res.getFamilyName().equals(erg.getFamilyName()));
	}
	
	
	
	
	@Test(expected= ResidentServiceException.class)
	public void uniqueTest3() throws ResidentServiceException
	{
	BaseResidentService base = new BaseResidentService();
	base.setResidentRepository(new ResidentRepostioryStub());
	
	Resident res = new Resident ("H*","Schckler","Strase1","Stadt1",new Date(22343));
	
	base.getUniqueResident(res);
	}
	
	@Test public void multtest1()
	{
		BaseResidentService base = new BaseResidentService();
		base.setResidentRepository(new ResidentRepostioryStub());
		
		Resident res = new Resident("Harald","Schmickler","Strase1","Stadt1", new Date(22343));
		
		List<Resident> list = base.getFilteredResidentsList(res);
		
		assertTrue(list.size()==2);
		
	}
	
	@Test 
	public  void multtest2()
	{
		BaseResidentService base = new BaseResidentService();
		base.setResidentRepository(new ResidentRepostioryStub());
		
		Resident res = new Resident("Ur*","Pr*","St*", "", null);
		
		List<Resident> lis = base.getFilteredResidentsList(res);
		assertTrue(lis.get(0).getGivenName().equals("Urban"));
	}
	
	
	@Test
	public void multtest3()
	{
		List<Resident> speicher = new ArrayList<Resident>();
		speicher.add(new Resident ("Harald","Schmickler","Strase1","Stadt1", new Date(22343)));
		speicher.add(new Resident ("Harald","Schmickler","Strase1","Stadt1", new Date(22343)));
		speicher.add(new Resident ("Urban","Priol","Strase2","Stadt2", new Date(22343)));
		speicher.add(new Resident ("Markus","Lanz","Strase3","Stadt3", new Date(22343)));
		
		ResidentRepository Resi = createMock(ResidentRepository.class);
		BaseResidentService base = new BaseResidentService();
		base.setResidentRepository(Resi);
		expect(Resi.getResidents()).andReturn(speicher);
		
		replay(Resi);
		List<Resident> list= base.getFilteredResidentsList(new Resident ("Harald","Schmickler","Strase1","Stadt1", new Date(22343)));
		verify(Resi);
		
	}
	
	
	

}
