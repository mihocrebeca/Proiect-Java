package org.ieti.MihocRebeca;

import org.ieti.MihocRebeca.ListSelectionListenerImpl;

import javax.swing.*;
import java.awt.*;

public class Table{

    private static final String[] COLUMN_NAMES = {
            "Nume",
            "Prenume",
            "Specializarea",
            "Nota",
            "Admis/Respins"
    };

    private static final Object[][] DATA = {
            {"Ionescu", "Darius", "TI", 5, "ADMIS"},
            {"Avram", "Miruna", "C", 9, "ADMIS"},
            {"Popescu", "Dan", "C", 4.5, "RESPINS"},
            {"Maris", "Ioana", "AIA", 10, "ADMIS"},
            {"Toma", "Anca", "TI", 3, "RESPINS"}
    };

    public static void main(String[] args) {

        JFrame container = new JFrame("Note examen matematica");
        JTable table = new JTable(DATA, COLUMN_NAMES);
        table.setCellSelectionEnabled(true);

        ListSelectionListenerImpl listSelectionListener = new ListSelectionListenerImpl(table);

        ListSelectionModel select = table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        select.addListSelectionListener(listSelectionListener);

        JScrollPane scrollPane = new JScrollPane(table);

        container.add(scrollPane);
        container.setLayout(new BorderLayout());
        container.add(table.getTableHeader(), BorderLayout.PAGE_START);
        container.add(table, BorderLayout.CENTER);
        container.setVisible(true);
        container.setSize(300, 400);
    }

}
