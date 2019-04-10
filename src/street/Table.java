package street;

import humans.Shorty;

public class Table {
    private Shorty customer;
    private boolean isEmpty;
    public Table(Shorty customer){
        if(customer != null) {
            this.customer = customer;
            isEmpty = false;
            customer.setTable(this);
        }else {
            isEmpty = true;
        }
    }
    public Table(){
        isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public Shorty getCustomer() {
        return customer;
    }

    public void setCustomers(Shorty customer) {
        if(customer != null) {
            this.customer = customer;
            isEmpty = false;
        }else {
            isEmpty = true;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
