package ua.myhome.camera.viewer;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import java.lang.String;

public class CameraViewBoard extends JFrame {

    String cam1 = "rtsp://operator:0perat0r@172.22.22.18:554/cam/realmonitor?channel=1&subtype=0";
    String cam2 = "rtsp://operator:0perat0r@172.22.22.19:554/cam/realmonitor?channel=1&subtype=0";
    String cam3 = "rtsp://operator:0perat0r@172.22.22.20:554/cam/realmonitor?channel=1&subtype=0";

    public CameraViewBoard(java.util.List<String> resources) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Cameras"));
        setContentPane(panel);

        panel.setLayout(new GridLayout(2, 2, 3,3));

        EmbeddedMediaPlayerComponent camera1 = new EmbeddedMediaPlayerComponent();
        EmbeddedMediaPlayerComponent camera2 = new EmbeddedMediaPlayerComponent();
        EmbeddedMediaPlayerComponent camera3 = new EmbeddedMediaPlayerComponent();

        JPanel p1 = new JPanel(new BorderLayout());
        p1.setBorder(BorderFactory.createTitledBorder("cam1"));
        add(p1);
        JPanel p2 = new JPanel(new BorderLayout());
        p2.setBorder(BorderFactory.createTitledBorder("cam2"));
        add(p2);
        JPanel p3 = new JPanel(new BorderLayout());
        p3.setBorder(BorderFactory.createTitledBorder("cam3"));
        add(p3);

//        add(new JPanel()); // dummy, for alignment purpose only
//        add(new JPanel()); // dummy, for alignment purpose only
//        add(new JPanel()); // dummy, for alignment purpose only

        p1.add(camera1, BorderLayout.CENTER);
        JPanel cam1ControlPanel= new JPanel();
        FlowLayout cam1Layout = new FlowLayout(FlowLayout.CENTER, 3, 3);
        cam1Layout.layoutContainer(cam1ControlPanel);
        cam1ControlPanel.add(new Button("Stream Info"));
        cam1ControlPanel.add(new Button("Record Cam1"));
        cam1ControlPanel.add(new Button("Storage Path"));
        p1.add(cam1ControlPanel, BorderLayout.PAGE_END);

        p2.add(camera2, BorderLayout.CENTER);
        JPanel cam2ControlPanel= new JPanel();
        FlowLayout cam2Layout = new FlowLayout(FlowLayout.CENTER, 3, 3);
        cam2Layout.layoutContainer(cam1ControlPanel);
        cam2ControlPanel.add(new Button("Stream Info"));
        cam2ControlPanel.add(new Button("Record Cam2"));
        cam2ControlPanel.add(new Button("Storage Path"));
        p2.add(cam2ControlPanel, BorderLayout.PAGE_END);

        p3.add(camera3, BorderLayout.CENTER);
        JPanel cam3ControlPanel= new JPanel();
        FlowLayout cam3Layout = new FlowLayout(FlowLayout.CENTER, 3, 3);
        cam3Layout.layoutContainer(cam1ControlPanel);
        cam3ControlPanel.add(new Button("Stream Info"));
        cam3ControlPanel.add(new Button("Record Cam3"));
        cam3ControlPanel.add(new Button("Storage Path"));
        p3.add(cam3ControlPanel, BorderLayout.PAGE_END);

        setSize(1024, 730);
        setVisible(true);

        camera1.mediaPlayer().media().play(cam1);
        camera2.mediaPlayer().media().play(cam2);
        camera3.mediaPlayer().media().play(cam3);
    }
}
