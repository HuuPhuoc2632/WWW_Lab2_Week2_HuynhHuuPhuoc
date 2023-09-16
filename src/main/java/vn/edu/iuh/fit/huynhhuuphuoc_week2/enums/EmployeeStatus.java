package vn.edu.iuh.fit.huynhhuuphuoc_week2.enums;

public enum EmployeeStatus {
    TERMINATED(-1),
    ACTIVE(0),
    IN_ACTIVE(1);
    private int value;

    EmployeeStatus(int value) {
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
