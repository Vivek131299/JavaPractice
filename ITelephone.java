/*
* Interfaces are nothing but the abstract classes, which has just method declarations and not body of the methods.
* Any class can implement an Interface by using 'implements' keyword just same as 'extends' keyword.
* Once class has implemented the interface, then we need to define (write body) of that all methods which are
* declared in that interface with (like overriding) with same name, return type and parameters.
* We cannot create object of interface. That's why Interfaces do not have constructor.
* It is used to achieve the security.
* As we know Java does not supports multiple inheritance (means a class in Java can only inherit from one superclass),
* but we can achieve this by using interfaces, because we can implement multiple interfaces in one class.
* Example for security will be as : if anyone is writing any class which contains telephone operations, then for
* avoiding any problems which can occur if he forgets to write any method or if he writes a method with incorrect
* parameters, then it will be problem. So, to avoid this, he can implement this 'ITelephone' interface, and now he
* will need to implement all the methods which are declared in interface with same return type, name, parameters.
*
* */

public interface ITelephone {

    public void powerOn();
    public void dial(int phoneNumber);
    public void answer();
    public boolean callPhone(int phoneNumber);
    public boolean isRinging();

    //We can remove 'public' access specifier. It is not necessary because we have to implement this methods
    // in different classes, so it doesn't makes any sense to keep access specifier as it should be available to
    // every class for overriding.
}
