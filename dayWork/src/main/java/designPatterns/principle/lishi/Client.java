package designPatterns.principle.lishi;

/**
 * @author csk
 * @date 2023/11/30 15:32
 */
public class Client {
    public static void main(String[] args) {
        Solider solider = new Solider();
        solider.setAbstractGun(new Rifle());
        solider.kill();

    }
}
