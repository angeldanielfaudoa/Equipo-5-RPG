package rpg.gui;

import rpg.gui.labels.NameLabel;

import javax.swing.*;
import java.awt.*;

public class StartWindow extends JFrame {
    private JLabel titleLabel;
    private JPanel mainPanel;
    private JList list1;
    private JLabel file1Name;
    private JButton button1;

    private void createUIComponents() {

        mainPanel = new FilesPanel();
        titleLabel = new JLabel("Java RPG");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        file1Name = new NameLabel("");
        newFile1 = new NewFileButton(1, this);
        loadFile1 = new LoadFileButton(1, this);
        file2Name = new NameLabel("");
        newFile2 = new NewFileButton(2, this);
        loadFile2 = new LoadFileButton(2, this);
        file3Name = new NameLabel("");
        newFile3 = new NewFileButton(3, this);
        loadFile3 = new LoadFileButton(3, this);
        file4Name = new NameLabel("");
        newFile4 = new NewFileButton(4, this);
        loadFile4 = new LoadFileButton(4, this);
        file5Name = new NameLabel("");
        newFile5 = new NewFileButton(5, this);
        loadFile5 = new LoadFileButton(5, this);
    }
}
