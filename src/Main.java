import classes.Employee;

import java.lang.reflect.Field;
import java.util.*;

public class Main {
    public static List<Employee> employeeList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static final String SURNAME = "фамилию";
    public static final String NAME = "имя";
    public static final String AGE = "возраст";
    public static final String SEX = "пол";
    public static final String GRADE = "образование";
    public static final String POSITION = "должность";
    public static final String DEPARTMENT = "отдел";
    public static final String[] FIELDS = {SURNAME, NAME, AGE, SEX, GRADE, POSITION, DEPARTMENT};

    public static void main(String[] args) {
        makeEmployeesList();
    }

    public static void makeEmployeesList() {
        while (true) {
            System.out.println("Нажмите Enter, чтобы ввести информацию о сотруднике или 'end', чтобы закончить");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                showEmployeesList();
                break;
            }
            employeeList.add(getEmployee());
        }
    }

    public static Employee getEmployee() {
        String[] employeeData = new String[FIELDS.length];
        for (int i = 0; i < FIELDS.length; i++) {
            System.out.println("Введите " + FIELDS[i] + " сотрудника");
            String input = scanner.nextLine();
            employeeData[i] = input;
        }
        return makeEmployee(employeeData);
    }

    public static Employee makeEmployee(String[] data) {
        String surname = data[0];
        String name = data[1];
        String age = data[2];
        String sex = data[3];
        String grade = data[4];
        String position = data[5];
        String department = data[6];
        return new Employee(surname, name, age, sex, grade, position, department);
    }

    public static void showEmployeesList() {
        editEmployee();
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println(i + 1 + ": " + employeeList.get(i).toString());
        }
    }

    public static void editEmployee() {
        while (true) {
            System.out.println("Нажмите Enter для изменения данных или 'end' для завершения");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            System.out.println("Введите фамилию и имя работника через Enter, для которого хотите изменить данные");
            String surname = scanner.next();
            String name = scanner.next();

            int empIndex = searchBySurname(surname, name);
            if (empIndex != -1) {
                editEmployeeField(empIndex);
            } else {
                System.out.println("Сотрудник не найден, повторите ввод");
            }
        }
    }

    public static int searchBySurname(String surname, String name) {
        int index = -1;
        for (int i = 0; i < employeeList.size(); i++) {
            Employee emp = employeeList.get(i);
            if (emp.getName().equals(name) && emp.getSurname().equals(surname)) {
                index = i;
            }
        }
        return index;
    }

    public static void editEmployeeField(int index) {
        String input = scanner.nextLine();
        Employee employee = employeeList.get(index);
        Field fieldlist[] = employee.getClass().getDeclaredFields();
        for (Field field : fieldlist) {
            System.out.println("Меняем " + field.getName() + "?");
            input = scanner.nextLine();
            if ("да".equals(input)) {
                System.out.println("Введите новое значение");
                String newVal = scanner.nextLine();
                switch (field.getName()) {
                    case "surname":
                        employee.setSurname(newVal);
                        break;
                    case "name":
                        employee.setName(newVal);
                        break;
                    case "age":
                        employee.setAge(newVal);
                        break;
                    case "sex":
                        employee.setSex(newVal);
                        break;
                    case "position":
                        employee.setPosition(newVal);
                        break;
                    case "grade":
                        employee.setGrade(newVal);
                        break;
                    case "department":
                        employee.setDepartment(newVal);
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println("Данные изменены, новые данные: " + employee.toString());
    }
}
