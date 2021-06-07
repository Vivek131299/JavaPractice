
/*private*/public class PrivateClass { // Here, we can't define a private class because we can't have private class
    // at the top level of the file. Fro more see comments below.

    // TOP LEVEL
    // Only classes, interfaces and enums can exist at top level, everything else must be included within one of these.
    //
    // public: the object is visible to all classes everywhere, whether they are in the same package or have imported
    //         the package containing the public class.
    //
    // Package-private: the object is only available within its own package (and is visible to every class within the same
    //                  package). Package-private is specified by not specifying, i.e. it is the default if we do not specify public.
    //                  There is not a "package-private" keyword. For e.g. "class PackagePrivateClass {}" is a package-private class
    //                  as we are not using public keyword here as we do always. Same for interface: "interface PackagePrivateInterface {}".

    // MEMBER LEVEL
    //
    // public: at the member level, public has the same meaning as at the top level. A public class member (or field) and
    //         public method can be accessed from any other class anywhere, even in a different package.
    //
    // Package-private: this also has the same meaning as it does at the top level. An object with no access modifier is
    //                  visible to every class within the same package (but not to classes in external packages.
    //
    // private: the object is only visible within the class it is declared. It is not visible anywhere else (including
    //          in subclass of its class).
    //
    // protected: the object is visible anywhere in its own package (like package-private) but also in subclasses even if
    //            they are in another package.

    public PrivateClass() {
    }
}
