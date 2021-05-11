public class Monitor {

    private String model;
    private String manufacturer;
    private int size;
    private Resolution nativeResolution; // This is called as COMPOSITION. Here, Resolution is a class and it is a part
                                         // of class Monitor, but class Monitor is not a part of the class Resolution.
                                         // Monitor Has-A Resolution.
                                         // Resolution is a component of a Monitor.

    public Monitor(String model, String manufacturer, int size, Resolution nativeResolution) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.size = size;
        this.nativeResolution = nativeResolution;
    }

    public void drawPixelAt(int x, int y, String color) {
        System.out.println("Drawing pixel at " + x + "," + y + " in colour " + color);
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getSize() {
        return size;
    }

    public Resolution getNativeResolution() {
        return nativeResolution;
    }
}
