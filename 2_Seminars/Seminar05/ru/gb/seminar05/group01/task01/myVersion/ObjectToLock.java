package ru.gb.seminar05.group01.task01.myVersion;

public class ObjectToLock {
    private ObjectToLock otherObject;

    public ObjectToLock getOtherObject() {
        return otherObject;
    }

    public void setOtherObject(ObjectToLock otherObject) {
        this.otherObject = otherObject;
    }

    public synchronized void call (ObjectToLock otherObject) {
        otherObject.call(this);
    }

}
