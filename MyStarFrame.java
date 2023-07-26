import javax.swing.JFrame;

public class MyStarFrame extends JFrame{

    private SnowPanel panel;

    public void addPanel(){
        panel=new SnowPanel();
        this.add(panel);
        panel.startSnow();
    }

    public void showMe(){
        this.setSize(728,455);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("snowing");
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MyStarFrame frame = new MyStarFrame();
        frame.addPanel();
        frame.showMe();
    }
}