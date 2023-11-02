package church.datamodel;

public class ChurchModel 
{
	String churchName;
	String churchAddress;
	String churchContact;
	String churchGameName;
	String GameDetails;
	String churchPrevPlay;
	String churchPrevDetails;
	String email;
	String phone;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	String website;
	public ChurchModel() {
		
	}
	public String getChurchName() {
		return churchName;
	}
	public void setChurchName(String churchName) {
		this.churchName = churchName;
	}
	public String getChurchAddress() {
		return churchAddress;
	}
	public void setChurchAddress(String churchAddress) {
		this.churchAddress = churchAddress;
	}
	
	public void setChurchContact(String churchContact) {
		this.churchContact = churchContact;
		String[] arr = churchContact.split("\\r?\\n|\\r");
		String[] ph = arr[1].split(":");
		String[] em = arr[1].split(":");
		if(ph.length>1 && ph[0].toLowerCase().contains("phone"))
			this.phone = ph[1];
		if(em.length>1 && em[0].toLowerCase().contains("phone"))
			this.email = em[1];
	}
	
	public String getChurchGameName() {
		return churchGameName;
	}
	public void setChurchGameName(String churchGameName) {
		this.churchGameName = churchGameName;
	}
	public String getGameDetails() {
		return GameDetails;
	}
	public void setGameDetails(String gameDetails) {
		GameDetails = gameDetails;
	}
	public String getChurchPrevPlay() {
		return churchPrevPlay;
	}
	public void setChurchPrevPlay(String churchPrevPlay) {
		this.churchPrevPlay = churchPrevPlay;
	}
	public String getChurchPrevDetails() {
		return churchPrevDetails;
	}
	public void setChurchPrevDetails(String churchPrevDetails) {
		this.churchPrevDetails = churchPrevDetails;
	}

}
