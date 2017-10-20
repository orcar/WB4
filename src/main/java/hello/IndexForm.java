package hello;

import java.util.Date;


public class IndexForm{

    private int number;
	private String animal;
    private String nation;
    
    private Date receivedtime ; 
    private int id;

    public Date getReceivedtime() {
		return receivedtime;
	}

	public void setReceivedtime(Date receivedtime) {
		this.receivedtime = receivedtime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    public String getAnimal() {
    	return animal;
    }
    
    public void setAnimal(String animal) {
    	this.animal = animal;
    }
    
    public String getNation() {
    	return nation;
    }
    
    public void setNation(String nation) {
    	this.nation = nation;
    }
    
    @Override
	public String toString() {
		return "IndexForm [number=" + number + ", animal=" + animal
				+ ", nation=" + nation + ", receivedtime=" + receivedtime
				+ ", id=" + id + "]";
	}
}