package Store.actions;


import Store.operations.CountChanging;

public class CountChange extends Actions {
    public  CountChange(){
        this.operations = new CountChanging();
    }
}
