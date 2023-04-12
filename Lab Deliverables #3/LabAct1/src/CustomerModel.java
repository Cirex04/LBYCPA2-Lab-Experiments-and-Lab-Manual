/**
 * @brief Model for Customers
 */

public class CustomerModel {
    /**
     * properties
     */
    private final int INITCASH = 10000;
    private int orderNum;
    private String accNum;
    private String accName;
    private char transType;
    private int transAmount;
    private int transTime;

    /**
     * constructors
     */
    public CustomerModel() {
    }

    public CustomerModel(int orderNum, String accNum, String accName, char transType, int transAmount, int transTime) {
        this.orderNum = orderNum;
        this.accNum = accNum;
        this.accName = accName;
        this.transType = transType;
        this.transAmount = transAmount;
        this.transTime = transTime;
    }

    /**
     * behaviors
     */
    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getINITCASH() {
        return INITCASH;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public char getTransType() {
        return transType;
    }

    public void setTransType(char transType) {
        this.transType = transType;
    }

    public int getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(int transAmount) {
        this.transAmount = transAmount;
    }

    public int getTransTime() {
        return transTime;
    }

    public void setTransTime(int transTime) {
        this.transTime = transTime;
    }

    @Override
    public String toString() {
        return getAccName();
    }
}
