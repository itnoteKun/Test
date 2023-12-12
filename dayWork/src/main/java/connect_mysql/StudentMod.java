package connect_mysql;

public class StudentMod {
    private int s_id;
    protected String s_name;
    private String s_sex;
    private String s_birthday;
    private int s_class;
    public StudentMod(){

    }
    public StudentMod(int s_id,String s_name,String s_sex,String s_birthday,int s_class){
        super();
        this.s_id=s_id;
        this.s_name=s_name;
        this.s_sex=s_sex;
        this.s_birthday=s_birthday;
        this.s_class=s_class;
    }
    public String getS_sex() {
        return s_sex;
    }

    public int getS_id() {
        return s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public int getS_class() {
        return s_class;
    }

    public String getS_birthday() {
        return s_birthday;
    }

    public void setS_birthday(String s_birthday) {
        this.s_birthday = s_birthday;
    }

    public void setS_class(int s_class) {
        this.s_class = s_class;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    @Override
    public String toString() {
        return
                s_id +
                ", s_name='" + s_name + '\'' +
                ", s_sex='" + s_sex + '\'' +
                ", s_birthday='" + s_birthday + '\'' +
                ", s_class=" + s_class
                ;
    }
}
