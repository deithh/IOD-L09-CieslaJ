package put.io.patterns.implement;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

public class SystemInfoObserver implements SystemStateObserver {

    @Override
    public void update(SystemMonitor monitor){
        SystemState lastSystemState = monitor.getLastSystemState();
        // Print information to the console
        System.out.println("============================================");
        System.out.println(String.format("CPU Load: %2.2f%%", lastSystemState.getCpu()));
        System.out.println(String.format("CPU temperature: %.2f C", lastSystemState.getCpuTemp()));
        System.out.println(String.format("Available memory: %.2f MB", lastSystemState.getAvailableMemory()));
        System.out.println(String.format("USB devices: %d", lastSystemState.getUsbDevices()));
    }
}
