package com.test.supportech.client;

import java.awt.EventQueue;

import com.test.supportech.frames.MainFrame;

public class DesktopClient {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
	}
}
