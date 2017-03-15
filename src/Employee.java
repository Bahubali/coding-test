/**
 * Created by bahubali.n on 14/03/17.
 */
public class Employee {
    int employeeId;
    int managerId;
    float rating;
    double bonusAmount;

    public Employee(int employeeId, int managerId, float rating) {
        this.employeeId = employeeId;
        this.managerId = managerId;
        this.rating = rating;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public double getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(double bonusAmount) {
        this.bonusAmount = bonusAmount;
    }
}
