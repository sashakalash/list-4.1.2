package classes;

public class Employee {
    private String name;
    private String surname;
    private String sex;
    private String age;
    private String grade;
    private String position;
    private String department;

    public Employee(String surname, String name, String age, String sex, String grade, String position, String department) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
        this.grade = grade;
        this.position = position;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Сотрудник\n" +
                "Имя: '" + name + "\',\n" +
                "Фамилия: '" + surname + "\',\n" +
                "Пол: '" + sex + "\',\n" +
                "Возвраст: " + age + "\n" +
                "Образование: '" + grade + "\',\n" +
                "Должность: '" + position + "\',\n" +
                "Отдел: '" + department + "\'\n";
    }
}
