public class MainEncapsulationChallenge {

    public static void main(String[] args) {

        Printer printer = new Printer(50, true);
        System.out.println("Initial page count = " + printer.getPagesPrinted());
        int pagesPrinted = printer.printPages(4);
        System.out.println("Pages printed was " + pagesPrinted + ", new total print count for printer = "
                + printer.getPagesPrinted());
        pagesPrinted = printer.printPages(2);
        System.out.println("Pages printed was " + pagesPrinted + ", new total print count for printer = "
                + printer.getPagesPrinted());

        System.out.println("*********** Printer 2 Below************");

        Printer printer2 = new Printer(50, false);
        System.out.println("Initial page count = " + printer2.getPagesPrinted());
        pagesPrinted = printer2.printPages(4);
        System.out.println("Pages printed was " + pagesPrinted + ", new total print count for printer = "
                + printer2.getPagesPrinted());
        pagesPrinted = printer2.printPages(2);
        System.out.println("Pages printed was " + pagesPrinted + ", new total print count for printer = "
                + printer2.getPagesPrinted());
    }
}
