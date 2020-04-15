package objectstructures;

import java.util.ArrayList;

public class Person {
	private String name;
	private char gender;
	private Person father, mother = null;
	private ArrayList<Person> children = new ArrayList<>();

	public Person(String name, char gender) {
		if(!(gender == 'M' || gender == 'F')) throw new IllegalArgumentException("kek");
		this.name = name;
		this.gender = gender;
	}



	public Person getFather() {
		return father;
	}



	public void setFather(Person father) {
		if(father == null) {
			if(this.father != null)
				this.father.removeChild(this);
			this.father = null;
		}
		else if(!father.equals(this) && father.getGender() == 'M' && !father.equals(this.father)) {
			if(this.father != null)
				this.father.removeChild(this);
			this.father = father;
			father.addChild(this);
		}
		else if(!father.equals(this.father))
			throw new IllegalArgumentException(" lll ");
	}





	public Person getMother() {
		return mother;
	}



	public void setMother(Person mother) {
		if(mother == null) {
			if(this.mother != null)
				this.mother.removeChild(this);
			this.mother = null;
		}
		else if(!mother.equals(this) && mother.getGender() == 'F' && !mother.equals(this.mother)) {
			if(this.mother != null)
				this.mother.removeChild(this);
			this.mother = mother;
			mother.addChild(this);
		}
		else if(!mother.equals(this.mother))
			throw new IllegalArgumentException(" mmm ");
	}



	public char getGender() {
		return gender;
	}



	public String getName() {
		return name;
	}



	public Person getChild(int n) {
		if(n<0 || n >= children.size()) throw new IllegalArgumentException("lol");
		return children.get(n);
	}

	public int getChildCount() {
		return children.size();
	}

	public void addChild(Person child) {
		if(child == null)
			throw new IllegalArgumentException("child add null");
		if(!children.contains(child)) {
			children.add(child);
			if(this.gender == 'M')
				child.setFather(this);
			else
				child.setMother(this);
		}
	}

	public void removeChild(Person child) {
		if(child == null)
			throw new IllegalArgumentException("child remove null");
		if(children.contains(child)) {
			children.remove(child);
			if(this.gender == 'M')
				child.setFather(null);
			else
				child.setMother(null);
		}
	}

	public static void main(String[] args) {
		Person mamma = new Person("AnneMette",'F');
		Person pappa = new Person("Ståle",'M');
		Person jørgen = new Person("Jørgen", 'M');
		Person ingrid = new Person("Ingrid", 'F');
		Person luna = new Person("Luna",'F');

		mamma.addChild(jørgen);
		pappa.addChild(jørgen);
		mamma.addChild(ingrid);
		pappa.addChild(ingrid);
		jørgen.addChild(luna);

	}

}
