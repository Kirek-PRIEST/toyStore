package Store.actions;


import Store.operations.RemovingToy;

public class RemoveToy extends Actions {
    public RemoveToy(){
        this.operations = new RemovingToy();
    }
}
