package put.io.patterns.implement;
import put.io.patterns.implement.SystemStateObserver;
public class USBDeviceObserver implements SystemStateObserver {

    private int lastDevices = 0;

    @Override
    public void update(SystemMonitor monitor){
        SystemState lastSystemState = monitor.getLastSystemState();

        // Inform if count of USB devices changes
        if (lastSystemState.getUsbDevices() != lastDevices){
            System.out.println("USB devices count changed!");
            lastDevices = lastSystemState.getUsbDevices();
        }
    }
}