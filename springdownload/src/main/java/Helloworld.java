public class Helloworld {
    private String name;
    public void setName(String name){
        System.out.println("调用了设置属性");
        this.name=name;

    }
    public Helloworld(){
        System.out.println("初始化构造器");
    }
    public void hello(){
        System.out.println("Hello"+name);
    }
}
