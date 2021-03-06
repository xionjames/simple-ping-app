package dev.xionjames.gnip.check;

import dev.xionjames.gnip.check.checker.HostChecker;

/**
 * Controls delay and execution for one specific checking type
 */
public class Control extends Thread {
    private Class checkerClass;
    private String host;

    public Control(Class checkerClass, String host) {
        this.checkerClass = checkerClass;
        this.host = host;
    }

    @Override
    public void run() {
        HostChecker previous = null;
        
        while (true) {
            HostChecker checker = null;
            try {
                checker = (HostChecker) checkerClass.getConstructor(String.class).newInstance(host);
            } catch (Exception e) {
                return;
            }

            int delay = checker.getDelay();
            if (previous == null || !previous.isAlive()) {
                checker.start();
                previous = checker;
            }
            try {
                sleep(delay);
            } catch (InterruptedException e) {
            }
        }
    }
}