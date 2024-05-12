package Store.actions;

import Store.actions.Actions;
import Store.operations.ValueChanging;

public class ValueChange extends Actions {
    public ValueChange(){
        this.operations = new ValueChanging();
    }
}
