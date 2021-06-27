package ch.zhaw.springboot.models;



public class ExpertRequest {

		public String name;
		public String about;
		public String email;
		public String phone;
		
		public ExpertRequest(String name, String about, String email, String phone) {
			this.name = name;
			this.about = about;
			this.email = email;
			this.phone = phone;
		}
		

}
