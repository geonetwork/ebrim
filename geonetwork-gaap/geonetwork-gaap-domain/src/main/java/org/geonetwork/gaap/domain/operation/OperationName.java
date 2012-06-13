package org.geonetwork.gaap.domain.operation;

/**
 * Enum with names for default operations
 *
 */
public enum OperationName {
    VIEW("view"), DOWNLOAD("download"), EDITING("editing"),
    NOTIFY("notify"), DYNAMIC("dynamic"), FEATURED("featured");

    String name;

    OperationName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}