package ua.myhome.camera.viewer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;

public class CameraViewBoard extends JFrame {

    private static final String STREAM_INFO = "Stream Info";
    private static final String STORAGE_PATH = "Storage Path";

    public CameraViewBoard(PlayList resources) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Cameras"));
        setContentPane(panel);

        panel.setLayout(new GridLayout(2, 2, 3,3));

        List<String> cameras = new ArrayList<>(resources.getProperties());
        List<EmbeddedMediaPlayerComponent> players = new ArrayList<>(cameras.size());

        for (int i = 0; i < cameras.size(); i++) {
            String cameraId = cameras.get(i);
            players.add(i, new EmbeddedMediaPlayerComponent());

            JPanel jPanel = new JPanel(new BorderLayout());
            jPanel.setBorder(BorderFactory.createTitledBorder(cameraId));
            add(jPanel);

            jPanel.add(players.get(i), BorderLayout.CENTER);
            JPanel camControlPanel = new JPanel();
            FlowLayout cam1Layout = new FlowLayout(FlowLayout.CENTER, 3, 3);
            cam1Layout.layoutContainer(camControlPanel);
            camControlPanel.add(new JButton(STREAM_INFO));
            JToggleButton recordButton = new JToggleButton("Record " + cameraId);
            recordButton.addActionListener(new FFMpeg(cameraId, resources.getPropertyValue(cameraId)));
            camControlPanel.add(recordButton);
            camControlPanel.add(new JButton(STORAGE_PATH));
            jPanel.add(camControlPanel, BorderLayout.PAGE_END);
        }

        setSize(1024, 730);
        setVisible(true);

        for (int i = 0; i < cameras.size(); i++) {
            players.get(i).mediaPlayer().media().play(resources.getPropertyValue(cameras.get(i)));
        }
    }
}
