package encapsulation;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class Person {
	
	private String name, email;
	
	private Date birthday;
	
	private char gender;
	
	private void checkName(String name) throws IllegalArgumentException {
		
		if(!name.matches("[a-zA-Z]{2,}\\s[a-zA-Z]{2,}")) throw new IllegalArgumentException("name");
		
	}
	
	private void checkEmail(String email) throws IllegalArgumentException {
		System.out.println(email);
		if(!Pattern.matches("[a-z]{2,}\\.[a-z]{2,}@[a-z0-9]{1,}\\.[a-z]{2}", email)) throw new IllegalArgumentException("email");
		List<String> validDomains = Arrays.asList("ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw");
		String[] parts = name.split(" ");
		String fname = parts[0].toLowerCase();
		String lname = parts[1].toLowerCase();
		String[] eparts = email.split("@");
		String[] ename = eparts[0].split("\\.");
		String[] domain = eparts[1].split("\\.");
		/*
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(ename[0]);
		System.out.println(ename[1]);
		System.out.println(domain[0]);
		System.out.println(domain[1]);
		System.out.println(fname.equals(ename[0]));
		System.out.println(lname.equals(ename[1]));
		System.out.println("//////////////////////");
		*/
		if(!fname.equals(ename[0])) {
		throw new IllegalArgumentException("Invalid email firstname");
		}
		if(!lname.equals(ename[1])) {
			throw new IllegalArgumentException("Invalid email lastname");
			}
		if(!validDomains.contains(domain[1])) {
			throw new IllegalArgumentException("Invalid email domain");
			}
		
		
	}
	
	public void setName(String input) {
		checkName(input);
		name = input;
	}
	
	public void setEmail(String input) {
		checkEmail(input);
		email = input;
	}
	
	public void setBirthday(Date input) throws IllegalArgumentException{
		Date d = new Date();
		if(input.after(d)) throw new IllegalArgumentException("lol");
		birthday = input;
	}
	public void setGender(char input) throws IllegalArgumentException{
		if(input != 'M' && input != 'F' && input != '\0') throw new IllegalArgumentException("gender");
		gender = input;
	}
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public char getGender() {
		return gender;
	}
	public static void main(String[] args) {
		Person a = new Person();
		a.setName("Espen Askeladd");
		a.setEmail("espen.askeladd@eventyr");
	}
	
}
