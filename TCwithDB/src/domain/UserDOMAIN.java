package domain;

public class UserDOMAIN {

	private int Cid;
	private String Nic;
	private String Name;
	
	public int getCid() {
		return Cid;
	}
	
	public void setCid(int cid) {
		Cid = cid;
	}
	
	public String getNic() {
		return Nic;
	}
	
	public boolean setNic(String nic) {
		boolean validate=true;
		int size =nic.length();
		if(size==10) {
			for(int index=0;index<size;index++) {
				char stringchar=nic.charAt(index);
				if (stringchar=='0'||stringchar=='1'||stringchar=='2'||stringchar=='3'||stringchar=='4'||stringchar=='5'||stringchar=='6'||stringchar=='7'||stringchar=='8'||stringchar=='9'||stringchar=='V') {		
				}
				else {
					validate=false;
					System.out.println("Wrong input");
					break;
				}
			}
		}
		else {
			validate= false;
		}
		if(validate) {
			this.Nic=nic;
		}
		return validate;
	}

	public boolean setName(String name) {
		boolean validate=true;
		if( name.matches( "[A-Z][a-z]*" )) {
					
		}
		else {
			validate=false;
		}
		if(validate) {
			this.Name=name;
		}
		return validate;
	}
	
	public UserDOMAIN() {
	
	}
	public String getName() {
		return Name;
	}

	
}
