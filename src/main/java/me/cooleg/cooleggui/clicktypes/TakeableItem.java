package me.cooleg.cooleggui.clicktypes;

public class TakeableItem extends ButtonType {

    public TakeableItem(ButtonType type) {
        super(type.getItem(), (type::buttonPress));
    }

    @Override
    public boolean isTakeable() {
        return true;
    }
}
