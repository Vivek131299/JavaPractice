public class MainVipPerson {

    public static void main(String[] args) {

        VipPerson vipPerson1 = new VipPerson();
        System.out.println(vipPerson1.getName());

        VipPerson vipPerson2 = new VipPerson("Bob", 25000);
        System.out.println(vipPerson2.getName());

        VipPerson vipPerson3 = new VipPerson("Tim", 40000, "tim@gmail.com");
        System.out.println(vipPerson3.getName());
    }
}
