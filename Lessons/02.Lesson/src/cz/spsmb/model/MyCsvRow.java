package cz.spsmb.model;

import cz.spsmb.scanner.CsvEntity;

import java.util.HashMap;
import java.util.Map;

@CsvEntity
public class MyCsvRow {
    private Map items;

    public MyCsvRow() {
        this.items = new HashMap();
    }

    public MyCsvRow(Map items) {
        this.items = items;
    }

    public Map getItems() {
        return items;
    }

    public void setItems(Map items) {
        this.items = items;
    }
}
