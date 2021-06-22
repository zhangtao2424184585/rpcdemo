import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {
    public PeopleService get() {

        Object o = Proxy.newProxyInstance(PeopleService.class.getClassLoader(), new Class[]{PeopleService.class}, (Object poxy, Method method,Object[] args) -> {
            System.out.println("1111");
            return null;
        });
        return (PeopleService) o;

    }
}
