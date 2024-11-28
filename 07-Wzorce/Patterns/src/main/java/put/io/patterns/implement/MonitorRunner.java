package put.io.patterns.implement;

public class MonitorRunner {

    public static void main(String args[]){
        // tworzymy monitor
        SystemMonitor monitor = new SystemMonitor();

        // tworzymy obserwatorów i dodajemy do monitora
        SystemStateObserver infObserver =  new SystemInfoObserver();
        SystemStateObserver coolerObserver =  new SystemGarbageCollectorObserver();
        SystemStateObserver usbObserver =  new SystemCoolerObserver();
        SystemStateObserver garbageObserver =  new USBDeviceObserver();
        
        monitor.addSystemStateObserver(infObserver);
        monitor.addSystemStateObserver(coolerObserver);
        monitor.addSystemStateObserver(usbObserver);
        monitor.addSystemStateObserver(garbageObserver);

        while (true) {
            monitor.probe();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
