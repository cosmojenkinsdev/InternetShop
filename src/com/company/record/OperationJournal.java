package com.company.record;

import java.util.ArrayList;
import java.util.List;

public final class OperationJournal {
    private static final List<OperationRecord> records = new ArrayList<>();

    private OperationJournal() {
    }

    public static void addRecord(OperationRecord record) {
        if (record == null) {
            throw new IllegalArgumentException("OperationRecord не должен быть null");
        }
        records.add(record);
    }

    private static List<OperationRecord> getRecords() {
        return List.copyOf(records);
    }

    public static void printHistory() {
        if (getRecords().isEmpty()) {
            System.out.println("История операций пуста");
            return;
        }
        System.out.println("===== ОБЩАЯ ИСТОРИЯ ОПЕРАЦИЙ =====");
        for (OperationRecord record : getRecords()) {
            System.out.println(record);
        }
        System.out.println("==================================");
    }
}