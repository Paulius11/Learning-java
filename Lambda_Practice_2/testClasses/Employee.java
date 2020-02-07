package testClasses;

public class Employee {
    private int price;

    public Employee(int price) {
        this.price = price;
    }

    public int getSalary() {
        return price;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "price=" + price +
                '}';
    }
}
