public class MainTelephone {

    public static void main(String[] args) {

        ITelephone timsPhone; // We can also do like: DeskPhone timsPhone;
        timsPhone = new DeskPhone(987654321);
        // Above, we can't do like this: ITelephone timsPhone = new ITelephone; If we do, we have to implement all
        // the methods declared in interface in this class as well. So, interface just tells that which methods we
        // should implement in the class(if we are implementing that interface).
        // Interface is at only abstract level.
        // We cannot create object of an Interface.

        // We are creating an object of class 'DeskPhone' because DeskPhone is a specific class for specific functionality
        // for a certain type of telephone.

        timsPhone.powerOn();
        timsPhone.callPhone(987654321);
        timsPhone.answer();


        // We can also do as below. It will be same as above. (Creating object of TYPE 'DeskPhone' class instead of
        // 'ITelephone' interface.
        DeskPhone deskPhone = new DeskPhone(123456789);

        deskPhone.powerOn();
        deskPhone.callPhone(123456789);
        deskPhone.answer();



        // Below code for executing 'MobilePhone2' class
        timsPhone = new MobilePhone2(8765432);
        timsPhone.powerOn();
        timsPhone.callPhone(8765432);
        timsPhone.answer();

        // Above, we are able to create new instance of MobilePhone2 class by using predefined 'timsPhone' variable beacuse,
        // 'timsPhone' is a type of 'ITelephone' Interface, and DeskPhone & MobilePhone2 are also implementing same interface
        // so we are able to create an new instance of these both classes by using same variable of type ITelephone Interface.

        // If above (on line 5), if we had done like this:  DeskPhone timsPhone;  , then we will unable to create an instance
        // of 'MobilePhone2' class here(on line 32) with same 'timsPhone' variable as it will be of type 'DeskPhone'.
    }
}
