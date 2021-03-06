package de.fhb.dassystem.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.fhb.dassystem.db.entity.Gruppe;
import de.fhb.dassystem.db.entity.User;
import de.fhb.dassystem.db.entity.User_old;
import de.fhb.dassystem.db.entity.Vorlesung;
import de.fhb.dassystem.db.entity.VorlesungTeilnehmer;
import de.fhb.dassystem.db.entity.VorlesungWochentag;
import de.fhb.dassystem.valueobject.gruppe.FreundEinladenIn;
import de.fhb.dassystem.valueobject.kurs.KursAnmeldenIn;
import de.fhb.dassystem.valueobject.raum.RauminfoIn;
import de.fhb.dassystem.valueobject.raum.Rauminformation;
import de.fhb.dassystem.valueobject.raum.TeilnehmerIn;

@Path("/dassystem")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IDasSystemRESTAccessor {

	@GET
	@Path("/hi")
	public User_old halloWelt();

	@GET
	@Path("/testuser")
	public List<User> getUser();

	@GET
	@Path("/gruppe/all")
	public List<Gruppe> getGroups();

	@POST
	@Path("/gruppe/user")
	public List<Gruppe> getGroups(User user);

	@POST
	@Path("/gruppe/add")
	public boolean addGroup(Gruppe gruppe);

	@POST
	@Path("/gruppe/update")
	public boolean updateGroup(FreundEinladenIn freundEinladenIn);

	@POST
	@Path("/gruppe/delete")
	boolean deleteGroup(Gruppe actGroup);

	@POST
	@Path("/login")
	public User_old login(User_old user);

	@POST
	@Path("/login2")
	public User login2(User user);

	@POST
	@Path("/register")
	public boolean register(User user);

	@GET
	@Path("/vorlesung/all")
	public List<VorlesungWochentag> getVorlesung();

	@GET
	@Path("/vorlesung/teilnehmer/all")
	public List<VorlesungTeilnehmer> getVorlesungsTeilnehmer();

	@POST
	@Path("/vorlesung/teilnehmer/anmelden")
	public Rauminformation anKursAnmelden(KursAnmeldenIn kIn);

	@GET
	@Path("/vorlesung/{dozentid}")
	public List<Vorlesung> getVorlesungByDozent(
			@PathParam("dozentid") int dozentid);

	@POST
	@Path("/rauminfo/")
	public Rauminformation getRauminformation(RauminfoIn rIn);

	@GET
	@Path("/rauminfo/test")
	public Rauminformation getRauminformation();

	// public List<VorlesungWochentag> getVorlesung();

	@POST
	@Path("/vorlesung/update")
	public Boolean updateVorlesungCode(Vorlesung vorlesung);

	@POST
	@Path("/vorlesung/teilnehmer")
	public List<User> getVorlesungTeilnehmer(TeilnehmerIn tin);

	@GET
	@Path("/vorlesung/teilnehmer/test")
	public List<User> getVorlesungTeilnehmerTest();

	@PUT
	public void updateLastLocationUser(User user); 
}
