package builder.model;

import java.util.List;

public class Student {

    private String name;
    private int age;
    private List<String> language;

    public static class StudentBuilder {

        private String name;
        private int age;
        private List<String> language;

        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder age(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder language(List<String> language) {
            this.language = language;
            return this;
        }

        public Student build() {
            return new Student(this);
        }


        
    }

    private Student(StudentBuilder builder) {
        name = builder.name;
        age = builder.age;
        language = builder.language;
    }

    
    public Student () {
    	
    }

    
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", language=" + language +
                '}';
    }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public List<String> getLanguage() {
		return language;
	}


	public void setLanguage(List<String> language) {
		this.language = language;
	}



}