package org.kersevanivan;

/**
 * <p>Title: Subject</p>
 * <p>Description: </p>
 * <p>$LastChangedRevision: $</p>
 * <p>$Id: $</p>
 * <p>$LastChangedDate: $</p>
 * <p>$HeadURL: $</p>
 *
 * @author ivan
 * @version 07.09.20 17:20
 */
public interface Subject {
    /**
     * Calls all registered observers and submitts the new value.
     */
    public void callObservers();

    /**
     * Adds a observer, whose method update(String) will be called.
     * @param observer - some concrete observer.
     */
    public void register(Observer observer);
}
