package com.shahenlibrary;

/**
 * Created by Shahen on 6/30/17.
 */

public enum SendEventTypes {
    EVENT_TOUCH("onTouch");

    private final String mName;

    SendEventTypes(final String name) {
        mName = name;
    }
    @Override
    public String toString() {
        return mName;
    }
}
