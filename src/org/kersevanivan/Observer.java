package org.kersevanivan;

/**
 * <p>Title: Observer</p>
 * <p>Description: </p>
 * <p>$LastChangedRevision: $</p>
 * <p>$Id: $</p>
 * <p>$LastChangedDate: $</p>
 * <p>$HeadURL: $</p>
 *
 * @author ivan
 * @version 07.09.20 17:20
 */
public interface Observer {
    /**
     * Observers are called by a concrete subject when a value changes.
     * @param value - the new value.
     */
    public void update(String value);
}
