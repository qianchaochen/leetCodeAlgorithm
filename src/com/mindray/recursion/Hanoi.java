import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;


public class Hanoi
{
    public static void main(String args[])
    {
        new MyFrame();
    }
}


class GamePanel extends Panel
{
    Stick[] sticks = new Stick[3];
    Button bt;
    GamePanel(int n)
    {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        sticks[0] = new Stick(n, Color.black);
        sticks[1] = new Stick(n, Color.red);
        sticks[2] = new Stick(n, Color.green);
        for (int i = n - 1; i >= 0; i--)
        {
            sticks[0].addDish(new Dish(i));
        }
        add(sticks[0]);
        add(Box.createHorizontalStrut(10));
        add(sticks[1]);
        add(Box.createHorizontalStrut(10));
        add(sticks[2]);
        validate();
    }
    public void paint(Graphics g)
    {
        g.drawRect(10, 20, 100, 110);
        sticks[0].repaint();
        sticks[1].repaint();
        sticks[2].repaint();
    }
    public void moveDish(int a, int b)
    {
        Dish dish = sticks[a].moveDish();
        sticks[b].addDish(dish);
        repaint();
    }
}


class MyFrame extends Frame implements ActionListener
{
    GamePanel panel;
    Button pre, next, init;
    TextField input;
    Label label;
    Panel menu;
    int a[][], n = 5, i = 0;
    public MyFrame()
    {
        super("汉诺塔");
        a = new int[(int)Math.pow(2, n)][2];
        panel = new GamePanel(n);
        pre = new Button("preview");
        next = new Button("next");
        init = new Button("初始化");
        label = new Label("盘子个数：");
        input = new TextField("5", 8);
        menu = new Panel();
        pre.addActionListener(this);
        next.addActionListener(this);
        init.addActionListener(this);
        menu.add(label);
        menu.add(input);
        menu.add(pre);
        menu.add(next);
        menu.add(init);


        add(panel, BorderLayout.CENTER);
        add(menu, BorderLayout.SOUTH);


        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });


        setBounds(300, 100, 800, 300);
        setVisible(true);
        validate();


        hanoi(n, 0, 1, 2);
        i = 0;


    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == init)
        {
            try
            {
                n = Integer.parseInt(input.getText());
            }
            catch (NumberFormatException ee)
            {
                JOptionPane.showMessageDialog(null, "输入错误 ");
                return;
            }
            remove(panel);
            panel = new GamePanel(n);
            add(panel, BorderLayout.CENTER);
            validate();
            a = new int[(int)Math.pow(2, n)][2];
            i = 0;
            hanoi(n, 0, 1, 2);
            i = 0;
        }
        else if (e.getSource() == next)
        {
            if (i >= (int)Math.pow(2, n) - 1)
                return;
            panel.moveDish(a[i][0], a[i][1]);
            i++;
        }
        else
        {
            if (i <= 0)
                return;
            i--;
            panel.moveDish(a[i][1], a[i][0]);
        }
    }
    private void hanoi(int n, int x, int y, int z)
    {
        if (n == 1)
        {
            a[i][0] = x;
            a[i][1] = z;
            i++;
        }
        else
        {
            hanoi(n - 1, x, z, y);
            a[i][0] = x; a[i][1] = z; i++;
            hanoi(n - 1, y, x, z);
        }
    }
}


class Dish
{
    Point location;
    int level;
    Color color;
    Dish(int l)
    {
        level = l;
        Random rand = new Random();
        color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }
    public void setLocation(Point p)
    {
        location = p;
    }
    public void Draw(Graphics g)
    {
        g.fillRect(location.x - (40 + level * 20) / 2, location.y, 40 + level * 20, 10);
    }
}


class Stick extends Canvas
{
    Dish[] dishs;
    int dishNum;
    Color color;
    Stick(int n, Color c)
    {
        dishNum = 0;
        color = c;
        dishs = new Dish[n];
    }
    public void addDish(Dish dish)
    {
        dishs[dishNum] = dish;
        dishNum++;
    }
    public Dish moveDish()
    {
        dishNum--;
        Dish dish = dishs[dishNum];
        dishs[dishNum] = null;
        return dish;
    }
    public void paint(Graphics g)
    {
        g.setColor(color);
        g.fillRect((getSize().width) / 2 - 5, (int)(getSize().height*0.1), 10, (int)(getSize().height*0.8));
        g.fillRect((getSize().width) / 10, (int)(getSize().height*0.8 + 10), (getSize().width) / 5 * 4, (int)(getSize().height*0.09));


        for (int i = 0; i < dishNum; i++)
        {
            g.setColor(dishs[i].color);
            dishs[i].setLocation(new Point((getSize().width) / 2, (int)(getSize().height*0.8 - i * 10)));
            dishs[i].Draw(g);
        }
    }
}