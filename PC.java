public class PC {

    // Here, we are again using Composition.
    // We are creating a class PC which HAS-A Case, Monitor, Motherboard.
    // We can't do this by 'extends' keyword because in Java we can only extend from
    // one class.
    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp() {
        theCase.pressPowerButton(); // We can also access by the getter like: getTheCase().pressPowerButton. But we
                                    // can do it directly. So, no need of getters.
        drawLogo();
    }

    private void drawLogo() {
        // Fancy graphics
        monitor.drawPixelAt(1200, 50, "yellow");
    }

    // Commented the getters below because we are not giving the access to another
    // class to get the values from get methods. Instead, we are creating another
    // method 'powerUp()' as public to accessed by another class as defined above.
    // So we dont need getters now.
    /*
     * public Case getTheCase() { return theCase; }
     * 
     * public Monitor getMonitor() { return monitor; }
     * 
     * public Motherboard getMotherboard() { return motherboard; }
     */
}
