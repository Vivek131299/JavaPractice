public class MobilePhone2 implements ITelephone {

    private int myNumber;
    private boolean isRinging;
    private boolean isOn = false;

    public MobilePhone2(int myNumber) {
        this.myNumber = myNumber;
    }

    // We have to implement below methods because we have implemented ITelephone Interface in which all these methods are
    // declared. If we don't implement them here, we will get an error.
    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("Mobile Phone powered on");
    }

    @Override
    public void dial(int phoneNumber) {
        if (isOn) {
            System.out.println("Now ringing "  + phoneNumber + " on mobile phone");
        } else {
            System.out.println("Mobile phone is switched off");
        }
    }

    @Override
    public void answer() {
        if (isRinging) {
            System.out.println("Answering the mobile phone");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (phoneNumber == myNumber && isOn) {
            isRinging = true;
            System.out.println("Melody Ring");
        } else {
            isRinging = false;
            System.out.println("Mobile phone not on or number is different");
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}

