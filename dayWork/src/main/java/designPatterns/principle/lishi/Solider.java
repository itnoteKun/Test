package designPatterns.principle.lishi;

/**
 * @author csk
 * @date 2023/11/30 15:30
 */
public class Solider {
    private AbstractGun abstractGun;
    public void setAbstractGun(AbstractGun abstractGun){
        this.abstractGun=abstractGun;
    }

    public void kill(){
        abstractGun.shoot();
    }

}
