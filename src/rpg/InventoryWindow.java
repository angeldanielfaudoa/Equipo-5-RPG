package rpg.inventory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import rpg.items.Item;

public class InventoryWindow extends JFrame {
    private JTable itemsTable;
    private DefaultTableModel tableModel;

    public InventoryWindow(List<Item> items) {
        // Configuración de la ventana
        this.setTitle("Inventario de Ítems");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Crear columnas de la tabla
        String[] columnNames = {"Nombre", "Descripción", "Precio", "Tipo"};

        // Crear modelo de tabla
        tableModel = new DefaultTableModel(columnNames, 0);
        itemsTable = new JTable(tableModel);

        // Agregar items a la tabla
        for (Item item : items) {
            Object[] rowData = {
                    item.getName(),
                    item.getDescription(),
                    item.getPrice(),
                    item.getItemType().name()  // Usamos .name() para mostrar el nombre del enum
            };
            tableModel.addRow(rowData);
        }

        // Agregar la tabla a un scroll pane
        JScrollPane scrollPane = new JScrollPane(itemsTable);
        this.add(scrollPane, BorderLayout.CENTER);

        // Hacer la ventana visible
        this.setVisible(true);
    }
}

